package practica3;

/**
 * Se intenta acceder un archivo o directorio no existente.
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class ElementoNoExisteException extends ExistenciaException{
	
	public ElementoNoExisteException(String mensaje){
		super(mensaje + ": No existe el archivo o directorio.");
	}

}
