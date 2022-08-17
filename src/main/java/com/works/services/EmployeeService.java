package com.works.services;

import com.works.entities.Employee;
import com.works.repositories.EmployeeRepository;
import com.works.utils.REnum;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;

@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity save(Employee employee){
        Map<REnum,Object> hm=new LinkedHashMap<>();
        Optional<Employee> optionalEmployee=employeeRepository.findByIdentificationNumber(employee.getIdentificationNumber());
        if(!optionalEmployee.isPresent()){
            Employee employee1=employeeRepository.save(employee);
            hm.put(REnum.status,true);
            hm.put(REnum.result,employee1);
            return new ResponseEntity(hm, HttpStatus.OK);
        }else{
            hm.put(REnum.status,false);
            hm.put(REnum.result,"There is already a employee with this ID");
            return new ResponseEntity<>(hm, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity update(Employee employee){
        Map<REnum,Object> hm=new LinkedHashMap<>();
        try {
            Optional<Employee> optionalEmployee=employeeRepository.findById(employee.getId());
            if(optionalEmployee.isPresent()){
                employeeRepository.saveAndFlush(employee);
                hm.put(REnum.status,true);
                hm.put(REnum.result,employee);
                return new ResponseEntity(hm,HttpStatus.OK);
            }else{
                hm.put(REnum.status,false);
                hm.put(REnum.message,"Update Error");
                return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            hm.put(REnum.status,false);
            hm.put(REnum.error,exception.getMessage());
        }
        return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity delete(Long id){
        Map<REnum,Object> hm=new LinkedHashMap<>();
        try {
            employeeRepository.deleteById(id);
            hm.put(REnum.result,true);
            return new ResponseEntity(hm,HttpStatus.OK);
        }catch (Exception exception){
            hm.put(REnum.result,false);
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity allEmployees(){
        Map<REnum,Object> hm=new LinkedHashMap<>();
        hm.put(REnum.result,employeeRepository.findAll());
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity getEmployee(Long id){
        Map<REnum,Object> hm=new LinkedHashMap<>();
        hm.put(REnum.result,employeeRepository.findById(id));
        return new ResponseEntity(hm,HttpStatus.OK);
    }


    public ResponseEntity updateDepartmentOfficeLocation(String department, String location){
        Map<REnum,Object> hm=new LinkedHashMap<>();
        try{
            employeeRepository.updateOfficeLocationByDepartment(department, location);
            hm.put(REnum.status,true);
            hm.put(REnum.result,location);
            hm.put(REnum.message,"Office location updated");
            return new ResponseEntity(hm, HttpStatus.OK);
        } catch (Exception exception) {
            hm.put(REnum.status,false);
            hm.put(REnum.error,exception.getMessage());
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getEmployeesByStartDateAndSalary(Date startDate, BigDecimal salary){
        Map<REnum,Object> hm=new LinkedHashMap<>();
        hm.put(REnum.result,employeeRepository.findEmployeesByStartDateAfterAndSalaryGreaterThan(startDate,salary));
        return new ResponseEntity(hm,HttpStatus.OK);
    }


    public ResponseEntity getWinner(){
        Map<REnum,Object> hm=new LinkedHashMap<>();
        hm.put(REnum.result,employeeRepository.getWinner());
        return new ResponseEntity(hm,HttpStatus.OK);
    }


    @Scheduled(cron = "0 0 9 1 * *")
    public void completeDraw(){
        employeeRepository.resetWinner();
        List<Employee> employeeList=employeeRepository.findAll();
        employeeRepository.updateWinnerTrueById(employeeList.get(new Random().nextInt(employeeList.size())).getId());
    }
}
