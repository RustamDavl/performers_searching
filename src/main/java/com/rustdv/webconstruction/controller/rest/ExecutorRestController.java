package com.rustdv.webconstruction.controller.rest;

import com.rustdv.webconstruction.service.PersonService;
import com.rustdv.webconstruction.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/executor")
@RequiredArgsConstructor
public class ExecutorRestController {

    private final PersonService personService;

    private final ResumeService resumeService;

    @GetMapping(value = "/responses/{resumeId}/images/{imageId}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getImageByResumeIdAndImageId(@PathVariable("resumeId") Integer resumeId,
                                    @PathVariable("imageId") Integer imageId) {

        return resumeService.getImageByResumeIdAndImageId(resumeId, imageId);

    }

    @GetMapping(value = "/{id}/image", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getExecutorIcon(@PathVariable("id") Integer id) {

        return personService.getExecutorIcon(id);
    }
}
