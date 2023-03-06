package com.rustdv.webconstruction.controller;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateResumeDto;
import com.rustdv.webconstruction.dto.read.ReadOrderResumeDto;
import com.rustdv.webconstruction.entity.Team;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

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

//        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
//
//        if(inputFlashMap == null) {
//            model.addAttribute("reply", "");
//        }
//        else {
//            model.addAttribute("reply", inputFlashMap.get("replyToOrder"));
//        }



       // model.addAttribute("orders", orderService.findAll());
        model.addAttribute("orders", orderResumeService.findAllSentOrderRequestsByExecutorId(id));
        model.addAttribute("executorId", id);

        return "executor/getAllOrders";
    }

    @GetMapping("/{id}/orders/{orderId}")
    public String getOrderById(Model model, @PathVariable("id") Integer id, @PathVariable("orderId") Integer orderId) {


        model.addAttribute("resumes", resumeService.findAllByPersonId(id));
        model.addAttribute("order", orderService.findById(orderId).orElse(null));
        model.addAttribute("executorId", id);


        return "executor/currentOrderInfo";
    }

    @GetMapping("/responses/{resumeId}")
    public String getPersonById(Model model, @PathVariable("resumeId") Integer resumeId) {

        model.addAttribute("executor", personService.findById(resumeId).orElse(null));

        return "executor/currentRespondedPerson";
    }


}
