package practica2;
/**
 * @author Eduardo Criado Mascaray 662844
 * @author Javier Fumanal Idocin 684229
 */
public class Baraja {

	private Carta[] cartas;
	private int indice;		// Para recorrer la baraja una vez mezclada
	
	/**
	 * Constructor. Inicializa todas las cartas de la baraja.
	 */
	public Baraja()
	{
		cartas = new Carta[40];
		int i;
		// Llenamos la baraja
		for(i = 0; i < 7; i++)
		{
			cartas[i] = new Carta(i+1, "Oros");
			cartas[i + 10] = new Carta(i+1,"Copas");
			cartas[i + 20] = new Carta(i+1, "Espadas");
			cartas[i + 30] = new Carta(i+1, "Bastos");
		}
		for(; i < 10; i++)
		{
			cartas[i] = new Carta(i + 3, "Oros");
			cartas[i + 10] = new Carta(i + 3,"Copas");
			cartas[i + 20] = new Carta(i + 3, "Espadas");
			cartas[i + 30] = new Carta(i + 3, "Bastos");
		}
	}
	
	/**
	 * Reordena las cartas de la baraja de forma aleatoria.
	 */
	public void mezcla()
	{
		for(int i=0;i<40;i++){
			swap(i,Main.rand());
		}	
	}
	/**
	 * Intercambia los valores de la cartas i-esima y e-esima.
	 * @param 0<=i<40 
	 * @param 0<=e<40
	 */
	private void swap(int i,int e){
		Carta aux = cartas[i];
		cartas[i]=cartas[e];
		cartas[e]=aux;
	}
	/**
	 * Pre: Queda al menos una carta en la baraja
	 * Post: Hay una carta menos en la baraja
	 * @return Carta siguiente que queda en la baraja
	 */
	public Carta cogeCarta()
	{
		indice++;
		return cartas[indice - 1];
	}
	
	/**
	 * @return true si queda al menos una carta en la baraja
	 */
	public boolean quedanCartas()
	{
		return indice < 40;
	}
	
	/**
	 * @return Numero de cartas que quedan en la baraja
	 */
	public int cartasRestantes(){
		return 40 - indice;
	}
}
