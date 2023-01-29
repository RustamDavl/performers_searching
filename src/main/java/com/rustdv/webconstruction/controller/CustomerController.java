package com.rustdv.webconstruction.controller;


import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderDto;
import com.rustdv.webconstruction.entity.Team;
import com.rustdv.webconstruction.repository.KeywordRepository;
import com.rustdv.webconstruction.service.KeywordService;
import com.rustdv.webconstruction.service.OrderService;
import com.rustdv.webconstruction.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.Arrays;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final OrderService orderService;

    private final PersonService personService;

    private final KeywordService keywordService;

    private final KeywordRepository keywordRepository;


    @GetMapping("/{id}/orders")
    public String findById(Model model, @PathVariable("id") Integer id) {

        var readOrderDtoList = orderService.findAllByPersonId(id);
        model.addAttribute("readOrders", readOrderDtoList);
        model.addAttribute("customerId", id);
        model.addAttribute("keywords", keywordRepository.findAll());


        return "customer/orders";

    }




    @PostMapping(value = "/{id}/orders")
    public String createOrder(Model model, @PathVariable("id") Integer id, CreateUpdateOrderDto createUpdateOrderDto) {

        orderService.create(createUpdateOrderDto, id);
        return "redirect:/customer/" + id + "/orders";
    }


}
