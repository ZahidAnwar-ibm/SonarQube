package com.sonarqube.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sonarqube.Configurator;

public class TestConfiguration {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConfiguration() {
		
		Configurator instance = Configurator.getConfig();
		
		assertNotNull(instance);
		assertEquals("localhost:3306/TestDb", instance.getDbUrl());
		assertEquals("oracle.jdbc.driver.OracleDriver", instance.getDbDriver());
		assertEquals("root", instance.getDbUser());
		assertEquals("password", instance.getDbPassword());
	}

}
