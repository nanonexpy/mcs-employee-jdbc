package com.nanonexpy.mcsempleados.controllers;

import com.nanonexpy.mcsempleados.models.Employee;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nanonexpy
 */

@RestController
@RequestMapping("/empleados")
public class EmployeeController {
    
    public List<Employee> listarEmpleados() {
        return null;
    }
}
