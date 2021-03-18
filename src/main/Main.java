package main;

public class Main {

	public static void main(String[] args) {
		try {
			File source = new File("C:\\Users\\Usuario\\git\\maze-solver\\File\\FileExample.txt");
		 //File copy = source.Clone(); 
		//Maze createdMaze = new Maze(source.getFileContent());
		 Stack<String> file = source.getFileContent();
		 while(file.isEmpty() != true)
		 {
			 System.out.println(file.pop());
		 }
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}