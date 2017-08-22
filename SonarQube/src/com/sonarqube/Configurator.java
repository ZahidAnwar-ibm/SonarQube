package com.sonarqube;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/*
 *  Singleton object to read properties file
 *  and sets database configurations
 *   
 */
public class Configurator {
	
	private static Configurator instance;
	private InputStream is = null;
	
	private String dbUrl, dbDriver, dbUser, dbPassword;
	
	public static Configurator getConfig() {
		
		if(instance == null) {
			instance = new Configurator();
			instance.init();
		}
		
		return instance;
	}
	
	private Configurator() {		
	}
	
	private Properties prop;
	
	public void init() {
		
		try {

			is = new FileInputStream("db-config.properties");

			// load a properties file
			prop.load(is);

			this.dbUrl = prop.getProperty("db.url");
			this.dbDriver = prop.getProperty("db.driver");
			this.dbUser = prop.getProperty("db.user");
			this.dbPassword = prop.getProperty("db.password");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public String getDbUrl() {
		return dbUrl;
	}



	public String getDbDriver() {
		return dbDriver;
	}



	public String getDbUser() {
		return dbUser;
	}



	public String getDbPassword() {
		return dbPassword;
	}



}
