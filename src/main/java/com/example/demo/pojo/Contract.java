package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id_primary")
    private int idPrimary;

    @Column(name = "_hash")
    @JsonProperty("hash")
    private String hash;

    @Column(name = "_language")
    @JsonProperty("language")
    private String language;


    @Column(name = "_description")
    @JsonProperty("description")
    private String description;


    @Column(name = "_format")
    @JsonProperty("format")
    private String format;

    @Column(name = "_url")
    @JsonProperty("url")
    private String url;

    @Column(name = "_title")
    @JsonProperty("title")
    private String title;

    @Column(name = "_document_of")
    @JsonProperty("documentOf")
    private String documentOf;

    @Column(name = "_date_published")
    @JsonProperty("datePublished")
    private String datePublished;

    @Column(name = "_document_type")
    @JsonProperty("documentType")
    private String documentType;

    @Column(name = "_date_modified")
    @JsonProperty("dateModified")
    private String dateModified;

    @Column(name = "_id")
    @JsonProperty("id")
    private String id;

    @Column(name = "_related_item")
    @JsonProperty("relatedItem")
    private String relatedItem;


    public int getIdPrimary() {
        return idPrimary;
    }

    public void setIdPrimary(int idPrimary) {
        this.idPrimary = idPrimary;
    }

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("documentOf")
    public String getDocumentOf() {
        return documentOf;
    }

    @JsonProperty("documentOf")
    public void setDocumentOf(String documentOf) {
        this.documentOf = documentOf;
    }

    @JsonProperty("datePublished")
    public String getDatePublished() {
        return datePublished;
    }

    @JsonProperty("datePublished")
    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    @JsonProperty("documentType")
    public String getDocumentType() {
        return documentType;
    }

    @JsonProperty("documentType")
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @JsonProperty("dateModified")
    public String getDateModified() {
        return dateModified;
    }

    @JsonProperty("dateModified")
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("relatedItem")
    public String getRelatedItem() {
        return relatedItem;
    }

    @JsonProperty("relatedItem")
    public void setRelatedItem(String relatedItem) {
        this.relatedItem = relatedItem;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "hash='" + hash + '\'' +
                ", format='" + format + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", documentOf='" + documentOf + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", documentType='" + documentType + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", id='" + id + '\'' +
                ", relatedItem='" + relatedItem + '\'' +
                '}';
    }
}
