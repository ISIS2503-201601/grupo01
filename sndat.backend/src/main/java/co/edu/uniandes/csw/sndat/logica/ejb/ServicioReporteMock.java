/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.logica.ejb;

import co.edu.uniandes.csw.sndat.dto.Reporte;
import co.edu.uniandes.csw.sndat.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.sndat.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioReporteSensorMockLocal;

/**
 *
 * @author s.linan10
 */
@Stateless
public class ServicioReporteMock implements IServicioReporteSensorMockLocal {
    
    private IServicioPersistenciaMockLocal persistencia;
    
    public ServicioReporteMock()
    {
        persistencia = new ServicioPersistenciaMock();
    }

    public void agregarReporte(Reporte reporte) {
        
        try
        {
            persistencia.create(reporte);
        }
         catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Reporte> darReportes() {
        
        return persistencia.findAll(Reporte.class);
    }
    
}
