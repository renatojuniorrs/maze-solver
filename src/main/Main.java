package main;

public class Main {

  /**
  * Class that declares everything that will be used in the program (File, Labyrinth and Person), in addition to printing the message '----' 
  * (Meaning Bob didn't make it to the end of the maze) and the one Bob declared champion.
  * 
  * @param String[] args       	String array that declares the variables that will be used in the program.
  * @return                     void
  */
	
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
