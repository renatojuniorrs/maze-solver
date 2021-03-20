package main;

public class Main {

	public static void main(String[] args) {
		try {
			File source = new File("C:\\Users\\194480\\git\\maze-solver\\File\\FileExample.txt");
			Maze createdMaze = new Maze(source.getFileContent());
		
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}