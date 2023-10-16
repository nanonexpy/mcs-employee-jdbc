package com.nanonexpy.mcsempleados.controllers;

import com.nanonexpy.mcsempleados.services.DataGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nanonexpy
 */

@RestController
@RequestMapping("/generar-empleados")
public class DataGeneratorController {
    private final DataGeneratorService service;
    
    @Autowired
    public DataGeneratorController(DataGeneratorService service){
        this.service = service;
    }
    
    @GetMapping
    public String generarDatos(){
        service.generateAndInsertData(10);
        return "Datos generados y guardados en la base de datos.";
    }
}
