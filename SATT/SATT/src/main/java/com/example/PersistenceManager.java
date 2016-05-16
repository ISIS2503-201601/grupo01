 /*
 * Tomado de: http://javanotepad.blogspot.com/2007/05/jpa-entitymanagerfactory-in-web.html
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;
 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
 
public class PersistenceManager {
 
    public static final boolean DEBUG = true;
    private static final PersistenceManager singleton = new PersistenceManager();
    protected EntityManagerFactory emf;
    private static  Logger logger;
   
    public static PersistenceManager getInstance() {
 
        return singleton;
    }
 
    private PersistenceManager() {
        logger= Logger.getLogger("PersistenceManagerLog");
    }
 
    public EntityManagerFactory getEntityManagerFactory() {
 
        if (emf == null) {
            createEntityManagerFactory();
        }
        return emf;
    }
 
    public void closeEntityManagerFactory() {
 
        if (emf != null) {
            emf.close();
            emf = null;
            if (DEBUG) {
                logger.log(Level.INFO,"Persistence started at " + new java.util.Date());
            }
        }
    }
 
    protected void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("sattPU", System.getProperties());
        if (DEBUG) {
            logger.log(Level.INFO,"Persistence started at " + new java.util.Date());
        }
    }
} 