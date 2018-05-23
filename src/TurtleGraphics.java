/**TurtleGraphics
 * Version 1.6
 * 5/22/2018
 */
import java.util.Scanner;

public class TurtleGraphics {
	public static void main(String[] args){
	
	//starts at top left (0, 0)
	int xCoord = 0; // the x or row coordinate the turtle is at
	int yCoord = 0; // the y or column coordinate the turtle is at
	int arraySize = 10; // size of the array the turtle moves in
	int turtleArray[][] = new int[arraySize][arraySize]; // the array the turtle's path will be in
	
	Direction dir = Direction.right;//direction enum, start off facing right
	
	//fill in array with 0s initially
	for(int i = 0; i<arraySize; i++){
		for(int j = 0; j<arraySize; j++){
			turtleArray[i][j] = 0;
				}
			}
	
	//menu
	int menuEnd = 0; // used for the menu while loop
	int firstSelection; // the initial user selection within the loop
	int selectDirection; // the direction the user selects
	int selectDistance = 0; // the distance the user selects
	TurtleMover turt = new TurtleMover(selectDistance, dir, xCoord, yCoord, turtleArray, arraySize);
			
			while (menuEnd!=1)
			{
				//ask for input
				System.out.println("Press 1 to change direction\n"
						+ "Press 2 to move forward\n"
						+ "Press 3 to print the current map\n"
						+ "Press 4 to end\n\n");
				
				Scanner input = new Scanner(System.in);
				firstSelection = input.nextInt();
				
				//check and respond to user selection
				switch (firstSelection)
				{
				case 1:	System.out.println("Which direction? Enter: 1 for up, 2 for right, 3 for down, 4 for left\n");
						selectDirection = input.nextInt();
						//check if the direction is ok and assign such that: 1 = up, 2 = right, 3 = down, 4 = left
						if (selectDirection == 1) dir = Direction.up;
						
						else if (selectDirection == 2) dir = Direction.right;
						
						else if (selectDirection == 3) dir = Direction.down;
						
						else if (selectDirection == 4) dir = Direction.left;
						
						else System.out.println("Incorrect selection: Must be 1, 2, 3, or 4\n");
						
						break;
				case 2: System.out.println("How far would you like to move? Remember to stay within bounds\n");
						selectDistance = input.nextInt();
						
						//update turtle with desired distance
						turtleArray = turt.moveTurtle(selectDistance, dir, xCoord, yCoord, turtleArray, arraySize);
						
						xCoord = turt.updateXCoord(dir, xCoord, selectDistance);
						
						yCoord = turt.updateYCoord(dir, yCoord, selectDistance);
						
						break;
				case 3: turt.paintPath(turtleArray, arraySize);
						break;
				case 4: menuEnd = 1;
						break;
				default: System.out.println("Not a valid choice\n");
						break;
				}
				
			}
	
	}

}
