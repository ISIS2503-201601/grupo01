/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.models.ReporteSensor;
import com.example.models.ReporteSensorDTO;
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
import javax.ws.rs.core.Response.Status;
import org.codehaus.jettison.json.JSONObject;

@Path("/reportes")
@Produces(MediaType.APPLICATION_JSON)
public class ReporteSensorService {
    
    @PersistenceContext(unitName = "sattPU")
    EntityManager entityManager; 
    
    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from ReporteSensor u");
        List<ReporteSensor> reportes = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(reportes).build();
    } 

     @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompetitor(ReporteSensorDTO reporte) {
        JSONObject rta = new JSONObject();
        ReporteSensor reporteSensorTmp = new ReporteSensor();
        reporteSensorTmp.setAltura(reporte.getAltura());
        reporteSensorTmp.setLatitud(reporte.getLatitud());
        reporteSensorTmp.setLongitud(reporte.getLongitud());
        reporteSensorTmp.setVelocidad(reporte.getVelocidad());
        String md5 = reporte.getMd5();
        
        boolean integridad = false;
        String generar = reporte.getAltura()+"-"+reporte.getVelocidad()+"-"+reporte.getLatitud()+"-"+reporte.getLongitud();
        String digest = Hash.MD5(generar);
        if(digest.equals(md5))
        {
            System.out.println("MD5 "+md5);
            integridad = true;
        }
        
        if(integridad)
        {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(reporteSensorTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(reporteSensorTmp);
            rta.put("reporteSensor_id", reporteSensorTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            reporteSensorTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }
        else
        {
            return Response.status(Status.BAD_REQUEST).build();
        }
}

}
