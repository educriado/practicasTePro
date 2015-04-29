
public class Contenedor<T extends Ocupa> extends Guarda implements Ocupa{

	public Contenedor(double capacidad){
		super(capacidad);
	}
	
	public double getVolumen() {
		return capacidad;
	}

}
