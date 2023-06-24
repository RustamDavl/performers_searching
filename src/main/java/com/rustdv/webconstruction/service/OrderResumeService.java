package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderResumeDto;
import com.rustdv.webconstruction.dto.read.ReadOrderResumeDto;
import com.rustdv.webconstruction.entity.*;
import com.rustdv.webconstruction.filter.OrderFilter;
import com.rustdv.webconstruction.mapping.ReadOrderMapper;
import com.rustdv.webconstruction.mapping.ReadOrdersResumeMapper;
import com.rustdv.webconstruction.mapping.ReadPersonMapper;
import com.rustdv.webconstruction.mapping.ReadResumeMapper;
import com.rustdv.webconstruction.repository.OrderRepository;
import com.rustdv.webconstruction.repository.OrderResumeRepository;
import com.rustdv.webconstruction.repository.PersonRepository;
import com.rustdv.webconstruction.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderResumeService implements IService<CreateUpdateOrderResumeDto, ReadOrderResumeDto, Integer> {

    private final ResumeRepository resumeRepository;

    private final OrderRepository orderRepository;

    private final ReadOrderMapper readOrderMapper;

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



        return orderResumeRepository.findById(id)
                .map(readOrdersResumeMapper::mapFrom);
    }


    @Override
    public void delete(Integer integer) {

    }

    Optional<ReadOrderResumeDto> findByOrderId(Integer orderId) {
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

    public List<ReadOrderResumeDto> getExecutableOrders(Integer id) {
        return personRepository.findById(id)
                .stream()
                .map(Person::getResumes)
                .flatMap(Collection::stream)
                .map(Resume::getOrdersResumeList)
                .flatMap(Collection::stream)
                .filter(ordersResume -> ordersResume.getOrderStatus().equals(RespondStatus.ACCEPTED))
                .map(readOrdersResumeMapper::mapFrom)
                .toList();
    }

    public List<ReadOrderResumeDto> findRespondedResumesByCustomerId(Integer id, OrderFilter filter) {


        return personRepository.findById(id)
                .stream()
                .map(Person::getOrders)
                .flatMap(Collection::stream)
                .map(Order::getOrdersResumeList)
                .flatMap(Collection::stream)
                .filter(ordersResume -> {
                            if (filter.getFilter() == null || filter.getFilter().equals("all"))
                                return true;
                            else
                                return ordersResume.getOrderStatus().equals(RespondStatus.getStatusByFilter(filter.getFilter()));
                        }

                )
                .map(readOrdersResumeMapper::mapFrom)
                .toList();

    }

    public List<ReadOrderResumeDto> findAllOrders(Integer executorId) {


        var readOrderDtoList = personRepository.findAll()
                .stream()
                .filter(person -> !person.getId().equals(executorId))
                .map(Person::getOrders)
                .flatMap(Collection::stream)
                .map(readOrderMapper::mapFrom)
                .toList();


        return readOrderDtoList.stream()
                .map(
                        readOrderDto -> {
                            var orderId = Integer.valueOf(readOrderDto.getId());
                            var people = orderResumeRepository.findAllByOrderId(orderId)
                                    .stream()
                                    .filter(ordersResume -> List.of(RespondStatus.ACCEPTED, RespondStatus.FINISHED)
                                            .contains(ordersResume.getOrderStatus()))
                                    .map(OrdersResume::getResume)
                                    .map(Resume::getPerson)
                                    //.filter(person -> person.getId().equals(executorId))
                                    .map(readPersonMapper::mapFrom)
                                    .toList();
                            if (people.isEmpty()) {
                                return ReadOrderResumeDto.builder()
                                        .readOrderDto(readOrderDto)
                                        .orderStatus(RespondStatus.TO_OR_NONE.name())
                                        .accepted(false)
                                        .build();
                            } else {
                                return ReadOrderResumeDto.builder()
                                        .readOrderDto(readOrderDto)
                                        .orderWithReply(people.get(0))
                                        .orderStatus(RespondStatus.EXCEPT_TO.name())
                                        .accepted(true)
                                        .build();
                            }
                        }
                )
                .toList();

    }


    public List<ReadOrderResumeDto> findAllOrdersV2(Integer executorId) {


        var readOrderDtoList = personRepository.findAll()
                .stream()
                .filter(person -> !person.getId().equals(executorId))
                .map(Person::getOrders)
                .flatMap(Collection::stream)
                .map(readOrderMapper::mapFrom)
                .toList();


        //GovnoCode...
        return readOrderDtoList.stream()
                .map(
                        readOrderDto -> {
                            var orderId = Integer.valueOf(readOrderDto.getId());
                            var ordersAndResumes = orderResumeRepository.findAllByOrderId(orderId)
                                    .stream()
                                    .filter(ordersResume -> Objects.equals(RespondStatus.TO, ordersResume.getOrderStatus()))
                                    .toList();
                            if (!ordersAndResumes.isEmpty()) {
                                AtomicReference<Integer> personId = new AtomicReference<>(-1);
                                List<Person> person = ordersAndResumes.stream()
                                        .map(OrdersResume::getResume)
                                        .map(Resume::getPerson)
                                        .filter(Objects::nonNull)
                                        .peek(person1 -> {
                                            personId.set(person1.getId());
                                        })
                                        .filter(person1 -> person1.getId().equals(executorId))
                                        .toList();
                                if (!person.isEmpty()) {
                                    return ReadOrderResumeDto.builder()
                                            .readOrderDto(readOrderDto)
                                            .orderStatus(RespondStatus.TO_OR_NONE.name())
                                            .orderWithReply(readPersonMapper.mapFrom(person.get(0)))
                                            .accepted(false)
                                            .submitted(true)
                                            .build();
                                }
                                return ReadOrderResumeDto.builder()
                                        .readOrderDto(readOrderDto)
                                        .orderStatus(RespondStatus.TO_OR_NONE.name())
                                        .accepted(false)
                                        .submitted(false)
                                        .personId(String.valueOf(personId.get()))
                                        .build();
                            } else {
                                return ReadOrderResumeDto.builder()
                                        .readOrderDto(readOrderDto)
                                        .orderStatus(RespondStatus.EXCEPT_TO.name())
                                        .accepted(true)
                                        .submitted(true)
                                        .build();

                            }
                        }
                )
                .toList();

    }


}
