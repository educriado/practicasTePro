package practica3;

/**
 * Se intenta crear un elemento con un nombre invalido.
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class NombreInvalidoException extends SyntaxErrorException{

	public NombreInvalidoException(String mensaje) {
		super(mensaje + ": No es un nombre valido.%n"
				+ "Un nombre no puede contener '.', '..', '/' o espacios.");
	}

}
