package com.example.service;


import com.example.dao.EmployeeDaoImpl;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee saveData(Employee employee){
        return employeeDaoImpl.saveData(employee);
    }

    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }

    public List<Employee> getDataByName(String empName){
        return employeeDaoImpl.getDataByName(empName);
    }

    public Employee getDataByContactNumber(long empContactNumber){
        return employeeDaoImpl.getDataByContactNumber(empContactNumber);
    }

    public Optional<Employee> getDataById(int empId){
        return employeeDaoImpl.getDataById(empId);
    }

    public List<Employee> getDataByDOB(String empDOB) throws ParseException {
        return employeeDaoImpl.getDataByDOB(empDOB);
    }
    public Employee updateData(int empId, Employee employee){
        return employeeDaoImpl.updateData(empId,employee);
    }

    public void deleteDataById(int empId){
        employeeDaoImpl.deleteDataById(empId);
    }

    public void deleteAllData(){
       employeeDaoImpl.deleteAllData();
    }
}
