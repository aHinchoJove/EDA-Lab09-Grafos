
public class TestGrafo {
	
	public static void main(String[] args) {
		
		// Lista grande
		ListaEnlazada<Integer> grande = new ListaEnlazada<Integer>();
		grande.insertLast(4);
		grande.insertLast(7);
		grande.insertLast(1);
		grande.insertLast(2);
		ListaEnlazada<Integer> pequena = new ListaEnlazada<Integer>();
		pequena.insertLast(1);
		pequena.insertLast(2);
		pequena.insertLast(2);
		
		System.out.println("Comparacion : " + grande.incluye(pequena) + "\n");
		
		System.out.println("Lista Grande:\n" + grande);
		System.out.println("Lista Grande:\n" + pequena);
		
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
		otroGrafo.insertarArista("Callao", "Moquegua", 7);
		otroGrafo.insertarArista("Cusco", "Lima", 6);
		otroGrafo.insertarArista("Piura", "Tarapoto", 3);
		
		// Imprimiendo el contenido del otroGrafo
		System.out.println("Otro Grafo de ciudades:\n");
		System.out.println(otroGrafo);
		
	}
	
}
