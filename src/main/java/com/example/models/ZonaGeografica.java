package com.example.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZonaGeografica implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    
    public ZonaGeografica()
    {
        
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    
    
}
