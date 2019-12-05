public class Fraction{

  private int num;
  private int den;

  public Fraction(){num = 0; den = 1;}

  public Fraction(int n, int d){num = n; den = d;}

  public int getNum(){return num;} 			

  public int getDen(){return den;

  public Fraction GetReciprocal(){Fraction reciprocal = new Fraction(this.den,this.num); return reciprocal;}

  public void setValue(int n, int d){num = n; den = d;}	

  public String toString(){return num + "/" + den;}

  public double getValue(){return (double)num/den;}
  
  public Boolean equals(Fraction other){if (num == other.num && den == other.den) return true;}	

  public void multiply(Fraction other){num = num*other.num; den = den*other.den;}

  public void divide(Fraction other){num = num*other.den; den = den*other.num;}

  public void add(Fraction other){num = num*other.den + other.num*den; den = den*other.den;}

  public void subtract(Fraction other){num = num*other.den - other.num*den; den = den*other.den;} 

  public int gcd(int a, int b){int answer = 1; for(int i = Math.min(Math.abs(a),Math.abs(b));i >= 1;i--) {if(a % i == 0 && b % i == 0){answer = i; break;}}return answer;}


  public void simplify(){num /= gcd(num,den); den /= gcd(num,den);}
}