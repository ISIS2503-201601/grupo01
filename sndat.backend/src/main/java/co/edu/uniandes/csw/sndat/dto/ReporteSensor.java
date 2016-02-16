/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.dto;

/**
 *
 * @author s.linan10
 */
public class ReporteSensor {
    
    private String idSensor;
    private double velocidad;
    private double altura;
    private double latitud;
    private double longitud;

    public ReporteSensor()
    {
        
    }

    public ReporteSensor(double velocidad, double altura, double latitud, double longitud) {
        this.velocidad = velocidad;
        this.altura = altura;
        this.latitud = latitud;
        this.longitud = longitud;
        idSensor = latitud + ";" + longitud;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
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
    
    public String getIdSensor()
    {
        return idSensor;
    }
    
    public void setIdSensor(String id)
    {
        this.idSensor = id;
    }
    
    public void generateId()
    {
        idSensor = latitud + ";" + longitud;
    }
   
     
}
