package com.nanonexpy.mcsempleados.controllers;

import com.nanonexpy.mcsempleados.models.Employee;
import com.nanonexpy.mcsempleados.services.EmployeeService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nanonexpy
 */

@RestController
@RequestMapping("/empleados")
public class EmployeeController {
    private final EmployeeService service;
    
    public EmployeeController(EmployeeService service){
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Employee>> listarEmpleados() {
        List<Employee> employees = service.getAllEmployees();
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(employees);
        }
    }
}
