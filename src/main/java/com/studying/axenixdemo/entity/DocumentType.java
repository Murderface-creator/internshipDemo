package com.studying.axenixdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "document_types")
@Getter
@Setter
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int id;
    @Column(name = "type_name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "documentType")
    private List<Document> documents;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public DocumentType() {}

    public DocumentType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", documents=" + documents +
                ", createdAt=" + createdAt +
                '}';
    }
}
