package com.nanonexpy.mcsempleados.services;


import com.nanonexpy.mcsempleados.models.Employee;
import com.nanonexpy.mcsempleados.models.rowMapper.EmployeeRowMapper;
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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author nanonexpy
 */

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService service;
    
    @Mock
    private NamedParameterJdbcTemplate template;
    
    @Test
    @DisplayName("Get all employees successfully")
    public void testGetAllEmployees(){
        List<Employee> empleadosEsperados = new ArrayList<>();
        Mockito.when(template.query(Mockito.<String>any(), Mockito.<EmployeeRowMapper>any())).thenReturn(empleadosEsperados);
        
        List<Employee> empleadosObtenidos = service.getAllEmployees();
        Assertions.assertEquals(empleadosEsperados, empleadosObtenidos);
    }
}
