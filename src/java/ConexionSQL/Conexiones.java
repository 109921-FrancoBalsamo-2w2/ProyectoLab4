/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionSQL;

import Clases.Articulos;
import Clases.Depositos;
import Clases.Parejas;
import Clases.Reporte;
import Clases.Reporte1;
import Clases.tipoArticulosClase;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francobalsamo
 */
public class Conexiones {
    private Connection conexion;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public void abrirConexion(){
        try{
            String url = "jdbc:sqlserver://EQUIPOFB\\FRANCOBALSAMO\\SQLEXPRESS:1433;database=TiendaArticulos";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conexion = DriverManager.getConnection(url, "sa", "franquito13");
        }catch(Exception e){
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }
    
    public void cerrarConexion(){
        try{
            conexion.close();
        }catch(Exception e){
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
    //////////////////↓↓↓↓↓↓//////////////////
    //////////////////ALTAS//////////////////
    //////////////////↓↓↓↓↓↓//////////////////
    
    public void insertPareja(Parejas p){
        try{
            abrirConexion();
            preparedStatement = conexion.prepareStatement("INSERT INTO pareja VALUES (?,?,?,?,?) ");
            preparedStatement.setString(1, p.getNombreUno());
            preparedStatement.setString(2, p.getApellidoUno());
            preparedStatement.setString(3, p.getNombreDos());
            preparedStatement.setString(4, p.getApellidoDos());
            preparedStatement.setInt(5, p.getIdBorrado());
            preparedStatement.execute();
            preparedStatement.close();
        }catch(SQLException sql){
            System.out.println("Error al insertar: " + sql.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("No se pudo cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public void insertArticulo(Articulos a){
        try{
            abrirConexion();
            preparedStatement = conexion.prepareStatement("INSERT INTO articulo VALUES (?,?,?,?) ");
            preparedStatement.setString(1, a.getCodigo());
            preparedStatement.setString(2, a.getDenominacion());
            preparedStatement.setDouble(3, a.getPrecioUnitario());
            preparedStatement.setInt(4, a.getIdta());
            preparedStatement.execute();
            preparedStatement.close();
        }catch(SQLException sql){
            System.out.println("Error al insertar: " + sql.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("No se pudo cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public void insertDepositos(Depositos d){
        try{
            abrirConexion();
            preparedStatement = conexion.prepareStatement("INSERT INTO deposito VALUES (?,?,?) ");
            preparedStatement.setString(1, d.getDatos());
            preparedStatement.setDouble(2, d.getMonto());
            preparedStatement.setInt(3, d.getPareja());
            preparedStatement.execute();
            preparedStatement.close();
        }catch(SQLException sql){
            System.out.println("Error al insertar: " + sql.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("No se pudo cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    //////////////////↓↓↓↓↓↓//////////////////
    //////////////////LISTAS//////////////////
    //////////////////↓↓↓↓↓↓//////////////////
    
    public ArrayList<tipoArticulosClase> articulosTa(){
        ArrayList<tipoArticulosClase> lista = new ArrayList<>();
        try{
            abrirConexion();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery("SELECT idTa, denominacionTA "
                    + "FROM tipoArticulo ");
            while(resultSet.next()){
               tipoArticulosClase tpc = new tipoArticulosClase();
               tpc.setId(resultSet.getInt(1));
               tpc.setTipo(resultSet.getString(2));
               lista.add(tpc);
            }
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al mostrar los tipos de artículos: " + e.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<Parejas> parejasListas(){
        ArrayList<Parejas> lista = new ArrayList<>();
        try{
            abrirConexion();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery("SELECT idP, nombre1 + ' '  + apellido1 AS nombreCompletoUno, "
                    + "nombre2 + ' '  + apellido2 AS nombreCompletoDos "
                    + "FROM pareja "
                    + "WHERE idBorrado = 0");
            while(resultSet.next()){
               Parejas parejas = new Parejas();
               parejas.setId(resultSet.getInt(1));
               parejas.setNombreCompleto1(resultSet.getString(2));
               parejas.setNombreCompleto2(resultSet.getString(3));
               lista.add(parejas);
            }
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al mostrar las parejas: " + e.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<Parejas> parejasListasByM(int a){
        ArrayList<Parejas> lista = new ArrayList<>();
        String consultarLista = "SELECT idP, nombre1, apellido1, nombre2, apellido2 "
                                + "FROM pareja "
                                + "WHERE idP = ? ";
        abrirConexion();
        try(PreparedStatement consulta = conexion.prepareStatement(consultarLista)){
            consulta.setInt(1, a);
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
               Parejas parejas = new Parejas();
               parejas.setId(rs.getInt(1));
               parejas.setNombreUno(rs.getString(2));
               parejas.setApellidoUno(rs.getString(3));
               parejas.setNombreDos(rs.getString(4));
               parejas.setApellidoDos(rs.getString(5));
               lista.add(parejas);
            }    
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al mostrar las parejas: " + e.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<Articulos> articulosListasByM(int a){
        ArrayList<Articulos> lista = new ArrayList<>();
        String consultarLista = "SELECT idA, codigo, denominacionA, a.idTA, ta.denominacionTA, precioUnitario "
                + "FROM articulo a "
                + "INNER JOIN tipoArticulo ta ON a.idTA = ta.idTA "
                + "WHERE idA = ?";
        abrirConexion();
        try(PreparedStatement consulta = conexion.prepareStatement(consultarLista)){
            consulta.setInt(1, a);
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
               Articulos articulos = new Articulos();
               articulos.setIdA(rs.getInt(1));
               articulos.setCodigo(rs.getString(2));
               articulos.setDenominacion(rs.getString(3));
               articulos.setIdta(rs.getInt(4));
               articulos.setTiar(rs.getString(5));
               articulos.setPrecioUnitario(rs.getDouble(6));
               lista.add(articulos);
            }    
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al mostrar los artículos: " + e.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<Articulos> articulosListaPareja(int a){
        ArrayList<Articulos> lista = new ArrayList<>();
        String consultarLista = "SELECT p.nombre1 + ' ' + p.apellido1, p.nombre2 + ' ' + p.apellido2, a.denominacionA, a.precioUnitario "
                                + "FROM articuloPareja ap "
                                + "INNER JOIN articulo a ON ap.idA = a.idA "
                                + "INNER JOIN pareja p ON ap.idPa = p.idP "
                                + "WHERE ap.idPa = ?";
        abrirConexion();
        try(PreparedStatement consulta = conexion.prepareStatement(consultarLista)){
            consulta.setInt(1, a);
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
               Articulos articulos = new Articulos();
               articulos.setP1(rs.getString(1));
               articulos.setP2(rs.getString(2));
               articulos.setDenominacion(rs.getString(3));
               articulos.setPrecioUnitario(rs.getDouble(4));
               lista.add(articulos);
            }    
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al mostrar los artículos: " + e.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<Articulos> articulosLista(){
        ArrayList<Articulos> lista = new ArrayList<>();
        String consultarLista = "SELECT idA, codigo, denominacionA, precioUnitario "
                                + "FROM articulo "
                                + "WHERE idBorrado = 0";
        abrirConexion();
        try(PreparedStatement consulta = conexion.prepareStatement(consultarLista)){
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
               Articulos articulos = new Articulos();
               articulos.setIdA(rs.getInt(1));
               articulos.setCodigo(rs.getString(2));
               articulos.setDenominacion(rs.getString(3));
               articulos.setPrecioUnitario(rs.getDouble(4));
               lista.add(articulos);
            }    
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al mostrar los artículos: " + e.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }
    
    //////////////////↓↓↓↓↓↓//////////////////
    //////////////////UPDATES/////////////////
    //////////////////↓↓↓↓↓↓//////////////////
    
    public boolean ModPar(Parejas pa){
        boolean valor = false;
       
        try{
            abrirConexion();
            String modificarPareja = "UPDATE pareja "
                + "SET nombre1 = ?, apellido1 = ?, nombre2 = ?, apellido2 = ? "
                + "WHERE idP = ?";
            preparedStatement = conexion.prepareStatement(modificarPareja);
            preparedStatement.setString(1, pa.getNombreUno());
            preparedStatement.setString(2, pa.getApellidoUno());
            preparedStatement.setString(3, pa.getNombreDos());
            preparedStatement.setString(4, pa.getApellidoDos());
            preparedStatement.setInt(5, (int)pa.getId());
            
            preparedStatement.executeUpdate();
            valor = true;
        }catch(Exception e){
            System.out.println("Ocurrió un error al modificar una Pareja: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return valor;
    }
    
    public boolean ModAr(Articulos a){
        boolean valor = false;
       
        try{
            abrirConexion();
            String modificarPareja = "UPDATE articulo "
                + "SET codigo = ?, denominacionA = ?, precioUnitario = ? "
                + "WHERE idA = ?";
            preparedStatement = conexion.prepareStatement(modificarPareja);
            preparedStatement.setString(1, a.getCodigo());
            preparedStatement.setString(2, a.getDenominacion());
            preparedStatement.setDouble(3, a.getPrecioUnitario());
            preparedStatement.setInt(4, (int)a.getIdA());
            
            preparedStatement.executeUpdate();
            valor = true;
        }catch(Exception e){
            System.out.println("Ocurrió un error al modificar el artículo: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return valor;
    }
    
    public boolean EliPar(Parejas pa){
        boolean valor = false;
       
        try{
            abrirConexion();
            String modificarPareja = "UPDATE pareja "
                + "SET idBorrado = ? "
                + "WHERE idP = ?";
            preparedStatement = conexion.prepareStatement(modificarPareja);
            preparedStatement.setInt(1, (int)pa.getIdBorrado());
            preparedStatement.setInt(2, (int)pa.getId());
            
            preparedStatement.executeUpdate();
            valor = true;
        }catch(Exception e){
            System.out.println("Ocurrió un error al eliminar una Pareja: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return valor;
    }
    
    public boolean EliAr(Articulos a){
        boolean valor = false;
       
        try{
            abrirConexion();
            String bajaArticulo = "UPDATE articulo "
                + "SET idBorrado = ? "
                + "WHERE idA = ?";
            preparedStatement = conexion.prepareStatement(bajaArticulo);
            preparedStatement.setInt(1, (int)a.getIdBorrado());
            preparedStatement.setInt(2, (int)a.getIdA());
            
            preparedStatement.executeUpdate();
            valor = true;
        }catch(Exception e){
            System.out.println("Ocurrió un error al modificar el artículo: " + e.getMessage());
        } finally {
            try {
                cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return valor;
    }
    
    //////////////////↓↓↓↓↓↓//////////////////
    //////////////////Reportes////////////////
    //////////////////↓↓↓↓↓↓//////////////////
    
    public ArrayList<Reporte> reporte(){
        ArrayList<Reporte> lista = new ArrayList<>();
        String reporte1 = "SELECT p.nombre1 + ' ' + p.apellido1, p.nombre2 + ' ' + p.apellido2, COUNT(d.idD), SUM(montoD) "
                        + "FROM pareja p "
                        + "INNER JOIN deposito d ON d.idP = p.idP "
                        + "WHERE idBorrado = 0 "
                        + "GROUP BY nombre1, apellido1, nombre2, apellido2";
        try{
            abrirConexion();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(reporte1);
            while(resultSet.next()){
               Reporte rp = new Reporte();
               rp.setNombreCompleto1(resultSet.getString(1));
               rp.setNombreCompleto2(resultSet.getString(2));
               rp.setCantidad(resultSet.getInt(3));
               rp.setMonto(resultSet.getDouble(4));
               lista.add(rp);
            }    
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al mostrar el reporte: " + e.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }
    
    public ArrayList<Reporte1> reporteUno(){
        ArrayList<Reporte1> lista = new ArrayList<>();
        String reporte1 = "SELECT TOP 5 a.denominacionA, COUNT(ap.idPa) "
                + "FROM articuloPareja ap "
                + "INNER JOIN pareja p ON ap.idPa = p.idP "
                + "INNER JOIN articulo a ON a.idA = ap.idA "
                + "GROUP BY a.denominacionA "
                + "HAVING COUNT(ap.idPa) >=5";
        try{
            abrirConexion();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(reporte1);
            while(resultSet.next()){
               Reporte1 rp1 = new Reporte1();
               rp1.setDeno(resultSet.getString(1));
               rp1.setContador(resultSet.getInt(2));
               lista.add(rp1);
            }    
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al mostrar el reporte: " + e.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }
    
    
    public ArrayList<Articulos> reporteDos(){
        ArrayList<Articulos> lista = new ArrayList<>();
        String reporte2 = "SELECT SUM(a.precioUnitario) "
                        + "FROM articuloPareja ap "
                        + "INNER JOIN articulo a "
                        + "ON ap.idA = a.idA "
                        + "INNER JOIN pareja p "
                        + "ON p.idP = ap.idPa";
        try{
            abrirConexion();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(reporte2);
            while(resultSet.next()){
               Articulos articulos = new Articulos();
               articulos.setPrecioUnitario(resultSet.getDouble(1));
               lista.add(articulos);
            }    
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al mostrar el reporte: " + e.getMessage());
        }finally{
            try{
                cerrarConexion();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista;
    }
}
