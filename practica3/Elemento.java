package practica3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa un enlace a un archivo o directorio.
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class Elemento{
	
	protected int tamano;
	protected String nombre;
	ArrayList<Directorio> carpetas =new ArrayList<Directorio>();
	

	Elemento(){}
	
	Elemento(int tamano,String nombre){
		this.tamano=tamano;
		this.nombre=nombre;
	}
	
	/**
	 * Devuelve el tamano del elemento.
	 */
	public int getTamano(){
		return tamano;
	}

	/**
	 * Modifica el tamano del elemento y actualiza el tamano de las carpetas
	 * de la ruta en la que esta contenido él y sus enlaces.
	 */
	public void setTamano(int tamano){
		int diffTam = tamano - this.tamano;
		this.tamano=tamano;
		notificarCarpetas(diffTam);
	}

	/**
	 * Devuelve el nombre del archivo.
	 */
	public String getNombre(){
		return nombre;
	}

	/**
	 * Devuelve true si solo si el elemento es una carpeta.
	 */
	public boolean esCarpeta(){
		return false;
	}
	
	/**
	 * Devuelve true si el elemento es un enlace.
	 */
	public boolean esEnlace(){
		return false;
	}

	/**
	 * El elemento se guarda en que carpeta esta contenido uno de sus enlaces.
	 */
	public void nuevoEnlace(Directorio folder){
		carpetas.add(folder);
	}
	
	/**
	 * Realiza las acciones especiales que deban realizarse con el elemento borrado
	 */
	public void rm(){;}
	
	/**
	 * Borra una entrada del fichero [folder] en la lista [carpetas] porque
	 * esta ha borrado un link a este fichero.
	 */
	public void retirarEnlace(Directorio folder){
		carpetas.remove(folder);
	}
	
	public String toString(){
		return nombre;
	}
	
	/**
	 * Indica a todas las carpetas que poseen un enlace de este archivo que
	 * su tamano ha sido modificado.
	 */
	private void notificarCarpetas(int diferencia) {
		Iterator<Directorio> index=carpetas.iterator();
		
		while(index.hasNext()){
			Directorio dir= index.next();
			dir.setTamano(diferencia);
			
		}
		
	}


}