package main;

public class Maze {
	public String[][] mazeMap;
	
	
	public Maze(Stack<String> File) throws Exception {
		mazeMap = new String[Integer.parseInt(File.getTop(0))][File.getTop().length()+1];
		Boolean hasEntry = false;
		Boolean hasExit = false;
		int lines = 0;

		while(File.getTopIndex() != 0) {
			String line = File.pop();
			String[] lineC = line.split("");
			
			if(line.indexOf("E") >= 0)
				hasEntry = true;
			if(line.indexOf("S") >= 0)
				hasExit = true;
			
			mazeMap[lines] = lineC;
			lines++;
		}
		
		if(lines != Integer.parseInt(File.getTop()))
			throw new IllegalArgumentException("Invalid Maze");
		if(!hasEntry)
			throw new IllegalArgumentException("Maze has no Entry");
		if(!hasExit)
			throw new IllegalArgumentException("Maze has no Exit");
	}
}