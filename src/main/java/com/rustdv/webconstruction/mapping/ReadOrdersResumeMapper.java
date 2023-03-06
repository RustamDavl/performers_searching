package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadOrderResumeDto;
import com.rustdv.webconstruction.entity.OrdersResume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadOrdersResumeMapper implements Mapper<OrdersResume, ReadOrderResumeDto> {

    private final ReadResumeMapper readResumeMapper;

    private final ReadOrderMapper readOrderMapper;

    @Override
    public ReadOrderResumeDto mapFrom(OrdersResume from) {


        return ReadOrderResumeDto.builder()
                .id(from.getId())
                .readOrderDto(readOrderMapper.mapFrom(from.getOrder()))
                .readResumeDto(readResumeMapper.mapFrom(from.getResume()))
                .resumeStatus(from.getResumeStatus().name())
                .orderStatus(from.getOrderStatus().name())
                .build();

    }
}
