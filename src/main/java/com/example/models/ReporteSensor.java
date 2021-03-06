 package com.example.models;
 
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
public class ReporteSensor implements Serializable {
 
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
 
    private double velocidad;
    private double altura;
    private double latitud;
    private double longitud;
 
    public ReporteSensor(double v, double a, double lat, double lon) 
    {
        velocidad = v;
        altura = a;
        latitud = lat;
        longitud = lon;
    }
    
    public ReporteSensor()
    {
        
    }

    @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = Calendar.getInstance();
    }
 
    @PrePersist
    private void creationTimestamp() {
        this.createdAt = this.updatedAt = Calendar.getInstance();
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
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
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