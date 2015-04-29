package practica1;

public class Carta {

	private int numero;
	private String palo;
	
	/**
	 * Constructor. Inicializa los valores de la carta.
	 * @param numero
	 * @param palo
	 */
	public Carta(int numero, String palo)
	{
		this.numero = numero;
		this.palo = palo;
	}
	
	/**
	 * 
	 * @return Devuelve el valor de la carta de acuerdo
	 * 			a las reglas del juego.
	 */
	public int getNum()
	{
		if(numero==1){
			return 13;
		}
		return numero;
	}
	
	/**
	 * 
	 * @return devuelve un String con el palo al que pertenece la carta.
	 */
	public String getPalo()
	{
		return palo;
	}
	
	/**
	 * 
	 * @param otra
	 * @return true si solo si this posee un valor mayor
	 * 			que [otra]. 
	 */
	public boolean gana(Carta otra)
	{
		return this.numero > otra.getNum();
	}
	
	/**
	 * @return un String que contiene la informacion referida a la carta.
	 */
	public String toString(){
		String resul="";
		
		if(numero<=7){
			resul+=numero +" de "+palo;
		}
		else if(numero==10){
			resul+="sota de "+palo;
		}
		else if(numero==11){
			resul+="caballo de "+palo;
		}
		else if(numero==12){
			resul+="rey de "+palo;
		}
		return resul; 
	}
}