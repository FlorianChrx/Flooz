package com.owle.OwleAPI.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DateController {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public @ResponseBody
    LocalDateTime getDate() {
        return LocalDateTime.now();
    }

}
