/*************************************************************************
 *  Compilation:  javac StdIn.java
 *  Execution:    java StdIn   (interactive test of basic functionality)
 *
 *  Reads in data of various types from standard input.
 *
 *  THIS VERSION HAS SPECIAL METHODS FOR GRADING.
 *
 *************************************************************************/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *  <i>Standard input</i>. This class provides methods for reading strings
 *  and numbers from standard input. See 
 *  <a href="http://introcs.cs.princeton.edu/15inout">Section 1.5</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i>
 *  by Robert Sedgewick and Kevin Wayne.
 *  <p>
 *  See the technical information in the documentation of the {@link In}
 *  class, which applies to this class as well. 
 */
public final class StdIn {

    private static Scanner scanner;

    // maximum allowable number of calls
    private static long maxNumberOfOperations = Long.MAX_VALUE;

    private static long isEmptyCount     = 0;
    private static long hasNextLineCount = 0;
    private static long hasNextCharCount = 0;
    private static long readIntCount     = 0;
    private static long readDoubleCount  = 0;
    private static long readStringCount  = 0;
    private static long readCharCount    = 0;
    private static long readLineCount    = 0;
    private static long readAllCount     = 0;
    private static long operationCount   = 0;

    public static void resetAllOperationCounts() {
        isEmptyCount     = 0;
        hasNextLineCount = 0;
        hasNextCharCount = 0;
        readIntCount     = 0;
        readDoubleCount  = 0;
        readStringCount  = 0;
        readCharCount    = 0;
        readAllCount     = 0;
        readLineCount    = 0;
        operationCount   = 0;
    }

    public static long isEmptyCount() {
        return isEmptyCount;
    }

    public static long hasNextLineCount() {
        return hasNextLineCount;
    }

    public static long hasNextCharCount() {
        return hasNextCharCount;
    }

    public static long readIntCount() {
        return readIntCount;
    }

    public static long readDoubleCount() {
        return readDoubleCount;
    }

    public static long readStringCount() {
        return readStringCount;
    }

    public static long readCharCount() {
        return readCharCount;
    }

    public static long readAllCount() {
        return readAllCount;
    }

    public static long readLineCount() {
        return readLineCount;
    }

    public static long operationCount() {
        return operationCount;
    }

    public static void setMaxNumberOfOperations(long limit) {
        maxNumberOfOperations = limit;
    }

    private static void checkOperationCount() {
        if (operationCount >= maxNumberOfOperations) {
            throw new OperationCountLimitExceededException("Number of calls to methods in StdIn exceeds limit: " + maxNumberOfOperations);
        }
    }

 
    // it doesn't make sense to instantiate this class
    private StdIn() { }

    /*** begin: section (1 of 2) of code duplicated from In to StdIn */
    
    // assume Unicode UTF-8 encoding
    private static final String CHARSET_NAME = "UTF-8";

    // assume language = English, country = US for consistency with System.out.
    private static final java.util.Locale usLocale = new java.util.Locale("en", "US");

    // the default token separator; we maintain the invariant that this value 
    // is held by the scanner's delimiter between calls
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    // makes whitespace characters significant 
    private static final Pattern EMPTY_PATTERN = Pattern.compile("");

    // used to read the entire input. source:
    // http://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner_1.html
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

    /*** end: section (1 of 2) of code duplicated from In to StdIn */

    /*** begin: section of code for private grader version only.
      ** DELETE THIS BLOCK FOR THE BOOKSITE/WEB. IS IT SECRET? IS IT SAFE? ***/
    public static void setFile(String filename) {
        try {
            scanner.close(); // warning, this may close StdIn the first time!
            setScanner(new Scanner(new java.io.File(filename), CHARSET_NAME));
        }
        catch (java.io.IOException ioe) {
            System.err.println("Could not open " + filename);
        }
    }
    public static void setString(String text) {
        scanner.close(); // warning, this may close StdIn the first time!
        setScanner(new Scanner(text));
    }
    /*** end: section of code for private grader version only ***/
 

    /*** begin: section (2 of 2) of code duplicated from In to StdIn,
      *  with all methods changed from "public" to "public static" ***/

   /**
     * Is the input empty (except possibly for whitespace)? Use this
     * to know whether the next call to {@link #readString()}, 
     * {@link #readDouble()}, etc will succeed.
     */
    public static boolean isEmpty() {
        isEmptyCount++;
        operationCount++;
        checkOperationCount();

        return !scanner.hasNext();
    }

   /**
     * Does the input have a next line? Use this to know whether the
     * next call to {@link #readLine()} will succeed. <p> Functionally
     * equivalent to {@link #hasNextChar()}.
     */
    public static boolean hasNextLine() {
        hasNextLineCount++;
        operationCount++;
        checkOperationCount();

        return scanner.hasNextLine();
    }

    /**
     * Is the input empty (including whitespace)? Use this to know 
     * whether the next call to {@link #readChar()} will succeed. <p> Functionally
     * equivalent to {@link #hasNextLine()}.
     */
    public static boolean hasNextChar() {
        hasNextCharCount++;
        operationCount++;
        checkOperationCount();

        scanner.useDelimiter(EMPTY_PATTERN);
        boolean result = scanner.hasNext();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }


   /**
     * Read and return the next line.
     */
    public static String readLine() {
        readLineCount++;
        operationCount++;
        checkOperationCount();

        String line;
        try                 { line = scanner.nextLine(); }
        catch (Exception e) { line = null;               }
        return line;
    }

    /**
     * Read and return the next characterr.
     */
    public static char readChar() {
        readCharCount++;
        operationCount++;
        checkOperationCount();

        try {
            scanner.useDelimiter(EMPTY_PATTERN);
            String ch = scanner.next();
            assert (ch.length() == 1) : "Internal (Std)In.readChar() error!"
                + " Please contact the authors.";
            scanner.useDelimiter(WHITESPACE_PATTERN);
            return ch.charAt(0);
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'char' value from standard input, but there are no more tokens available");
        }

    }  


   /**
     * Read and return the remainder of the input as a string.
     */
    public static String readAll() {
        readAllCount++;
        operationCount++;
        checkOperationCount();

        if (!scanner.hasNextLine())
            return "";

        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        // not that important to reset delimeter, since now scanner is empty
        scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
        return result;
    }


   /**
     * Read and return the next string.
     */
    public static String readString() {
        readStringCount++;
        operationCount++;
        checkOperationCount();

        try {
            return scanner.next();
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'String' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Read and return the next int.
     */
    public static int readInt() {
        readIntCount++;
        operationCount++;
        checkOperationCount();

        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Read and return the next double.
     */
    public static double readDouble() {
        readDoubleCount++;
        operationCount++;
        checkOperationCount();

        try {
            return scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'double' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'double' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Read and return the next float.
     */
    public static float readFloat() {
        try {
            return scanner.nextFloat();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'float' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'float' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Read and return the next long.
     */
    public static long readLong() {
        try {
            return scanner.nextLong();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'long' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'long' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Read and return the next short.
     */
    public static short readShort() {
        try {
            return scanner.nextShort();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'short' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'short' value from standard input, but there are no more tokens available");
        }
    }

   /**
     * Read and return the next byte.
     */
    public static byte readByte() {
        try {
            return scanner.nextByte();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'byte' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'byte' value from standard input, but there are no more tokens available");
        }
    }

    /**
     * Read and return the next boolean, allowing case-insensitive
     * "true" or "1" for true, and "false" or "0" for false.
     */
    public static boolean readBoolean() {
        try {
            String token = readString();
            if ("true".equalsIgnoreCase(token))  return true;
            if ("false".equalsIgnoreCase(token)) return false;
            if ("1".equals(token))               return true;
            if ("0".equals(token))               return false;
            throw new InputMismatchException("attempts to read a 'boolean' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'boolean' value from standard input, but there are no more tokens available");
        }
    }

    /**
     * Read all strings until the end of input is reached, and return them.
     */
    public static String[] readAllStrings() {
        readAllCount++;
        operationCount++;
        checkOperationCount();

        // we could use readAll.trim().split(), but that's not consistent
        // since trim() uses characters 0x00..0x20 as whitespace
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0)
            return tokens;
        String[] decapitokens = new String[tokens.length-1];
        for (int i=0; i < tokens.length-1; i++)
            decapitokens[i] = tokens[i+1];
        return decapitokens;
    }

    /**
     * Reads all remaining lines from standard input and returns them as an array of strings.
     * @return all remaining lines on standard input, as an array of strings
     */
    public static String[] readAllLines() {
        readAllCount++;
        operationCount++;
        checkOperationCount();

        ArrayList<String> lines = new ArrayList<String>();
        while (hasNextLine()) {
            lines.add(readLine());
        }
        return lines.toArray(new String[lines.size()]);
    }

    /**
     * Read all ints until the end of input is reached, and return them.
     */
    public static int[] readAllInts() {
        readAllCount++;
        operationCount++;
        checkOperationCount();

        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Integer.parseInt(fields[i]);
        return vals;
    }

    /**
     * Read all doubles until the end of input is reached, and return them.
     */
    public static double[] readAllDoubles() {
        readAllCount++;
        operationCount++;
        checkOperationCount();

        String[] fields = readAllStrings();
        double[] vals = new double[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Double.parseDouble(fields[i]);
        return vals;
    }
    
    /*** end: section (2 of 2) of code duplicated from In to StdIn */
    
    
    /**
     * If StdIn changes, use this to reinitialize the scanner.
     */
    private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
    }
    
    private static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;
        StdIn.scanner.useLocale(usLocale);
    }

    // do this once when StdIn is initialized
    static {
        resync();
    }

   /**
     * Reads all ints from stdin.
     * @deprecated For more consistency, use {@link #readAllInts()}
     */
    @Deprecated
    public static int[] readInts() {
        return readAllInts();
    }

   /**
     * Reads all doubles from stdin.
     * @deprecated For more consistency, use {@link #readAllDoubles()}
     */
    @Deprecated
    public static double[] readDoubles() {
        return readAllDoubles();
    }

   /**
     * Reads all Strings from stdin.
     * @deprecated For more consistency, use {@link #readAllStrings()}
     */
    @Deprecated
    public static String[] readStrings() {
        return readAllStrings();
    }


    /**
     * Interactive test of basic functionality.
     */
    public static void main(String[] args) {

        System.out.println("Type a string: ");
        String s = StdIn.readString();
        System.out.println("Your string was: " + s);
        System.out.println();

        System.out.println("Type an int: ");
        int a = StdIn.readInt();
        System.out.println("Your int was: " + a);
        System.out.println();

        System.out.println("Type a boolean: ");
        boolean b = StdIn.readBoolean();
        System.out.println("Your boolean was: " + b);
        System.out.println();

        System.out.println("Type a double: ");
        double c = StdIn.readDouble();
        System.out.println("Your double was: " + c);
        System.out.println();

    }

}
