package com.application.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "student_full_name")
    private String studentFullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "birth_certificate_id")
    private BirthCertificate birthCertificate;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_data_id")
    private PassportData passportData;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Parent> parents = new ArrayList<Parent>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Attendance> attendance = new ArrayList<Attendance>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Performance> performance = new ArrayList<Performance>();

    public List<Parent> getParents() {
        return parents;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public List<Performance> getPerformance() {
        return performance;
    }


    public Student() {

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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }


    public BirthCertificate getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(BirthCertificate birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public PassportData getPassportData() {
        return passportData;
    }

    public void setPassportData(PassportData passportData) {
        this.passportData = passportData;
    }

    public void addParent(Parent parent) {
        parent.setStudent(this);
        this.parents.add(parent);
    }

    public void addAttendance(Attendance attendance) {
        attendance.setStudent(this);
        this.attendance.add(attendance);
    }

    public void addPerformance(Performance performance) {
        performance.setStudent(this);
        this.performance.add(performance);
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }

    public void setPerformance(List<Performance> performance) {
        this.performance = performance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != obj.getClass())
            return false;

        Student student = (Student) obj;
        return id.equals(student.id) &&
                Objects.equals(student.studentFullName, studentFullName) &&
                Objects.equals(student.birthDate, birthDate) &&
                Objects.equals(student.phoneNumber, phoneNumber) &&
                Objects.equals(student.address, address) &&
                Objects.equals(student.birthCertificate, birthCertificate) &&
                Objects.equals(student.passportData, passportData);
    }
}
