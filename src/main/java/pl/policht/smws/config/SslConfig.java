package pl.policht.smws.config;

import java.io.IOException;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class SslConfig {
	@Bean
	public EmbeddedServletContainerFactory servletContainer() throws IOException{
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.addAdditionalTomcatConnectors(createConnector());
		return tomcat;
	}
	
	private Connector createConnector() throws IOException{
		Connector connector = new Connector(Http11NioProtocol.class.getName());
		Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
		connector.setPort(8443);
		connector.setSecure(true);
		connector.setScheme("https");
		protocol.setSSLEnabled(true);
		protocol.setKeyAlias("smws");
		protocol.setKeyPass("sm&root");
		protocol.setKeystorePass("sm&root");
		protocol.setKeystoreFile(new ClassPathResource("tomcat.keystore").getFile().getAbsolutePath());
		protocol.setSslProtocol("TLS");
		return connector;
	}
}
