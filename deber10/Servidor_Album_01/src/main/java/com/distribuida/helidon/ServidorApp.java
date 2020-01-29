package com.distribuida.helidon;

import java.util.Set;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

@ApplicationPath("/")
@ApplicationScoped
public class ServidorApp extends Application {

	@Inject
	@ConfigProperty(name = "server.port")
	private Integer port;

	@Inject
	@ConfigProperty(name = "consul.server", defaultValue = "127.0.0.1")
	private String consulIp;

	@Inject
	@ConfigProperty(name = "consul.port", defaultValue = "8500")
	private Integer consulPort;

	String id = UUID.randomUUID().toString();

	@Override
	public Set<Class<?>> getClasses() {
		return Set.of(AlbumRest.class, PingRest.class);
	}

	// parametros del consul

	@Inject
	private ConsulClient client;

	@Inject
	private NewService newService;

	@Inject
	private NewService.Check check;

	// Inicializando los eventos se registre
	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		System.out.println("Iniicio");

		newService.setId(id);
		newService.setName("album");
		newService.setAddress("127.0.0.1");
		newService.setPort(port);

		// comprobar si funciona el servicio
		check.setMethod("GET");
		check.setHttp("http://127.0.0.1:" + port + "/ping");
		check.setInterval("10s");
		// si no responde espera 10s y lo elimina
		check.setDeregisterCriticalServiceAfter("10s");

		newService.setCheck(check);

		client.agentServiceRegister(newService);
	}

	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
		ConsulClient client = new ConsulClient();
		client.agentServiceDeregister(id);
	}

}
