package com.rustdv.webconstruction.repository;

import com.rustdv.webconstruction.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword,Integer> {

    Optional<Keyword> findByKeyword(String keyword);

}
