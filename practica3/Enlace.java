package practica3;

/**
 * Clase que representa un enlace.
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class Enlace extends Elemento{

	Elemento contenido;
	Directorio folder;

	public Enlace(Elemento contenido,String nombre,Directorio folder){
		this.contenido=contenido;
		this.nombre=nombre;
		this.folder=folder;
		contenido.nuevoEnlace(folder);
	}

	/**
	 * Devuelve el tamano del  al que esta asociado
	 * el enlace.
	 */
	public int getTamano(){
		return contenido.getTamano();
	}

	/**
	 * Cambia el tamano del elemento al que esta asociado.
	 */
	public void setTamano(int tamano){
		contenido.setTamano(tamano);
	}

	/**
	 * Devuelve el nombre del enlace.
	 */
	public String getNombre(){
		return nombre;
	}

	

	/**
	 * Devuelve true si el elemento es un enlace.
	 */
	public boolean esEnlace(){
		return true;
	}
	/**
	 * Notifica al archivo original que el enlace ha sido borrado.
	 */
	public void rm(){
		contenido.retirarEnlace(folder);
	}

	/**
	 * @return El contenido al que apunta el enlace
	 */
	public Elemento getContenido(){
		return contenido;
	}


}
