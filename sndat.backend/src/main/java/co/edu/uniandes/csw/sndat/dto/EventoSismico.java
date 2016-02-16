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
public class EventoSismico {
    
    private double longitud;
    private double latitud;
    private double distanciaCosta;

    public EventoSismico()
    {
        
    }
    
    public EventoSismico(double longitud, double latitud, double distanciaCosta) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.distanciaCosta = distanciaCosta;
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
    
    
}
