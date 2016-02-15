/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.servicios;

import co.edu.uniandes.csw.sndat.dto.Reporte;
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
@Path("/ReporteSensor")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReporteSensor {
    
        @EJB
        private IServicioReporteSensorMockLocal reporteEjb;
        
        @GET
        //@Path("reportes/")
        public List<Reporte> getTodosLosReportes()
        {
            return reporteEjb.darReportes();
        }
        
        @POST
       // @Path("agregar/")
        public List <Reporte> agregarReportes (List <Reporte> rep)
        {
            for(Reporte reporte: rep)
            {
                reporteEjb.agregarReporte(reporte);
            }
            
            return rep;
        }
}
