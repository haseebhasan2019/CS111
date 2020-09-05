/*************************************************************************
 *  Compilation:  javac RunLengthEncoding.java
 *  Execution:    java RunLengthEncoding
 *
 *  @author:
 Haseeb Hasan
 Haseeb.Hasan@rutgers.edu
 RUID: 193002038
 *
 *************************************************************************/

public class RunLengthEncoding 
{

    /* 
     * Encode the original string by finding sequences in the string
     * where the same character repeats. Replace each such sequence
     * by a token consisting of: the number of characters in the sequence
     * followed by the repeating character.
     * Return the encoded string.
     */
    public static String encode (String original)  
    {
	    // WRITE YOUR CODE HERE
        String code = "";
        int pos = 0;
        int repeat = 1;
        while (pos < original.length() - 1)
        {
            if (original.charAt(pos) == original.charAt(pos+1))
            {
                repeat++;
            }
            else
            {
                if (repeat > 1)
                    code += Integer.toString(repeat) + original.charAt(pos);
                else
                    code += original.charAt(pos);
                repeat = 1;

            }
            pos++;
        }
        if (repeat > 1)
            code += Integer.toString(repeat) + original.charAt(pos);
        else
            code += original.charAt(pos);
        return code;
    }

    /*
     * Decodes the original string encoded with the encode method.
     * Returns the decoded string.
     *
     * YOUR decode METHOD MUST BE RECURSIVE, do not use while, do/while, 
     * or for loops
     */
    public static String decode (String original)  
    {
	    // WRITE YOUR RECURSIVE CODE HERE
        char c = original.charAt(0);
        if (original.length() == 1)
            return original;
        else if (Character.isDigit(c))
        {
            if (c == '2')
                return original.charAt(1) + decode(original.substring(1));
            else
            {
                c--;
                return original.charAt(1) + decode(c + original.substring(1));
            }
        }
        else
            return c + decode(original.substring(1));
    }

    public static void main (String[] args) 
    {
	    // WRITE YOUR TEST CASES HERE to test your methods
        String string = args[0];
        System.out.print(decode(string));
    }
}