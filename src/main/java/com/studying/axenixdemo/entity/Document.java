package com.studying.axenixdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "documents")
@Getter
@Setter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private int id;
    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "issuing_authority")
    private String issuingAuthority;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private DocumentType documentType;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
    public Document() {
    }

    public Document(String documentNumber, LocalDate issueDate, String issuingAuthority) {
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.issuingAuthority = issuingAuthority;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", documentNumber='" + documentNumber + '\'' +
                ", issueDate=" + issueDate +
                ", issuingAuthority='" + issuingAuthority + '\'' +
                ", documentType=" + documentType +
                ", employee=" + employee +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
