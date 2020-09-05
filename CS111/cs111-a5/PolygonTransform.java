/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author:
 Haseeb Hasan
 Haseeb.Hasan@rutgers.edu
 RUID: 193002038
 *
 *************************************************************************/

public class PolygonTransform 
{

    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) 
    {

    	// WRITE YOUR CODE HERE
    	// DO NOT use StdDraw methods in this method
        double[] a = new double[array.length]; 
        for (int i = 0; i < array.length; i++)
        {
            a[i] = array[i];
        }
        return a;
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) 
    {

    	// WRITE YOUR CODE HERE
    	// DO NOT use StdDraw methods in this method
        for (int i = 0; i < x.length; i++)
        {
            x[i] = alpha * x[i];
        }
        for (int i = 0; i < y.length; i++)
        {
            y[i] = alpha * y[i];
        }
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) 
    {

    	// WRITE YOUR CODE HERE
    	// DO NOT use StdDraw methods in this method
        for (int i = 0; i < x.length; i++)
        {
            x[i] = dx + x[i];
        }
        for (int i = 0; i < y.length; i++)
        {
            y[i] = dy + y[i];
        }
    }
  
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) 
    {

    	// WRITE YOUR CODE HERE
    	// DO NOT use StdDraw methods in this method
        double[] x2 = copy(x);

        for (int i = 0; i < x.length; i++)
        {
            x[i] = (x[i] * Math.cos(Math.toRadians(theta))) - (y[i] * Math.sin(Math.toRadians(theta)));
        }
        for (int i = 0; i < y.length; i++)
        {
            y[i] = (y[i] * Math.cos(Math.toRadians(theta))) + (x2[i] * Math.sin(Math.toRadians(theta)));
        }

    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) 
    {

    	// WRITE YOUR CODE HERE
    	// Use the StdDraw library methods to test the polygon transform methods here
        //Declare Variables
        StdDraw.setScale(-5.0, +5.0);
        double[] x = {0, 1};
        double[] y = {0, 0};
        double alpha = 2.0;
        double dx = 2.0, dy = 1.0;
        double theta = 90.0;

        //Original Drawing
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);

        //Calling Methods
        //copy(x);
        //scale(x, y, alpha);
        //translate(x, y, dx, dy);
        rotate(x, y, theta);
        
        //New Drawing
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y); 
    }
}
