package com.nanonexpy.mcsempleados.models.rowMapper;

import com.nanonexpy.mcsempleados.models.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author nanonexpy
 */
public class EmployeeRowMapper implements RowMapper<Employee>{

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee model = new Employee();
        model.setId(rs.getLong("id"));
        model.setFirstName(rs.getString("first_name"));
        model.setLastName(rs.getString("last_name"));
        model.setDocumentNumber(rs.getString("document_number"));
        model.setGender(rs.getString("gender"));
        model.setEmail(rs.getString("email"));
        model.setPhoneNumber(rs.getString("phone_number"));
        model.setAddress(rs.getString("address"));
        model.setPosition(rs.getString("position"));
        model.setStatus(rs.getString("status"));
        model.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        model.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
        return model;
    }

}
