
// Representacion de un Grafo mediante una Lista de Adyacencia

public class Grafo<T> {
	
	// Atributos de la clase Grafo
	
	protected ListaEnlazada<Vertice<T>> listaVertices;
	
	// Constructor de la clase Grafo
	
	public Grafo() {
		setVertices();
	}
	
	// Setters y getters de la clase Grafo
	
	public ListaEnlazada<Vertice<T>> getVertices() {
		return this.listaVertices;
	}
	
	public void setVertices() {
		this.listaVertices = new ListaEnlazada<Vertice<T>>();
	}
	
	// Metodos de la clase Grafo
	
	
	
	// Metodo para insertar Vertices en el Grafo
	public void insertarVertice(T data) {
		Vertice<T> nuevo = new Vertice<T>(data);
		if(getVertices().search(nuevo) != null) {
			System.out.println("El Vertice ya existe ...");
			return;
		} else {
			getVertices().insert(nuevo);
		}
	}
	
	// Metodo para insertar Aristas en el Grafo
	public void insertarArista(T origen, T destino) {
		insertarArista(origen, destino, -1);
	}
	
	// Metodo auxiliar para insertar Aristas en el Grafo
	public void insertarArista(T origen, T destino, int peso) {
		
		// Buscar si existen los Vertices que se quieren unir
		Vertice<T> refOrigen = getVertices().search(new Vertice<T>(origen));
		Vertice<T> refDestino = getVertices().search(new Vertice<T>(destino));
		
		// En caso de no existir alguno de los dos Vertices mandar un mensaje
		if(refOrigen == null || refDestino == null) {
			System.out.println("El Vertice de origen y/o destino no existen ...");
			return;
		}
		
		// Buscar si existe una Arista ya registrada entre los dos Vertices
		if(refOrigen.getLista().search(new Arista<T>(refDestino)) != null) {
			System.out.println("Ya existe una Arista entre los Vertices ...");
			return;
		}
		
		// En otro caso, valido, insertar la Arista entre los Vertices
		refOrigen.getLista().insert(new Arista<T>(refDestino));
		refDestino.getLista().insert(new Arista<T>(refOrigen));
		
	}
	
	// Metodo toString que devuelve el contenido del Grafo
	@Override
	public String toString() {
		return "Contenido del Grafo:\n" + getVertices();
	}
	
}
