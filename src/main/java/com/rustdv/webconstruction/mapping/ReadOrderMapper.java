package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadOrderDto;
import com.rustdv.webconstruction.entity.Order;
import com.rustdv.webconstruction.entity.PhotoForOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReadOrderMapper implements Mapper<Order, ReadOrderDto> {

    private final ReadPersonMapper readPersonMapper;

    @Override
    public ReadOrderDto mapFrom(Order from) {
        return ReadOrderDto.builder()
                .id(String.valueOf(from.getId()))
                .orderName(from.getOrderName())
                .address(from.getAddress())
                .readPersonDto(readPersonMapper.mapFrom(from.getPerson()))
                .keyword(from.getKeyword().getKeyword())
                .imagePaths(from.getPhotos().stream().map(PhotoForOrder::getPhoto).toList())
                .description(from.getDescription())
                .startAt(from.getStartAt())
                .endAt(from.getEndAt())
                .build();
    }


}
