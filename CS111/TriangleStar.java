public class TriangleStar
{
	   public static void main(String[] args) 
	   {
	   		int h = Integer.parseInt(args[0]);
	   		for (int i = 0; i < h + 1; i++)
			{
				for (int j = 0; j < i; j++)
				{
					System.out.print("* ");
				}
				System.out.println();
			}
			for (int i = h+1; i < 0; i--)
			{
				for (int j = i; j < j; j--)
				{
					System.out.print("* ");
				}
			}
	   }

}

