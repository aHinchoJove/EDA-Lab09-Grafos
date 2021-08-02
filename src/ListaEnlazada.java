
public class ListaEnlazada<T> {
	
	// Atributos de la clase ListaEnlazada
	
	protected Nodo<T> first;
	
	// Constructor de la clase ListaEnlazada
	
	public ListaEnlazada() {
		setFirst(null);
	}
	
	// Metodos setters y getters
	
	public void setFirst(Nodo<T> first) {
		this.first = first;
	}
	
	public Nodo<T> getFirst() {
		return this.first;
	}
	
	// Metodos de la clase Lista Enlazada
	
	// Metodo isEmpty verifica si la Lista Enlazada esta vacia
	public boolean isEmpty() {
		return getFirst() == null;
	}
	
	// Insertar un Nodo al inicio
	public void insert(T data) {
		setFirst(new Nodo<T>(data, getFirst()));
	}
	
	// Insertar al final de un Nodo
	public void insertLast(T data) {
		Nodo<T> aux = getFirst();
		// Recorrer el Nodo hasta llegar al final
		while(aux.getNext() != null) {
			aux = aux.getNext();
		}
		// Aux contiene el ultimo Nodo, insertar al siguiente
		aux.setNext(new Nodo<T>(data));
	}
	
	// Buscar un elemento dentro de nuestra Lista Enlazada
	public T search(T data) {
		// Rescatar la referencia al primer Nodo
		Nodo<T> aux = getFirst();
		// Recorrer la Lista Enlazada desde el primer Nodo
		while(aux != null && !aux.getData().equals(data)) {
			aux = aux.getNext();
		}
		// Evaluar el contenido y dar respuesta
		if(aux != null) {
			// Busqueda con exito
			return aux.getData();
		} else {
			// Busqueda sin exito
			return null;
		}
	}
	
	// Metodo toString, devuelve contenido de la Lista Enlazada
	@Override
	public String toString() {
		String retornar = "";
		Nodo<T> aux = getFirst();
		while(aux != null) {
			retornar += aux.getData();
			aux = aux.getNext();
		}
		return retornar;
	}
	
}
