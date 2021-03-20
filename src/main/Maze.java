package main;

public class Maze {
	public String[][] mazeMap;
	
	
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
		
		int lines = numberLines;
		
		while(lines > 0) {
			String line = File.getTop(lines);
			String[] lineC = line.split("");
			
			if(line.indexOf("E") >= 0)
				hasEntry = true;
			if(line.indexOf("S") >= 0)
				hasExit = true;
			
			System.out.println(line);
			mazeMap[(lines)] = lineC;
			lines--;
		}
		
		if(lines != 0)
			throw new IllegalArgumentException("Invalid Maze");
		if(!hasEntry)
			throw new IllegalArgumentException("Maze has no Entry");
		if(!hasExit)
			throw new IllegalArgumentException("Maze has no Exit");
		System.out.println(mazeMap[0][1]);
	}
}