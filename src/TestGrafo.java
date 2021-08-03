
public class TestGrafo {
	
	public static void main(String[] args) {
		
		// Creando un objeto de tipo Grafo
		Grafo<String> grafo = new Grafo<String>();
		
		// Insertando algunos Vertices
		grafo.insertarVertice("Lima");
		grafo.insertarVertice("Arequipa");
		grafo.insertarVertice("Cusco");
		grafo.insertarVertice("Piura");
		grafo.insertarVertice("Tarapoto");
		
		// Insertando algunas Aristas
		grafo.insertarArista("Lima", "Arequipa", 8);
		grafo.insertarArista("Cusco", "Arequipa", 4);
		grafo.insertarArista("Piura", "Lima", 5);
		grafo.insertarArista("Cusco", "Lima", 6);
		grafo.insertarArista("Piura", "Tarapoto", 3);
		
		// Imprimiendo el contenido del Grafo
		System.out.println("Grafo de ciudades:\n");
		System.out.println(grafo);
		
		// Probando el recorrido DFS
		System.out.println("Probando el recorrido DFS para Cusco");
		grafo.DFS("Cusco");
		
		System.out.println();
		
		// Probando el recorrido BFS
		System.out.println("Probando el recorrido BFS para Arequipa");
		grafo.BFS("Arequipa");
		
		// Creando otro objeto de tipo Grafo para poder ver si este
		// incluye al creado por primera vez objeto 'grafo'
		
		Grafo<String> otroGrafo = new Grafo<String>();
		
		// Insertando algunos Vertices
		otroGrafo.insertarVertice("Lima");
		otroGrafo.insertarVertice("Arequipa");
		otroGrafo.insertarVertice("Cusco");
		otroGrafo.insertarVertice("Piura");
		otroGrafo.insertarVertice("Tarapoto");
		otroGrafo.insertarVertice("Moquegua");
		otroGrafo.insertarVertice("Callao");
		
		// Insertando algunas Aristas
		otroGrafo.insertarArista("Lima", "Arequipa", 8);
		otroGrafo.insertarArista("Moquegua", "Callao", 10);
		otroGrafo.insertarArista("Cusco", "Arequipa", 4);
		otroGrafo.insertarArista("Piura", "Lima", 5);
		otroGrafo.insertarArista("Lima", "Callao", 5);
		otroGrafo.insertarArista("Cusco", "Lima", 6);
		otroGrafo.insertarArista("Piura", "Tarapoto", 3);
		
		// Imprimiendo el contenido del 'otroGrafo'
		System.out.println("Otro Grafo de ciudades:\n");
		System.out.println(otroGrafo);
		
		// Probando el metodo 'incluye' de la clase Grafo
		// En este caso 'grafo' esta incluido en 'otroGrafo'
		System.out.println("Compararando 'otroGrafo' con 'grafo'\n");
		System.out.println("El Grafo 'otroGrafo' incluye a 'grafo'? : "
				+ otroGrafo.incluye(grafo));
		
		// Creando otro objeto de tipo Grafo
		
		Grafo<String> otroGrafo2 = new Grafo<String>();
		
		// Insertando algunos Vertices
		otroGrafo2.insertarVertice("Lima");
		otroGrafo2.insertarVertice("Arequipa");
		otroGrafo2.insertarVertice("Cusco");
		otroGrafo2.insertarVertice("Piura");
		otroGrafo2.insertarVertice("Tarapoto");
		otroGrafo2.insertarVertice("Moquegua");
		otroGrafo2.insertarVertice("Callao");
		
		// Insertando algunas Aristas
		otroGrafo2.insertarArista("Lima", "Arequipa", 8);
		otroGrafo2.insertarArista("Moquegua", "Callao", 10);
		otroGrafo2.insertarArista("Cusco", "Arequipa", 4);
		otroGrafo2.insertarArista("Lima", "Callao", 5);
		otroGrafo2.insertarArista("Cusco", "Lima", 6);
		otroGrafo2.insertarArista("Piura", "Tarapoto", 3);
		
		// Imprimiendo el contenido del 'otroGrafo2'
		System.out.println("\n'Otro Grafo 2' de ciudades:\n");
		System.out.println(otroGrafo2);
		
		// Probando el metodo 'incluye' de la clase Grafo
		// En este caso 'grafo' NO esta incluido en 'otroGrafo'
		// YA QUE FALTA LA ARISTA LIMA - PIURA QUE EXISTE EN 'GRAFO'
		System.out.println("Compararando 'otroGrafo2' con 'grafo'\n");
		System.out.println("El Grafo 'otroGrafo2' incluye a 'grafo'? : "
				+ otroGrafo2.incluye(grafo));		
	}
	
}
