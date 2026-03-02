package com.studying.MyProject.service;

import com.studying.MyProject.DTO.DocumentDTO;
import com.studying.MyProject.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DocumentService {
    @Autowired
    private final DocumentRepository documentRepository;
    List<DocumentDTO> documentDTOList;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    //Метод, который ищет работников, чья дата выдачи документа старше, чем переданная в параметре дата.
    public List<DocumentRepository.DocumentInfo> findEmployeesLastNameWithDocumentsIssueOlderThan(LocalDate date){
        List<DocumentRepository.DocumentInfo> list = documentRepository.findEmployeesLastNameWithDocumentsIssueOlderThan(date);
        return list;
    }



}
