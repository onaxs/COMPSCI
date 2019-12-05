public class WholeNum extends Fraction{

  public WholeNum(){super();}
  public WholeNum(int n){super(n,1);}

  public void setValue(int n){setNum(n);}

  public Fraction toFrac(){return this;}

  public String toString(){return "" + this.getNum();}
  
}