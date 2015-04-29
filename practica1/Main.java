package practica1;

import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		Partida p = new Partida();

		p.juega();
		p.resultado();
	}

	static Random rnd;
	static {
		rnd = new Random();
	}
	public static int rand()
	{
		return rnd.nextInt(40);
	}
}
