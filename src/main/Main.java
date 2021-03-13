package main;

public class Main {

	public static void main(String[] args) {
	    try {
            Stack st = new Stack(2);  
            
            st.push(1); // Adiciona 1
            
            System.out.println(st.isEmpty()); // false
            System.out.println(st.pop()); // 1
            System.out.println(st.isEmpty()); // true
            
            st.push(1); // Adiciona 1
            st.push(2); // Adiciona 2
            
            System.out.println(st.getTop()); // 2
            
            st.push(3); // Erro, sem espaço
            
	    } catch(Exception e) {
            System.err.println(e);
	    }

	}

}
