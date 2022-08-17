package com.works;

import com.works.entities.Employee;

import java.math.BigDecimal;
import java.sql.Date;

import static java.lang.Boolean.FALSE;

public class EmployeeServiceDataBuilder {

    private static final Long ID=1L;
    private static final String FIRST_NAME="firstName";
    private static final String LAST_NAME="lastName";
    private static final Long IDENTIFICATION_NUMBER= 12345678902L;
    private static final String OFFICE_LOCATION = "officeLocation";
    private static final String DEPARTMENT = "department";
    private static final BigDecimal SALARY = BigDecimal.valueOf(30000);
    private static final Date START_DATE = new Date(System.currentTimeMillis());
    private static final Boolean WINNER = FALSE;

    protected static Employee aValidEmployee(){
        return new Employee(ID,FIRST_NAME,LAST_NAME,IDENTIFICATION_NUMBER,OFFICE_LOCATION,DEPARTMENT,SALARY,START_DATE,WINNER);
    }
}
