package com.example.models;
  
public class ReporteSensorDTO {
  
    private double velocidad;
    private double altura;
    private double latitud;
    private double longitud;
    private String md5;
 
    public ReporteSensorDTO(double v, double a, double lat, double lon, String md) 
    {
        velocidad = v;
        altura = a;
        latitud = lat;
        longitud = lon;
        md5 = md;
    }
    
    public ReporteSensorDTO()
    {
        // Se crea el constructor vacio de la clase
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
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

    public String getMd5() {
        return md5;
    }
    
    public void setMd5(String m) {
        md5 = m;
    }
    
     public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
}