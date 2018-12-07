package org.iesalandalus.programacion.agenda;

import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Objects;

//Inicializacion de variables privativas//
public class Contacto {
	private static final String ER_TELEFONO = "[6 9][0-9] {8}";
	private static final String ER_CORREO = "^\\w+.+[@]{1}\\w+.[a-z]{2,5}$";
	private String nombre;
	private String telefono;
	private String correo;

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
		} else {
			throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");
		}
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		Pattern pat = Pattern.compile(ER_TELEFONO);
		Matcher mat = pat.matcher(telefono);
		if (telefono == null) {
			throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
		}
		if (mat.matches() == false) {
			throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
		} else {
			this.telefono = telefono;
		}
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		Pattern pat = Pattern.compile(ER_CORREO);
		Matcher mat = pat.matcher(correo);
		if (correo == null) {
			throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
		}
		if (mat.matches() == false) {
			throw new IllegalArgumentException("El correo no tiene un formato válido.");
		} else {
			this.correo = correo;
		}
	}

}
