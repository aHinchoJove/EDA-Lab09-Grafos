
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
		if(aux == null) {
			// Si el nodo auxiliar es nulo insertar al inicio
			insert(data);
		} else {
			// Recorrer el Nodo hasta llegar al final
			while(aux.getNext() != null) {
				aux = aux.getNext();
			}
			// Aux contiene el ultimo Nodo, insertar al siguiente
			aux.setNext(new Nodo<T>(data));
		}
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
	
	// Eliminar un elemento dentro de nuestra Lista Enlazada
	public T remove(T data) {
		// Variable de apoyo para el retorno del metodo
		T retornar = null;
		// Rescatar el Nodo inicial de la Lista
		Nodo<T> aux = getFirst();
		if(getFirst().getData().equals(data)) {
			// Eliminar al inicio de la Lista
			setFirst(getFirst().getNext());
			retornar = null;
		} else {
			// Eliminar en medio de la Lista
			while(aux.getNext() != null) {
				if(aux.getNext().getData().equals(data)) {
					retornar = aux.getNext().getData();
					aux.setNext(aux.getNext().getNext());
				} else {
					aux = aux.getNext();
				}
			}
		}
		return retornar;
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
	
	public ListaEnlazada<T> copiar(ListaEnlazada<T> lista) {
		// Rescatar el Nodo inicial
		Nodo<T> inicio = getFirst();
		// Crear una nueva Lista Enlazada
		ListaEnlazada<T> copia = new ListaEnlazada<T>();
		while(inicio != null) {
			copia.insertLast(inicio.getData());
			inicio = inicio.getNext();
		}
		return copia;
	}
	
	// Metodo para ver si una lista está incluida en otra
	// OJO: La Lista que llama al metodo es la mas grande
	public boolean incluye(ListaEnlazada<T> otraLista) {
		// Variable de apoyo para el retorno del metodo
		boolean retornar = false;
		// Rescatar el Nodo inicial de la Lista pequenia
		Nodo<T> inicioP = otraLista.getFirst();
		// Hacer una copia de Lista grande
		ListaEnlazada<T> copia = copiar(this);
		// Iterar mientras la Lista pequenia tenga Nodos
		while(inicioP != null) {
			// Buscar si inicioP esta dentro de la Lista grande
			T buscar = search(inicioP.getData());
			// Si inicioP se encuentra en la Lista grande
			if(buscar != null) {
				System.out.println("El elemento " + inicioP.getData() 
					+ ", esta incluido");
				copia.remove(inicioP.getData());
				retornar = true;
			} else {
				System.out.println("El elemento " + inicioP.getData() 
				+ ", no esta incluido");
				retornar = false;
				break;
			}
			inicioP = inicioP.getNext();
		}
		return retornar;
	}
	
}
