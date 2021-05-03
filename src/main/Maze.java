package main;

public class Maze {
	public String[][] mazeMap;

/**
 * Methods that defines the number of lines and columns in the maze, 
 * and which can be returned in an invalid or no existent maze.
 * 
 * @param  numberLines		Sets the number of lines in the maze
 * @param  numberColumns	Sets the number of colunms in the maze
 * @param  lines			Defines the lines of the maze that should be = 0 and ++
 * @return					void
 */
		
	public Maze(Stack<String> File) throws Exception {
		int numberLines; 
		int numberColumns;
		try {
			numberLines = Integer.parseInt(File.getTop(0));
			numberColumns = File.getTop().length()+1;
		}
		catch(Exception error){ 
			throw new IllegalArgumentException("Invalid Maze");
		}
		
		if (numberLines <= 0) 
			throw new IllegalArgumentException("Invalid Maze");
	
		mazeMap = new String[numberLines+1][numberColumns+1];
		Boolean hasEntry = false;
		Boolean hasExit = false;
		
		int lines = 0;
		lines++;
		while(lines <= numberLines) {
			String line = File.getTop(lines);
			String[] lineC = line.split("");
			
			if(line.indexOf("E") >= 0)
				hasEntry = true;
			if(line.indexOf("S") >= 0)
				hasExit = true;
				
			mazeMap[(lines-1)] = lineC;
			lines++;
		}
		
		if(!hasEntry)
			throw new IllegalArgumentException("Maze has no Entry");
		if(!hasExit)
			throw new IllegalArgumentException("Maze has no Exit");
		/*
		for(int intLine = 0; intLine < mazeMap.length-1; intLine++) {
			for(int intColumn = 0; intColumn < mazeMap[intLine].length; intColumn++) {
				System.out.print(mazeMap[intLine][intColumn]);
			}
			System.out.print("\n");
		}
		*/
		
	}
	
	public String[][] getMazeMap(){
		return this.mazeMap;
	}
	
/**
 * Methods that define Bob's walk and return through the maze, 
 * until he finds the exit leaving a trail: '*' where to go. 
 * 
 * @param  footPrint		Prints the coordinates in the maze.
 * @param  x				Defines what the maze lines will look like
 * @param  y				Defines what the maze colunms will look like
 * @param  eraseFootPrint	Erase the traces: '*' left by bob.	
 * @return 					void
 */
	
	public void footPrint(Coordinates coordinate) {
		int x = coordinate.getX();
		int y = coordinate.getY();
		String tile = this.mazeMap[x][y];
		
		if(x < 0 || y < 0 || x > this.mazeMap.length-1 || y > this.mazeMap[x].length-1)
			throw new IllegalArgumentException("You are a not a fish to swim outside the land!");
		
		if(tile.equals("#")) {
			throw new IllegalArgumentException("You can not jump walls!");
		}
		
		this.mazeMap[x][y] = "*";
	}
	
	public void eraseFootPrint(Coordinates coordinate) {
		int x = coordinate.getX();
		int y = coordinate.getY();
		String tile = this.mazeMap[x][y];
		
		if(x < 0 || y < 0 || x > this.mazeMap.length-1 || y > this.mazeMap[x].length-1)
			throw new IllegalArgumentException("You are a not a fish to swim outside the land! ("+x+","+y+")");
		
		if(!tile.equals("*"))
			throw new IllegalArgumentException("You can't cheat an honest code ("+x+","+y+")");
		
		
		this.mazeMap[x][y] = " ";
	}
}