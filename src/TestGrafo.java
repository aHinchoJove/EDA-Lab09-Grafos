
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
		grafo.insertarArista("Lima", "Arequipa");
		grafo.insertarArista("Cusco", "Arequipa");
		grafo.insertarArista("Piura", "Lima");
		grafo.insertarArista("Cusco", "Lima");
		grafo.insertarArista("Piura", "Tarapoto");
		
		// Imprimiendo el contenido del Grafo
		System.out.println("Grafo de ciudades:\n");
		System.out.println(grafo);
		
		// Probando el recorrido DFS
		System.out.println("Probando el recorrido DFS para Cusco");
		grafo.DFS("Cusco");
		
	}
	
}
