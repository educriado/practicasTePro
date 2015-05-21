package practica3;

/**
 * Se intenta crear un directorio con el mismo nombre que uno existente.
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class DirectorioYaExistenciaException extends ElementoYaExisteException{

	public DirectorioYaExistenciaException(String mensaje) {
		super(mensaje + ": Ya existe un directorio con este nombre.");
		// TODO Auto-generated constructor stub
	}

}
