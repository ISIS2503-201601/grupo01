/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

/**
 *
 * @author slinanromero
 */
public class EventoSismicoDTO {
    
    private double longitud;
    private double latitud;
    private double distanciaCosta;
    private String md5;

    public EventoSismicoDTO()
    {
        
    }
    
    public EventoSismicoDTO(double longitud, double latitud, double distanciaCosta, String md) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.distanciaCosta = distanciaCosta;
        md5 = md;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getDistanciaCosta() {
        return distanciaCosta;
    }

    public void setDistanciaCosta(double distanciaCosta) {
        this.distanciaCosta = distanciaCosta;
    }
    
    public void setMd5(String m)
    {
        md5 = m;
    }
    
    public String getMd5()
    {
        return md5;
    }
    
    
}
