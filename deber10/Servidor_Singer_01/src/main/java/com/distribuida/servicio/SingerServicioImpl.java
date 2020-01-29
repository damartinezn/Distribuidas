package com.distribuida.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.modelo.Singer;

public class SingerServicioImpl implements IServicioSinger{

	@Inject EntityManager EM;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Singer> listarSinger() {
		List<Singer> listaSinger = new ArrayList<Singer>();
//		listaSinger = EM.createQuery("FROM Singer").getResultList();	
		for (int i = 0; i < listaSinger.size(); i++) {
			System.out.println(listaSinger.get(i));
		}
		return listaSinger;
	}

	@Override
	public Singer getSinger(Integer idsinger) {
		return EM.find(Singer.class, idsinger);
	}

	@Override
	public Singer insertar(Singer singer) {
		EM.getTransaction().begin();
		EM.persist(singer);
		EM.getTransaction().commit();
		return singer;
	}

	@Override
	public Singer editar(Singer singer) {
		EM.getTransaction().begin();
		EM.merge(singer);
		EM.getTransaction().commit();
		return singer;
	}

	@Override
	public void eliminar(Integer idsinger) {
		EM.getTransaction().begin();
		Singer sing = EM.find(Singer.class, idsinger);
		EM.remove(sing);
		EM.getTransaction().commit();
		
	}

}
