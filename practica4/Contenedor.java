
public class Contenedor<T extends Producto> implements Ocupa, Guarda{

	
	public boolean guardar(Ocupa elemento) {
		return true;
	}

	
	public double getVolumen() {
		return 0;
	}

}
