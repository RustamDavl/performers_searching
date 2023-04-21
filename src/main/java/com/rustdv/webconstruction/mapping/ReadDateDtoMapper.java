package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.Months;
import com.rustdv.webconstruction.dto.read.ReadDateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class ReadDateDtoMapper {




    public ReadDateDto mapFrom(LocalDate start, LocalDate end) {

        var startMonth = Months.getMonthByOrder(start.getMonthValue());
        var endMonth = Months.getMonthByOrder(end.getMonthValue());

        return ReadDateDto.builder()
                .startAtDay(String.valueOf(start.getDayOfMonth()))
                .startAtMonth(startMonth)
                .endAtDay(String.valueOf(end.getDayOfMonth()))
                .endAtMonth(endMonth)
                .build();
    }
}
