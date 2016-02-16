/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.servicios;

import co.edu.uniandes.csw.sndat.dto.ReporteSensor;
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
public class ReporteSensorService {
    
        @EJB
        private IServicioReporteSensorMockLocal reporteEjb;
        
        @GET
        //@Path("reportes/")
        public List<ReporteSensor> getTodosLosReportes()
        {
            return reporteEjb.darReportes();
        }
        
        @POST
       // @Path("agregar/")
        public List <ReporteSensor> agregarReportes (List <ReporteSensor> rep)
        {
            for(co.edu.uniandes.csw.sndat.dto.ReporteSensor reporte: rep)
            {
                reporteEjb.agregarReporte(reporte);
            }
            
            return rep;
        }
}
