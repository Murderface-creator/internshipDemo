package com.studying.MyProject.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DocumentDTO {
    private String documentNumber;
    private LocalDate issueDate;
    private String issuingAuthority;
    private String documentType;
}
