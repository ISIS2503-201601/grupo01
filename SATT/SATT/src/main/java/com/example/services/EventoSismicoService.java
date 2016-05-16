/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.logic.BoletinAlertaLogic;
import com.example.models.BoletinAlerta;
import com.example.models.EventoSismico;
import com.example.models.EventoSismicoDTO;
import com.example.security.Hash;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

@Path("/eventosSismicos")
@Produces(MediaType.APPLICATION_JSON)
public class EventoSismicoService {

    BoletinAlertaLogic baLogic2;
    private Logger logger;
    
    @PersistenceContext(unitName = "sattPU")
    EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
            baLogic2 = new BoletinAlertaLogic(entityManager);
            logger= Logger.getLogger("EventoSismicoServLog");
        } catch (Exception e) {
            logger.log(Level.ERROR,e);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from EventoSismico u");
        List<EventoSismico> eventos = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(eventos).build();
    }

    //Puede generar un boletín de alerta
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @java.lang.SuppressWarnings("squid:S1143")
    public BoletinAlerta almacenarEventoSismico(EventoSismicoDTO evento) {
        EventoSismico eventoTmp = new EventoSismico();
        eventoTmp.setLongitud(evento.getLongitud());
        eventoTmp.setLatitud(evento.getLatitud());
        eventoTmp.setDistanciaCosta(evento.getDistanciaCosta());

        String md5 = evento.getMd5();
        String md5Gen = Hash.MD5(evento.getLongitud() + "-" + evento.getLatitud() + "-" + evento.getDistanciaCosta());
        boolean integridad = false;

        if (md5.equals(md5Gen)) {
            integridad = true;
        } else {
            logger.log(Level.INFO, "Problema de integridad");
        }

        if (integridad) {

            try 
            {
                entityManager.getTransaction().begin();
                entityManager.persist(eventoTmp);
                entityManager.getTransaction().commit();
                entityManager.refresh(eventoTmp);
            } 
            catch (Exception t) 
            {
                logger.log(Level.ERROR, t);
                if (entityManager.getTransaction().isActive()) 
                {
                    entityManager.getTransaction().rollback();
                }
                eventoTmp = null;
            }
            finally 
            {
                BoletinAlerta bol = baLogic2.darBoletinAlerta(eventoTmp);

                if (bol != null) {
                    try {
                        entityManager.getTransaction().begin();
                        entityManager.persist(bol);
                        entityManager.getTransaction().commit();
                        entityManager.refresh(eventoTmp);
                    } catch (Exception t) {
                        logger.log(Level.ERROR, t);
                        if (entityManager.getTransaction().isActive()) {
                            entityManager.getTransaction().rollback();
                        }
                        eventoTmp = null;
                    }
                }
                entityManager.clear();
                entityManager.close();
                return bol;
            }
        } else {
            return null;
        }
    }
}
