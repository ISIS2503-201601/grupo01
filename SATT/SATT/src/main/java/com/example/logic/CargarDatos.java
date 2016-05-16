/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.logic;

import com.example.models.Escenario;
import com.example.models.ZonaGeografica;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class CargarDatos {
    
   private EntityManager em;
   
   private ArrayList <ZonaGeografica> zonas;
   private static  Logger logger;
    
    public CargarDatos(EntityManager e)
    {
        em = e;
        
        cargarZonasGeograficas();
        cargarEscenarios();
        logger= Logger.getLogger("CargarDatosLog");
        em.clear();
        em.close();
    }
    
    public void cargarZonasGeograficas()
    {
            zonas = new ArrayList();
            
            zonas.add(new ZonaGeografica(11.547789, -72.920928, ZonaGeografica.ZONA_ATLANTICO_GUAJIRA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica(11.283611, -73.872483, ZonaGeografica.ZONA_ATLANTICO_MAGDALENA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica(9.389778, -75.788502, ZonaGeografica.ZONA_ATLANTICO_SUCRE, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica( 8.988165, -76.278467, ZonaGeografica.ZONA_ATLANTICO_CORDOBA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica(8.606767, -76.899438, ZonaGeografica.ZONA_ATLANTICO_ANTIOQUIA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica( 5.572450, -77.502771, ZonaGeografica.ZONA_PACIFICO_CHOCO, ZonaGeografica.ZONA_PACIFICO));
            zonas.add(new ZonaGeografica(3.293384, -77.502600, ZonaGeografica.ZONA_PACIFICO_VALLE, ZonaGeografica.ZONA_PACIFICO));
            zonas.add(new ZonaGeografica(2.735288, -77.778793, ZonaGeografica.ZONA_PACIFICO_CAUCA, ZonaGeografica.ZONA_PACIFICO));
            zonas.add(new ZonaGeografica(1.795305, -78.870860, ZonaGeografica.ZONA_PACIFICO_NARIÑO, ZonaGeografica.ZONA_PACIFICO));
            
            
            for (ZonaGeografica zona : zonas) {
            em.getTransaction().begin();
            em.persist(zona);
            em.getTransaction().commit();
            em.refresh(zona);
        }

    }
    
    public void cargarEscenarios()
    {
            ArrayList<Escenario> escenarios = new ArrayList();
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
            
            for (Escenario e : escenarios) {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            em.refresh(e);
        }            
    }
    
    public void mensaje()
    {
         logger.log(Level.INFO,"Se cargan todos los datos");
    }
    
}
