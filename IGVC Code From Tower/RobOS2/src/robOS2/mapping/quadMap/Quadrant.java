package robOS2.mapping.quadMap;
public class Quadrant {

	private double xCoord, yCoord;
	private int divisionNum;

	public Quadrant(double x, double y, int division) {
		xCoord = x;
		yCoord = y;
		divisionNum = division;

	}// end Quadrant Constructor

	public double getX() {
		return xCoord;
	}// end getX()

	public double getY() {
		return yCoord;
	}// end getY()

	public int getDiv() {
		return divisionNum;
	}// end getDiv()

}// end class