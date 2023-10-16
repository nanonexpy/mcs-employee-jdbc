package com.nanonexpy.mcsempleados.services;

import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author nanonexpy
 */

@Service
public class DataGeneratorService {
    private final NamedParameterJdbcTemplate template;
    private final Faker faker;
    
    @Autowired
    public DataGeneratorService(NamedParameterJdbcTemplate template) {
        this.template = template;
        this.faker = new Faker();
    }
    
    public void generateAndInsertData(int numRecords) {
        for(int i = 0; i < numRecords; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String documentNumber = faker.idNumber().valid();
            String gender = faker.demographic().sex();
            String email = faker.internet().emailAddress();
            String phoneNumber = faker.phoneNumber().cellPhone();
            String address = faker.address().fullAddress();
            String position = faker.job().position();
            String status = faker.options().option("Activo", "Inactivo", "En espera");
            LocalDateTime createdAt = LocalDateTime.now();
            LocalDateTime updatedAt = createdAt;
            
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("firstName", firstName);
            parameters.put("lastName", lastName);
            parameters.put("documentNumber", documentNumber);
            parameters.put("gender", gender);
            parameters.put("email", email);
            parameters.put("phoneNumber", phoneNumber);
            parameters.put("address", address);
            parameters.put("position", position);
            parameters.put("status", status);
            parameters.put("createdAt", createdAt);
            parameters.put("updatedAt", updatedAt);
            
            String sql = "INSERT INTO employees "
                    + "(first_name, last_name, document_number, gender, email, "
                    + "phone_number, address, position, status, created_at, updated_at) VALUES "
                    + "(:firstName, :lastName, :documentNumber, :gender, :email, "
                    + ":phoneNumber, :address, :position, :status, :createdAt, :updatedAt) ";

            template.update(sql, parameters);
        }
    }
}
