package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeResourceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(String id) {

        Employee employee = employeeService.getById(id);
        if(employee == null)
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity createEmployee(Employee employeeReq) {

        boolean f = employeeService.create(employeeReq);
        if(f){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

       return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

}
