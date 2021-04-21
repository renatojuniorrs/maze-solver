package main;

 /**
  * Classe que demonstra as coordenadas a serem percorridas no labirinto.
  * 
  * @param coordinate       	Coordenada inteira que sera transformada em 2 coordenadas- x e y
  * @param getCoordinate    	Obtem as coordenadas que serao percorridas
  * @param getX             	Obtem as coordenadas de X percorridas
  * @param getY             	Obtem as coordenadas de Y percorridas
  * @param updateCoordinates    Altera o caminho que foi percorrido no labirinto
  * @return                     Retorna todas as coordenadas obtidas
  * @return                     Retorna as coordenadas obtidas de X em 0
  * @return                     Retorna as coordenadas obtidas de Y em 1
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
