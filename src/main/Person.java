package main;

public class Person {
	private Maze maze;
	private Coordinates coordinate;
	private Stack<Coordinates> adjacent;
	private Stack<Stack<Coordinates>> chance;
	private Stack<Coordinates> mentalMap;
	private boolean winner = false;
	
	public Person(Maze maze) throws Exception {
		this.maze = maze;
		this.chance = new  Stack<Stack<Coordinates>>(3);
		this.mentalMap = new Stack<Coordinates>(3);
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
	}
	
	public Boolean think() throws Exception {
		this.adjacent = new Stack<Coordinates>(3);
		
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
			
			if(!this.adjacent.isEmpty()) {
				keepForward();
			}else {
				goBack();
			}
			
			return true;
		}
	}
	
	private void keepForward() throws Exception {
		trackInMap();
		walk(this.adjacent.getTop());
		this.mentalMap.push(adjacent.pop());
		this.chance.push(adjacent);
		
	}
	
	private void goBack() throws Exception {
		this.mentalMap.pop();
		while(!this.chance.isEmpty()) {
			this.adjacent = this.chance.pop();
			if(this.adjacent.isEmpty()) {
				walk(this.mentalMap.pop());
				eraseMap();
			}else {
				walk(this.mentalMap.pop());
				eraseMap();
				keepForward();
				break;
			}
		}
	}
	
	private void eraseMap() {
		this.maze.eraseFootPrint(this.coordinate);
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
