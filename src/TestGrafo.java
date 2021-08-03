
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
		
	}
	
}
