package pl.policht.smws.config;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import pl.policht.smws.entity.Person;

@Configuration
@ComponentScan("pl.policht.smws")
@EnableWebMvc
public class AppConfig {
	
	@Bean
	public SessionFactory sessionFactory() {
		org.hibernate.cfg.Configuration configuration = createHibernateConfiguration();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

	private org.hibernate.cfg.Configuration createHibernateConfiguration() {
		org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration()
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "root")
				.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/sm")
				.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
				.addAnnotatedClass(Person.class);
		return cfg;
	}
}
