/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.logica.interfaces;

import co.edu.uniandes.csw.sndat.dto.BoletinAlerta;
import co.edu.uniandes.csw.sndat.dto.EventoSismico;
import co.edu.uniandes.csw.sndat.dto.ReporteSensor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author s.linan10
 */

@Local
public interface IServicioEventoSismicoMockLocal {
    
    public void agregarEvento(EventoSismico evento);
    
    public List<EventoSismico> darEventos();
    
    public BoletinAlerta darBoletinAlerta (EventoSismico evento);
    
    
    
}
