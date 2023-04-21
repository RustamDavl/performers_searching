package com.rustdv.webconstruction.controller;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdatePersonDto;
import com.rustdv.webconstruction.dto.createupdate.CreateUpdateResumeDto;
import com.rustdv.webconstruction.dto.read.ReadRoleDto;
import com.rustdv.webconstruction.entity.Roles;
import com.rustdv.webconstruction.entity.Team;
import com.rustdv.webconstruction.filter.OrderFilter;
import com.rustdv.webconstruction.repository.ExperienceRepository;
import com.rustdv.webconstruction.repository.KeywordRepository;
import com.rustdv.webconstruction.repository.MeasurementRepository;
import com.rustdv.webconstruction.service.OrderResumeService;
import com.rustdv.webconstruction.service.OrderService;
import com.rustdv.webconstruction.service.PersonService;
import com.rustdv.webconstruction.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RequestMapping("/executor")
@RequiredArgsConstructor
@Controller
public class ExecutorController {

    private final ResumeService resumeService;
    private final MeasurementRepository measurementRepository;
    private final KeywordRepository keywordRepository;
    private final ExperienceRepository experienceRepository;

    private final OrderService orderService;

    private final PersonService personService;

    private final OrderResumeService orderResumeService;

    @GetMapping("/{id}/profile")
    public String getProfile(Model model, @PathVariable("id") Integer id) {

        var readPersonDto = personService.findById(id);

        model.addAttribute("readPersonDto", readPersonDto.orElse(null));

        return "executor/profile";
    }



    @PostMapping("/{id}/profile/update")
    public String updateProfile(CreateUpdatePersonDto createUpdatePersonDto,
                                @PathVariable("id") Integer id) {

        personService.update(id, createUpdatePersonDto);

        return "redirect:/executor/" + id + "/profile";
    }

    @GetMapping("/{id}/resumes")
    public String getResumes(Model model, @PathVariable("id") Integer id) {


        model.addAttribute("resumes", resumeService.findAllByPersonId(id));
        model.addAttribute("executorId", id);
        model.addAttribute("measurements", measurementRepository.findAll());
        model.addAttribute("keywords", keywordRepository.findAll());
        model.addAttribute("experiences", experienceRepository.findAll());
        model.addAttribute("teams", Arrays.stream(Team.values()).map(Team::getDescription)
                .toList());
        model.addAttribute("acceptedCount", personService.findAcceptedResumesByExecutorId(id).size());


        return "executor/resumes";
    }

    @PostMapping("/{id}/resumes")
    public String createResume(Model model, @PathVariable("id") Integer id,
                               CreateUpdateResumeDto createUpdateResumeDto) {

        var readResumeDto = resumeService.create(createUpdateResumeDto, id);


        return "redirect:/executor/" + id + "/resumes";
    }

    @GetMapping("/{id}/orders")
    public String getAllOrders(Model model, @PathVariable("id") Integer id, HttpServletRequest request) {


        model.addAttribute("orders", orderResumeService.findAllOrdersV2(id));
        model.addAttribute("executorId", id);

        return "executor/getAllOrders";
    }

    @PostMapping("/{id}/resume/delete")
    public String deleteResume(@PathVariable("id") Integer id) {

        resumeService.delete(id);

        return "redirect:/executor/" + id + "resumes";

    }

    @GetMapping("/{id}/orders/{orderId}")
    public String getOrderById(Model model, @PathVariable("id") Integer id, @PathVariable("orderId") Integer orderId,
                               @RequestParam(required = false) String accepted,
                               @RequestParam(required = false) String submitted) {


        model.addAttribute("accepted", accepted);
        model.addAttribute("submitted", submitted);
        model.addAttribute("resumes", resumeService.findAllByPersonId(id));
        model.addAttribute("order", orderService.findById(orderId).orElse(null));
        model.addAttribute("executorId", id);


        return "executor/currentOrderInfo";
    }

    @GetMapping("/{id}/progress")
    public String getPerformedOrders(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("executorId", id);
        model.addAttribute("executableOrders", orderResumeService.getExecutableOrders(id));

        return "executor/inprogress";
    }

    @GetMapping("/responses/{resumeId}")
    public String getPersonById(Model model, @PathVariable("resumeId") Integer resumeId) {

        model.addAttribute("executor", personService.findById(resumeId).orElse(null));

        return "executor/currentRespondedPerson";
    }


}
