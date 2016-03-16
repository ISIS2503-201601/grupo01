package com.example.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Escenario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static String PERFIL_INFORMATIVO = "Informativo";
    public static String PERFIL_PRECAUCION = "Precaución";
    public static String PERFIL_ALERTA = "Alerta";
    public static String PERFIL_ALARMA = "Alarma";
    
    private double tiempoMax;
    private double tiempoMin;
    private double alturaMax;
    private double alturaMin;
    
    @OneToOne
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
    
    public Escenario()
    {
        
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
