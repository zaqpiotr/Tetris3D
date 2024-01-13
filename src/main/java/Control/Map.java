package Control;

public class Map {

	private static int width = 4;
	private static int height = 60;	
	private static int cubesNumber = 200;
	private static int cubesSize = 10;

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int length) {
		Map.width = length;
	}

	public static int getCubesNumber() {
		return cubesNumber;
	}

	public static void setCubesNumber(int cubesNumber) {
		Map.cubesNumber = cubesNumber;
	}

	public static int getCubesSize() {
		return cubesSize;
	}

	public static void setCubesSize(int cubesSize) {
		Map.cubesSize = cubesSize;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		Map.height = height;
	}
}
