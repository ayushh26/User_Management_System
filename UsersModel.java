package com.ayush.UserManagement.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data

@Entity
@Table(name= "usersTable")

public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String fullName;
    private String email;
    private String password;
    private String gender;
    private String dob;
    private String address;
    private String state;
    private String contact;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersModel that = (UsersModel) o;
        return Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(gender, that.gender) && Objects.equals(dob, that.dob) && Objects.equals(address, that.address) && Objects.equals(state, that.state) && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, password, gender, dob, address, state, contact);
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
