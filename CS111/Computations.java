public class Computations 
{
	public static void main (String args[])
	{
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);
	int result = 0;
	while (a > 0)
	{
		result += b;
		a -= 1;
	}
	System.out.println(result);

	}
}