package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ContractDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("hash")
    private String hash;

    @JsonProperty("language")
    private String language;

    @JsonProperty("description")
    private String description;

    @JsonProperty("format")
    private String format;

    @JsonProperty("url")
    private String url;

    @JsonProperty("title")
    private String title;

    @JsonProperty("documentOf")
    private String documentOf;

    @JsonProperty("datePublished")
    private String datePublished;

    @JsonProperty("documentType")
    private String documentType;

    @JsonProperty("dateModified")
    private String dateModified;

    @JsonProperty("relatedItem")
    private String relatedItem;

    public String getId() {
        return id;
    }

    public ContractDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public ContractDTO setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public ContractDTO setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ContractDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public ContractDTO setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ContractDTO setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ContractDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDocumentOf() {
        return documentOf;
    }

    public ContractDTO setDocumentOf(String documentOf) {
        this.documentOf = documentOf;
        return this;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public ContractDTO setDatePublished(String datePublished) {
        this.datePublished = datePublished;
        return this;
    }

    public String getDocumentType() {
        return documentType;
    }

    public ContractDTO setDocumentType(String documentType) {
        this.documentType = documentType;
        return this;
    }

    public String getDateModified() {
        return dateModified;
    }

    public ContractDTO setDateModified(String dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    public String getRelatedItem() {
        return relatedItem;
    }

    public ContractDTO setRelatedItem(String relatedItem) {
        this.relatedItem = relatedItem;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractDTO that = (ContractDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ContractDTO{" +
                "id='" + id + '\'' +
                ", hash='" + hash + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", documentOf='" + documentOf + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", documentType='" + documentType + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", relatedItem='" + relatedItem + '\'' +
                '}';
    }
}
