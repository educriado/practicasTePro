package practica3;
/**
 * Se intenta crear un directorio o un archivo que ya existe.
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class ElementoYaExisteException extends ExistenciaException{
	
	public ElementoYaExisteException(String mensaje){
		super("Ya existe un fichero con nombre: "+mensaje);
	}

}
