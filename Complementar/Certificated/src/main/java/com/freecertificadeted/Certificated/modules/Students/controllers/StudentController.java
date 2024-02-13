package com.freecertificadeted.Certificated.modules.Students.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecertificadeted.Certificated.modules.Students.dto.verifyHasCertificationDTO;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody verifyHasCertificationDTO verifyHasCertificationDTO) {
        System.out.println(verifyHasCertificationDTO);
        return "pode fazer a primeira prova";
    }
}
