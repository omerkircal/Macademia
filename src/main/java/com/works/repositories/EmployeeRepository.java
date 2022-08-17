package com.works.repositories;

import com.works.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByIdentificationNumber(Long identificationNumber);

    List<Employee> findEmployeesByStartDateAfterAndSalaryGreaterThan(Date startDate, BigDecimal salary);

    @Transactional
    @Modifying
    @Query("update Employee e set e.winner = true where e.id = ?1")
    void updateWinnerTrueById(Long id);


    @Transactional
    @Modifying
    @Query("update Employee e set e.winner=false ")
    void resetWinner();


    @Query(value="SELECT * FROM Employee e WHERE e.winner=TRUE ", nativeQuery = true)
    Employee getWinner();


    @Modifying()
    @Transactional
    @Query(value="update Employee e SET e.OFFICE_LOCATION =?2 where e.DEPARTMENT =?1", nativeQuery = true)
    void updateOfficeLocationByDepartment(String department,String officeLocation);


}