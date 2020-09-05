/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage
 *
 *  @author:
 Haseeb Hasan
 Haseeb.Hasan@rutgers.edu
 RUID: 193002038
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) 
    {
	   // WRITE YOUR CODE HERE           
        collageDimension = 4;
        tileDimension = 100;
        int width = tileDimension*collageDimension;
        int height = tileDimension*collageDimension;

        original = new Picture(filename);
        collage = new Picture(width, height);
        for (int tcol = 0; tcol < width; tcol++)
        {
            for (int trow = 0; trow < height; trow++)
            {
                int scol = tcol * original.width() / width;
                int srow = trow * original.height() / height;
                Color color = original.get(scol, srow);
                collage.set(tcol, trow, color);
            }
        }
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) 
    {
        // WRITE YOUR CODE HERE
        collageDimension = cd;
        tileDimension = td;

        int width = cd*td;
        int height = cd*td;
        original = new Picture(filename);
        collage = new Picture(width, height);
        for (int tcol = 0; tcol < width; tcol++)
        {
            for (int trow = 0; trow < height; trow++)
            {
                int scol = tcol * original.width() / width;
                int srow = trow * original.height() / height;
                Color color = original.get(scol, srow);
                collage.set(tcol, trow, color);
            }
        }
    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() 
    {
        // WRITE YOUR CODE HERE
        return collageDimension;
    }
    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() 
    {
        // WRITE YOUR CODE HERE
        return tileDimension;
    }
    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() 
    {
        // WRITE YOUR CODE HERE
        return original;
    }
    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() 
    {
        // WRITE YOUR CODE HERE
        return collage;
    }
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() 
    {
        // WRITE YOUR CODE HERE
        original.show();
    }
    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() 
    {
        // WRITE YOUR CODE HERE
        collage.show();
    }
    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) 
    {
        // WRITE YOUR CODE HERE
        Picture pic = new Picture(filename);

        for (int cc = collageCol * tileDimension; cc < collageCol * tileDimension + tileDimension; cc++)
        {
            for (int cr = collageRow * tileDimension; cr < collageRow * tileDimension + tileDimension; cr++)
            {
                int origCol = ((cc - collageCol * tileDimension) * pic.width()) / tileDimension;
                int origRow = ((cr - collageRow * tileDimension) * pic.height()) / tileDimension;
                collage.setRGB(cc, cr, pic.getRGB(origCol, origRow));
            }
        }
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () 
    {
        // WRITE YOUR CODE HERE
        for (int a = 0; a < collageDimension; a++) 
        {
            for (int b = 0; b < collageDimension; b++)   
            {                
                for (int collCol = a * tileDimension; collCol < a * tileDimension + tileDimension; collCol++)
                {
                    for (int collRow = b * tileDimension; collRow < b * tileDimension + tileDimension; collRow++)
                    {
                        int origCol = ((collCol - a * tileDimension) * original.width()) / tileDimension;
                        int origRow = ((collRow - b * tileDimension) * original.height()) / tileDimension;
                        collage.setRGB(collCol, collRow, original.getRGB(origCol, origRow));
                    }
                }
            }
        }
        
    }
    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) 
    {
        // WRITE YOUR CODE HERE
        if (component.equals("red"))
        {
            for (int y = collageCol * tileDimension; y < collageCol * tileDimension + tileDimension; y++)
            { 
                for (int x = collageRow * tileDimension; x < collageRow * tileDimension + tileDimension; x++) 
                { 
                    Color color = collage.get(y, x);
                    int r = color.getRed();
                    Color tint = new Color(r, 0, 0);
                    collage.set(y, x, tint);
                } 
            }
        }
        if (component.equals("green"))
        {
            for (int y = collageCol * tileDimension; y < collageCol * tileDimension + tileDimension; y++)
            { 
                for (int x = collageRow * tileDimension; x < collageRow * tileDimension + tileDimension; x++) 
                { 
                    Color color = collage.get(y, x);
                    int g = color.getGreen();
                    Color tint = new Color(0, g, 0);
                    collage.set(y, x, tint);
                } 
            }
        }
        if (component.equals("blue"))
        {
            for (int y = collageCol * tileDimension; y < collageCol * tileDimension + tileDimension; y++)
            { 
                for (int x = collageRow * tileDimension; x < collageRow * tileDimension + tileDimension; x++) 
                { 
                    Color color = collage.get(y, x);
                    int b = color.getBlue();
                    Color tint = new Color(0, 0, b);
                    collage.set(y, x, tint); 
                } 
            }
        }
        
    }

    /*
     * Greyscale tile at (collageCol, collageRow)
     * (see Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void greyscaleTile (int collageCol, int collageRow) 
    {
        // WRITE YOUR CODE HERE
        for (int collCol = collageCol * tileDimension; collCol < collageCol * tileDimension + tileDimension; collCol++)
        {
            for (int collRow = collageRow * tileDimension; collRow < collageRow * tileDimension + tileDimension; collRow++)
            {
                Color color = collage.get(collCol, collRow);
                Color gray  = Luminance.toGray(color);
                collage.set(collCol, collRow, gray);
            } 
        }
    }


    // Test client 
    public static void main (String[] args) 
    {
        /*ArtCollage art = new ArtCollage(args[0]);
        art.showCollagePicture();*/

        /*ArtCollage art = new ArtCollage(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        art.showCollagePicture();*/

        /*ArtCollage art = new ArtCollage(args[0], 200, 3);
        art.makeCollage();
        art.showCollagePicture();*/

        /*//Replace Tile
        ArtCollage art = new ArtCollage(args[0], 200, 3);
        art.makeCollage();
        // Replace tile at col 1, row 1 with args[1] image
        art.replaceTile(args[1],1,1);
        art.showCollagePicture();*/

        /*//Colorize
        // Creates a collage of 3x3 tiles. Each tile dimension is 200x200 pixels
        ArtCollage art = new ArtCollage(args[0], 200, 3);
        art.makeCollage();
        // Colorize tile at col 2, row 2 to only show the red component
        art.replaceTile(args[1],2,1);
        art.colorizeTile("blue",1,2);
        art.showCollagePicture();*/

        /*//Greyscale
        // Creates a collage of 3x3 tiles. Each tile dimension is 200x200 pixels
        ArtCollage art = new ArtCollage(args[0], 200, 3);
        art.makeCollage();
        // Converts the tile at col 1, row 0 from color to greyscale
        art.greyscaleTile(1, 0);
        art.showCollagePicture();*/


    }
}
