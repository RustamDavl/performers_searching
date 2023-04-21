package com.rustdv.webconstruction.controller;

import com.rustdv.webconstruction.dto.createupdate.CreateUpdateOrderResumeDto;
import com.rustdv.webconstruction.service.OrderResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/response")
@RequiredArgsConstructor
public class ResponseOrderResumeController {

    private final OrderResumeService orderResumeService;


    @PostMapping("/executor/{executorId}/orders/{orderId}")
    public String respondToOrder(RedirectAttributes redirAttr, @PathVariable("executorId") Integer executorId,
                                 @PathVariable("orderId") Integer orderId,
                                 CreateUpdateOrderResumeDto object) {


//        redirAttr.addFlashAttribute("replyToOrder", orderResumeService.create(object));
        orderResumeService.create(object);

        return "redirect:/executor/" + executorId + "/orders";
    }

    @PostMapping("/customer/{customerId}/responses/{resumeId}")
    public String updateResumeStatus(Model model, @PathVariable("customerId") Integer customerId,
                               @PathVariable("resumeId") Integer resumeId,
                               CreateUpdateOrderResumeDto object) {
        orderResumeService.update(object);

        return "redirect:/customer/" + customerId + "/responses";
    }

    @PostMapping("/executor/{executorId}/responses/{resumeId}")
    public String updateOrderStatus(Model model, @PathVariable("executorId") Integer executorId,
                                     @PathVariable("resumeId") Integer resumeId,
                                     CreateUpdateOrderResumeDto object) {
        orderResumeService.update(object);

        return "redirect:/executor/" + executorId + "/progress";
    }
}
