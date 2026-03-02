package com.studying.MyProject.mapper;

import com.studying.MyProject.DTO.DocumentDTO;
import com.studying.MyProject.entity.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentMapper {
    public DocumentDTO toDTO (Document document){
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setDocumentNumber(document.getDocumentNumber());
        documentDTO.setIssueDate(document.getIssueDate());
        documentDTO.setIssuingAuthority(document.getIssuingAuthority());
        documentDTO.setDocumentType(document.getDocumentType().getName());
        return documentDTO;
    }
    public List<DocumentDTO> toDTOList (List<Document> documents){
        return documents.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
