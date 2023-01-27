package com.example;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresa")
public class VeloseController {
    
    @Autowired
    private EmpresaService empresaService;
    
    @RequestMapping("/home")
    String hello() {
        return "Hello World!";
    }

    @PostMapping("/create")
    public Object create(@RequestBody Empresa empresa) throws Exception {
        try {
            return empresaService.saveOrUpdate(empresa);
        } catch (Exception e) {
            // TODO: handle exception
            return e;
        }
    }

    @GetMapping("/findLastThree")
    public ArrayList<Empresa> findLastThree() throws Exception {   
        try {
            return empresaService.getLastThreeBusinness();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
