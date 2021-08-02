
public class Arista<T> {
	
	// Atributos de la clase Arista
	
	protected Vertice<T> destino;
	protected int peso;
	protected int label; // 0 => Sin explorar, 1 => Descubierta, 2 => Back
	
	// Constructores de la clase Arista
	
	public Arista(Vertice<T> destino) {
		this(destino, -1);
	}
	
	public Arista(Vertice<T> destino, int peso) {
		setDestino(destino);
		setPeso(peso);
	}
	
	// Setters y getters
	
	public Vertice<T> getDestino() {
		return this.destino;
	}
	
	public void setDestino(Vertice<T> destino) {
		this.destino = destino;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getLabel() {
		return this.label;
	}
	
	public void setLabel(int label) {
		this.label = label;
	}
	
	// Metodos de la clase Arista
	
	public boolean equals(Object obj) {
		if(obj instanceof Arista<?>) {
			Arista<T> arista = (Arista<T>) obj;
			return getDestino().equals(arista.getDestino());
		}
		return false;
	}
	
	//Metodo toString, devuelve el contenido de la Arista
	@Override
	public String toString() {
		if(getPeso() > -1) {
			return getDestino() + " (" + getPeso() + "), ";
		} else {
			return getDestino().getData() + ", ";
		}
	}
	
}
