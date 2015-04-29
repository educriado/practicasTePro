package practica2;
/**
 * @author Eduardo Criado Mascaray 662844
 * @author Javier Fumanal Idocin 684229
 */

import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		Casino lasVegas = new Casino(10);
		lasVegas.juega();
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
