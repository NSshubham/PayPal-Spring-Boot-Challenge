package com.paypal.bfs.test.employeeserv.mappers;

import com.paypal.bfs.test.employeeserv.dto.EmployeeDTO;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO mapEmployeetoEmployeeDTO(Employee e){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(e.getId());
        employeeDTO.setFirstName(e.getFirstName());
        employeeDTO.setLastName(e.getLastName());
        employeeDTO.setDob(e.getDob());
        employeeDTO.setLine1(e.getLine1());
        employeeDTO.setLine2(e.getLine2());
        employeeDTO.setCity(e.getCity());
        employeeDTO.setState(e.getState());
        employeeDTO.setCountry(e.getCountry());
        employeeDTO.setZipCode(e.getZipCode());

        return employeeDTO;
    }

    public Employee mapEmployeeDTOtoEmployee(EmployeeDTO eDTO){
        Employee employee = new Employee();
        employee.setId(eDTO.getId());
        employee.setFirstName(eDTO.getFirstName());
        employee.setLastName(eDTO.getLastName());
        employee.setDob(eDTO.getDob());
        employee.setLine1(eDTO.getLine1());
        employee.setLine2(eDTO.getLine2());
        employee.setCity(eDTO.getCity());
        employee.setState(eDTO.getState());
        employee.setCountry(eDTO.getCountry());
        employee.setZipCode(eDTO.getZipCode());

        return employee;
    }
}
