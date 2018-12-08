package org.iesalandalus.programacion.agenda;

import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Objects;

//Inicializacion de variables privativas//
public class Contacto {
	private static final String ER_TELEFONO = "^[6 9][0-9]{8}$";
	private static final String ER_CORREO = "^\\w+.+[@]{1}[a-z]+[.][a-z]{2,5}$";
	private String nombre;
	private String telefono;
	private String correo;

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty() == true) {

			throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");
		}
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {

		if (telefono == null || telefono.isEmpty() == true) {
			throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
		}
		Pattern pat = Pattern.compile(ER_TELEFONO);
		Matcher mat = pat.matcher(telefono);
		if (mat.matches() == true) {
			this.telefono = telefono;
		} else {
			throw new IllegalArgumentException("El teléfono no tiene un formato válido.");

		}
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {

		if (correo == null|| correo.isEmpty()==true) {
			throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
		}
		Pattern pat = Pattern.compile(ER_CORREO);
		Matcher mat = pat.matcher(correo);
		if (mat.matches() == true) {
			this.correo = correo;
		} else {
			throw new IllegalArgumentException("El correo no tiene un formato válido.");
		}
	}

	public Contacto(String nombre, String telefono, String correo) {
		setTelefono(telefono);
		setNombre(nombre);
		setCorreo(correo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

}
