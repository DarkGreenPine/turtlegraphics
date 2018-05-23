/**TurtleGraphics
 * Version 1.3
 * 5/22/2018
 */
import java.util.Scanner;

public class TurtleGraphics {
	public static void main(String[] args){
	int direction = 2;
	//starts at top left (0, 0)
	int xCoord = 0;
	int yCoord = 0;
	int arraySize = 10;
	int distance;
	int turtleArray[][] = new int[arraySize][arraySize];
	
	//fill in array with 0s initially
	for(int i = 0; i<arraySize; i++){
		for(int j = 0; j<arraySize; j++){
			turtleArray[i][j] = 0;
				}
			}
	
	//menu
	int menuEnd = 0;
	int firstSelection;
	int selectDirection;
	int selectDistance = 0;
	TurtleMover turt = new TurtleMover(selectDistance, direction, xCoord, yCoord, turtleArray, arraySize);
			
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
				case 1:	System.out.println("Which direction? 1 for up, 2 for right, 3 for down, 4 for left\n");
						selectDirection = input.nextInt();
						if (selectDirection == 1 || selectDirection == 2 || selectDirection == 3 || selectDirection == 4)
						{
							direction = selectDirection;
						}
						else System.out.println("Incorrect selection: Must be 1, 2, 3, or 4\n");
						break;
				case 2: System.out.println("How far would you like to move? Remember to stay within bounds\n");
						selectDistance = input.nextInt();
						//update turtle with desired distance
						
						turtleArray = turt.moveTurtle(selectDistance, direction, xCoord, yCoord, turtleArray, arraySize);
						xCoord = turt.updateXCoord(direction, xCoord, selectDistance);
						yCoord = turt.updateYCoord(direction, yCoord, selectDistance);
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
