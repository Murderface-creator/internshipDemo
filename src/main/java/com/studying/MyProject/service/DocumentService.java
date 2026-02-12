package com.studying.MyProject.service;

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

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<DocumentRepository.DocumentInfo> findEmployeesLastNameWithDocumentsIssueOlderThan(LocalDate date){
        System.out.println("Поиск фамилий работников чья дата получения документа старше, чем " + date);
        List<DocumentRepository.DocumentInfo> list = documentRepository.findEmployeesLastNameWithDocumentsIssueOlderThan(date);
        return list;
    }

}
