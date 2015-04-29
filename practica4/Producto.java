
public class Producto implements Ocupa{

	private String nombre;
	private double volumen;

	public Producto(double volumen, String nombre){
		this.volumen = volumen;
		this.nombre = nombre;
	}


	public double getVolumen() {
		return volumen;
	}

}
