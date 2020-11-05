/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author francobalsamo
 */
public class Reporte {
    private String nombreCompleto1;
    private String nombreCompleto2;
    private int cantidad;
    private Double monto;

    public String getNombreCompleto1() {
        return nombreCompleto1;
    }

    public void setNombreCompleto1(String nombreCompleto1) {
        this.nombreCompleto1 = nombreCompleto1;
    }

    public String getNombreCompleto2() {
        return nombreCompleto2;
    }

    public void setNombreCompleto2(String nombreCompleto2) {
        this.nombreCompleto2 = nombreCompleto2;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Reporte(String nombreCompleto1, String nombreCompleto2, int cantidad, Double monto) {
        this.nombreCompleto1 = nombreCompleto1;
        this.nombreCompleto2 = nombreCompleto2;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public Reporte() {
    }
    
    
    
}
