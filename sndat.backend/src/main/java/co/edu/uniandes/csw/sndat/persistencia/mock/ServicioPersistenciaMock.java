/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioPersistenciaMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.csw.sndat.persistencia.mock;


import co.edu.uniandes.csw.sndat.dto.Escenario;
import co.edu.uniandes.csw.sndat.dto.EventoSismico;
import co.edu.uniandes.csw.sndat.dto.ReporteSensor;
import co.edu.uniandes.csw.sndat.dto.ZonaGeografica;
import co.edu.uniandes.csw.sndat.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioPersistenciaMockRemote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;

/**
 * Implementación de los servicios de persistencia
 */

public class ServicioPersistenciaMock implements IServicioPersistenciaMockRemote, IServicioPersistenciaMockLocal {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------


    
    private static ArrayList<ReporteSensor> reportes;
    
    private static ArrayList<EventoSismico> eventos;
    
    private static ArrayList<ZonaGeografica> zonas;
    
    private static ArrayList <Escenario> escenarios;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase. Inicializa los atributos.
     */
    public ServicioPersistenciaMock()
    {
        if (escenarios == null)
        {

            reportes = new ArrayList<ReporteSensor>();
            reportes.add(new ReporteSensor(12, 3, 1212414.4, 123123.34));
            
            eventos = new ArrayList<EventoSismico>();
            eventos.add(new EventoSismico(33.3, 66.3, 99.3));
            
            zonas = new ArrayList<ZonaGeografica>();
            
            zonas.add(new ZonaGeografica(11.547789, -72.920928, ZonaGeografica.ZONA_ATLANTICO_GUAJIRA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica(11.283611, -73.872483, ZonaGeografica.ZONA_ATLANTICO_MAGDALENA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica(9.389778, -75.788502, ZonaGeografica.ZONA_ATLANTICO_SUCRE, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica( 8.988165, -76.278467, ZonaGeografica.ZONA_ATLANTICO_CORDOBA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica(8.606767, -76.899438, ZonaGeografica.ZONA_ATLANTICO_ANTIOQUIA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica( 5.572450, -77.502771, ZonaGeografica.ZONA_PACIFICO_CHOCO, ZonaGeografica.ZONA_PACIFICO));
            zonas.add(new ZonaGeografica(3.293384, -77.502600, ZonaGeografica.ZONA_PACIFICO_VALLE, ZonaGeografica.ZONA_PACIFICO));
            zonas.add(new ZonaGeografica(2.735288, -77.778793, ZonaGeografica.ZONA_PACIFICO_CAUCA, ZonaGeografica.ZONA_PACIFICO));
            zonas.add(new ZonaGeografica(1.795305, -78.870860, ZonaGeografica.ZONA_PACIFICO_NARIÑO, ZonaGeografica.ZONA_PACIFICO));

            escenarios = new ArrayList<Escenario>();
            escenarios.add(new Escenario(500, 1, 50, 1, zonas.get(0), Escenario.PERFIL_ALARMA));
            escenarios.add(new Escenario(400, 10, 50, 1, zonas.get(1), Escenario.PERFIL_INFORMATIVO));
            escenarios.add(new Escenario(500, 45, 40, 1, zonas.get(2), Escenario.PERFIL_ALARMA));
            escenarios.add(new Escenario(200, 66, 40, 1, zonas.get(3), Escenario.PERFIL_INFORMATIVO));
            escenarios.add(new Escenario(100, 50, 40, 1, zonas.get(4), Escenario.PERFIL_ALERTA));
            escenarios.add(new Escenario(200, 34, 30, 1, zonas.get(5), Escenario.PERFIL_ALARMA));
            escenarios.add(new Escenario(300, 34, 30, 1, zonas.get(6), Escenario.PERFIL_INFORMATIVO));
            escenarios.add(new Escenario(400, 34, 30, 1, zonas.get(7), Escenario.PERFIL_ALERTA));
            escenarios.add(new Escenario(500, 14, 30, 1, zonas.get(8), Escenario.PERFIL_ALARMA));
            escenarios.add(new Escenario(500, 23, 60, 1, zonas.get(7), Escenario.PERFIL_INFORMATIVO));
            escenarios.add(new Escenario(700, 400, 70, 1, zonas.get(6), Escenario.PERFIL_ALERTA));

        }
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    @Override
    public void create(Object obj) throws OperacionInvalidaException
    {        
        if (obj instanceof ReporteSensor)
        {
            ReporteSensor rep = (ReporteSensor) obj;
            rep.generateId();
            reportes.add(rep);
        }
        
         else if (obj instanceof EventoSismico)
        {
            eventos.add((EventoSismico)obj);
        }
    }

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    @Override
    public void update(Object obj)
    {
        
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    @Override
    public void delete(Object obj) throws OperacionInvalidaException
    {
        
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    @Override
    public List findAll(Class c)
    {
        
        if (c.equals(ReporteSensor.class))
        {
            return reportes;
        }
        
        else if(c.equals(EventoSismico.class))
        {
            return eventos;
        }
        else if(c.equals(ZonaGeografica.class))
        {
            return zonas;
        }
        else if(c.equals(Escenario.class))
        {
            return escenarios;
        }
        else
        {
            return null;
        }
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    @Override
    public Object findById(Class c, Object id)
    {
        return null;
    }
}
