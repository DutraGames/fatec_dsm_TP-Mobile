package com.freecertificadeted.Certificated.modules.Students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class verifyHasCertificationDTO {
    
    private String email;
    private String technology;
}
