package com.example.demo.pojo;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @Type(type="uuid-char")
    private UUID uuid;

    @Column(name = "hash")
    private String hash;

    @Column(name = "language")
    private String language;


    @Column(name = "description")
    private String description;


    @Column(name = "format")
    private String format;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "document_of")
    private String documentOf;

    @Column(name = "date_published")
    private OffsetDateTime datePublished;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "date_modified")
    private OffsetDateTime dateModified;

    @Column(name = "related_item")
    private String relatedItem;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocumentOf() {
        return documentOf;
    }

    public void setDocumentOf(String documentOf) {
        this.documentOf = documentOf;
    }

    public OffsetDateTime getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(OffsetDateTime datePublished) {
        this.datePublished = datePublished;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public OffsetDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(OffsetDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public String getRelatedItem() {
        return relatedItem;
    }

    public void setRelatedItem(String relatedItem) {
        this.relatedItem = relatedItem;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "uuid=" + uuid +
                ", hash='" + hash + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", documentOf='" + documentOf + '\'' +
                ", datePublished=" + datePublished +
                ", documentType='" + documentType + '\'' +
                ", dateModified=" + dateModified +
                ", relatedItem='" + relatedItem + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(uuid, contract.uuid) &&
                Objects.equals(hash, contract.hash) &&
                Objects.equals(language, contract.language) &&
                Objects.equals(description, contract.description) &&
                Objects.equals(format, contract.format) &&
                Objects.equals(url, contract.url) &&
                Objects.equals(title, contract.title) &&
                Objects.equals(documentOf, contract.documentOf) &&
                Objects.equals(datePublished, contract.datePublished) &&
                Objects.equals(documentType, contract.documentType) &&
                Objects.equals(dateModified, contract.dateModified) &&
                Objects.equals(relatedItem, contract.relatedItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, hash, language, description, format, url, title, documentOf, datePublished, documentType, dateModified, relatedItem);
    }
}