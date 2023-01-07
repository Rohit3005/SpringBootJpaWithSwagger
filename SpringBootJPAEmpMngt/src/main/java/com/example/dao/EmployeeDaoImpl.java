package com.example.dao;

import com.example.model.Employee;
import com.example.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee saveData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public List<Employee> getAllData(){
        return employeeRepoImpl.findAll();
    }

    public List<Employee> getDataByName(String empName){
        return employeeRepoImpl.findDataByEmpName(empName);
    }

    public Employee getDataByContactNumber(long empContactNumber){
        return employeeRepoImpl.findDataByEmpContactNumber(empContactNumber);
    }

    public Optional<Employee> getDataById(int empId){
        return  employeeRepoImpl.findById(empId);
    }

    public List<Employee> getDataByDOB(String empDOB) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date empDob1 = simpleDateFormat.parse(empDOB);
        return employeeRepoImpl.findDataByEmpDOB(empDob1);
    }
    public Employee updateData(int empId, Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public void deleteDataById(int empId){
        employeeRepoImpl.deleteById(empId);
    }

    public void deleteAllData(){
        employeeRepoImpl.deleteAll();
    }
}
