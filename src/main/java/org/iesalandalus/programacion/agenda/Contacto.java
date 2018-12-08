package org.iesalandalus.programacion.agenda;

import java.util.StringTokenizer;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Objects;

//Inicializacion de variables privativas
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

		if (correo == null || correo.isEmpty() == true) {
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

	private String getIniciales() {
		StringTokenizer cadena = new StringTokenizer(nombre);
		String iniciales = "";
		while (cadena.hasMoreTokens()) {
			String nombreCompletoToken = cadena.nextToken();
			iniciales += nombreCompletoToken.charAt(0);
		}
		iniciales = iniciales.toUpperCase();
		return iniciales;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Contacto other = (Contacto) obj;
		if (Objects.equals(this.nombre.toLowerCase(), other.nombre.toLowerCase())) {
			return true;
		}
		if (!Objects.equals(this.telefono, other.telefono)) {
			return false;
		}
		if (!Objects.equals(this.correo, other.correo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getIniciales() + " [" + telefono + ", " + correo + "]";
	}

}
