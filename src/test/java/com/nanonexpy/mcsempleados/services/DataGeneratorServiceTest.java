package com.nanonexpy.mcsempleados.services;

import com.github.javafaker.Faker;
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
public class DataGeneratorServiceTest {
    @InjectMocks
    private DataGeneratorService service;
    
    @Mock
    private NamedParameterJdbcTemplate template;
    
    @Mock
    private Faker faker;
    
    @Test
    @DisplayName("JavaFaker generates and inserts data successfully")
    public void testGenerateAndInsertData(){
        int numRecords = 5;
        service.generateAndInsertData(numRecords);
        
        Mockito.verify(template, Mockito.times(numRecords)).update(Mockito.any(), Mockito.anyMap());
    }
}
