package com.coder.crudSpringBoot.service;

import com.coder.crudSpringBoot.entity.Employee;
import com.coder.crudSpringBoot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(Long id){
        Optional<Employee> employeeResp = employeeRepository.findById(id);

        if (employeeResp.isPresent()){
            return employeeResp.get();
        }
        return null;
    }

    public List<Employee> getAllEmployee(){
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }
    public Employee createEmployee(Employee employee){
        Employee createdEmployee = employeeRepository.save(employee);
        return createdEmployee;
    }

    public Employee updateEmployee(Long id, Employee employeeReq){
       Optional<Employee> existingEmployee = employeeRepository.findById(id);

       if (existingEmployee.isEmpty()){
           return null;
       }

       Employee employeeToSave = existingEmployee.get();
       employeeToSave.setName(employeeReq.getName());
       employeeToSave.setEmail(employeeReq.getEmail());
       employeeToSave.setDepartment(employeeReq.getDepartment());
       employeeToSave.setSalary(employeeReq.getSalary());

       return employeeRepository.save(employeeToSave);
    }

    public Boolean deleteEmployee(Long id){
        Boolean isEmployee = employeeRepository.existsById(id);

        if (!isEmployee) return false;

        employeeRepository.deleteById(id);
        return true;
    }
}
