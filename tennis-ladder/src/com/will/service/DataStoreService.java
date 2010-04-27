package com.will.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import com.will.data.PMF;
import com.will.data.entity.Configuration;

public class DataStoreService {
    private static final Logger log = Logger.getLogger(DataStoreService.class.getName());

    public String getRedirectURL() {
	return getProperty(Configuration.PROPERTIES.URL_REDIRECT.toString());
    }

    public String getMaintainMessage() {
	return getProperty(Configuration.PROPERTIES.MAIN_MAINTAIN_MESSAGE.toString());
    }

    public String getMainTitle() {
	return getProperty(Configuration.PROPERTIES.MAIN_TITLE.toString());
    }

    public String getMainMessage() {
	return getProperty(Configuration.PROPERTIES.MAIN_MESSAGE.toString());
    }

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

    public String getProperty(String propertyName) {
	String value = null;
	PersistenceManager pm = PMF.get().getPersistenceManager();
	try {
	    Configuration e = pm.getObjectById(Configuration.class, propertyName);
	    value = e.getValue();
	} catch (Exception e) {
	    e.printStackTrace();
	    log.log(Level.SEVERE, e.getMessage());

	} finally {
	    pm.close();
	}
	return value;
    }

    public Map<String, String> getProperties(String filter) {
	Map<String, String> name_value = new HashMap<String, String>();
	PersistenceManager pm = PMF.get().getPersistenceManager();
	try {
	    javax.jdo.Query query = pm.newQuery(Configuration.class);

	    if (filter != null && filter.length() > 0) {
		query.setFilter("property like '" + filter + "'");
	    }
	    List<Configuration> results = (List) query.execute();

	    for (Configuration config : results) {
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
