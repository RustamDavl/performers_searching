package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadOrderDto;
import com.rustdv.webconstruction.entity.Order;
import com.rustdv.webconstruction.entity.PhotoForOrder;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReadOrderMapper implements Mapper<Order, ReadOrderDto> {

    private final ReadPersonMapper readPersonMapper;

    private final ImageLoader imageLoader;

    @Value("${app.orders.path}")
    private final String ORDERS_IMAGES_FOLDER;

    @Override
    public ReadOrderDto mapFrom(Order from) {

        var imagesId = from.getImages().stream()
                .map(PhotoForOrder::getId)
                .toList();



        return ReadOrderDto.builder()
                .id(String.valueOf(from.getId()))
                .orderName(from.getOrderName())
                .address(from.getAddress())
                .readPersonDto(readPersonMapper.mapFrom(from.getPerson()))
                .keyword(from.getKeyword().getName())
                .imageIdentifiers(imagesId)
                .description(from.getDescription())
                .startAt(from.getStartAt())
                .endAt(from.getEndAt())
                .build();
    }


}
