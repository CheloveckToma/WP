package com.application.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "birth_certificate")
public class BirthCertificate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "series")
    private Integer series;

    @Column(name = "number")
    private Integer number;

    @Column(name = "issued_by")
    private String issuedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_issue")
    private Date dateIssue;

    @OneToOne(mappedBy = "birthCertificate")
    private Student student;


    public BirthCertificate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != obj.getClass())
            return false;

        BirthCertificate birthCertificate = (BirthCertificate)obj;
        return  id.equals(birthCertificate.id) &&
                Objects.equals(series, birthCertificate.series) &&
                Objects.equals(number, birthCertificate.number) &&
                Objects.equals(issuedBy, birthCertificate.issuedBy) &&
                dateIssue.equals(birthCertificate.dateIssue);
    }
}
