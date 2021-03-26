package main;

public class Main {

	public static void main(String[] args) {
		Boolean bobThought = null;
		try {
			File source = new File("C:\\Users\\RGrupos\\Desktop\\PUC\\ProjetoIntegrado\\maze-solver\\File\\FileExample.txt");
			Maze maze = new Maze(source.getFileContent());
			Person Bob = new Person(maze);
			
			while(!Bob.isTheWinner()) {
				bobThought = Bob.think();
				System.out.println("-------------------------------------------------------------------");
				Bob.writeSolution();
			}
			System.out.println("Bingo! Bob is the winner!!!!!!");
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}