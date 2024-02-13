package com.freecertificadeted.Certificated.modules.Students.entities;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertionStudentEntry {
    private UUID id;
    private UUID studentID;
    private String technology;
    private int grade;
    private List<AnswersCertionEntry> answersCertionEntries;

}
