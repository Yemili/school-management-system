package com.yemili.org.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.session.config.SessionRepositoryCustomizer;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configurable
@EnableJdbcHttpSession(tableName = "SPRING_SESSION")
public class SessionConfig {
  
	/*
	 * @Bean public TableNameCustomizer tableNameCustomizer() { return new
	 * TableNameCustomizer(); }
	 */
}
/*
 * public class TableNameCustomizer implements
 * SessionRepositoryCustomizer<JdbcIndexedSessionRepository> {
 * 
 * @Override public void customize(JdbcIndexedSessionRepository
 * sessionRepository) { sessionRepository.setTableName("SPRING_SESSION"); }
 * 
 * }
 */
	

	/*
	 * public class QueryCustomizer implements
	 * SessionRepositoryCustomizer<JdbcIndexedSessionRepository> {
	 * 
	 * private static final String CREATE_SESSION_ATTRIBUTE_QUERY = """ INSERT INTO
	 * %TABLE_NAME%_ATTRIBUTES (SESSION_PRIMARY_ID, ATTRIBUTE_NAME, ATTRIBUTE_BYTES)
	 * VALUES (?, ?, ?) ON CONFLICT (SESSION_PRIMARY_ID, ATTRIBUTE_NAME) DO NOTHING
	 * """;
	 * 
	 * private static final String UPDATE_SESSION_ATTRIBUTE_QUERY = """ UPDATE
	 * %TABLE_NAME%_ATTRIBUTES SET ATTRIBUTE_BYTES = encode(?, 'escape')::jsonb
	 * WHERE SESSION_PRIMARY_ID = ? AND ATTRIBUTE_NAME = ? """;
	 * 
	 * @Override public void customize(JdbcIndexedSessionRepository
	 * sessionRepository) { sessionRepository.setCreateSessionAttributeQuery(
	 * CREATE_SESSION_ATTRIBUTE_QUERY);
	 * sessionRepository.setUpdateSessionAttributeQuery(
	 * UPDATE_SESSION_ATTRIBUTE_QUERY); } }
	 */





