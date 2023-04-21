package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderDto;
import com.rustdv.webconstruction.dto.read.ReadOrderDto;
import com.rustdv.webconstruction.entity.Order;
import com.rustdv.webconstruction.entity.PhotoForOrder;
import com.rustdv.webconstruction.mapping.CreateUpdateOrderDtoMapper;
import com.rustdv.webconstruction.mapping.ReadOrderMapper;
import com.rustdv.webconstruction.repository.OrderRepository;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService implements IService<CreateUpdateOrderDto, ReadOrderDto, Integer> {

    private final ReadOrderMapper readOrderMapper;

    private final CreateUpdateOrderDtoMapper createUpdateOrderDtoMapper;

    private final OrderRepository orderRepository;

    private final PersonService personService;

    private final ImageLoader imageLoader;

    @Value("${app.orders.path}")
    private final String ORDERS_IMAGES_FOLDER;

    @Override
    public ReadOrderDto create(CreateUpdateOrderDto object) {

        return null;


    }

    @Override
    public Optional<ReadOrderDto> findById(Integer id) {

        return orderRepository.findById(id)
                .map(readOrderMapper::mapFrom);

    }

    public byte[] getImageByOrderIdAndImageId(Integer orderId, Integer imageId) {


        var image = orderRepository.findById(orderId)
                .map(Order::getImages)
                .stream()
                .flatMap(Collection::stream)
                .filter(photoForOrder -> photoForOrder.getId().equals(imageId))
                .map(PhotoForOrder::getPhoto)
                .filter(StringUtils::hasText)
                .collect(Collectors.joining());

        return imageLoader.downloadOneImage(image, ORDERS_IMAGES_FOLDER);

    }

    @Override
    public Optional<ReadOrderDto> update(Integer integer, CreateUpdateOrderDto object) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer orderId) {

        orderRepository.findById(orderId)
                .ifPresent(order -> {
                    orderRepository.delete(order);
                    orderRepository.flush();

                });
    }

    @Override
    public List<ReadOrderDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(readOrderMapper::mapFrom)
                .toList();
    }

    public List<ReadOrderDto> findAllByPersonId(Integer id) {
        return orderRepository.findAllByPersonId(id)
                .stream()
                .map(readOrderMapper::mapFrom)
                .toList();
    }

    public ReadOrderDto create(CreateUpdateOrderDto createUpdateOrderDto, Integer personId) {

        var readPersonDto = personService.findById(personId)
                .orElseThrow(RuntimeException::new);


//        if(createUpdateOrderDto.getImages() != null) {
//
//            imageLoader.uploadAllImages(createUpdateOrderDto.getImages(), ORDERS_IMAGES_FOLDER);
//
//        }


        return readOrderMapper.mapFrom(
                orderRepository
                        .save(createUpdateOrderDtoMapper.mapFrom(createUpdateOrderDto, readPersonDto))
        );
    }
}
