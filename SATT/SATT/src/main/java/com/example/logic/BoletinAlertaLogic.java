/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.logic;

import com.example.models.BoletinAlerta;
import com.example.models.Escenario;
import com.example.models.EventoSismico;
import com.example.models.ReporteSensor;
import com.example.models.ZonaGeografica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class BoletinAlertaLogic {
    
    private EntityManager entityManager;
    private static Logger logger;
    
    public BoletinAlertaLogic( EntityManager em)
    {
        entityManager = em;
        logger= Logger.getLogger("BoletinAlertaLogicLog");
    }
    
      public ReporteSensor buscarSensorMasCercanoA (EventoSismico evento)
    {
        double latitud = evento.getLatitud();
        double longitud = evento.getLongitud();
        Query q = entityManager.createQuery("select u from ReporteSensor u");
        List <ReporteSensor> reportes = q.getResultList();
        ReporteSensor masCercano = null;
        double actual = 99999999;
        
        for(int i=0; i<reportes.size(); i++)
        {
            ReporteSensor sensor = reportes.get(i);
            double pLatitud = sensor.getLatitud();
            double pLongitud = sensor.getLongitud();
            double distancia = calcularDistancia(latitud, pLatitud, longitud, pLongitud);
            if(distancia <= actual)
            {
                actual = distancia;
                masCercano = reportes.get(i);
            }
            
        }
          return masCercano;
    }
    
    public ZonaGeografica darZonaGeograficaMasCercana (double latitud, double longitud)
    {
        Query q = entityManager.createQuery("select u from ZonaGeografica u");        
        List<ZonaGeografica> zonas = q.getResultList();
        
        ZonaGeografica masCercano = null;
        double actual = 99999999;
        
        for(int i=0; i<zonas.size(); i++)
        {
            ZonaGeografica zona = zonas.get(i);
            double pLatitud = zona.getLatitud();
            double pLongitud = zona.getLongitud();
            double distancia = calcularDistancia(latitud, pLatitud, longitud, pLongitud);
            if(distancia <= actual)
            {
                actual = distancia;
                masCercano = zonas.get(i);
            }
            
        }
          return masCercano;
        
        
    }
    
    public double calcularDistancia(double latitud, double pLatitud, double longitud, double pLongitud)
    {
        return Math.sqrt(Math.pow(latitud - pLatitud, 2)+Math.pow(longitud - pLongitud, 2));
    }
    
    public Escenario darEscenarioPremodelado(ZonaGeografica zona, double altura, double tiempo)
    {
        Query q = entityManager.createQuery("select u from Escenario u");        
        List<Escenario> escenarios = q.getResultList();
        for(int i=0; i<escenarios.size(); i++)
        {
            Escenario actual = escenarios.get(i);
            
            if(actual.getZona().getNombre().equals(zona.getNombre()))
            {
                 logger.log(Level.INFO,"Nombre zona");
               
                if(altura >= actual.getAlturaMin() && altura <= actual.getAlturaMax() && tiempo >= actual.getTiempoMin() && tiempo <= actual.getTiempoMax())
                {
                    logger.log(Level.INFO,"Altura");  
                    logger.log(Level.INFO,"Tiempo:" + tiempo);
                    logger.log(Level.INFO,"TiempoMin:" + actual.getTiempoMin());
                    logger.log(Level.INFO,"TiempoMax:" + actual.getTiempoMax());                       
                    return actual;
                }
            }
        }
        
        return null;
    }

    public BoletinAlerta darBoletinAlerta(EventoSismico evento) {
        
        ReporteSensor reporte = buscarSensorMasCercanoA(evento);
        if(reporte == null)
        {
             logger.log(Level.INFO,"REPORTE ES NULL");
        }
        else
        {
        logger.log(Level.INFO,"Reporte encontrado :"+reporte.getId());
        
        double altura = reporte.getAltura();
        double velocidad = reporte.getVelocidad();
        double latitud = reporte.getLatitud();
        double longitud = reporte.getLongitud();
        ZonaGeografica zona = darZonaGeograficaMasCercana(latitud, longitud);
        
        double distanciaEvento = calcularDistancia(zona.getLatitud(), evento.getLatitud(), zona.getLongitud(), evento.getLongitud());
        double tiempoLlegada = distanciaEvento / velocidad;
        
        Escenario escenario = darEscenarioPremodelado(zona, altura, tiempoLlegada);
        
        if(escenario == null)
        {
            logger.log(Level.INFO,"ESCENARIO NULL");
            return null;
        }
        
        BoletinAlerta boletin = new BoletinAlerta(escenario.getPerfilAlerta(), escenario.getZona(), tiempoLlegada, altura, (int)Math.random());
        
        return boletin;
        }
        
        return null;
    }
    
}
