package practica2;
/**
 * @author Eduardo Criado Mascaray 662844
 * @author Javier Fumanal Idocin 684229
 */



public class CartaMasAlta implements Partida{

	private int	puntos1,puntos2;
	private Baraja baraja;
	
	public CartaMasAlta()
	{
		puntos1 = 0;
		puntos2 = 0;
		baraja = new Baraja();
	}

	/**
	 * Simula un juego de "Guerra" hasta que este finalice porque no quedan cartas
	 * en la baraja.
	 */
	public int juega()
	{
		int puntosEnJuego = 2;
		int valorReal1, valorReal2;
		baraja.mezcla();
		while(baraja.quedanCartas())
		{
			Carta c1, c2;
			c1 = baraja.cogeCarta(); 
			c2 = baraja.cogeCarta();
			
			if(c1.getNum() == 1) valorReal1 = 13;
			else valorReal1 = c1.getNum();
			if(c2.getNum() == 1) valorReal2 = 13;
			else valorReal2 = c2.getNum();
			if(valorReal1 > valorReal2)
			{
				puntos1 += puntosEnJuego;	
				puntosEnJuego = 2;
			}
			else if(valorReal1 < valorReal2)
			{
				puntos2 += puntosEnJuego;
				puntosEnJuego = 2;
			}
			else // Empieza la guerra
			{
				puntosEnJuego += 2;
			}
		}
		if(puntos1 > puntos2) return 1;
		else if(puntos2 > puntos1) return 2;
		else return 0;
	}
}
