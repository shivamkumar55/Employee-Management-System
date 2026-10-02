package com.coder.crudSpringBoot.controller;

import com.coder.crudSpringBoot.entity.Employee;
import com.coder.crudSpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Employee employeeResp = employeeService.getEmployee(id);
        if (employeeResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeResp);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        if (employeeList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeReq){
        Employee employeeRes = employeeService.updateEmployee(id, employeeReq);
        if (employeeRes == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        Boolean isDelete = employeeService.deleteEmployee(id);
        if (!isDelete){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record is Deleted");
    }
}
