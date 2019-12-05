public class Rectangle extends Quadilateral {

  static int numOfRects;
  private int length = s2;
  private int width = s1;

  public Rectangle() {
    super();
    numOfRects++;
  }

  public Rectangle(double w, double l) {
    super(w,l,w,l);
    numOfRects++;
  }


  public int getNumOfRects() {
    return numOfRects;
  } 	

  public double getWidth() {
    return getS1();
  } 			

  public double getLength() {
    return getS2();
  }  	
  
  public void setWidth(double w) {
    setS1(w);
    setS3(w);
  }

  public void setLength(double l) {
    setS2(l);
    setS4(l);
  }

  public double getArea() {
    return s1*s2;
  } 


  public boolean equals(Rectangle other)	{
    if((this.s1 = other.s1 && this.s2 == other.s2) || (this.s1 =    other.s2 && this.s2 == other.s1)) {
      return true;
    }
    else return false;
  }

  public String toString() {
    return s1 + " x " + s2 + " Rectangle; Perimeter = " + (s1*2+s2*2) + "; Area = " + getArea();
  } 

}