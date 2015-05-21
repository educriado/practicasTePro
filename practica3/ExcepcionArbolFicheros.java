package practica3;
/**
 * Clase base de la jerarquia de excepciones.
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 *
 */
public class ExcepcionArbolFicheros extends Exception{
	
	private String mensajeError;
	
	public ExcepcionArbolFicheros(String mensaje){
		mensajeError = mensaje;
	}
	
	public String toString(){
		return mensajeError;
	}

}
