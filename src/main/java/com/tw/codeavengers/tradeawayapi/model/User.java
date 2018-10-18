package com.tw.codeavengers.tradeawayapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "user_name")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private long mobileNo;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "pan")
    private String pan;

    @Column(name = "exp_years")
    private int experienceInYears;

    @Column(name = "exp_months")
    private int experienceInMonths;

    @ManyToMany(targetEntity = Item.class,
            mappedBy = "sellers",
            fetch = FetchType.EAGER)
    private Set<Item> items;

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public int getExperienceInMonths() {
        return experienceInMonths;
    }

    public void setExperienceInMonths(int experienceInMonths) {
        this.experienceInMonths = experienceInMonths;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
