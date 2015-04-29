package practica2;
/**
 * @author Eduardo Criado Mascaray 662844
 * @author Javier Fumanal Idocin 684229
 */
import java.util.Random;

public class Casino {
	
	private int numPartidas;
	
	public Casino(int partidaN){
		numPartidas = partidaN;
	}
	
	/**
	 * Juega las partidas que tiene el casino e indica si globalmente gana
	 * el jugador o gana el casino.
	 */
	public void juega(){
		int gana1=0,gana2=0;
		Random generador = new Random();
		Partida partida;
		for(int i=0;i<numPartidas;i++){
			if(generador.nextBoolean()){
				partida = new CartaMasAlta();
				System.out.println("Juego: Carta Mas Alta");
				
			}
			else{
				partida = new SieteYMedio();
				System.out.println("Juego: Siete Y Medio");
			}
			switch(partida.juega()){
			case 1:
				System.out.println("Victoria para el Casino");
				gana1++;
				break;
			case 2: 
				System.out.println("Victoria para el Jugador");
				gana2++;
				break;
			default:
				System.out.println("Empate");
			}
		}
		System.out.printf("\n%d - %d%n", gana1, gana2);
		if (gana1 > gana2) System.out.println("El ganador global es el Casino");
		else if(gana2 > gana1) System.out.println("El ganador global es el Jugador");
		else System.out.println("Empate global");
	}
	
	

}
