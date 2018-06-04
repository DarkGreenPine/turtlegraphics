/**
 * TurtleMover contains methods for moving the turtle around the array. 
 * @author Ian
 *
 */
public class TurtleMover {

	private int distance, xCoord, yCoord, arraySize;
	private int[][] arr;
	private Direction direction;
	private Direction penPosition;
	
	// constructor
	public TurtleMover (int distance, Direction direction, int xCoord, int yCoord, int[][] arr, int arraySize, Direction penPosition){
		this.distance = distance;
		this.direction = direction;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.arr = arr;
		this.arraySize = arraySize;
		this.penPosition = penPosition;
	}
	
	/**
	 * moves the turtle in the desired direction and distance
	 * calls isValidMove to check if it is within bounds
	 * updates array to have a 1 in the path the turtle took
	 * @param distance The distance to move forward
	 * @param direction The direction the turtle is facing
	 * @param xCoord The x or row coordinate of the current position
	 * @param yCoord The y or column coordinate of the current position
	 * @param penPosition The position the pen is at, up or down
	 * @return The updated array
	 */
 	public int[][] moveTurtle(int distance, Direction direction, int xCoord, int yCoord, Direction penPosition){
		int length = distance;
		int rowPos = yCoord;
		int colPos = xCoord;
		
		
		// if move is valid
		if (isValidMove(distance, direction, xCoord, yCoord) == true) {
			
			// check and move up
			if (direction == Direction.up) {
				for(int i = 0; i<=length; i++) {
					if (penPosition == Direction.down) arr[rowPos][colPos] = 1;
					rowPos--;
				}
			}
			
			// check and move right
			if (direction == Direction.right) {
				for (int j = 0; j<=length; j++) {
					if (penPosition == Direction.down) arr[rowPos][colPos] = 1;
					colPos++;
				}
			}
			
			// check and move down
			if (direction == Direction.down) {
				for (int k = 0; k<=length; k++) {
					if (penPosition == Direction.down) arr[rowPos][colPos] = 1;
					rowPos++;
				}
			}
			
			// check and move left
			if (direction == Direction.left) {
				for (int l = 0; l<=length; l++) {
					arr[rowPos][colPos] = 1;
					colPos--;
				}
			}
			return arr;
		}
		
		// if move is not valid, return the initial array
		else {
			System.out.println("Out of Bounds");
			return arr;
		}
 	}
 	
	/**updates x coordinate
	 * @param direction The direction the turtle is facing
	 * @param xCoord The x or row coordinate of the turtle's position
	 * @param yCoord The y or column coordinate of the turtle's position
	 * @param distance The distance to move forward
	 * @return The updated x coordinate
	 */
	public int updateXCoord(Direction direction, int xCoord, int yCoord, int distance) {
		
		// right and left
		if (isValidMove(distance, direction, xCoord, yCoord)) {
			if (direction == Direction.right) return xCoord += distance;
			else if (direction == Direction.left) return xCoord -= distance;
			else return xCoord; 
		}
		
		else return xCoord;
	}
	
	/**updates y coordinate
	 * @param direction The direction the turtle is facing
	 * @param xCoord The x or row coordinate of the turtle's position
	 * @param yCoord The y or column coordinate of the turtle's position
	 * @param distance The distance to move forward
	 * @return The updated y coordinate
	 */
	public int updateYCoord(Direction direction, int xCoord, int yCoord, int distance) {
		
		// up and down
		if (isValidMove(distance, direction, xCoord, yCoord)) {
			if (direction == Direction.up) return yCoord -= distance;
			else if (direction == Direction.down) return yCoord += distance;
			else return yCoord;
		}
		else return yCoord;
	}
	
	/**
	 * checks if the desired move is within bounds
	 * @param distance The distance to move forward
	 * @param direction The direction the turtle is facing
	 * @param xCoord The x or row position of the turtle
	 * @param yCoord The y or column position of the turtle
	 * @return True or false 
	 */
	public boolean isValidMove(int distance, Direction direction, int xCoord, int yCoord) {
		
		// checking up
		if (direction == Direction.up) {
			if ((xCoord -  distance) < 0) return false;
			else return true;
		}
		
		// checking right
		else if (direction == Direction.right) {
			if ((yCoord + distance) > arraySize) return false;
			else return true;
		}
		
		// check down
		else if (direction == Direction.down) {
			if ((xCoord + distance) > arraySize) return false;
		    else return true;
		}
		
		// checking left
		else if (direction == Direction.left) {
			if ((yCoord - distance) < 0) return false;
			else return true;
		}
		
		else return false;
	}
	

}