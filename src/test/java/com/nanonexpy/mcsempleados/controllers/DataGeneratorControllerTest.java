package com.nanonexpy.mcsempleados.controllers;

import com.nanonexpy.mcsempleados.services.DataGeneratorService;
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
public class DataGeneratorControllerTest {
    @InjectMocks
    private DataGeneratorController controller;
    
    @Mock
    private DataGeneratorService service;
    
    @Test
    @DisplayName("If listarEmpleados() works successfully")
    public void testListarEmpleados() {
        //Datos ficticios que espero de la respuesta
        int numRecords = 10;
        String respuesta = "Datos generados y guardados en la base de datos.";
        
        //Configuro el comportamiento del mock
        Mockito.doNothing().when(service).generateAndInsertData(numRecords);
        
        //Llamo al método que quiero probar
        String respuestaEsperada = controller.generarDatos();
        
        //Verifico que la lista de empleados coincida con la lista esperada
        Assertions.assertEquals(respuestaEsperada, respuesta);
    }
}
