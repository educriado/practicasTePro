package practica3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Main {
   public static void main(String[] args) {
	Directorio raiz;
	Ruta ruta;
	try {
		raiz = new Directorio("");
		ruta = new Ruta(raiz);
	} catch (ExcepcionArbolFicheros e) { return; }
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean end = false;

	while (!end)
	{ 
		System.out.print(ruta.pwd()+"> ");
		try {
			String[] argv = br.readLine().split(" ");
			if (argv[0].equals("pwd")) {
				System.out.println(ruta.pwd());
			} else if (argv[0].equals("ls")) {
				ruta.ls();
			} else if (argv[0].equals("cd")) {
				ruta.cd(argv[1]);
			} else if (argv[0].equals("stat")) {
				if (argv.length > 1) ruta.stat(argv[1]);
				else ruta.stat(".");
			} else if (argv[0].equals("vim")) {
				ruta.vim(argv[1], Integer.parseInt(argv[2]));
			} else if (argv[0].equals("mkdir")) {
				ruta.mkdir(argv[1]);
			} else if (argv[0].equals("ln")) {
				ruta.ln(argv[1],argv[2]);
			} else if (argv[0].equals("rm")) {
				ruta.rm(argv[1]);
			} else if (argv[0].equals("exit")) {
				end = true;
			} else {
				System.out.println("Comando desconocido");
			}
		} catch(ExcepcionArbolFicheros e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println("Error de entrada-salida");
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("Error sintactico: parametros insuficientes");
		}
	}
   }
};
