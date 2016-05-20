package com.example.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BoletinAlerta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;
 
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updatedAt;
    
    private String perfilDeAlerta;
    
    @OneToOne
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
    
        public String getCreatedAt()
    {
    Calendar now = createdAt;
    int year = now.get(Calendar.YEAR);
    int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
    int day = now.get(Calendar.DAY_OF_MONTH);
    int hour = now.get(Calendar.HOUR_OF_DAY);
    int minute = now.get(Calendar.MINUTE);
    int second = now.get(Calendar.SECOND);
    int millis = now.get(Calendar.MILLISECOND); 
    
    String r = String.format("%d-%02d-%02d %02d:%02d:%02d.%03d", year, month, day, hour, minute, second, millis);
    return r;
    }
    
        @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = Calendar.getInstance();
    }
 
    @PrePersist
    private void creationTimestamp() {
        this.createdAt = this.updatedAt = Calendar.getInstance();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
