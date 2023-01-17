package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.entity.*;
import com.rustdv.webconstruction.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CreateUpdateOrderDtoMapper implements Mapper<CreateUpdateOrderDto, Order> {

    private final ReadPersonMapper readPersonMapper;

    private final KeywordRepository keywordRepository;

    @Override
    public Order mapFrom(CreateUpdateOrderDto from) {

        return null;
    }

    public Order mapFrom(CreateUpdateOrderDto from, ReadPersonDto readPersonDto) {
        var order = Order.builder()
                .address(Address.builder()
                        .city(from.getCity())
                        .street(from.getStreet())
                        .houseNumber(from.getHouseNumber())
                        .build())
                .description(from.getDescription())
                .person(readPersonMapper.mapFrom(readPersonDto))
                .keyword(keywordRepository.findByKeyword(from.getKeyword()).orElseThrow(RuntimeException::new))
                .startAt(from.getStartAt())
                .endAt(from.getEndAt())
                .orderName(from.getOrderName())
                .build();
        order.addPhotos(from.getImages().stream()
                        .map(multipartFile -> PhotoForOrder.builder()
                                .photo(multipartFile.getOriginalFilename())
                                .build()).toList());

        return order;
    }
}
