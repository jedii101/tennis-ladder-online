package com.will.data;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import com.will.AdminServlet;
import com.will.data.entity.Configuration;

public class DataStoreService {
    private static final Logger log = Logger.getLogger(AdminServlet.class.getName());


    public void saveConfig(Configuration c) {
	PersistenceManager pm = PMF.get().getPersistenceManager();
	try {

	    pm.makePersistent(c);
	} catch (Exception e) {
	    e.printStackTrace();
	    log.log(Level.SEVERE, e.getMessage());

	} finally {

	    pm.close();
	}
    }

    public String getRedirectURL() {
	String url = null;
	PersistenceManager pm = PMF.get().getPersistenceManager();
	try {
	    Configuration e = pm.getObjectById(Configuration.class, Configuration.PROPERTY_REDIRECT_URL);
	    url = e.getValue();
	} catch (Exception e) {
	    e.printStackTrace();
	    log.log(Level.SEVERE, e.getMessage());

	} finally {
	    pm.close();
	}
	return url;
    }

}
