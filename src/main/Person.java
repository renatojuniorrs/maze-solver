package main;

public class Person {
	private Maze maze;
	private Coordinates coordinate;
	private Stack<Coordinates> adjacent;
	private boolean winner = false;
	
	public Person(Maze maze) throws Exception {
		this.maze = maze;
		String[][] mazeMap = maze.getMazeMap();
		
		// He tries to find `E`, to know where he is
		boolean foundEntry = false;
		outerloop: // Sair do loop inteiro
		for(int intLine = 0; intLine < mazeMap.length-1; intLine++) {
			for(int intColumn = 0; intColumn < mazeMap[intLine].length; intColumn++) {
				if(mazeMap[intLine][intColumn].equals("E")) {
					this.coordinate = new Coordinates(intLine, intColumn);
					foundEntry = true;
					break outerloop;
				}
			}
		}
		
		if(!foundEntry)
			throw new IllegalArgumentException("Sorry, I could'nt find the entry");
		
		this.adjacent = new Stack<Coordinates>(3);
	}
	
	public Boolean think() throws Exception {
		if(this.winner) {
			throw new IllegalArgumentException("I already found the exit, I won!");
		}
		else if(getStepAt().equals("S")) {
			winner = true;
			trackInMap();
			return false;
		}else {
			int[] me = this.coordinate.getCoordinate();
			look(Positions.TOP);
			look(Positions.BOTTOM);
			look(Positions.LEFT);
			look(Positions.RIGHT);
			
			trackInMap();
			walk(adjacent.pop());	
			return true;
		}
	}
	
	private void trackInMap() {
		this.maze.footPrint(this.coordinate);
	}
	
	private void look(Positions lookingAt) {
		int x = this.coordinate.getX();
		int y = this.coordinate.getY();
		String tile = null;
		
		if(lookingAt == Positions.TOP) {
			if(x == 0)
				return;
			x--;
			tile =  maze.getMazeMap()[x][y];
		}
		else if(lookingAt == Positions.BOTTOM) {
			if(x == maze.getMazeMap().length-1)
				return;
			x++;
			tile =  maze.getMazeMap()[x][y];
		}
		else if(lookingAt == Positions.LEFT) {
			if(y == 0)
				return;
			y--;
			tile =  maze.getMazeMap()[x][y];
		}
		else if(lookingAt == Positions.RIGHT) {
			if(y == maze.getMazeMap()[x].length-1)
				return;
			y++;
			tile =  maze.getMazeMap()[x][y];
		}
		
		// Only adds if he sees a way
		if((tile.equals("S") || tile.equals(" ")) && tile != null) {
			Coordinates coordinateToAdd = new Coordinates(x, y);
			
			this.adjacent.push(coordinateToAdd);
		}
		
		return;
	}
	
	public void walk(Coordinates coordinate) {
		this.coordinate = coordinate;
	}
	
	public String getStepAt() {
		return maze.getMazeMap()[this.coordinate.getX()][this.coordinate.getY()];
	}
	
	public boolean isTheWinner() {
		return this.winner;
	}
	
	public void writeSolution() {
		this.maze = maze;
		String[][] mazeMap = maze.getMazeMap();
		
		// He tries to find `E`, to know where he is
		boolean foundEntry = false;
		outerloop: // Sair do loop inteiro
		for(int intLine = 0; intLine < mazeMap.length-1; intLine++) {
			for(int intColumn = 0; intColumn < mazeMap[intLine].length; intColumn++) {
				System.out.print(mazeMap[intLine][intColumn]);
			}
			System.out.print("\n");
		}
	}
	
}
