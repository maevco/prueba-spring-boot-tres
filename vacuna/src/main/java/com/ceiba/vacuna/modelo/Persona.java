package com.ceiba.vacuna.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "persona", schema = "public")
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private Date fechaNacimiento;

	public Persona() {
	};

	public Persona(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public Persona(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			String tipoIdentificacion, String numeroIdentificacion, Date fechaNacimiento) {
		this.id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.fechaNacimiento = fechaNacimiento;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "El nombre no puede ser Nulo")
	@Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
	@Column(name = "primer_nombre")
	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	@Column(name = "segundo_nombre")
	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	@NotNull(message = "El primer apellido no puede ser Nulo")
	@Size(min = 2, message = "El primer apellido debe tener al menos dos caracteres")
	@Column(name = "primer_apellido")
	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	@Column(name = "segundo_apellido")
	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	@NotNull(message = "El numero de identificacion no puede ser Nulo")
	@Size(min = 2, message = "El numero de identificacion debe tener al menos dos caracteres")
	@Column(name = "numero_identificacion")
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	@Column(name = "fecha_nacimiento")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Column(name = "tipo_identificacion")
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
}
