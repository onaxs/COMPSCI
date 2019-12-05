/*
public class Complex {
  static int numOfColmplex = 0;
  double real;
  double img;

  public Complex () {
    real = 0;
    img  = 0;
    numOfColmplex++;
  }

  public Complex (double real, double img) {
    this.real = real;
    this.img  = img;
    numOfColmplex++;
  }

  public static int getNumOfComplex () { return numOfColmplex; }
  public double getReal () { return real; }
  public double getImg  () { return img; }

  public void setReal (double r) { real = r; }
  public void setImg  (double i) { img = i;  }

  public void add (Complex c) {
    real += c.getReal();
    img  += c.getImg();
  }

  public void subtract (Complex c) {
    real -= c.getReal();
    img  -= c.getImg();
  }

  public void multiply (Complex c) {
    double temp = real;
    real = real * c.getReal() - img * c.getImg();
    img  = temp * c.getImg()  + img * c.getReal();
  }

  public boolean equals (Complex c) { return real == c.getReal() && img == c.getImg(); }

  public String toString() {
    if (img == 0 && real == 0) {
      return "0.0";
    } else if(img == 0) {
      return real + "";
    } else if (real == 0) {
      if(img == 1){
        return "i";
      } else {
          return img + "i";
        }
    } else {
      if (img < 0) {
        if(img == -1) {
          return real + " - i";
        } else {
          return real + " - " + (img*-1) + "i";
        }
      } else {
        if (img == 1) {
          return real + " + i";
        } else {
          return real + " + " + img + "i";
        }
      }
    }
  }
}

*/