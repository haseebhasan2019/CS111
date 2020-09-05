/*************************************************************************
 *  Compilation:  javac TrainTicket.java
 *  Execution:    java TrainTicket
 *
 *  @author: 
 Haseeb Hasan
 Haseeb.Hasan@rutgers.edu
 RUID: 193002038
 *
 * The program TrainTicket takes two command-line arguments: an int
 * referring to the persons age and a boolean referring to whether or
 * not the ticket was bought at the train station (true for a ticket
 * bought at the train station). The program computes and displays the
 * ticket price the person needs to pay for the train ride.
 *
 *  % java TrainTicket 23.0 true
 *  13.20
 *
 *  % java TrainTicket 23.0 false
 *  15.84
 * 
 *  % java TrainTicket 230 false
 *  Illegal input
 *
 *************************************************************************/

public class TrainTicket 
{
    public static void main(String[] args) 
    {
		int age = Integer.parseInt(args[0]);
		boolean boughtAtStation = Boolean.parseBoolean(args[1]);
		if (age < 0 || age > 120)
		{
			System.out.print("Illegal input");
		}
		else
		{
			if (age < 7)
			{
				System.out.print(0);
			}
			else if (age <= 65)
			{
				if (!boughtAtStation)
				{
					System.out.print(15.84);
				}
				else
					System.out.print(13.2);
			}
			else
			{
				if (!boughtAtStation)
				{
					System.out.print(9);
				}
				else
					System.out.print(7.5);
			}
		}
    }
}
