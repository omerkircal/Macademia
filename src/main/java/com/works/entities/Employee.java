package com.works.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please Enter First Name")
    @Length(message = "Your first name cannot exceed 50 characters.", max = 50)
    private String firstName;

    @NotBlank(message = "Please Enter Last Name")
    @Length(message = "Your last  name cannot exceed 50 characters.", min = 0, max = 50)
    private String lastName;


    @NotNull(message = "Please Enter Identification Number")
    private Long identificationNumber;

    @NotBlank(message = "Please Enter Office Location")
    @Length(message = "Your office location cannot exceed 50 characters.", min = 0, max = 50)
    private String officeLocation;

    @NotBlank(message = "Please Enter Department")
    @Length(message = "Your department cannot exceed 50 characters.", min = 0, max = 50)
    private String department;

    @NotNull(message = "Please Enter Salary")
    private BigDecimal salary;

    @NotNull(message = "Please Enter Star Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    private Boolean winner=false;


}
