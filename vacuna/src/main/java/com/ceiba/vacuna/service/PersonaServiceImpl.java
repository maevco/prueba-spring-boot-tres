package com.ceiba.vacuna.service;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.ceiba.vacuna.modelo.Persona;
import com.ceiba.vacuna.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaServiceDecl {

	private  final Date fechaActual = new Date();
	
	@Autowired
	PersonaRepository personaRepository;

	@Override
	public List<Persona> getAllPersonas() {
		return personaRepository.findAll();
	}

	@Override
	public Persona findById(long id) {
		return personaRepository.findById(id);
	}

	@Override
	public Persona add(Persona persona) {
		long daysBetween = ChronoUnit.DAYS.between(persona.getFechaNacimiento().toInstant(), fechaActual.toInstant());		
		
		if (daysBetween / 365 < 18) {
			throw new IllegalArgumentException("Edad no permitida, debe ser mayor de edad: "+ daysBetween/365 + " Años");
		}
		
		if(personaRepository.existsByTipoNumeroIdentificacion(persona.getTipoIdentificacion(), persona.getNumeroIdentificacion())==true) {
			  throw new DuplicateKeyException("Ya existe usuario con tipo y numero de identificación ingresado: " + persona.getNumeroIdentificacion());
		}		
		
		//prueba clonado
		
		return personaRepository.save(persona);

	}

	@Override
	public Persona edit(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public Persona delete(long id) {
		Persona persona = personaRepository.findById(id);

		if (persona != null) {
			personaRepository.delete(persona);
		}
		return persona;
	}

	@Override
	public boolean existsByTipoNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion) {
		return personaRepository.existsByTipoNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion);
	}

}
