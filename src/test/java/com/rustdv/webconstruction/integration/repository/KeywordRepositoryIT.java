package com.rustdv.webconstruction.integration.repository;

import com.rustdv.webconstruction.integration.IntegrationTestBase;
import com.rustdv.webconstruction.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@RequiredArgsConstructor
public class KeywordRepositoryIT extends IntegrationTestBase {

    private final KeywordRepository keywordRepository;

    @Test
    void getKeywordByName() {

        String keyword = "прораб";

        var actualResult = keywordRepository.findByName(keyword);

        actualResult.map(keyword1 -> assertThat(keyword1.getName()).isEqualTo(keyword));
        System.out.println(actualResult);
        actualResult.map(keyword1 -> assertThat(keyword1.getId()).isEqualTo(1));

    }

    @Test
    void findAll() {
        var keywords = keywordRepository.findAll();

        System.out.println(keywords);
    }
}
