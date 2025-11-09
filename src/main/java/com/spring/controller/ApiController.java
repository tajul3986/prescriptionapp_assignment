package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Prescription;
import com.spring.service.PrescriptionService;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

	@Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/prescriptions")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.findAll();
    }
}
