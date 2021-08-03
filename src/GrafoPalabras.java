
public class GrafoPalabras {
	
	public static void main(String[] args) {
		
		// Creando el Grafo de Palabras - Ejercicio4
		System.out.println("Creando el Grafo 'palabras'\n");
		Grafo<String> palabras = new Grafo<String>();
		
		System.out.println("Agregando los Vertices y Aristas\n");
		
		// Agregando los Vertices
		palabras.insertarVertice("words");
		palabras.insertarVertice("cords");
		palabras.insertarVertice("corps");
		palabras.insertarVertice("coops");
		palabras.insertarVertice("crops");
		palabras.insertarVertice("drops");
		palabras.insertarVertice("drips");
		palabras.insertarVertice("grips");
		palabras.insertarVertice("gripe");
		palabras.insertarVertice("grape");
		palabras.insertarVertice("graph");
		
		// Agregando las Aristas
		palabras.insertarArista("words", "cords");
		palabras.insertarArista("cords", "corps");
		palabras.insertarArista("corps", "coops");
		palabras.insertarArista("coops", "crops");
		palabras.insertarArista("crops", "drops");
		palabras.insertarArista("drops", "drips");
		palabras.insertarArista("drips", "grips");
		palabras.insertarArista("grips", "gripe");
		palabras.insertarArista("gripe", "grape");
		palabras.insertarArista("grape", "graph");
		
		// Lista de Adyacencia para el Grafo 'palabras'
		System.out.println("Lista de Adyacencia:\n");
		System.out.println(palabras);
		
	}
	
}
