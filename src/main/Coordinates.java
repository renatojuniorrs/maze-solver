package main;

 /**
  * Class that shows the coordinates to be traversed in the maze
  * 
  * @param coordinate       	Integer coordinate that will be transformed into 2 x- and y-coordinates
  * @param getCoordinate    	Get the coordinates to be traversed
  * @param getX             	Obtains the X coordinates traveled
  * @param getY             	Obtains the Y coordinates traveled
  * @param updateCoordinates    Change the path that was taken in the maze
  * @return                     Returns all obtained coordinates
  * @return                     Returns the coordinates obtained from X at 0
  * @return                     Returns the coordinates obtained from Y at 1
  */

public class Coordinates {
	private int coordinate[] = new int[2];
	
	public Coordinates(int x, int y) {
		this.coordinate[0] = x;
		this.coordinate[1] = y;
	}
	
	public int[] getCoordinate() {
		return this.coordinate;
	}
	
	public int getX() {
		return this.coordinate[0];
	}
	
	public int getY() {
		return this.coordinate[1];
	}
	
	public void updateCoordinates(int x, int y) {
		this.coordinate[0] = x;
		this.coordinate[1] = y;
	}
	
}
