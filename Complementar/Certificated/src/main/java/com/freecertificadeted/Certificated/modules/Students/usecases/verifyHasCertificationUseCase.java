package com.freecertificadeted.Certificated.modules.Students.usecases;

import org.springframework.stereotype.Service;

import com.freecertificadeted.Certificated.modules.Students.dto.verifyHasCertificationDTO;

@Service
public class verifyHasCertificationUseCase {
    
    public boolean execute(verifyHasCertificationDTO dto) {
        if (dto.getTechnology().equals("Java") && dto.getEmail().equals("a@a.com")) {
            return true;
        } 
        return false;  
    }
}
