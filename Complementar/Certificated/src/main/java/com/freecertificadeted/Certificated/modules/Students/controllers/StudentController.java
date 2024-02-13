package com.freecertificadeted.Certificated.modules.Students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecertificadeted.Certificated.modules.Students.dto.verifyHasCertificationDTO;
import com.freecertificadeted.Certificated.modules.Students.usecases.verifyHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private verifyHasCertificationUseCase verifyHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody verifyHasCertificationDTO verifyHasCertificationDTO) {

        var result = verifyHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if(result){
            return "nao pode fazer a prova";
        }

        return "pode fazer a prova";
    }
}
