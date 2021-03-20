package main;

public class Main {

	public static void main(String[] args) {
		try {
			File source = new File("C:\\Users\\RGrupos\\Desktop\\PUC\\ProjetoIntegrado\\maze-solver\\File\\FileExample.txt");
			Maze createdMaze = new Maze(source.getFileContent());
		
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}