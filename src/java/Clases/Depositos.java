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
public class Depositos {
    private int id;
    private String datos;
    private double monto;
    private int pareja;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getPareja() {
        return pareja;
    }

    public void setPareja(int pareja) {
        this.pareja = pareja;
    }

    public Depositos() {
    }

    public Depositos(String datos, double monto, int pareja) {
        this.datos = datos;
        this.monto = monto;
        this.pareja = pareja;
    }
    
}
