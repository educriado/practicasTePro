package practica1;

public class Partida
{
	int	puntos1,puntos2;
	Baraja baraja;
	
	public Partida()
	{
		puntos1 = 0;
		puntos2 = 0;
		baraja = new Baraja();
	}

	/**
	 * Simula un juego de "Guerra" hasta que este finalice porque no quedan cartas
	 * en la baraja.
	 */
	public void juega()
	{
		int puntosEnJuego = 2;
		baraja.mezcla();
		while(baraja.quedanCartas())
		{
			Carta c1, c2;
			System.out.printf("Jugador 1 coge: ");
			c1 = baraja.cogeCarta(); 
			System.out.printf("Jugador 2 coge: ");
			c2 = baraja.cogeCarta();
			if(c1.gana(c2))
			{
				puntos1 += puntosEnJuego;
				System.out.printf("Gana la ronda el jugador 1%n");
				puntosEnJuego = 2;
			}
			else if(c2.gana(c1))
			{
				puntos2 += puntosEnJuego;
				System.out.printf("Gana la ronda el jugador 2%n");
				puntosEnJuego = 2;
			}
			else // Empieza la guerra
			{
				System.out.printf("�GUERRA!%n");
				puntosEnJuego += 2;
			}
		}
	}

	/**
	 * Indica el ganador de la partida mediante un mensaje por pantalla.
	 */
	public void resultado()
	
	{
		System.out.printf("%nPuntuacion jugador 1: %d%nPuntuacion jugador 2: %d%n",puntos1,puntos2);
		if (puntos1>puntos2)
		{
			System.out.println("Gana el Jugador 1");
			return;
		}
		if (puntos2>puntos1)
		{
			System.out.println("Gana el Jugador 2");
			return;
		}
		System.out.println("Empate");
	}
}
