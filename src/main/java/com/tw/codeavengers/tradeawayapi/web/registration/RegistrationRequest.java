package com.tw.codeavengers.tradeawayapi.web.registration;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.tw.codeavengers.tradeawayapi.model.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class RegistrationRequest {
    @Size(min = 3, max = 20)
    @NotNull
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 20)
    private String email;

    @Size(min = 3, max = 20)
    @NotNull
    @NotEmpty
    private String username;

    @Size(min = 7, max = 20)
    @NotNull
    private String password;

    @Size(min = 3, max = 100)
    @NotNull
    private String address;

    @NotNull
    private Long mobileNo;

    @NotNull
    private UserType userType;

    private Gender gender;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

    private String pan;

    private Integer experienceInYears;

    private Integer experienceInMonths;

    public RegistrationRequest() {}

    public RegistrationRequest(String name, String email, String username, String password, String address,
                               Long mobileNo, UserType userType, Gender gender, LocalDate dateOfBirth, String pan,
                               Integer experienceInYears, Integer experienceInMonths) {

        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.mobileNo = mobileNo;
        this.userType = userType;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.pan = pan;
        this.experienceInYears = experienceInYears;
        this.experienceInMonths = experienceInMonths;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email == null ? "" : email;
    }

    public String getUsername() {
        return username == null ? "" : username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public UserType getUserType() {
        return userType;
    }

    public Gender getGender() {
        return gender;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPan() {
        return pan;
    }

    public Integer getExperienceInYears() {
        return experienceInYears;
    }

    public Integer getExperienceInMonths() {
        return experienceInMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationRequest that = (RegistrationRequest) o;

        if (!getEmail().equals(that.getEmail())) return false;
        return getUsername().equals(that.getUsername());
    }

    @Override
    public int hashCode() {
        int result = getEmail().hashCode();
        result = 31 * result + getUsername().hashCode();
        return result;
    }

    public User mapToUser() {
        User user = new User();
        user.setName(this.name);
        user.setPassword(this.password);
        user.setRole(this.userType.toString());
        user.setUsername(this.username);
        user.setAddress(this.address);
        user.setDateOfBirth(this.dateOfBirth);
        user.setMobileNo(this.mobileNo);

        if(this.getUserType().equals(UserType.BUYER)) {
            user.setGender(this.gender == null ? null : this.gender.toString());
            user.setDateOfBirth(this.dateOfBirth);
        } else {
            user.setPan(this.pan);
            user.setExperienceInMonths(this.experienceInMonths);
            user.setExperienceInYears(this.experienceInYears);
        }
        return user;
    }
}
