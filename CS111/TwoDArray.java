public class TwoDArray
{
	public static void main(String[] args) 
    {
    	//Declare Variables
    	int x = Integer.parseInt(args[0]);
    	int y = Integer.parseInt(args[1]);
    	boolean[][] a = new boolean[x][y];
    	String[][] b = new String[x+1][y+1];
    	int rand;

    	//Randomly filling array a
    	for (int i = 0; i<x; i++)
    	{
    		for (int j = 0; j<y; j++)
    		{
    			rand = (int)(Math.random()*2) + 1;
    			if (rand==1)
    				a[i][j] = false;
    			else
    				a[i][j] = true;
    		}
    	}

    	//Filling array b
    	for (int i = 0; i < x; i++)
    	{
    		for(int j = 0; j < y; j++)
    		{
    			if (i==0 || j==0)
    			{
    				b[i][j] = j+"";
    			}
    			else
    			{
    				if (a[i][j]==false)
    				{
    					b[i+1][j+1] = " ";
    				}
    				else
    				{
    					b[i+1][j+1] = "*";
    				}
    			}
    		}
    	}


    	//Print array a
    	for (int i = 0; i<x; i++)
    	{
    		for (int j = 0; j<y; j++)
    		{
    			System.out.print(a[i][j] + " ");
    		}
    		System.out.println();
    	}

    	//Print array b
    	for (int i = 0; i<x+1; i++)
    	{
    		for (int j = 0; j<y+1; j++)
    		{
    			System.out.print(b[i][j]);
    		}
    		System.out.println();
    	}
    }
}