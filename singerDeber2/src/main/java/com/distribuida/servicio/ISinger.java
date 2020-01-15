package com.distribuida.servicio;

import java.util.List;

import com.distribuida.entidades.Singer;

public interface ISinger {

	List<Singer> listarSinger();
	
	Singer getSinger(Integer idsinger);
	
	Singer insertar(Singer singer);
	
	Singer editar(Singer singer);
	
	void eliminar(Integer idsinger);
}
