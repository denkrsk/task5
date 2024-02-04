package com.example.demotest.controller;

import com.example.demotest.app_query.*;
import com.example.demotest.service.MyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;

@Controller
@RequiredArgsConstructor
@Component
public class MyController {


    private final MyService myService;

    @PostMapping("/corporate-settlement-instance/create")
    public ResponseEntity<Object> handleInstance(@RequestBody Instance my){
        Result res= myService.processInstance(my);
        if (res.getStatus() == 2) {
            ResponseEntity.status(400);
            ResponseEntity.badRequest();
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    res.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
        if (res.getStatus() == 3) {
            ResponseEntity.status(404);
            ResponseEntity.badRequest();
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    res.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(res.getResInst());
    }

    @PostMapping("/corporate-settlement-account/create")
    public ResponseEntity<Object> handleAcc(@RequestBody Account my){
        Result res= myService.processAccount(my);
        if (res.getStatus() == 2) {
            ResponseEntity.status(400);
            ResponseEntity.badRequest();
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    res.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
        if (res.getStatus() == 3) {
            ResponseEntity.status(404);
            ResponseEntity.badRequest();
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    res.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(res.getResAcc());
    }
}

