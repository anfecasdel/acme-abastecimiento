package com.acme.abastecimiento.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PedidoRequest {
    
    private String pedido;
    private String cantidad;
    private String EAN;
    private String producto;
    private String cedula;
    private String direccion;

    public String getPedido() {
        return pedido;
    }
    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public String getEAN() {
        return EAN;
    }
    public void setEAN(String eAN) {
        EAN = eAN;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
