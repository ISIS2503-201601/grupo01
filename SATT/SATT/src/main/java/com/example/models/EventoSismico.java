/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;


import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class EventoSismico implements Serializable {
    
   private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double longitud;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;
    
    private double latitud;
    private double distanciaCosta;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updatedAt;

    public EventoSismico()
    {
        // Se crea el constructor vacio de la clase
    }
    
    public EventoSismico(double longitud, double latitud, double distanciaCosta) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.distanciaCosta = distanciaCosta;
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
    
    
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }    
        
    @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = Calendar.getInstance();
    }
 
    @PrePersist
    private void creationTimestamp() {
        this.createdAt = this.updatedAt = Calendar.getInstance();
    }


    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
     public double getDistanciaCosta() {
        return distanciaCosta;
    }

    public void setDistanciaCosta(double distanciaCosta) {
        this.distanciaCosta = distanciaCosta;
    }
   
}
