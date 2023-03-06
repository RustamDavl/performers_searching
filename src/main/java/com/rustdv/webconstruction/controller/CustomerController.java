package com.rustdv.webconstruction.controller;


import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderDto;
import com.rustdv.webconstruction.dto.read.ReadRoleDto;
import com.rustdv.webconstruction.entity.Roles;
import com.rustdv.webconstruction.repository.KeywordRepository;
import com.rustdv.webconstruction.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final OrderService orderService;

    private final PersonService personService;

    private final KeywordService keywordService;

    private final ResumeService resumeService;

    private final KeywordRepository keywordRepository;

    private final OrderResumeService orderResumeService;

    private final PersonRoleService personRoleService;

    private final RoleService roleService;




    @GetMapping("/{id}/orders")
    public String getById(Model model, @PathVariable("id") Integer id) {

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

    @GetMapping("{id}/responses")
    public String getResponses(Model model, @PathVariable("id") Integer id) {

        model.addAttribute("customerId", id);
//        var respondedResumes = resumeService.findRespondedResumesByCustomerId(id);
        model.addAttribute("respondedResumes", orderResumeService.findRespondedResumesByCustomerId(id));


        var roleId = roleService.findByName(Roles.EXECUTOR).map(ReadRoleDto::getId).orElse(null);
        model.addAttribute("personRole", personRoleService.findByRoleIdAndPersonId(roleId, id).orElse(null));


        return "customer/checkRespondedPeople";

    }

    @GetMapping("/{id}/responses/{resumeId}")
    public String getResponseById(Model model, @PathVariable("id") Integer id,
                                  @PathVariable("resumeId") Integer resumeId,
                                  HttpServletRequest request) {

        Integer orderId = Integer.parseInt(request.getParameter("orderId"));
        model.addAttribute("resume", resumeService.findById(resumeId).orElse(null));
        model.addAttribute("customerId", id);
        model.addAttribute("customer", personService.findById(id).orElse(null));
        model.addAttribute("resumeId", resumeId);
        model.addAttribute("orderId", model.addAttribute("orderId"));
        model.addAttribute("orderResumeDto", orderResumeService.findByOrderIdAndResumeId(orderId, resumeId).orElse(null));

        return "customer/currentRespondedPerson";
    }


}
