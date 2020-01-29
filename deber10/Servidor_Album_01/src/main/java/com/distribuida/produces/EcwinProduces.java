package com.distribuida.produces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

@ApplicationScoped
public class EcwinProduces {
	
	@Produces
	public ConsulClient consul() {
		return new ConsulClient();
	}
	
	@Produces
	public NewService service() {
		return new NewService();
	}
	
	@Produces
	public NewService.Check check(){
		return  new NewService.Check();
	}
}
