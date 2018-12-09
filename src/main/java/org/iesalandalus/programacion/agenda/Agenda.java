package org.iesalandalus.programacion.agenda;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Agenda {
	private int numContactos;
	private static final int MAX_CONTACTOS = 1000;
	

	public int getNumContactos() {
		return numContactos;
	}

	public Agenda() {
	}

	public Contacto[] getContactos() {
		//crear array de contactos y copia de contactos con la longitud de numero de contactos de la agenda.
		//copiar con arraycopy uno a otro, devolver la copia
		
		Contacto[] contactos = new Contacto[getNumContactos()];
		Contacto[] copiaDeContactos = new Contacto[getNumContactos()];
		System.out.println("dentro de getContactos"+Arrays.toString(contactos));
		System.arraycopy(contactos, 0, copiaDeContactos, 0, contactos.length);

		return copiaDeContactos;

	}
	
	
		private boolean IndiceNoSuperaTamano(int i){
			if(i>=getContactos().length) {
				return true;
			}else
				return false;
			}
		//Intente hacer el metodo anadir pero no pude hacer que funcionase
	/*public void anadir(Contacto contacto) {
		System.out.println("el numero de contatos vale"+ this.getNumContactos());
		Contacto[] contactosActuales = new Contacto[this.getNumContactos()];
	 
		int numeroContactos = this.numContactos;
		contactosActuales = this.getContactos();
		System.out.println("los contactos actuales son"+Arrays.toString(contactosActuales));

		contacto=new Contacto(contacto.getNombre(),contacto.getTelefono(),contacto.getCorreo());
	
		Contacto[] contactos = new Contacto[this.getNumContactos()+1];
			
		contactos[contactos.length-1] = contacto;
		
		if(this.numContactos >= 1) {
			for(int i= 0; i<=this.getNumContactos();i++) {
				contactos[i] = contactosActuales[i];
			}
		}
		
		this.numContactos = contactos.length;
		System.out.println(Arrays.toString(contactos));
	}*/
}
