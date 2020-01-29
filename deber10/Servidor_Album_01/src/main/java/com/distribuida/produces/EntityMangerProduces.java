package com.distribuida.produces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityMangerProduces {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	@Produces
	public EntityManager manager() {
		EntityManager em = emf.createEntityManager();
		return em;
	}
}
