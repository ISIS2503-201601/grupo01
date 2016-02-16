/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.dto;

/**
 *
 * @author slinanromero
 */
public class ZonaGeografica {
    public static String PERFIL_INFORMATIVO = "Informativo";
    public static String PERFIL_PRECAUCION = "Precaución";
    public static String PERFIL_ALERTA = "Alerta";
    public static String PERFIL_ALARMA = "Alarma";
    
    public static String ZONA_PACIFICO_CHOCO = "Pacífico - Chocó";
    public static String ZONA_PACIFICO_VALLE = "Pacífico - Valle del Cauca";
    public static String ZONA_PACIFICO_CAUCA = "Pacífico - Cauca";
    public static String ZONA_PACIFICO_NARIÑO = "Pacífico - Nariño";

    public static String ZONA_ATLANTICO_GUAJIRA = "Atlántico - Guajira";
    public static String ZONA_ATLANTICO_MAGDALENA = "Atlántico - Magdalena";
    public static String ZONA_ATLANTICO_SUCRE = "Atlántico - Sucre";
    public static String ZONA_ATLANTICO_CORDOBA = "Atlántico - Córdoba";
    public static String ZONA_ATLANTICO_ANTIOQUIA = "Atlántico - Antioquia";
    
    public static String ZONA_ATLANTICO = "Atlántico";
    public static String ZONA_PACIFICO = "Pacifico";
    
    private double latitud;
    private double longitud;
    private String nombre;
    private String zona;

    public ZonaGeografica(double latitud, double longitud, String nombre, String zona) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.zona = zona;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
    
    
    
    
    
}
