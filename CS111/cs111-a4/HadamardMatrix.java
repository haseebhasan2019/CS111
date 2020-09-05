/*************************************************************************
 *  Compilation:  javac HadamardMatrix.java
 *  Execution:    java HadamardMatrix 2
 *
 *  @author: 
 Haseeb Hasan
 Haseeb.Hasan@rutgers.edu
 RUID: 193002038
 *
 * The program HadamardMatrix prints H(n)
 *
 *  % java HadamardMatrix 2
 *  T T
 *  T F
 *
 *************************************************************************/

public class HadamardMatrix 
{
    public static void main(String[] args) 
    {
    	// WRITE YOUR CODE HERE
    	//Declare Variables
    	int num = Integer.parseInt(args[0]);
    	boolean[][] a = new boolean[num][num];
    	int counter = 1;

    	//Set first element to true
    	a[0][0] = true;

    	//Editing elements of the array
    	while (counter < num)
    	{
    		for(int i = 0; i < counter; i++)
    		{
    			for(int j = 0; j < counter; j++)
    			{
    				a[i][j+counter] = a[i][j];
    				a[i+counter][j] = a[i][j];
    				a[i+counter][j+counter] = !a[i][j];
    			}
    		}
    		counter*=2;
    	}

    	//Print Array
    	for (int i = 0; i < a.length; i++)
    	{
    		for (int j = 0; j < a[0].length; j++)
    		{
    			if (a[i][j])
    				StdOut.print("T  ");
    			else
    				StdOut.print("F  ");
    			
    		}
    		StdOut.println();
    	}
    }
}
