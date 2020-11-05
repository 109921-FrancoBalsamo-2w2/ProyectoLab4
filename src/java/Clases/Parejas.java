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
public class Parejas {
    private int id;
    private String nombreCompleto1;
    private String nombreCompleto2;
    private String nombreUno;
    private String nombreDos;
    private String apellidoUno;
    private String apellidoDos;
    private int idBorrado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Parejas(String nombreUno, String apellidoUno, String nombreDos, String apellidoDos, int idBorrado) {
        this.nombreUno = nombreUno;
        this.apellidoUno = apellidoUno;
        this.nombreDos = nombreDos;
        this.apellidoDos = apellidoDos;
        this.idBorrado = idBorrado;
    }
    
    public Parejas(int id, String nombreCompleto1, String nombreCompleto2) {
        this.id = id;
        this.nombreCompleto1 = nombreCompleto1;
        this.nombreCompleto2 = nombreCompleto2;
    }
    
    public Parejas(int idBorrado){
        this.idBorrado = idBorrado;
    }

    public Parejas() {
    }

    public String getNombreUno() {
        return nombreUno;
    }

    public void setNombreUno(String nombreUno) {
        this.nombreUno = nombreUno;
    }

    public String getNombreDos() {
        return nombreDos;
    }

    public void setNombreDos(String nombreDos) {
        this.nombreDos = nombreDos;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public int getIdBorrado() {
        return idBorrado;
    }

    public void setIdBorrado(int idBorrado) {
        this.idBorrado = idBorrado;
    }

    public Parejas(String nombreUno, String apellidoUno, String nombreDos, String apellidoDos) {
        this.nombreUno = nombreUno;
        this.apellidoUno = apellidoUno;
        this.nombreDos = nombreDos;
        this.apellidoDos = apellidoDos;
    }
    
    
    
}
