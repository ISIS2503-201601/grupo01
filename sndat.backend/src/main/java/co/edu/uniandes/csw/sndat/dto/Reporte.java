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
public class Reporte {
    
    private int idReporte;
    private double velocidad;
    private double altura;

    public Reporte()
    {
        
    }
    
    public Reporte(int idReporte, double velocidad, double altura) {
        this.idReporte = idReporte;
        this.velocidad = velocidad;
        this.altura = altura;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
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
     
}
