package practica3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que define una ruta en el arbol de directorios,
 * @author Javier Fumanal Idocin - 684229
 * @author Eduardo Criado Mascaray - 662844
 */
public class Ruta {

	private Directorio dirActual, raiz, dirAux;
	private String rutaActual, rutaAux;

	public Ruta(Directorio dir) throws NoEsRaizException{
		if(!dir.esRaiz()){throw new NoEsRaizException(dir.getNombre());}
		dirActual=dir;
		rutaActual=dir.ruta();
		raiz=dir;
	}

	/**
	 * @return La ruta actual.
	 */
	public String pwd(){
		return rutaActual;
	}

	/**
	 * Muestra por pantalla los ficheros existentes en la carpeta.
	 */
	public void ls(){
		dirActual.ls();
	}

	/**
	 * Accede al directorio o ruta especificado.
	 * @param ruta puede ser una ruta o un archivo
	 * @throws ElementoNoExisteException Si no exista la ruta o archivo dado.
	 * @throws NoEsUnDirectorioException Si el archivo dado no es un directorio
	 */
	public void cd(String ruta) throws ElementoNoExisteException, NoEsUnDirectorioException{
		ruta=expandirRuta(ruta);
		if(ruta.equals(".")){return ;}
		ruta=expandirRuta(ruta);
		
		if(ruta.charAt(0)=='/'){
			dirAux=raiz;
			rutaAux="/";
		}
		else{
			dirAux=dirActual;
			rutaAux=rutaActual;
		}
		
		String[] rutaDelim=ruta.split("/");
		for(String folder: rutaDelim){
			if(!folder.equals("")){
				cdAux(folder);
			}
		}
		
		dirActual = (Directorio) dirAux;
		rutaActual = rutaAux;
	}
	
	/**
	 * Muestra por pantalla el tamano de un fichero especificado, sea directamente
	 * o mediante una ruta completa.
	 * @throws ElementoNoExisteException 
	 * @throws NoEsUnDirectorioException
	 */
	public void stat(String element) throws ElementoNoExisteException, NoEsUnDirectorioException{
		element=expandirRuta(element);
		if(element.charAt(0)=='/'){
			dirAux=raiz;
			rutaAux="";
		}
		else{
			dirAux=dirActual;
			rutaAux=rutaActual;
		}
		
		String[] rutaDelim=element.split("/");
		for(int i=1;i<rutaDelim.length-1;i++){
			cdAux(rutaDelim[i]);
		}
		
		System.out.println("Tamanyo de "+ rutaDelim[rutaDelim.length-1] + ": "
				+ dirAux.acceder(rutaDelim[rutaDelim.length-1]).getTamano());
		
		
	}

	/**
	 * Cambia el tamano de un archivo al indicado con [parseInt]
	 * @param fileName nombre del fichero a cambiar
	 * @param parseInt nuevo tamano del fichero
	 * @throws NoEsUnArchivoException si el elemento especificado no es un archivo
	 * @throws NombreInvalidoException si el nombre es invalido.
	 * @throws ElementoNoExisteException si [fileName] no existe
	 */
	public void vim(String fileName, int parseInt) throws NoEsUnArchivoException, NombreInvalidoException{
		// COMPROBAR SI EL NOMBRE ES VALIDO
		Pattern p = Pattern.compile("\\.|\\.{2}| ");
		Matcher m = p.matcher(fileName);
		boolean b = m.find();
		if(b) throw new NombreInvalidoException(fileName);
		try{
			Elemento resul = dirActual.acceder(fileName);
			if(resul.esCarpeta()){throw new NoEsUnArchivoException(fileName);}
			int diff = parseInt - resul.getTamano();
			resul.setTamano(parseInt);
			dirActual.setTamano(diff);
		}
		catch(ElementoNoExisteException e){
			dirActual.add(new Archivo(fileName,parseInt));
		}
			
	}

	/**
	 * Crea un directorio de nombre [nombre] en la carpeta actual.
	 * @throws ElementoYaExisteException No se puede crear si ya existe un elemento con
	 * 		   ese nombre en la carpeta.
	 * @throws NombreInvalidoException si el nombre del directorio es invalido.
	 */
	public void mkdir(String nombre) throws ElementoYaExisteException, NombreInvalidoException{
		// COMPROBAR SI EL NOMBRE ES VALIDO
		Pattern p = Pattern.compile("\\.|\\.{2}| ");
		Matcher m = p.matcher(nombre);
		boolean b = m.find();
		if(b) throw new NombreInvalidoException(nombre);
		dirActual.add(new Directorio(nombre,dirActual));
		
	}

	/**
	 * Crea un enlace del fichero [origen] en la carpeta actual con nombre destino.
	 * El fichero de origen puede ser especificado con una ruta completa o directamente.
	 * @param origen fichero original
	 * @param destino nombre del enlace a crear
	 * @throws ElementoNoExisteException Si no existe el fichero original
	 * @throws NoEsUnDirectorioException Si la ruta no ha sido bien especificada.
	 */
	public void ln(String origen, String destino) throws ElementoNoExisteException,
	NoEsUnDirectorioException{
		origen=expandirRuta(origen);
		if(origen.charAt(0)=='/'){
			dirAux=raiz;
			rutaAux="";
		}
		else{
			dirAux=dirActual;
			rutaAux=rutaActual;
		}
		
		String[] rutaDelim=origen.split("/");
		for(int i=1;i<rutaDelim.length-1;i++){ 
			cdAux(rutaDelim[i]);			
		}
		
		Enlace link=new Enlace(dirAux.acceder(rutaDelim[rutaDelim.length-1]),
				destino,dirAux);
		dirActual.add(link);
		
	}

	/**
	 * Borra el archivo especificado, ya sea directamente o mediante una ruta completa.
	 * @param origen fichero a borrar
	 * @throws ElementoNoExisteException si no existe el elemento a borrar
	 * @throws NoEsUnDirectorioException Si la ruta ha sido mal especificada
	 */
	public void rm(String origen) throws ElementoNoExisteException, NoEsUnDirectorioException{	
		origen=expandirRuta(origen);
		if(origen.charAt(0)=='/'){
			dirAux=raiz;
			rutaAux="";
		}
		else{
			dirAux=dirActual;
			rutaAux=rutaActual;
		}
		String[] rutaDelim=origen.split("/");
		for(int i=1;i<rutaDelim.length-1;i++){
			cdAux(rutaDelim[i]);
		}
		
		dirAux.rm(rutaDelim[rutaDelim.length-1]);
		
	}

	/**
	 * Accede a [archivo] desde dirAux y actualiza rutaAux
	 * @throws ElementoNoExisteException si no existe [archivo]
	 * @throws NoEsUnDirectorioException si [archivo] no es un directorio
	 */
	private void cdAux(String archivo) throws ElementoNoExisteException,
	NoEsUnDirectorioException{
		Elemento candidato=dirAux.acceder(archivo);
		if(candidato.esCarpeta()){
			dirAux = (Directorio) candidato;
			rutaAux += candidato.getNombre()+"/";
		}
		else if(candidato.esEnlace() && ((Enlace) candidato).getContenido().esCarpeta()){
			dirAux = (Directorio) ((Enlace) candidato).getContenido();
			rutaAux = ((Directorio) ((Enlace) candidato).getContenido()).ruta();
		}
		else{throw new NoEsUnDirectorioException(archivo);}
	}

	private String expandirRuta(String ruta){
		if(ruta.equals("..")){
			ruta = dirActual.getRutaPadre();
		}
		else if(ruta.equals(".")){
			ruta = dirActual.ruta();
		}
		else if(ruta.length()>3 && ruta.substring(0, 2).equals("..")){
			ruta = dirActual.getRutaPadre() +ruta.substring(3, ruta.length());
		}
		else if(ruta.length()>2 && ruta.substring(0, 1).equals(".")){
			ruta = dirActual.ruta() +ruta.substring(2, ruta.length());
		}
		
		return ruta;
	}
}
