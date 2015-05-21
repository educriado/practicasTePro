package practica3;

/**
 * Se intenta realizar una operacion para un archivo con un directorio.
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class NoEsUnArchivoException extends DistintoTipoException{

	public NoEsUnArchivoException(String mensaje){
		super(mensaje+": No es un archivo");
	}
}
