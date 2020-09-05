public class StringToInteger
{
	public static int stringToInteger( String str )
	{	
		int num = 0;
		int temp;
		for (int i =0; i < str.length(); i++)
		{
			temp = str.charAt( str.length() - 1 -i ) - '0';
			num+= temp * Math.pow(10, i);
		}
		return num;
	}

	public static void main(String args[])
	{		
		String str = "3237";
		System.out.print(stringToInteger(str));
	}
}