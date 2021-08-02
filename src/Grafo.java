
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
	
	// Metodo de apoyo para inicializar las etiquetas
	
	private void inicializarLabel() {
		Nodo<Vertice<T>> aux = getVertices().getFirst();
		for( ; aux != null; aux = aux.getNext()) {
			aux.getData().setLabel(0);
			Nodo<Arista<T>> auxVer = aux.getData().getLista().getFirst();
			for( ; auxVer != null; auxVer = auxVer.getNext()) {
				aux.getData().setLabel(0);
			}
		}
	}
	
	// Metodo para el recorrido DFS
	
	public void DFS(T data) {
		Vertice<T> nuevo = new Vertice<T>(data);
		Vertice<T> auxiliar = getVertices().search(nuevo);
		// Verificar que el Vertice existe dentro del Grafo
		if(auxiliar == null) {
			System.out.println("El Vertice no existe ...");
			return;
		}
		// En caso existe el Vertice, inicializar las etiquetas
		inicializarLabel();
		DFSApoyo(auxiliar);
	}
	
	// Metodo de apoyo para el recorrido DFS
	
	private void DFSApoyo(Vertice<T> auxiliar) {
		// Marcarlo como ya visitado
		auxiliar.setLabel(1);
		// Mostrarlo por consola
		System.out.println(auxiliar + ", ");
		// Recorrer la lista de Aristas del Vertice
		Nodo<Arista<T>> auxA = auxiliar.getLista().getFirst();
		for( ; auxA != null; auxA = auxA.getNext()) {
			// Evaluar la etiqueta
			if(auxA.getData().getLabel() == 0) {
				Vertice<T> opuesto = auxA.getData().getDestino();
				// Verificar la etiqueta del vecino
				if(opuesto.getLabel() == 0) {
					// Cambiar la etiqueta a Descubierto
					auxA.getData().setLabel(1);
					// Llamar al metodo recursivamente con el opuesto
					DFSApoyo(opuesto);
				} else {
					// Si no es verdad la etiquera sera Back
					auxA.getData().setLabel(2);
				}
			}
		}
	}
	
}
