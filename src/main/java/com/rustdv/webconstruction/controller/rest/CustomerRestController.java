package com.rustdv.webconstruction.controller.rest;

import com.rustdv.webconstruction.service.OrderService;
import com.rustdv.webconstruction.service.PersonService;
import com.rustdv.webconstruction.util.ImageLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerRestController {

    private final OrderService orderService;
    private final PersonService personService;



    @GetMapping(value = "/orders/{orderId}/images/{imageId}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getOrderImageById(@PathVariable("orderId") Integer orderId,
                                    @PathVariable("imageId") Integer imageId) {

        return orderService.getImageByOrderIdAndImageId(orderId, imageId);


    }

    @GetMapping(value = "/{id}/image", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getExecutorIcon(@PathVariable("id") Integer id) {

        return personService.getExecutorIcon(id);
    }

}
