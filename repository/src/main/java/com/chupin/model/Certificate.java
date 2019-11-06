package com.chupin.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@javax.persistence.Entity
@Table(name = "certificates")
public class Certificate extends Entity {

    @Column(name = "name")
    private String certificateName;

    @Column(name = "description")
    private String certificateDescription;

    @Column(name = "price")
    private double certificatePrice;

    @Column(name = "date_of_creation")
    private LocalDate dateOfCreation;

    @Column(name = "date_of_modification")
    private LocalDate dateOfModification;

    @Column(name = "duration")
    private int duration;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "certificates_tags",
            joinColumns = @JoinColumn(name = "certificate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
    )
    private Set<Tag> tags;

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateDescription() {
        return certificateDescription;
    }

    public void setCertificateDescription(String certificateDescription) {
        this.certificateDescription = certificateDescription;
    }

    public double getCertificatePrice() {
        return certificatePrice;
    }

    public void setCertificatePrice(double certificatePrice) {
        this.certificatePrice = certificatePrice;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDate getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(LocalDate dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "certificateName='" + certificateName + '\'' +
                ", certificateDescription='" + certificateDescription + '\'' +
                ", certificatePrice=" + certificatePrice +
                ", dateOfCreation=" + dateOfCreation +
                ", dateOfModification=" + dateOfModification +
                ", duration=" + duration +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return Double.compare(that.certificatePrice, certificatePrice) == 0 &&
                duration == that.duration &&
                Objects.equals(certificateName, that.certificateName) &&
                Objects.equals(certificateDescription, that.certificateDescription) &&
                Objects.equals(dateOfCreation, that.dateOfCreation) &&
                Objects.equals(dateOfModification, that.dateOfModification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificateName, certificateDescription, certificatePrice, dateOfCreation, dateOfModification, duration);
    }
}
