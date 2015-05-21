package practica3;
/**
 * Se intenta realizar una operacion con un elemento de un tipo que no deberia.
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class DistintoTipoException extends ExistenciaException{

	public DistintoTipoException(String mensaje) {
		super(mensaje);
	}

}
