package com.will.mail;

import java.util.Map;

import com.will.service.DataStoreService;

/**
 * This is a cloud cache.
 * @author willhan
 *
 */
public class MailTemplate {
    private static Map<String,String> mailProperties=null;

    private static DataStoreService service=new DataStoreService();
    public static Map<String,String> getMailProperties(){
	if(mailProperties==null){
	    mailProperties=service.getProperties("MAIL_");
	}
	return mailProperties;

    }
    
    public static String getMailProperty(String key){
	return getMailProperties().get(key);
    }

}
