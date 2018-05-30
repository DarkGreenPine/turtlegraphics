/**
 * PathPainter contains the methods that print and clear the array 
 * @author Ian
 */
public class PathPainter {

	private int[][] arr;
	private int arraySize;
	
	PathPainter(int[][] arr, int arraySize) {
		this.arr = arr;
		this.arraySize = arraySize;
	}
	/**prints out the path, if a 1 is encountered, it prints a '*' symbol 
	 * @param array The array that the turtle moves in
	 * @param arraySize The size of the array. 
	 */
	public void paintPath(int[][] array) {
		int length = 0;
			
		//checks each position in the array and prints a * if a 1 is encountered
		for (int i = 0; i<arraySize; i++) {
			for (int j = 0; j<arraySize; j++) {
				//new line if at end of array
				if (length >= arraySize) {
					System.out.print("\n");
					length = 0;
				}
					
				if (array[i][j] == 1) System.out.print("*");
					
				if (array[i][j] == 0) System.out.print(" ");
					
				length++;
			}
		}
	}
		
	/**
	 * Clears the board by resetting the array to all 0s
	 * @param array The array to be cleared
	 * @param arraySize The size of the array
	 * @return The cleared array
	 */
	public int[][] clearPath(int[][] arr) {
			
		for (int i = 0; i < arraySize; i++) {
			for (int j = 0; j < arraySize; j++) {
				arr[i][j] = 0;
			}
		}
			
		return arr;
	}
		
	/**
	 * Uses StdDraw to paint the path with color
	 * @param array The array to be cleared
	 * @param arraySize The size of the array
	 */
	public void newFramePainter(int[][] array) {
			
		int lengthCount = 0; // used to see if a new line needs to be printed
		double x = -80;
		double y = 80;
		double radius = 5;
			
		// set the screen size 
		StdDraw.setCanvasSize(1000, 700);
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
			
			
		for (int i = 0; i < arraySize; i++) {
			for (int j = 0; j < arraySize; j++) {
					 
				// draw the squares in the path
				if (array[i][j] == 1) {
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.filledSquare(x, y, radius);
					x += 12; // move square's coordinat to the right
				}
					
				else {
					x += 12; // move square's x coordinate to the right 
				}
					
				lengthCount++;
				if(lengthCount >= arraySize)
				{
					x = -80; // move square's x coordinate back to the left edge
					y -= 12; // move square's y coordinate down a line
					lengthCount = 0;
				}
			}
		}
	}
}
