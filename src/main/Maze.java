package main;

public class Maze {
	public String[][] mazeMap;
	
	
	public Maze(Stack<String> File) throws Exception {
		//Verification about lines
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
			
		//Progessive method
		public Stack stackAdjacent = new Stack();
		
		if(mazeMap != "#") 
		stackAdjacent = new String[numberLines][numberColumns];
			
		}
		
		if(!hasEntry)
			throw new IllegalArgumentException("Maze has no Entry");
		if(!hasExit)
			throw new IllegalArgumentException("Maze has no Exit");
	} 
}