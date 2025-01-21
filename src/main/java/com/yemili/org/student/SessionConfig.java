package com.yemili.org.student;

import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configurable
@EnableJdbcHttpSession(tableName = "SPRING_SESSION")
public class SessionConfig {
  
	
}




