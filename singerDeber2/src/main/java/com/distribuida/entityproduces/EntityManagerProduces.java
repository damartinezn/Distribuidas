package com.distribuida.entityproduces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProduces {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	@Produces
	public EntityManager manger() {
		EntityManager em = emf.createEntityManager();
		return em;
	}
}
