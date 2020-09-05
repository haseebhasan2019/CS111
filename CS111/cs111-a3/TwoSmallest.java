/*************************************************************************
 *  Compilation:  javac TwoSmallest.java
 *  Execution:    java TwoSmallest 1.1 6.9 0.3
 *
 *  @author: 
 Haseeb Hasan
 Haseeb.Hasan@rutgers.edu
 RUID: 193002038
 *
 *  The program TwoSmallest takes a set of double command-line
 *  arguments and prints the smallest and second-smallest number, in that
 *  order. It is possible for the smallest and second-smallest numbers to
 *  be the same (if the sequence contains duplicate numbers).
 *
 *  Note: display one number per line
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  1.1
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  0.3
 *************************************************************************/

public class TwoSmallest 
{
    public static void main(String[] args) 
    {
		//Variables
		int counter = 0;
		int size = args.length;
		int size2 = size - 1;
		double[] a = new double[size];
		double[] b = new double[size2];
		
		//Reading in numbers from compiler
		for (int i = 0; i < size; i++)
		{
			a[i] = Double.parseDouble(args[i]);
		}
		
		//Finding Smallest Number
		double small1 = a[0];
		for (int j = 1; j < size; j++)
		{
			if (a[j] < small1)
			{
				small1 = a[j];
				counter = j;
			}
		}
		
		//Creating New Array without smallest number
		for (int k = 0; k < counter; k++)
		{
			b[k] = a[k];
		}
		for (int l = counter; l < size2; l++)
		{
			b[l] = a[l+1];
		}
		
		//Finding Second Smallest Number
		double small2 = b[0];
		for (int j = 1; j < size2; j++)
		{
			if (b[j] < small2)
			{
				small2 = b[j];
			}
		}
		
		//Printing Output
		System.out.println(small1);
		System.out.println(small2);


    }

}
