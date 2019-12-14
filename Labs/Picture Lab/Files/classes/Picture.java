import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the red and blue to 0 */
  public void greenOnly()
  {
    //add your code here
  }
  
  /** Method to set the red,green,blue to (255 - its original value)  */
  public void negate()
  {
    //add your code here
  }
  
  /** Method to set all red,green,blue to the average of the three values  */
  public void grayscale()
  {
    //add your code here
  }
  
  /** Method to make the shape of the fish stand out  */
  public void enhanceFish()
  {
    //add your code here
  }
  
  /** Method to highlight the edges of object in a picture by checking large changes in color */
  public void edgeDetection()
  {
    //add your code here
  }
  
  
  /** Method to mirror the picture around a vertical line in the center of the picture from left to right */
  public void mirrorVertical()
  {
    //add your code here
  }
  
  /** Method to mirror around a diagonal line from bottom left to top right */
  public void mirrorDiagonal()
  {
    //add your code here
  }
    
  /** Method to mirror just part of a picture of a temple to fix the broken part of the temple */
  public void mirrorTemple()
  {
    //add your code here
  }
  
  /** Method to mirror just part of a picture of a snowman, so that it will have four arms instead of two */
  public void mirrorArms()
  {
    //add your code here
  }
  
  /** Method to copy the gull in the picture to another location of the picture */
  public void copyGull()
  {
    //add your code here
  }
  
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    //add your code here
  }
   
  
  /** Method to replace the blue background with the pixels in the newBack picture
    * @param newBack the picture to copy from
    */
  public void chromakey(Picture newBack)
  {
    //add your code here
  }
  
  /** Method to decode a message hidden in the red value of the current picture */
  public void decode()
  {
    //add your code here
  }
  
  /** Hide a black and white message in the current picture by changing the green to even and then setting it to odd if the message pixel is black 
    * @param messagePict the picture with a message
    */
  public void encodeGreen(Picture messagePict)
  {
    //add your code here
  }
} 
