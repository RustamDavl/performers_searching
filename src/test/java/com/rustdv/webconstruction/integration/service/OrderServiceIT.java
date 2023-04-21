package com.rustdv.webconstruction.integration.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderDto;
import com.rustdv.webconstruction.integration.IntegrationTestBase;
import com.rustdv.webconstruction.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@RequiredArgsConstructor
class OrderServiceIT extends IntegrationTestBase {

    private final OrderService orderService;

    @Test
    void delete() {

        int orderId = 1;

        orderService.delete(orderId);

        var emptyResult = orderService.findById(orderId);

        Assertions.assertThat(emptyResult).isEmpty();
    }

    @Test
    void createOrderWithoutImages() {

        CreateUpdateOrderDto order = CreateUpdateOrderDto.builder()
                .orderName("test")
                .keyword("прораб")
                .city("test")
                .street("test")
                .houseNumber("test")
                .startAt(LocalDate.now())
                .endAt(LocalDate.now())
                .description("test descr")
                .build();



        var readOrderDto = orderService.create(order, 1);


        Assertions.assertThat(readOrderDto).isNotNull();



    }
}