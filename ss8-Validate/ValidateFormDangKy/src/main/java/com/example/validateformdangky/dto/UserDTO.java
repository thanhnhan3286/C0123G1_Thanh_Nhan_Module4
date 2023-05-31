package com.example.validateformdangky.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;


public class UserDTO implements Validator {
    private Integer id;
    @NotBlank(message = "Không đúng định dạng")
    @Size(min = 1, max = 45, message = "Phải ít hơn 45 ký tự")
    private String firstName;
    @NotBlank(message = "Không đúng định dạng")
    @Size(min = 1, max = 45, message = "Phải ít hơn 45 ký tự")
    private String lastName;
    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải có 10 số, bắt đầu bằng số 0")
    @NotBlank(message = "Không đúng định dạng số điện thoại. Vd: 0123456789")
    private String phoneNumber;
    @NotBlank(message = "Không được để trống")
    private String birthDay;
    @Email(message = "Không đúng định dạng")
    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 60, message = "Phải nhiều hơn 5 ký tự và ít hơn 60 ký tự")
    private String email;
    public UserDTO() {
    }

    public UserDTO(Integer id, String firstName, String lastName, String phoneNumber, String birthDay, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.email = email;
    }


    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate age = LocalDate.parse(userDTO.birthDay, formatter);
            LocalDate now = LocalDate.now();
            int yearOld = Period.between(age, now).getYears();
            if (yearOld < 18 || yearOld > 89) {
                errors.rejectValue("birthDay", "","Tuổi tối thiểu là 18, tối đa là 89 vui lòng kiểm tra lại");
            }
        } catch (DateTimeParseException e) {
            errors.rejectValue("birthDay", "","Định dạng ngày không hợp lệ, vui lòng kiểm tra lại");
        }
    }

}
