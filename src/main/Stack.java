package main;

public class Stack {
    private int elements[];
    private int top;
    
    
    /*
    * Class Constructor
    **/
    public Stack(int size) {
        if(size <=0)
            throw new IllegalArgumentException("Constructor size must be greater than 0");
        
        elements = new int[size];
        top = -1;
    }
    
    /*
    * Method that pushes a value to the element
    **/
    public void push(int value){
        if((top+1) >= elements.length)
            throw new ArrayIndexOutOfBoundsException("You don't have enough size to push");
        top++;
        elements[top] = value;
    }
    
    /*
    * Method that removes the last value from element
    **/
    public int pop() throws Exception{
        if(isEmpty())
            throw new IllegalStateException("There isn't elements to pop");
            
        int value = elements[top];
        top--; // Element continua na pilha, mas o topo é alterado e ele se torna inacessivel. Isso é um problema?
        return value;
    }
    
    /*
    * Method that checks if it is empty
    **/
    public boolean isEmpty(){
        return top == -1;
    }
    
    /*
    * Method that gets top's element
    **/
    public int getTop() throws Exception{
        if(isEmpty())
            throw new IllegalStateException("There isn't elements to get");
        return elements[top];
    }
}
