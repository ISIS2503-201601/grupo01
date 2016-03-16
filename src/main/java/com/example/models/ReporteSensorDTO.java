package com.example.models;
  
public class ReporteSensorDTO {
  
    private double velocidad;
    private double altura;
    private double latitud;
    private double longitud;
 
    public ReporteSensorDTO(double v, double a, double lat, double lon) 
    {
        velocidad = v;
        altura = a;
        latitud = lat;
        longitud = lon;
    }
    
    public ReporteSensorDTO()
    {
        
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
}