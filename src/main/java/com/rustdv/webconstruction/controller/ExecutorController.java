package com.rustdv.webconstruction.controller;


import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderDto;
import com.rustdv.webconstruction.dto.read.ReadOrderDto;
import com.rustdv.webconstruction.dto.read.ReadPersonDto;
import com.rustdv.webconstruction.service.KeywordService;
import com.rustdv.webconstruction.service.OrderService;
import com.rustdv.webconstruction.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;

@Controller
@RequestMapping("/executor")
@RequiredArgsConstructor
public class ExecutorController {

    private final OrderService orderService;

    private final PersonService personService;

    private final KeywordService keywordService;


    @GetMapping("/{id}/orders")
    public String findById(Model model, @PathVariable("id") Integer id) {

        var readOrderDtoList = orderService.findAllByPersonId(id);
        model.addAttribute("readOrders", readOrderDtoList);
        model.addAttribute("executorId", id);
        model.addAttribute("keywords", keywordService.findAll());

        return "executor/orders";


    }


    @PostMapping("/{id}/orders/create")
    public String createOrder(Model model, @PathVariable("id") Integer id, CreateUpdateOrderDto createUpdateOrderDto) {

       orderService.create(createUpdateOrderDto, id);
        return "redirect:/executor/" + id + "/orders";
    }


}
