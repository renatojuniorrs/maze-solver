package main;

public class Stack<Type> {
	private Object elements[];
	private int top;
    
	/*
	 * Default Class Constructor
	 **/
	public Stack() {
		int size = 10;
		elements = new Object[size];
		top = -1;
	}

	/*
	 * Class Constructor with size
	 **/
	public Stack(int size) throws Exception {
		if (size <= 0)
			throw new IllegalArgumentException("Constructor size must be greater than 0");

		elements = new Object[size];
		top = -1;
	}

	/*
	 * Method that pushes a value to the element
	 **/
	public void push(Type value) {
		if ((top + 1) >= elements.length)
			autoSize(2); // Increases the element size to double
		top++;
		elements[top] = value;
	}

	/*
	 * Method that removes the last value from element
	 **/
	public Type pop() throws Exception {
		if (isEmpty())
			throw new IllegalStateException("There isn't elements to pop");

		Object value = elements[top];
		top--; // Element continua na pilha, mas o topo é alterado e ele se torna inacessivel.
				// Isso é um problema?
		return (Type) value;
	}

	/*
	 * Method that checks if it is empty
	 **/
	public boolean isEmpty() {
		return top == -1;
	}

	/*
	 * Method that gets top's element
	 **/
	public Type getTop() throws Exception {
		if (isEmpty())
			throw new IllegalStateException("There isn't elements to get");
		return (Type) elements[top];
	}

	public Type getTop(int value) throws Exception {
		if (isEmpty())
			throw new IllegalStateException("There isn't elements to get");
		if(value>top)
			throw new IllegalStateException("Ilegal value");
		
		return (Type) elements[value];
	}

	/*
	 * Method that resizes the Stack
	 **/

	public void autoSize(float factor) {
		Object[] newElement = new Object[Math.round(elements.length * factor)];

		for (int i = 0; i <= this.top; i++)
			newElement[i] = elements[i];

		elements = newElement;
	}
	
	public int getTopIndex() {
		return top;
	}
}