package com.test.User.usermanagement.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by AshayRajimwale on 6/24/2017.
 */
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false)
    private UUID id;

//    @Column(name="password",nullable=false)
//    @NotNull
//    @Size(max=64)
//    private String password;

    @Column(name="firstName")
    @NotNull(message = "error.null")
    @Pattern(regexp = "[a-z-A-Z]*", message = "error.firstName")
    private String firstName;


    @Column(name="middleName")
    @Pattern(regexp = "[a-z-A-Z]*", message = "error.middleName")
    private String middleName;

    @Column(name="lastName")
    @NotNull(message = "error.null")
    @Pattern(regexp = "[a-z-A-Z]*", message = "error.middleName")
    private String lastName;

    @Column(name="age")
    @Range(min = 0,max = 150,message="error.age")
    private Integer age;

    @Column(name="gender")
    @NotNull(message = "error.null")
    @Size(max=1,message="error.null")
    @Pattern(regexp = "[^mf]", message = "error.gender")
    private String gender;

    @Column(name="phoneNumber")
    @NotNull(message = "error.null")
    @Size(min=10,max=10,message = "error.phonenumber")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message="error.phonenumber")
        private String phoneNumber;

    @Column(name="zip")
    private String zip;


    public User()
    {

    }

    public User(String firstName, String middleName, String lastName, Integer age, String gender, String phoneNumber, String zip) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.zip = zip;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
