package practica3;

/**
 * 
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class NoEsRaizException extends ExistenciaException {

	public NoEsRaizException(String mensaje) {
		super(mensaje +": No es una carpeta raiz");
	}
	

}
