package com.example.repo;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    //custom method

    public List<Employee> findDataByEmpName(String empName);

    public Employee findDataByEmpContactNumber(long empContactNumber);

    public List<Employee> findDataByEmpDOB(Date empDOB);
}
