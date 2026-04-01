package com.example.schoolmanager.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(columnDefinition = "UNIQUEIDENTIFIER", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 50, nullable = false, unique = true)
    private String code;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String description;

    public Permission() {}

    public Permission(String code, String description) {
        this.code = code;
        this.description = description;
    }

    // Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
