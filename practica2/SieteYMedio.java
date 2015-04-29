package practica2;
/**
 * @author Eduardo Criado Mascaray 662844
 * @author Javier Fumanal Idocin 684229
 */

public class SieteYMedio implements Partida{

	private int	puntos1,puntos2;
	private Baraja baraja;
	
	public SieteYMedio(){
		baraja = new Baraja();
		puntos1 = 0; puntos2 = 0;
	}
	
	public int juega() {
		baraja.mezcla();
		Carta cartas1[] = new Carta[3]; // Mano del jug. 1
		Carta cartas2[] = new Carta[3]; // Mano del jug. 2
		float suma1, suma2;
		while(baraja.cartasRestantes() >= 6){
			suma1 = 0; suma2 = 0;
			for(int i = 0; i < 3; i++){
				
				cartas1[i] = baraja.cogeCarta();
				cartas2[i] = baraja.cogeCarta();
				if(cartas1[i].getNum() >= 10) suma1 += 0.5;
				else suma1 += cartas1[i].getNum();
				if(cartas2[i].getNum() >= 10) suma2 += 0.5;
				else suma2 += cartas2[i].getNum();
			}
			if(suma1 > 7.5 && suma2 <= 7.5) puntos2++;
			else if(suma2 > 7.5 && suma1 <= 7.5) puntos1++;
			else if(suma1 <= 7.5 && suma2 <= 7.5){
				if(7.5 - suma1 < 7.5 - suma2) puntos1++;
				else if(7.5 - suma2 < 7.5 - suma1) puntos2++;
			}
		}
		if(puntos1 > puntos2) return 1;
		else if(puntos2 > puntos1) return 2;
		else return 0;
	}

}
