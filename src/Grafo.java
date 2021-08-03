
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
			getVertices().insertLast(nuevo);
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
		refOrigen.getLista().insertLast(new Arista<T>(refDestino));
		refDestino.getLista().insertLast(new Arista<T>(refOrigen));
		
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
			Nodo<Arista<T>> auxA = aux.getData().getLista().getFirst();
			for( ; auxA != null; auxA = auxA.getNext()) {
				auxA.getData().setLabel(0);
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
		System.out.println(auxiliar.getData() + ", ");
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
	
	// Metodo para el recorrido BFS
	
	public void BFS(T data) {
		Vertice<T> nuevo = new Vertice<T>(data);
		Vertice<T> auxiliar = getVertices().search(nuevo);
		// Verificar que el Vertice existe dentro del Grafo
		if(auxiliar == null) {
			System.out.println("El Vertice no existe ...");
			return;
		}
		// En caso existe el Vertice, inicializar las etiquetas
		inicializarLabel();
		BFSApoyo(auxiliar);
	}
	
	// Metodo de apoyo para el recorrido BFS
	
	private void BFSApoyo(Vertice<T> auxiliar) {
		// Creando una nueva Lista de Listas de Vertices
		ListaEnlazada<ListaEnlazada<Vertice<T>>> lista =
			new ListaEnlazada<ListaEnlazada<Vertice<T>>>();
		// Insertar el Vertice auxiliar al final
		ListaEnlazada<Vertice<T>> insertar = new ListaEnlazada<Vertice<T>>();
		insertar.insertLast(auxiliar);
		lista.insertLast(insertar);
		// Marcar como ya visitado
		auxiliar.setLabel(1);
		// Recorrer la Lista de Lista de Vertices
		Nodo<ListaEnlazada<Vertice<T>>> auxL = lista.getFirst();
		// Recorrer la primera lista de la Lista de Listas de Vertices
		while(auxL != null) {
			Nodo<Vertice<T>> auxV = auxL.getData().getFirst();
			ListaEnlazada<Vertice<T>> listaAux = new ListaEnlazada<Vertice<T>>();
			// Recorrer la Lista de Vertices
			while(auxV != null) {
				Nodo<Arista<T>> auxA = auxV.getData().getLista().getFirst();
				System.out.println(auxV.getData().getData() + ", ");
				// Recorrer la Lista de Aristas
				while(auxA != null) {
					// Verificar la Arista que aun no ha sido visitada
					if(auxA.getData().getLabel() == 0) {
						// Rescatar su opuesto o destino
						Vertice<T> opuesto = auxA.getData().getDestino();
						// Verificar que el Vertice no se ha visitado
						if(opuesto.getLabel() == 0) {
							// Cambiar el valor del Vertice como visitado
							opuesto.setLabel(1);
							// Cambiar el valor de la Arista como visitada
							auxA.getData().setLabel(1);
							// Insertar el Vertice opuesto en la listaAux
							listaAux.insertLast(opuesto);
						} else {
							// Si ya se ha visitado, establecerlo como Back / Cross
							auxA.getData().setLabel(2);
						}
					}
					auxA = auxA.getNext();
				}
				auxV = auxV.getNext();
			}
			// Asi mismo verificar si la listaAux es diferente de nulo
			if(listaAux.getFirst() != null) {
				// Si es diferente de nulo agregar otra en auxL
				auxL.setNext(new Nodo<ListaEnlazada<Vertice<T>>>(listaAux));
				// No olvidar avanzar para poder romper los ciclos
				auxL = auxL.getNext();
			} else {
				// Si es igual a nulo entonces no se agrego nada
				// Solo debemos avanzar en la Lista de Listas de Vertices
				auxL = auxL.getNext();
			}
		}
	}
	
}
