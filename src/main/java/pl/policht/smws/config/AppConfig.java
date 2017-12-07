package pl.policht.smws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HibernateConfiguration.class)
@ComponentScan("pl.policht.smws.repository")
public class AppConfig {}
