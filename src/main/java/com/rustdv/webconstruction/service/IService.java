package com.rustdv.webconstruction.service;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateDto;
import com.rustdv.webconstruction.dto.read.ReadDto;
import org.hibernate.annotations.Target;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public interface IService<C extends CreateUpdateDto, R extends ReadDto, ID extends Serializable>{


    R create(C object);

    Optional<R> findById(ID id);


    Optional<R> update(ID id, C object);


    void delete(ID id);

    List<R> findAll();


}
