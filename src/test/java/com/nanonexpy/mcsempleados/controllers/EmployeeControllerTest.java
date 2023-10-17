package com.nanonexpy.mcsempleados.controllers;

import com.nanonexpy.mcsempleados.models.Employee;
import com.nanonexpy.mcsempleados.services.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author nanonexpy
 */

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @InjectMocks
    private EmployeeController controller;
    
    @Mock
    private EmployeeService service;
    
    @Test
    @DisplayName("If listarEmpleados() works successfully")
    public void testListarEmpleados() {
        //Datos ficticios que espero de la respuesta
        List<Employee> empleadosEsperados = new ArrayList();
        
        //Configuro el comportamiento del mock
        Mockito.when(service.getAllEmployees()).thenReturn(empleadosEsperados);
        
        //Llamo al método que quiero probar
        List<Employee> empleadosObtenidos = controller.listarEmpleados();
        
        //Verifico que la lista de empleados coincida con la lista esperada
        Assertions.assertEquals(empleadosEsperados, empleadosObtenidos);
    }
}
