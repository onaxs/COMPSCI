/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
    /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    //testGreenOnly();
    //testNegate();
    //testGrayscale();
    //testEnhanceFish();
    //testEdgeDetection();
    
    //testMirrorVertical();
    //testMirrorDiagonal();
    //testMirrorTemple();
    //testMirrorArms();
    //testCopyGull();    
    //testCreateCollage();
    
    //testChromakey();
    //testDecode();
    //testEncodeGreen();
  }
  
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test greenOnly */
  public static void testGreenOnly()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.greenOnly();
    beach.explore();
  }
  
  /** Method to test negate */
  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  
  /** Method to test grayscale */
  public static void testGrayscale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
  }
  
  /** Method to test enhanceFish */
  public static void testEnhanceFish()
  {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.enhanceFish();
    water.explore();
  }
  
    /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection();
    swan.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorDiagonal */
  public static void testMirrorDiagonal()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test mirrorArms */
  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }
  
  /** Method to test copyGull */
  public static void testCopyGull()
  {
    Picture gull = new Picture("seagull.jpg");
    gull.explore();
    gull.copyGull();
    gull.explore();
  }
  
  /** Method to test the createCollage method */
  public static void testCreateCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test chromakey */
  public static void testChromakey()
  {
    Picture mark = new Picture("blue-mark.jpg");
    Picture moon = new Picture("moon-surface.jpg");
    mark.explore();
    moon.explore();
    mark.chromakey(moon);
    mark.explore();
  }
  
  /** Method to test decode */
  public static void testDecode()
  {
    
    Picture secret = new Picture("secret.bmp");
    secret.explore();
    secret.decode();
    secret.explore();
  }
  
  /** Method to test encodeGreen */
  public static void testEncodeGreen()
  {
    
    Picture beach = new Picture("beach.jpg");
    Picture text = new Picture("text.bmp");
    beach.explore();
    text.explore();
    beach.encodeGreen(text);
    beach.write("encodeGreen.bmp");
    beach.explore();
  }
}