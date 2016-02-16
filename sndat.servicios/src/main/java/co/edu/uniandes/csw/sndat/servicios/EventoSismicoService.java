/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.servicios;

import co.edu.uniandes.csw.sndat.dto.BoletinAlerta;
import co.edu.uniandes.csw.sndat.dto.EventoSismico;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioEventoSismicoMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioReporteSensorMockLocal;

/**
 *
 * @author s.linan10
 */
@Path("/EventoSismico")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventoSismicoService {
    
        @EJB
        private IServicioEventoSismicoMockLocal eventoEjb;
        
        @GET
        //@Path("reportes/")
        public List<EventoSismico> getTodosLosEventos()
        {
            return eventoEjb.darEventos();
        }
        
        @POST
       // @Path("agregar/")
        public BoletinAlerta  agregarEvento (EventoSismico ev)
        {
                eventoEjb.agregarEvento(ev);
                
            return  eventoEjb.darBoletinAlerta(ev);
        }
}
