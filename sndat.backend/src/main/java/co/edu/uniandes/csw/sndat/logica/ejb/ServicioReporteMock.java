/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.logica.ejb;

import co.edu.uniandes.csw.sndat.dto.ReporteSensor;
import co.edu.uniandes.csw.sndat.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.sndat.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import javax.ejb.Stateless;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioReporteSensorMockLocal;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioReporteSensorMockRemote;

/**
 *
 * @author s.linan10
 */
@Stateless
public class ServicioReporteMock implements IServicioReporteSensorMockLocal, IServicioReporteSensorMockRemote {
    
    private IServicioPersistenciaMockLocal persistencia;
    
    public ServicioReporteMock()
    {
        persistencia = new ServicioPersistenciaMock();
    }

    public void agregarReporte(ReporteSensor reporte) {
        
        try
        {
            persistencia.create(reporte);
        }
         catch (OperacionInvalidaException ex)
        {
            System.out.println("Inválido");
        }
        
    }

    public List<ReporteSensor> darReportes() {
        
        return persistencia.findAll(ReporteSensor.class);
    }
    
    
}
