package com.example;

public class Empresa {
    private String ruc, razonSocial,direccion;
    private Boolean estado;

    //constructor
    public Empresa(String ruc,String razonSocial,String direccion,Boolean estado){
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.estado = estado;
    }
    
    public void setRuc(String r) {
        this.ruc = r;
    }

    public String getRuc() { 
        return (this.ruc);
    }
    
    public void setRazonSocial(String raz) {
        this.razonSocial = raz;
    }

    public String getRazonSocial() { 
        return (this.razonSocial);
    }
    
    public void setDireccion(String dir) {
        this.direccion = dir;
    }

    public String getDireccion() { 
        return (this.direccion);
    }
    
    public void setEstado(Boolean est) {
        this.estado = est;
    }

    public Boolean getEstado() { 
        return (this.estado);
    }
}
