package com.rustdv.webconstruction.controller.rest;

import com.rustdv.webconstruction.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/executor")
@RequiredArgsConstructor
public class ExecutorRestController {

    private final OrderService orderService;

    @GetMapping(value = "{id}/orders/{orderId}/images/{imageId}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getImageById(@PathVariable("id") Integer id, @PathVariable("orderId") Integer orderId,
                               @PathVariable("imageId") Integer imageId) {

        return orderService.getImageByOrderIdAndImageId(orderId, imageId);


    }
}
