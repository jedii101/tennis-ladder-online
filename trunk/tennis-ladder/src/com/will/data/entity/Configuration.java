package com.will.data.entity;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Configuration {
    public enum PROPERTIES{
	URL_REDIRECT,
	EMAIL_SENDFROM,
	EMAIL_STANDARD_SUBJECT,
	EMAIL_RESIPTANT,
	EMAIL_STANDARD_FOOTER;

    }
//    public static final String PROPERTY_REDIRECT_URL = "PROPERTY_REDIRECT_URL";
    @PrimaryKey
    @Persistent
    private String property;

    @Persistent
    private String value;

    @Persistent
    private String updateBy;

    @Persistent
    private Date lastUpdate=new Date();

    public String getProperty() {
        return property;
    }

    public void setProperty(PROPERTIES property) {
        this.property = property.toString();
    }

    public void setProperty(String property) {
        this.property = property.toString();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public String toString(){
	return "property:"+property+";value:"+value+";updateBy:"+updateBy+";lastUpdate"+lastUpdate;
    }
}