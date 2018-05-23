
public class TurtleMover extends TurtleGraphics{

	private int distance, direction, xCoord, yCoord, arraySize;
	private int[][] arr;
	
	public TurtleMover(int distance, int direction, int xCoord, int yCoord, int[][] arr, int arraySize){
		this.distance = distance;
		this.direction = direction;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.arr = arr;
		this.arraySize = arraySize;
	}
	
	
	/*moves the turtle in the desired direction and distance
	 * calls isValidMove to check if it is within bounds
	 * updates array to have a 1 in the path the turtle took
	 * returns updated array
	 * */
 	public int[][] moveTurtle(int distance, int direction, int xCoord, int yCoord, int[][] arr, int arraySize){
		int length = distance;
		int rowPos = yCoord;
		int colPos = xCoord;
		int[][] array = arr;
		//if move is valid
		if (isValidMove(distance, direction, xCoord, yCoord, arraySize) == true){
			
			//check up
			if (direction == 1) {
				for(int i = 0; i<=length; i++){
					array[rowPos][colPos] = 1;
					rowPos--;
				}
			}
			//check right
			if (direction == 2){
				for(int j = 0; j<=length; j++){
					array[rowPos][colPos] = 1;
					colPos++;
				}
			}
			//check down
			if (direction == 3){
				for(int k = 0; k<=length; k++){
					array[rowPos][colPos] = 1;
					rowPos++;
				}
			}
			//check left
			if (direction == 4){
				for (int l = 0; l<=length; l++){
					array[rowPos][colPos] = 1;
					colPos--;
				}
			}
			return array;
		}
		//if move is not valid, return the initial array
		else {
			System.out.println("Out of Bounds");
			return arr;
		}
	}
 	
 	
	//updates x coord
	public int updateXCoord(int direction, int xCoord, int distance)
	{
		//right and left
		if (direction == 2)return xCoord += distance;
		else if (direction == 4) return xCoord -= distance;
		else return xCoord;
	}
	
	
	//updates y coord
	public int updateYCoord(int direction, int yCoord, int distance){
		//up and down
		if (direction == 1) return yCoord-=distance;
		else if (direction == 3) return yCoord+=distance;
		else return yCoord;
	}
	
	
	//checks if the desired move is within bounds
	public boolean isValidMove(int distance, int direction, int xCoord, int yCoord, int arraySize){
		//checking up
		if (direction == 1){
			if (xCoord -  distance < 0) return false;
			else return true;
		}
		//checking right
		else if (direction == 2){
			if (yCoord+distance>arraySize) return false;
			else return true;
		}
		//check down
		else if (direction == 3){
			if (xCoord + distance > arraySize) return false;
		    else return true;
		}
		//checking left
		else if (direction == 4){
			if (yCoord - distance < arraySize) return false;
			else return true;
		}
		else return false;
	}
	
	
	//prints out the path, if a 1 is encountered, it prints a '*' symbol
	public void paintPath(int[][] array, int arraySize){
		int length =0;
		
		//checks each position in the array and prints a * if a 1 is encountered
		for (int i = 0; i<arraySize; i++){
			for (int j = 0; j<arraySize; j++){
				//new line if at end of array
				if (length>=arraySize){
					System.out.print("\n");
					length = 0;
				}
				
				if (array[i][j] == 1) System.out.print("*");
				
				if (array[i][j] == 0) System.out.print(" ");
				
				length++;
			}
		}
	}

}