/*************************************************************************
 *  Compilation:  javac Gas.java
 *  Execution:    java Gas 3.40 15.0 true
 *
 *  @author: 
 Haseeb Hasan
 Haseeb.Hasan@rutgers.edu
 RUID: 193002038
 *
 * The program Gas computes and displays the price a
 * person will pay for gas at the gas station.
 *
 *  % java Gas 3.40 15.0 false
 *  56.1
 *
 *  % java Gas 3.40 15.0 true
 *  51.0
 *
 *************************************************************************/

public class Gas 
{
    public static void main(String[] args) 
    {
	// WRITE YOUR CODE HERE
		double perGallon = Double.parseDouble(args[0]);
		double gallons = Double.parseDouble(args[1]);
		boolean cash = Boolean.parseBoolean(args[2]);
		

		if (perGallon <= 0 || gallons <= 0)
		{
			System.out.print("Illegal input");
		}
		else if (cash)
		{
			System.out.print(perGallon*gallons);
		}
		else
		{
			System.out.print(perGallon*gallons*1.1);
		}

    }
}
