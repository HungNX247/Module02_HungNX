package com.codegym.review;

import java.time.LocalDate;

public class Candidate {
    private int id;
    private String fullName;
    private LocalDate dob;
    private String address;
    private String email;
    private String phone;
    private String position;

    public Candidate() {
    }

    public Candidate(int id, String fullName, LocalDate dob, String address,
                     String email, String phone, String position) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Candidate [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", address=" + address + ", email="
                + email + ", phone=" + phone + ", position=" + position + "]";
    }
}
