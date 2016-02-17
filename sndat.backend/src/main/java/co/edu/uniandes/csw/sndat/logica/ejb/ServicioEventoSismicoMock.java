/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.logica.ejb;

import co.edu.uniandes.csw.sndat.dto.BoletinAlerta;
import co.edu.uniandes.csw.sndat.dto.Escenario;
import co.edu.uniandes.csw.sndat.dto.EventoSismico;
import co.edu.uniandes.csw.sndat.dto.ReporteSensor;
import co.edu.uniandes.csw.sndat.dto.ZonaGeografica;
import co.edu.uniandes.csw.sndat.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioEventoSismicoMockLocal;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.sndat.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioReporteSensorMockLocal;
import java.util.ArrayList;

/**
 *
 * @author s.linan10
 */
@Stateless
public class ServicioEventoSismicoMock implements IServicioEventoSismicoMockLocal {
    
    private IServicioPersistenciaMockLocal persistencia;
    
    public ServicioEventoSismicoMock()
    {
        persistencia = new ServicioPersistenciaMock();
    }

    public void agregarEvento(EventoSismico evento) {
        
        try
        {
            persistencia.create(evento);
        }
         catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<EventoSismico> darEventos() {
        
        return persistencia.findAll(EventoSismico.class);
    }
    
    public ReporteSensor buscarSensorMasCercanoA (EventoSismico evento)
    {
        double latitud = evento.getLatitud();
        double longitud = evento.getLongitud();
        
        List <ReporteSensor> reportes = persistencia.findAll(ReporteSensor.class);
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
        List<ZonaGeografica> zonas = persistencia.findAll(ZonaGeografica.class);
        
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
        List<Escenario> escenarios = persistencia.findAll(Escenario.class);
        for(int i=0; i<escenarios.size(); i++)
        {
            Escenario actual = escenarios.get(i);
            
            if(actual.getZona().getNombre().equals(zona.getNombre()))
            {
                if(altura >= actual.getAlturaMin() && altura <= actual.getTiempoMax())
                {
                    if(tiempo >= actual.getTiempoMin() && tiempo <= actual.getTiempoMax())
                    {
                        return actual;
                    }
                }
            }
        }
        
        return null;
    }


    @Override
    public BoletinAlerta darBoletinAlerta(EventoSismico evento) {
        
        ReporteSensor reporte = buscarSensorMasCercanoA(evento);
        if(reporte == null)
        {
            System.out.println("REPORTE ES NULL");
        }
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
            return null;
        }
        
        BoletinAlerta boletin = new BoletinAlerta(escenario.getPerfilAlerta(), escenario.getZona(), tiempoLlegada, altura, (int)Math.random());
        
        return boletin;
        
    }
    
}
