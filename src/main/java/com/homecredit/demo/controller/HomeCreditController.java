package com.homecredit.demo.controller;

import com.homecredit.demo.dto.UserMenuRequest;
import com.homecredit.demo.exception.ResourceNotFoundException;
import com.homecredit.demo.service.HomeCreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/homeCredit")
public class HomeCreditController {

    private final HomeCreditService homeCreditService;

    @Autowired
    public HomeCreditController(HomeCreditService homeCreditService) {
        this.homeCreditService = homeCreditService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserId(@PathVariable("userId") Integer userId) {
        try {
            return ResponseEntity.ok(homeCreditService.getUserIdAndModule(userId));
        } catch (IOException | ResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/createUpdateUser/{id}")
    public ResponseEntity createOrUpdate(@Valid @RequestBody UserMenuRequest request,@PathVariable(value="id")Integer id) {
        try{
            return ResponseEntity.ok(homeCreditService.createOrUpdate(request,id));
        } catch(ResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
