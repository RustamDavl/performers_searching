package com.rustdv.webconstruction.controller.rest;

import com.rustdv.webconstruction.dto.createupdate.CreatePersonDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:5500/"},
        methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/people")
public class PersonRestController {

    private final PersonService personService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReadPersonDto create(@RequestBody CreatePersonDto createPersonDto) {

        return personService.create(createPersonDto);
    }

    @GetMapping
    public String getSomeString() {

        return "Some string for checking";
    }


}
