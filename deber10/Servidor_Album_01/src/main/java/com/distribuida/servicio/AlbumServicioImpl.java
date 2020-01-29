package com.distribuida.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.modelo.Album;

public class AlbumServicioImpl implements IServicioAlbum{

	@Inject EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Album> listarAlbum() {
		List<Album> listaAlbum = new ArrayList<Album>();
		listaAlbum = em.createQuery("FROM Album").getResultList();	
		for (int i = 0; i < listaAlbum.size(); i++) {
			System.out.println(listaAlbum.get(i));
		}
		return listaAlbum;
	}

	@Override
	public Album getAlbum(Integer idAlbum) {
		return em.find(Album.class, idAlbum);
	}

	@Override
	public Album insertar(Album Album) {
		em.getTransaction().begin();
		em.persist(Album);
		em.getTransaction().commit();
		return Album;
	}

	@Override
	public Album editar(Album Album) {
		em.getTransaction().begin();
		em.merge(Album);
		em.getTransaction().commit();
		return Album;
	}

	@Override
	public void eliminar(Integer idAlbum) {
		em.getTransaction().begin();
		Album sing = em.find(Album.class, idAlbum);
		em.remove(sing);
		em.getTransaction().commit();
		
	}

}
