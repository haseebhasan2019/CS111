public class ArrayProcessing2 
{
	public static void main(String[] args) 
	{
		//System.out.println(args.length);
		//read a bunch of integegers from compiler
		int size = Integer.parseInt(args[0]);
		int[] a = new int[size];
		for (int i = 0; i < size; i++)
		{
			a[i] = (int)(Math.random() * 10) + 1;
		}
		// print the array
		for (int i = 0; i < size; i++)
		{
			System.out.println(a[i] + " ");
		}
	}
}