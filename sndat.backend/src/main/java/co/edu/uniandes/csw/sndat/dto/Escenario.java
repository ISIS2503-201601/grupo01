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
public class Escenario {
    public static String PERFIL_INFORMATIVO = "Informativo";
    public static String PERFIL_PRECAUCION = "Precaución";
    public static String PERFIL_ALERTA = "Alerta";
    public static String PERFIL_ALARMA = "Alarma";
    
    private double tiempoMax;
    private double tiempoMin;
    private double alturaMax;
    private double alturaMin;
    private ZonaGeografica zona;
    private String perfilAlerta;

    public Escenario(double tiempoMax, double tiempoMin, double alturaMax, double alturaMin, ZonaGeografica zona, String perfilAlerta) {
        this.tiempoMax = tiempoMax;
        this.tiempoMin = tiempoMin;
        this.alturaMax = alturaMax;
        this.alturaMin = alturaMin;
        this.zona = zona;
        this.perfilAlerta = perfilAlerta;
    }

    public double getTiempoMax() {
        return tiempoMax;
    }

    public void setTiempoMax(double tiempoMax) {
        this.tiempoMax = tiempoMax;
    }

    public double getTiempoMin() {
        return tiempoMin;
    }

    public void setTiempoMin(double tiempoMin) {
        this.tiempoMin = tiempoMin;
    }

    public double getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(double alturaMax) {
        this.alturaMax = alturaMax;
    }

    public double getAlturaMin() {
        return alturaMin;
    }

    public void setAlturaMin(double alturaMin) {
        this.alturaMin = alturaMin;
    }

    public ZonaGeografica getZona() {
        return zona;
    }

    public void setZona(ZonaGeografica zona) {
        this.zona = zona;
    }

    public String getPerfilAlerta() {
        return perfilAlerta;
    }

    public void setPerfilAlerta(String perfilAlerta) {
        this.perfilAlerta = perfilAlerta;
    }
    
    
    
    
}
