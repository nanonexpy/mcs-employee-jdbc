package com.nanonexpy.mcsempleados.controllers;

import com.nanonexpy.mcsempleados.models.Employee;
import com.nanonexpy.mcsempleados.services.EmployeeService;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        Employee empleado1 = new Employee(1L, "Juanito", "Garcia", "1234567", "Male", "correo@prueba.com", "0991321456", "Buenos Aires", "Progrmador", "Inactivo", LocalDateTime.now(), LocalDateTime.now());
        Employee empleado2 = new Employee(2L, "Juanito", "Garcia", "1234567", "Male", "correo@prueba.com", "0991321456", "Buenos Aires", "Progrmador", "Inactivo", LocalDateTime.now(), LocalDateTime.now());
        //Datos ficticios que espero de la respuesta
        List<Employee> empleadosEsperados = Arrays.asList(empleado1, empleado2);

        //Configuro el comportamiento del mock
        Mockito.when(service.getAllEmployees()).thenReturn(empleadosEsperados);

        //Llamo al método que quiero probar
        ResponseEntity<List<Employee>> response = controller.listarEmpleados();

        //Verifico que la lista de empleados coincida con el resultado que espero
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(empleadosEsperados, response.getBody());
    }

    @Test
    @DisplayName("If listarEmpleados() retrieve an empty list")
    public void testListarEmpleados_EmptyList() {
        Mockito.when(service.getAllEmployees()).thenReturn(Collections.emptyList());

        ResponseEntity<List<Employee>> response = controller.listarEmpleados();

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
