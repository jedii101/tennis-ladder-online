package com.will.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import com.google.appengine.api.datastore.Query;
import com.will.AdminServlet;
import com.will.data.PMF;
import com.will.data.entity.Configuration;

public class DataStoreService {
    private static final Logger log = Logger.getLogger(DataStoreService.class.getName());


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
	    Configuration e = pm.getObjectById(Configuration.class, Configuration.PROPERTIES.URL_REDIRECT.toString());
	    url = e.getValue();
	} catch (Exception e) {
	    e.printStackTrace();
	    log.log(Level.SEVERE, e.getMessage());

	} finally {
	    pm.close();
	}
	return url;
    }

    public Map<String,String> getProperties(String filter) {
	Map<String,String> name_value=new HashMap<String, String>();
	PersistenceManager pm = PMF.get().getPersistenceManager();
	try {
	    javax.jdo.Query query = pm.newQuery(Configuration.class);

	    query.setFilter( "property like '"+filter+"'");

	    List<Configuration> results = (List)query.execute();

	    for (Configuration config  : results) {
		name_value.put(config.getProperty(), config.getValue());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    log.log(Level.SEVERE, e.getMessage());

	} finally {
	    pm.close();
	}
	return name_value;
    }

}
