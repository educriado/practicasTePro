package practica3;

/**
 * Se intenta acceder a un archivo o a un enlace
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class NoEsUnDirectorioException extends DistintoTipoException{

	public NoEsUnDirectorioException(String mensaje){
		super(mensaje+": No es un directorio");
	}
}
