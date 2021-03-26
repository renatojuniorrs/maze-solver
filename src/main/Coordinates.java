package main;

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
