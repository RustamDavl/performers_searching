package com.rustdv.webconstruction.service;


import com.rustdv.webconstruction.dto.read.ReadKeywordDto;
import com.rustdv.webconstruction.mapping.ReadKeywordMapper;
import com.rustdv.webconstruction.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class KeywordService {

    private final KeywordRepository keywordRepository;

    private final ReadKeywordMapper readKeywordMapper;

    public List<ReadKeywordDto> findAll() {
        return keywordRepository.findAll()
                .stream()
                .map(readKeywordMapper::mapFrom)
                .toList();
    }

    public Optional<ReadKeywordDto> findByName(String keyword) {
        return keywordRepository.findByName(keyword)
                .map(readKeywordMapper::mapFrom);
    }

}
