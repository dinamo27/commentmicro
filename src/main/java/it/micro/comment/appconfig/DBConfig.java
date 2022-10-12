package it.micro.comment.appconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfig {

//	@Value("${spring.datasource.username}")
//	private String mongodbUserName;
//	@Value("${spring.datasource.password}")
//	private String mongodbPassword;
//	@Value("${spring.datasource.url}")
//	private String mongodbUrl;
//
//	@Bean("mongodb")
//	public DataSource createMongoDBDataSource() {
//
//		HikariConfig config = new HikariConfig();
//		config.setUsername(mongodbUserName);
//		config.setPassword(mongodbPassword);
//		config.setJdbcUrl(mongodbUrl);
//
//		return new HikariDataSource(config);
//
//	}

	@Value("${spring.datasource.username}") // con value prendiamo il valore specificato nell'application.properties
	private String postgreUserName;
	@Value("${spring.datasource.password}")
	private String postgrePassword;
	@Value("${spring.datasource.url}")
	private String postgreUrl;

	@Bean("postgre")
	public DataSource createPostgredDataSource() {

		HikariConfig config = new HikariConfig();
		config.setUsername(postgreUserName);
		config.setPassword(postgrePassword);
		config.setJdbcUrl(postgreUrl);

		return new HikariDataSource(config);

	}

}
