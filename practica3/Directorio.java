package practica3;



import java.util.Enumeration;
import java.util.Hashtable;

public class Directorio extends Elemento{

	private Hashtable<String,Elemento> archivos;
	private Directorio padre;
	private boolean raiz;
	
	/**
	 * Constructor especifico para la raiz.
	 */
	public Directorio(String nombre){
		super(0,nombre);
		archivos = new Hashtable<String, Elemento>();
		raiz=true;
	}
	
	public Directorio(String nombre,Directorio padre) throws ElementoYaExisteException{
		super(0,nombre);
		if(padre.archivos.containsKey(nombre)){
			throw new ElementoYaExisteException(nombre);
		}
		archivos=new Hashtable<String,Elemento>();
		this.padre=padre;
	}
	
	/**
	 * Crea un directorio dentro del directorio actual.
	 * @throws ElementoYaExisteException si ya existe un elemento con ese nombre en la carpeta.
	 */
	public void mkdir(String nombreDir) throws ElementoYaExisteException{
		archivos.put(nombreDir,new Directorio(nombreDir,this));
	}

	/**
	 * Devuelve el elemento de nombre [fileName]
	 * @throws ElementoNoExisteException si no existe tal elemento
	 */
	public Elemento acceder(String fileName) throws ElementoNoExisteException{
		Elemento resultado = archivos.get(fileName);
		if(resultado==null){throw new ElementoNoExisteException(fileName);}
		return resultado;
		
	}

	/**
	 * Devuelve la ruta en la que se encuentra el directorio.
	 */
	public String ruta(){
		if(raiz){return "/";}
		return padre.ruta()+nombre+"/";
	}

	/**
	 * Muetra por pantalla todos los elementos del directorio actual.
	 */
	public void ls(){
		Enumeration<Elemento> enumeracion= archivos.elements();
		
		while(enumeracion.hasMoreElements()){
			System.out.println(enumeracion.nextElement());
		}
	}

	/**
	 * Modifica el tamano del directorio actual.
	 */
	public void setTamano(int aumento){
		tamano+=aumento;
		if(!raiz){padre.setTamano(aumento);}
	}
	
	/**
	 * Borra el elemento de nombre [fileName] del directorio actual.
	 * @throws ElementoNoExisteException si no se encuentra tal elemento.
	 */
	public void rm(String fileName) throws ElementoNoExisteException{
		Enumeration<Elemento> enumeracion= archivos.elements();
		
		while(enumeracion.hasMoreElements()){
			Elemento aux=enumeracion.nextElement();
			if(aux.getNombre().equals(fileName)){
				archivos.remove(fileName);
				aux.rm();
				tamano+=-aux.getTamano();
				if(!raiz){padre.setTamano(-aux.getTamano());}
				return;
			}
		}
		
		throw new ElementoNoExisteException(fileName);
	}

	/**
	 * Anyade al directorio el elemento [anadir].
	 */
	public void add(Elemento anadir){
		archivos.put(anadir.getNombre(),anadir);
		tamano+=anadir.getTamano();
		if(!raiz){padre.setTamano(padre.getTamano()+anadir.getTamano());}
	}

	@Override
	public boolean esCarpeta(){
		return true;
	}
	
	/**
	 * Devuelve true si solo si el directorio es raiz, y por tanto no
	 * tiene padre.
	 */
	public boolean esRaiz(){return raiz;}
	
	/**
	 * Devuelve la raiz del sistema de directorios en el que esta el
	 * directorio actual.
	 */
	public Directorio getRaiz(){
		if(!raiz){return padre.getRaiz();}
		return this;
	}
	
	/**
	 * 
	 * @return la ruta del padre del directorio actual.
	 */
	public String getRutaPadre(){
		if(raiz){return "/";}
		return padre.ruta();
	}






	
}