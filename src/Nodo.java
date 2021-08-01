
public class Nodo<T> {
	
	// Atributos de la clase Nodo
	
	protected T data;
	protected Nodo<T> next;
	
	// Constructores de la clase Nodo
	
	public Nodo(T data) {
		this(data, null);
	}
	
	public Nodo(T data, Nodo<T> next) {
		setData(data);
		setNext(next);
	}
	
	// Metodos setters y getters de la clase Nodo
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Nodo<T> getNext() {
		return this.next;
	}
	
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
	
}
