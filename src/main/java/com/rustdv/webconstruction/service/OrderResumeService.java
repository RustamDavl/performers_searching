package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderResumeDto;
import com.rustdv.webconstruction.dto.read.ReadOrderDto;
import com.rustdv.webconstruction.dto.read.ReadOrderResumeDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.dto.read.ReadResumeDto;
import com.rustdv.webconstruction.entity.*;
import com.rustdv.webconstruction.mapping.ReadOrderMapper;
import com.rustdv.webconstruction.mapping.ReadOrdersResumeMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.mapping.ReadResumeMapper;
import com.rustdv.webconstruction.repository.OrderRepository;
import com.rustdv.webconstruction.repository.OrderResumeRepository;
import com.rustdv.webconstruction.repository.PersonRepository;
import com.rustdv.webconstruction.repository.ResumeRepository;
import liquibase.pro.packaged.I;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderResumeService implements IService<CreateUpdateOrderResumeDto, ReadOrderResumeDto, Integer> {

    private final ResumeRepository resumeRepository;

    private final OrderRepository orderRepository;

    private final ReadOrderMapper readOrderMapper;

    private final ReadResumeMapper readResumeMapper;
    private final OrderResumeRepository orderResumeRepository;
    private final ReadOrdersResumeMapper readOrdersResumeMapper;
    private final PersonRepository personRepository;

    private final ReadPersonMapper readPersonMapper;

    @Override
    public ReadOrderResumeDto create(CreateUpdateOrderResumeDto object) {

        var order = orderRepository.findById(Integer.parseInt(object.getOrderId()))
                .orElse(null);

        var resume = resumeRepository.findById(Integer.parseInt(object.getResumeId()))
                .orElse(null);

        var ordersResume = OrdersResume.builder()
                .resumeStatus(RespondStatus.valueOf(object.getResumeStatus()))
                .orderStatus(RespondStatus.valueOf(object.getOrderStatus()))
                .build();

        assert order != null;
        ordersResume.addOrder(order);
        assert resume != null;
        ordersResume.addResume(resume);


        return readOrdersResumeMapper
                .mapFrom(orderResumeRepository.save(ordersResume));


    }


    @Override
    public Optional<ReadOrderResumeDto> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Optional<ReadOrderResumeDto> update(Integer integer, CreateUpdateOrderResumeDto object) {

        return Optional.empty();
    }

    public Optional<ReadOrderResumeDto> update(CreateUpdateOrderResumeDto object) {
        var orderId = Integer.parseInt(object.getOrderId());

        Integer id = orderResumeRepository.updateStatusByOrderIdAndResumeId(
                orderId, Integer.parseInt(object.getResumeId()),
                RespondStatus.valueOf(object.getOrderStatus()));


//        orderResumeRepository.updateStatusesToRejectByOrderId(orderId);

//        orderResumeRepository.deleteAllByOrderIdAndOrderStatus(Integer.parseInt(object.getOrderId()), RespondStatus.TO.name());

        return orderResumeRepository.findById(id)
                .map(readOrdersResumeMapper::mapFrom);
    }


    @Override
    public void delete(Integer integer) {

    }

    Optional<ReadOrderResumeDto> findByOrderId(Integer orderId) {
//        return orderResumeRepository.findByOrderId(orderId)
//                .map(readOrdersResumeMapper::mapFrom);
        return null;
    }


    @Override
    public List<ReadOrderResumeDto> findAll() {
        return null;
    }

    public Optional<ReadOrderResumeDto> findByOrderIdAndResumeId(Integer orderId, Integer resumeId) {
        return orderResumeRepository.findByOrderIdAndResumeId(orderId, resumeId)
                .map(readOrdersResumeMapper::mapFrom);
    }

    public List<ReadOrderResumeDto> findRespondedResumesByCustomerId(Integer id) {

        return personRepository.findById(id)
                .stream()
                .map(Person::getOrders)
                .flatMap(Collection::stream)
                .map(Order::getOrdersResumeList)
                .flatMap(Collection::stream)
                .map(readOrdersResumeMapper::mapFrom)
                .toList();

    }

    public List<ReadOrderResumeDto> findAllSentOrderRequestsByExecutorId(Integer executorId) {


        var readOrderDtoList = personRepository.findAll()
                .stream()
                .map(Person::getOrders)
                .flatMap(Collection::stream)
                .map(readOrderMapper::mapFrom)
                .toList();


        return readOrderDtoList.stream()
                .map(
                        readOrderDto -> {
                            var orderId = Integer.valueOf(readOrderDto.getId());
                            var people = orderResumeRepository.findByOrderId(orderId)
                                    .stream()
                                    .map(OrdersResume::getResume)
                                    .map(Resume::getPerson)
                                    .filter(person -> person.getId().equals(executorId))
                                    .map(person -> {
                                        if(person == null)
                                            return ReadPersonDto.builder().build();
                                        else
                                            return readPersonMapper.mapFrom(person);
                                    })
                                    .toList();
                            if (people.isEmpty()) {
                                return ReadOrderResumeDto.builder()
                                        .readOrderDto(readOrderDto)
                                        .build();
                            } else {
                               return ReadOrderResumeDto.builder()
                                        .readOrderDto(readOrderDto)
                                        .orderWithReply(people.get(0))
                                        .build();
                            }
                        }
                )
                .toList();



    }


}
