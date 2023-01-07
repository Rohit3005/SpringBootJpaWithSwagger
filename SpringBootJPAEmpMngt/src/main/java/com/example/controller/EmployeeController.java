package com.example.controller;

import com.example.exception.RecordNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyname/{empName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName){
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<String> updateData(@PathVariable int empId, @RequestBody Employee employee){
        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(()-> new RecordNotFoundException("EMPLOYEE NOT EXIST"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());

        employeeServiceImpl.updateData(empId,employee1);
        return ResponseEntity.ok("DATA UPDATED");
    }

    @GetMapping("/getdatabydob/{empDOB}")
    public ResponseEntity<List<Employee>> getDataByDOB(@PathVariable String empDOB) throws ParseException {
        return ResponseEntity.ok(employeeServiceImpl.getDataByDOB(empDOB));
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("DATA DELETEED");
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData(){
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("DELETE ALL DATA");
    }
}
