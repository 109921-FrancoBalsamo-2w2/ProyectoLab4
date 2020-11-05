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
public class Reporte1 {
    private String deno;
    private int contador;

    public String getDeno() {
        return deno;
    }

    public void setDeno(String deno) {
        this.deno = deno;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Reporte1(String deno, int contador) {
        this.deno = deno;
        this.contador = contador;
    }

    public Reporte1() {
    }    
}
