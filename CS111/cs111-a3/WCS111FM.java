/*************************************************************************
 *  Compilation:  javac WCS111FM.java
 *  Execution:    java WCS111FM 53
 *
 *  The program takes the number of hours the listener spends
 *  programming as an int argument. Based on the number of hours spent
 *  programming, display the listener prize
 *
 *  @author: 
 Haseeb Hasan
 Haseeb.Hasan@rutgers.edu
 RUID: 193002038
 *
 *  % java WCS111FM 3
 *  T-shirt
 *
 *  % java WCS111FM 9
 *  Laptop
 *  TV
 * 
 *  % java WCS111FM 0
 *  Nothing
 *************************************************************************/

public class WCS111FM 
{
    public static void main(String[] args) 
    {
	// WRITE YOUR CODE HERE
    	int hours = Integer.parseInt(args[0]);
		if (hours < 0 || hours > 730)
			System.out.print("Illegal Input");
		else
		{
			if (hours == 0) 
				System.out.print("Nothing");
			else if (hours <= 5) 
				System.out.print("T-shirt ");
			else if (hours <= 400)
			{
				if (hours % 10 == 9) 
					System.out.print("Laptop ");
				if (hours % 2 == 0) 
					System.out.print("Hat ");
				if (hours % 3 == 0) 
					System.out.print("TV ");
			}
			else
				System.out.print("Cat");
		}
    }

}
