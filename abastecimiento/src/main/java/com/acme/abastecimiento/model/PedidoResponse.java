package com.acme.abastecimiento.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PedidoResponse {
    
    private String codigoEnvio;
    private String estado;
    
    public String getCodigoEnvio() {
        return codigoEnvio;
    }
    public void setCodigoEnvio(String codigoEnvio) {
        this.codigoEnvio = codigoEnvio;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
