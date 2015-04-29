import java.util.*;
/**
 * Interfaz que implementan objetos que pueden guardar cosas.
 */
public class Guarda {

	double capacidad;
	private ArrayList<Ocupa> guardados;

	public Guarda(double capacidad){
		this.capacidad = capacidad;
		guardados = new ArrayList<>();
	}

	public boolean guardar(Ocupa elemento){
		if(elemento.getVolumen() >= capacidad + elemento.getVolumen()){
			return false;
		}
		else{
			guardados.add(elemento);
			capacidad -= elemento.getVolumen();
			return true;
		}
	}
}
