package com.example;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired  
    EmpresaDao empresaRepository;

    public Object saveOrUpdate(Empresa empresa) throws Exception {  
        try {
            return empresaRepository.registerEmpresa(empresa);
        } catch (Exception e) {
            // TODO: handle exception
            return e;
        }
    }

    public ArrayList<Empresa> getLastThreeBusinness() throws Exception {
        return empresaRepository.getLastThreeBusinness();
    }
}
