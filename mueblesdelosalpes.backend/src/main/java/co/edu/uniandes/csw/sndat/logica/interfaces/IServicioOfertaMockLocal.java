/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sndat.logica.interfaces;

import co.edu.uniandes.csw.sndat.dto.Mueble;
import co.edu.uniandes.csw.sndat.dto.Oferta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author s.linan10
 */

@Local
public interface IServicioOfertaMockLocal {
    
    public void agregarOferta(Oferta oferta);
    
    public void eliminarOferta(int idOferta);
    
    public List<Oferta> darOfertas();
    
}
