package com.application.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "passport_data")
public class PassportData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "student_full_name")
    private String studentFullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "place_residence")
    private String placeResidence;

    @Column(name = "series")
    private Integer series;

    @Column(name = "number")
    private Integer number;

    @Column(name = "issued_by")
    private String issuedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_issue")
    private Date dateIssue;

    @Column(name = "department_code")
    private Integer departmentCode;

    @Column(name = "tin")
    private Long tin;

    @Column(name = "snils_number")
    private Long snilsNumber;

    @OneToOne(mappedBy = "passportData")
    private Student student;

    public PassportData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPlaceBirth() {
        return placeResidence;
    }

    public void setPlaceResidence(String placeBirth) {
        this.placeResidence = placeBirth;
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

    public int getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
    }

    public long getTin() {
        return tin;
    }

    public void setTin(long tin) {
        this.tin = tin;
    }

    public long getSnilsNumber() {
        return snilsNumber;
    }

    public void setSnilsNumber(long snilsNumber) {
        this.snilsNumber = snilsNumber;
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

        PassportData passportData = (PassportData)obj;
        return id.equals(passportData.id) &&
                Objects.equals(studentFullName, passportData.studentFullName) &&
                Objects.equals(number, passportData.number) &&
                Objects.equals(birthDate, passportData.birthDate) &&
                Objects.equals(dateIssue, passportData.dateIssue) &&
                placeResidence.equals(passportData.placeResidence) &&
                Objects.equals(series, passportData.series) &&
                Objects.equals(number, passportData.number) &&
                Objects.equals(issuedBy, passportData.issuedBy) &&
                Objects.equals(dateIssue, passportData.dateIssue) &&
                Objects.equals(departmentCode, passportData.departmentCode) &&
                Objects.equals(dateIssue, passportData.dateIssue) &&
                Objects.equals(tin, passportData.tin) &&
                Objects.equals(snilsNumber, passportData.snilsNumber);
    }
}