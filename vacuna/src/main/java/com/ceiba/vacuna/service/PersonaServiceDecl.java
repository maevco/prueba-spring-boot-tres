package com.ceiba.vacuna.service;

import java.util.List;

import com.ceiba.vacuna.modelo.Persona;

public interface PersonaServiceDecl {
	/**
	 * 
	 * @return
	 */
	public List<Persona> getAllPersonas();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Persona findById(long id);

	/**
	 * 
	 * @param persona
	 * @return
	 * @throws Exception 
	 */
	public Persona add(Persona persona);

	/**
	 * 
	 * @param persona
	 * @return
	 */
	public Persona edit(Persona persona);

	/**
	 * 
	 * @param persona
	 */
	public Persona delete(long id);
	
	/**
	 * 
	 * @param tipoIdentificacion
	 * @param numeroIdentificacion
	 * @return
	 */
	public boolean existsByTipoNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion);

}
