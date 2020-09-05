/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker 10
 *
 *  @author:
 Haseeb Hasan
 Haseeb.Hasan@rutgers.edu
 RUID: 193002038
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker 
{

    public static void main(String[] args) 
    {
		// WRITE YOUR CODE HERE
		//Declare Variables
		int num = Integer.parseInt(args[0]);
    	int x = 0;
    	int y = 0;
    	int counter = 0;
    	int dir = 0;
    	double dist;
    	System.out.println("(0,0)");
    	//Calculating ending position
    	while (counter < num)
    	{
    		dir = (int)(Math.random() * 4) + 1;
    		//North
    		if (dir == 1)
    		{
    			y += 1;
    		}
    		//South
    		if (dir == 2)
    		{
    			y -= 1;
    		}
    		//East
    		if (dir == 3)
    		{
    			x += 1;
    		}
    		//West
    		if (dir == 4)
    		{
    			x -= 1;
    		}
    		counter++;
    		System.out.println("(" + x + "," + y + ")");
    	}

    	//Calculate and print squared distance
		dist = Math.pow(x,2) + Math.pow(y, 2);
    	System.out.println("Squared distance = " + dist);
    }
}
