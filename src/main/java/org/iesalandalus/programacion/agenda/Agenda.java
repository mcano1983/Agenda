package org.iesalandalus.programacion.agenda;

public class Agenda {
	private int numContactos;
	private static final int MAX_CONTACTOS = 1000;

	public int getNumContactos() {
		return numContactos;
	}

	public Agenda() {
	}

	public Contacto[] getContactos() {

		Contacto contactosCopia[] = new Contacto[getNumContactos()];
		Contacto contactos[] = new Contacto[getNumContactos()];
		Contacto a[] = new Contacto[contactosCopia.length + contactos.length];
		System.arraycopy(contactosCopia, 0, a, 0, contactosCopia.length);
		System.arraycopy(contactos, 0, a, contactosCopia.length, contactos.length);
		return contactos;
	}

}
