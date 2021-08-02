
public class Vertice<T> {
	
	// Atributos de la clase Vertice
	
	protected T data;
	protected ListaEnlazada<Arista<T>> listaAdyacencia;
	protected int label; // 0 => Sin explorar, 1 => Explorada

	// Constructor de la clase Vertice
	
	public Vertice(T data) {
		setData(data);
		setLista();
	}
	
	// Setters y getters de la clase Vertice
	
	public T getData() {
		return this.data; 
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public ListaEnlazada<Arista<T>> getLista(){
		return this.listaAdyacencia;
	}
	
	public void setLista() {
		this.listaAdyacencia = new ListaEnlazada<Arista<T>>();
	}
	
	// Metodos de la clase Vertice
	
	public boolean equals(Object obj) {
		if(obj instanceof Vertice<?>) {
			Vertice<T> vertice = (Vertice<T>) obj;
			return getData().equals(vertice.getData());
		}
		return false;
	}
	
	// Metodo toString, devuelve el contenido del Vertice
	@Override
	public String toString() {
		return getData() + " ==> " + getLista() + "\n";
	}
	
}
