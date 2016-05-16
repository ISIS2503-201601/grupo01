package com.example.models;


import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class BoletinAlerta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String perfilDeAlerta;
    
    @OneToOne
    private ZonaGeografica zonaGeografica;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;
    
    private double tiempoLlegadaMinutos;
    private double alturaOla;
    private int idBoletin;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updatedAt;

    public BoletinAlerta(String perfilDeAlerta, ZonaGeografica zonaGeografica, double tiempoLlegadaMinutos, double alturaOla, int idBoletin) {
        this.perfilDeAlerta = perfilDeAlerta;
        this.zonaGeografica = zonaGeografica;
        this.tiempoLlegadaMinutos = tiempoLlegadaMinutos;
        this.alturaOla = alturaOla;
        this.idBoletin = idBoletin;
    }

    public BoletinAlerta()
    {
        // Se crea el constructor vacio de la clase
    }
    
        public String getCreatedAt()
    {
    Calendar now = createdAt;
    int yearBa = now.get(Calendar.YEAR);
    int monthBa = now.get(Calendar.MONTH) + 1; // Note: zero based!
    int dayBa = now.get(Calendar.DAY_OF_MONTH);
    int hourBa = now.get(Calendar.HOUR_OF_DAY);
    int minuteBa = now.get(Calendar.MINUTE);
    int secondBa = now.get(Calendar.SECOND);
    int millisBa = now.get(Calendar.MILLISECOND); 
    
    String r = String.format("%d-%02d-%02d %02d:%02d:%02d.%03d", yearBa, monthBa, dayBa, hourBa, minuteBa, secondBa, millisBa);
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
