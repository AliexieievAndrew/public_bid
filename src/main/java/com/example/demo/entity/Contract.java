package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "contract")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contract {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @JsonDeserialize(using = UuidDeserializer.class)
    private UUID id;

    @Column(name = "hash")
    private String hash;

    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "description")
    private String description;

    @Column(name = "format")
    @Enumerated(EnumType.STRING)
    private Format format;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "document_of")
    @Enumerated(EnumType.STRING)
    private DocumentOf documentOf;

    @Column(name = "date_published")
    private OffsetDateTime datePublished;

    @Column(name = "document_type")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "date_modified")
    private OffsetDateTime dateModified;

    @Column(name = "related_item")
    private String relatedItem;

    public UUID getId() {
        return id;
    }

    public Contract setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public Contract setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public Contract setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Contract setDescription(String description) {
        this.description = description;
        return this;
    }

    public Format getFormat() {
        return format;
    }

    public Contract setFormat(Format format) {
        this.format = format;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Contract setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Contract setTitle(String title) {
        this.title = title;
        return this;
    }

    public DocumentOf getDocumentOf() {
        return documentOf;
    }

    public Contract setDocumentOf(DocumentOf documentOf) {
        this.documentOf = documentOf;
        return this;
    }

    public OffsetDateTime getDatePublished() {
        return datePublished;
    }

    public Contract setDatePublished(OffsetDateTime datePublished) {
        this.datePublished = datePublished;
        return this;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public Contract setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
        return this;
    }

    public OffsetDateTime getDateModified() {
        return dateModified;
    }

    public Contract setDateModified(OffsetDateTime dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    public String getRelatedItem() {
        return relatedItem;
    }

    public Contract setRelatedItem(String relatedItem) {
        this.relatedItem = relatedItem;
        return this;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", language=" + language +
                ", description='" + description + '\'' +
                ", format=" + format +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", documentOf=" + documentOf +
                ", datePublished=" + datePublished +
                ", documentType=" + documentType +
                ", dateModified=" + dateModified +
                ", relatedItem='" + relatedItem + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(id, contract.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}