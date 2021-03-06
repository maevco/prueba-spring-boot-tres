package com.ceiba.vacuna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ceiba.vacuna.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	/**
	 * 
	 * @return
	 */
	public List<Persona> findAll();

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
	 */
	@SuppressWarnings("unchecked")
	public Persona save(Persona persona);

	/**
	 * 
	 * @param id
	 */
	public void delete(Persona persona);
	
	/**
	 * 
	 * @param numeroIdentificacion
	 * @return
	 */
	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN 'true' ELSE 'false' END FROM Persona p WHERE p.tipoIdentificacion = ?1 AND p.numeroIdentificacion = ?2")
    public boolean existsByTipoNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion);

	

}
