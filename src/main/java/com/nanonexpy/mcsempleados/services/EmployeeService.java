package com.nanonexpy.mcsempleados.services;

import com.nanonexpy.mcsempleados.models.Employee;
import com.nanonexpy.mcsempleados.models.rowMapper.EmployeeRowMapper;
import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author nanonexpy
 */

@Service
public class EmployeeService {
    private final NamedParameterJdbcTemplate template;

    public EmployeeService(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    
    //Consulta SQL
    public List<Employee> getAllEmployees(){
        String consulta = "SELECT * FROM employees";
        return template.query(consulta, new EmployeeRowMapper());
    } 
}
