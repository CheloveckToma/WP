package com.application.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "parents")
public class Parent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "family_status")
    private String familyStatus;

    @Column(name = "number_children")
    private int numberChildren;

    @Column(name = "parent_full_name")
    private String parentFullName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "place_work")
    private String placeWork;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Parent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public int getNumberChildren() {
        return numberChildren;
    }

    public void setNumberChildren(int numberChildren) {
        this.numberChildren = numberChildren;
    }

    public String getParentFullName() {
        return parentFullName;
    }

    public void setParentFullName(String parentFullName) {
        this.parentFullName = parentFullName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

        Parent parent = (Parent)obj;
        return id.equals(parent.id) &&
                Objects.equals(parentFullName, parent.parentFullName) &&
                Objects.equals(familyStatus, parent.familyStatus) &&
                Objects.equals(numberChildren, parent.numberChildren) &&
                Objects.equals(phoneNumber, parent.phoneNumber) &&
                Objects.equals(placeWork, parent.placeWork) &&
                address.equals(parent.address);
    }
}
