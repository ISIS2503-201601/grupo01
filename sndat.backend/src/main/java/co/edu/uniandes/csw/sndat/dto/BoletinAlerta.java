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
public class BoletinAlerta {
    
    private String perfilDeAlerta;
    private ZonaGeografica zonaGeografica;
    private double tiempoLlegadaMinutos;
    private double alturaOla;
    private int idBoletin;

    public BoletinAlerta(String perfilDeAlerta, ZonaGeografica zonaGeografica, double tiempoLlegadaMinutos, double alturaOla, int idBoletin) {
        this.perfilDeAlerta = perfilDeAlerta;
        this.zonaGeografica = zonaGeografica;
        this.tiempoLlegadaMinutos = tiempoLlegadaMinutos;
        this.alturaOla = alturaOla;
        this.idBoletin = idBoletin;
    }

    public BoletinAlerta()
    {
        
    }

    public int getIdBoletin() {
        return idBoletin;
    }

    public void setIdBoletin(int idBoletin) {
        this.idBoletin = idBoletin;
    }

    public String getPerfilDeAlerta() {
        return perfilDeAlerta;
    }

    public void setPerfilDeAlerta(String perfilDeAlerta) {
        this.perfilDeAlerta = perfilDeAlerta;
    }

    public ZonaGeografica getZonaGeografica() {
        return zonaGeografica;
    }

    public void setZonaGeografica(ZonaGeografica zonaGeografica) {
        this.zonaGeografica = zonaGeografica;
    }

    public double getTiempoLlegadaMinutos() {
        return tiempoLlegadaMinutos;
    }

    public void setTiempoLlegadaMinutos(double tiempoLlegadaMinutos) {
        this.tiempoLlegadaMinutos = tiempoLlegadaMinutos;
    }

    public double getAlturaOla() {
        return alturaOla;
    }

    public void setAlturaOla(double alturaOla) {
        this.alturaOla = alturaOla;
    }
    
    
    
}
