package com.rustdv.webconstruction.mapping;

import com.rustdv.webconstruction.dto.read.ReadKeywordDto;
import com.rustdv.webconstruction.entity.Keyword;
import org.springframework.stereotype.Component;

@Component
public class ReadKeywordMapper implements Mapper<Keyword, ReadKeywordDto> {
    @Override
    public ReadKeywordDto mapFrom(Keyword from) {
       return ReadKeywordDto.builder()
               .id(from.getId())
               .keyword(from.getKeyword())
               .build();
    }
}
