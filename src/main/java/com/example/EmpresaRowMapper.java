package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpresaRowMapper implements RowMapper<Empresa>{

    @Override
    public Empresa mapRow(ResultSet resultSet, int i) throws SQLException {
        // TODO Auto-generated method stub
        Empresa empresa = new Empresa(null, null, null, null);
        empresa.setRuc(resultSet.getString("ruc"));
        empresa.setRazonSocial(resultSet.getString("razonSocial"));
        empresa.setDireccion(resultSet.getString("direccion"));
        empresa.setEstado(resultSet.getBoolean("estado"));
        return empresa;
    }
    
}
