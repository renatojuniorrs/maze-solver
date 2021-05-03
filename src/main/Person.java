package main;

/**
 * Class that declares the maze, the coordinates of the pile that the person 
 * will go through and verifies that he is not a Champion.
 * In this class we find the progressive and regressive methods,
 * finding the 'E' to see where it is and looking for the 'S' to find the exit from the maze.
 * In addition to defining the positions Bob travels through. 
 * Write and erase the "tracks" left by Bob.
 */

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
		
/**
 * 
 * @param intLine		Sets the size of the lines of the maze to locate.
 * @param intColumn 	Sets the size of the columns of the maze to locate.
 * @return				void
 */
		
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
/**
 * @return false  It returns false if it does not find the exit to be champion.
 */
		else if(getStepAt().equals("S")) {
			winner = true;
			trackInMap();
			return false;
			
/**
 * @param  me		Declares the positions that bob must walk in the maze.
 * @return true  	It returns true if the adjacent side is empty.
 */
			
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
	
/**
 * Here we have the progressive method
 * 
 * @param  keepForward	Set Bob's floor through the maze until he finds the exit.
 */	

	private void keepForward() throws Exception {
		trackInMap();
		walk(this.adjacent.getTop());
		this.mentalMap.push(adjacent.pop());
		this.chance.push(adjacent);
		
	}
	
/**
 * Here we have the regressive method
 * 
 * @param  goBack	Sets Bob's return inside the maze until he finds the exit.
 */	
	
	private void goBack() throws Exception {
		this.mentalMap.pop();
		while(!this.chance.isEmpty()) {
			this.adjacent = this.chance.pop();
			if(this.adjacent.isEmpty()) {
				Coordinates mMap = this.mentalMap.pop();
				walk(mMap);
				eraseMap();
			}else {
				Coordinates mMap = this.mentalMap.pop();
				walk(mMap);
				this.mentalMap.push(mMap);
				
				eraseMap();
				keepForward();
				break;
			}
		}
	}
	
/**
 * Here we have the method that erases the "tracks" left by bob while he walks.
 * Staying just the right way to get to the exit.
 * 
 * @param  eraseMap	 Erase the "tracks" left by Bob.
 */	
	
	private void eraseMap() {
		this.maze.eraseFootPrint(this.coordinate);
	}
	
/**
 * @param  trackInMap	 Leave only the trail that meets the exit of the maze.
 */	
	
	private void trackInMap() {
		this.maze.footPrint(this.coordinate);
	}
	
/**
 * @param  look		Check the positions that Bob can walk and add him only if he is on his way to 'S'.
 * @param  x		Defines what the maze lines will look like, from the positions that bob has to walk.
 * @param  y		Defines what the maze colunms will look like, from the positions that bob has to walk.
 * @return 		  	void
 */
	
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
	
/**
 * @param  	walk			Sets the coordinates for Bob to walk on the maze.
 * @param   writeSolution	Write the solution to the maze, defining the entire path taken by Bob. 	
 */
	
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
		
/**
 * Method that tries to find `E`, to know where he is and exits infinite looping.
 * 
 * @param intLine		Sets the size of the lines of the maze to locate.
 * @param intColumn 	Sets the size of the columns of the maze to locate.
 * @return				void
 */
	
		boolean foundEntry = false;
		outerloop: // Sair do loop inteiro
		for(int intLine = 0; intLine < mazeMap.length-1; intLine++) {
			for(int intColumn = 0; intColumn < mazeMap[intLine].length; intColumn++) {
				System.out.print(mazeMap[intLine][intColumn]);
			}
			System.out.print("\n");
		}
	}
	
/**
 * @return	this.coordinate		Returns the coordinates of the maze.
 */
	
	public Coordinates getCoordinates() {
		return this.coordinate;
	}
	
}
