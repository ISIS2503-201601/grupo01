/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Oferta;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioOfertaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author s.linan10
 */
@Stateless
public class ServicioOfertaMock implements IServicioOfertaMockLocal {
    
    private IServicioPersistenciaMockLocal persistencia;
    
    public ServicioOfertaMock()
    {
        persistencia = new ServicioPersistenciaMock();
    }

    public void agregarOferta(Oferta oferta) {
        
        try
        {
            persistencia.create(oferta);
        }
         catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void eliminarOferta(int idOferta) {
        
        Oferta oferta = (Oferta) persistencia.findById(Oferta.class, idOferta);
        try
        {
            persistencia.delete(oferta);
        }
        catch (OperacionInvalidaException ex)
        {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Oferta> darOfertas() {
        
        return persistencia.findAll(Oferta.class);
    }
    
}
