/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.logic.BoletinAlertaLogic;
import com.example.models.BoletinAlerta;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

@Path("/boletines")
@Produces(MediaType.APPLICATION_JSON)
public class BoletinService {

    BoletinAlertaLogic baLogic;
    private Logger logger;
    
    @PersistenceContext(unitName = "sattPU")
    EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
            baLogic = new BoletinAlertaLogic(entityManager);
            logger= Logger.getLogger("BoletinServLog");
        } catch (Exception e) {
            logger.log(Level.ERROR, e);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from BoletinAlerta u");
        List<BoletinAlerta> boletines = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(boletines).build();
    }
    
    

  
}
