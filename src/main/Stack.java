package main;

/**
 * Class that stores any type of stack due to the Stack <Type> method;
 * It also defines a standard constructor for a stack of any size and with the top always being -1;
 * The stack must be greater than zero, with the push (Add an item from the stack), pop (remove an item from the stack) methods 
 * and top (Returns the top of the stack), checks if the stack is empty and finally resizes the stack causing 
 * it increases in size according to the user's need.
 *
 * @param   top				 Declares a private variable of the entire type that should always be the top;
 * @param   size			 Demonstrates stack size;
 * @param	value			 Demonstrates the values that are on the stack;
 * @param	factor			 Demonstrates the maximum value to be allocated in the stack;
 * @param	getTopIndex		 Read the top of the stack and return to the index;
 * @return  value 			 Returns the values that are on the stack;
 * @return  top == -1        Returns whether the stack is empty or not, after checking if the top is -1;
 * @return  elements[top]	 Returns the element at the top of the stack;
 * @return  elements[value]	 Returns the elements at the values of the stack;
 * @return  top				 Returns the top of the stack after it has been resized;
 */

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