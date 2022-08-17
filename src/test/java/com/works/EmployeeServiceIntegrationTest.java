package com.works;

import com.works.entities.Employee;
import com.works.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.works.EmployeeServiceDataBuilder.aValidEmployee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceIntegrationTest {
    @Autowired
    EmployeeService testee;

    @Test
    public void testCreateEmployee()
    {
        ResponseEntity<Employee> employeeResponseEntity = testee.save(aValidEmployee());
        assertEquals(HttpStatus.OK, employeeResponseEntity.getStatusCode());
        assertNotNull(employeeResponseEntity.getBody());
    }

    @Test
    public void testUpdate(){
        ResponseEntity<Employee> employeeResponseEntity=testee.update(aValidEmployee());
        assertEquals(HttpStatus.OK,employeeResponseEntity.getStatusCode());
        assertNotNull(employeeResponseEntity.getBody());
    }
}
