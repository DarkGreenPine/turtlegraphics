
public class PathPainter extends TurtleGraphics{

	private int[][] arr;
	private int arraySize;
	
	PathPainter(int[][] arr, int arraySize){
		this.arr = arr;
		this.arraySize = arraySize;
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