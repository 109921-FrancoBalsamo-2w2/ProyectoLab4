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
public class Articulos {
    private int idA;
    private String codigo;
    private String denominacion;
    private double precioUnitario;
    private int idta;
    private String tiar;
    private int idBorrado;

    public int getIdBorrado() {
        return idBorrado;
    }

    public void setIdBorrado(int idBorrado) {
        this.idBorrado = idBorrado;
    }
    
    

    public String getTiar() {
        return tiar;
    }

    public void setTiar(String tiar) {
        this.tiar = tiar;
    }

    public Articulos(String codigo, String denominacion, double precioUnitario) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.precioUnitario = precioUnitario;
    }
    
    
    
    private String p1;
    private String p2;

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
    
    
    
    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Articulos() {
    }

    public int getIdta() {
        return idta;
    }

    public void setIdta(int idta) {
        this.idta = idta;
    }

    public Articulos(String codigo, String denominacion, double precioUnitario, int idta) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.precioUnitario = precioUnitario;
        this.idta = idta;
    }

    public Articulos(int idBorrado) {
        this.idBorrado = idBorrado;
    }
    
    
}
