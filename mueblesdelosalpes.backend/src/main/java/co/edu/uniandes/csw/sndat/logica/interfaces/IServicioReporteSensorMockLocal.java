/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.logica.interfaces;

import co.edu.uniandes.csw.sndat.dto.Reporte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author s.linan10
 */

@Local
public interface IServicioReporteSensorMockLocal {
    
    public void agregarReporte(Reporte reporte);
    
    public List<Reporte> darReportes();
    
}
