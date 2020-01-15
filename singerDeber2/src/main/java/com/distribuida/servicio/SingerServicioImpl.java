package com.distribuida.servicio;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import com.distribuida.entidades.Singer;

@ApplicationScoped
public class SingerServicioImpl implements ISinger {

	@Inject EntityManager em;
	
	@Override
	public List<Singer> listarSinger() {
		List<Singer> singers = em.createQuery("FROM Singer", Singer.class).getResultList();
		return singers;
	}

	@Override
	public Singer getSinger(Integer idsinger) {
		Singer sing = em.find(Singer.class, idsinger);
		return sing;
	}

	@Override
	public Singer insertar(Singer singer) {
		em.getTransaction().begin();
		em.persist(singer);
		em.getTransaction().commit();
		return singer;
	}

	@Override
	public Singer editar(Singer singer) {
		em.getTransaction().begin();
		em.merge(singer);
		em.getTransaction().commit();
		return singer;
	}

	@Override
	public void eliminar(Integer idsinger) {
		em.getTransaction().begin();
		Singer sing = em.find(Singer.class, idsinger);		
		em.remove(sing);
		em.getTransaction().commit();
	}

}
