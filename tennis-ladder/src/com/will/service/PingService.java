package com.will.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;



public class PingService {
    private static final Logger log = Logger.getLogger(MailerService.class.getName());
    public boolean ping(int timeout, String paramUrl) {
	try {
	    // Create a URL for the desired page
	    URL url = new URL(paramUrl);
	    URLConnection c=url.openConnection();
	    c.setConnectTimeout(timeout);
	    // Read all the text returned by the server
	    c.connect();
	    return true;
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	log.info("new ping remote site not available:"+paramUrl);
	return false;
    }
    public boolean xxping(int timeout, String paramUrl) {
	try {
	    // Create a URL for the desired page
	    URL url = new URL(paramUrl);
	    URLConnection c=url.openConnection();
	    c.setConnectTimeout(timeout);
	    // Read all the text returned by the server
	    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	    String str;
	    while ((str = in.readLine()) != null) {
		// str is one line of text; readLine() strips the newline
		// character(s)
		return true;
	    }
	    in.close();
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	log.info("remote site not available:"+paramUrl);
	return false;
    }
}
