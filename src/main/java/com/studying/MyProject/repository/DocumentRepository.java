package com.studying.MyProject.repository;

import com.studying.MyProject.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    @Query(value = "SELECT e.lastName as lastName, dt.name as documentName, d.issueDate as issueDate FROM DocumentType dt JOIN dt.documents d JOIN d.employee e WHERE d.issueDate < :date")
    List<DocumentInfo> findEmployeesLastNameWithDocumentsIssueOlderThan(@Param("date") LocalDate date);
    interface DocumentInfo {
        String getLastName();
        String getDocumentName();
        LocalDate getIssueDate();
    }
}
