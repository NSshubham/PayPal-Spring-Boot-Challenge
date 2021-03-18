package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.dto.EmployeeDTO;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.mappers.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public Employee getById(String id){
        EmployeeDTO employeeDTO = employeeRepository.findById(Integer.valueOf(id)).get();
        Employee employee = employeeMapper.mapEmployeeDTOtoEmployee(employeeDTO);
        return employee;
    }

    public boolean create(Employee employeeReq){
        EmployeeDTO employeeDTO = null;
        employeeDTO = employeeRepository.save(employeeMapper.mapEmployeetoEmployeeDTO(employeeReq));
        if(Objects.nonNull(employeeDTO))
            return true;
        return false;
    }
}
