/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.logica.interfaces;

import co.edu.uniandes.csw.sndat.dto.ReporteSensor;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author s.linan10
 */

@Remote
public interface IServicioReporteSensorMockRemote {
    
    public void agregarReporte(ReporteSensor reporte);
    
    public List<ReporteSensor> darReportes();
    
}
