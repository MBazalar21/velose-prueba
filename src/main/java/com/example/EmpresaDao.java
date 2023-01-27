package com.example;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaDao
{  
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Object registerEmpresa(Empresa empresa) {
        try {
            String sql = "INSERT INTO empresas (ruc, razonSocial, direccion, estado) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql, empresa.getRuc(), empresa.getRazonSocial(), empresa.getDireccion(), empresa.getEstado());
        } catch (Exception e) {
            // TODO: handle exception
            return e;
        }
    }

    public ArrayList<Empresa> getLastThreeBusinness() {
        String sql = "SELECT * FROM empresas ORDER BY id DESC LIMIT 3";
        return (ArrayList<Empresa>) jdbcTemplate.query(sql, new EmpresaRowMapper());
    }
}  