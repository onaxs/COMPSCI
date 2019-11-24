//testing class built by Huo Chen; Last Update 11/5/2018
/*
public class CoinTester
{
  public static void main(String[] args)
  {
    boolean checkTrue = false;
    boolean checkFalse = false;
    
    System.out.println("Constructing a Coin called c1 using no-arges constructor...");
    Coin c1 = new Coin();
    System.out.println("PASSED: no-arges constructor");
    System.out.println();
    
    System.out.println("Constructing a Coin called c2 using parameterized constructor...");
    Coin c2 = new Coin(true);
    System.out.println("PASSED: parameterized constructor");
    System.out.println();
       
    System.out.println("Checking c2 instant variables");
    if(c2.isHead()){
      System.out.println("PASSED: parameterized constructor instant variables");
    }else{
      System.out.println("FAILED!!!: parameterized constructor instant variables");
    }
    System.out.println();
    
    System.out.println("Checking toss method...");
    checkTrue = false;
    checkFalse = false;
    
    for(int i =0; i<=100; i++)
    {
      if (c1.toss() && c1.isHead()){
        checkTrue = true;
      }else if(!c1.toss() && !c1.isHead()){
        checkFalse = true;
      }
    }
    if(checkTrue && checkFalse){
      System.out.println("PASSED: Toss generates random results");
    }else{
      System.out.println("FAILED!!!: Toss Does Not generates random results");
    }
    System.out.println();
    
    System.out.println("Checking toString method...");
    checkTrue = false;
    checkFalse = false;
    for(int i =0; i<=100; i++)
    {
      c1.toss();
      if (c1.toString() == "Head"){
        checkTrue = true;
      }else if(c1.toString() == "Tail"){
        checkFalse = true;
      }else{
        System.out.println("FAILED!!!: toString method generates unwanted result");
        break;
      }
    }
    if(checkTrue && checkFalse){
      System.out.println("PASSED: toString method passed");
    }else{
      System.out.println("FAILED!!!: toString method failed");
    }
    System.out.println();
    
    Coin c3 = new Coin(true);
    Coin c4 = new Coin(false);
    System.out.println("Checking equals method");
    if(c2.equals(c3) && !c2.equals(c4))
    {
      System.out.println("PASSED: equals method");
    }else{
      System.out.println("FAILED!!!: equals method");
    }
    System.out.println();
    
    System.out.println("Checking getNumOfCoins method");
    if(Coin.getNumOfCoins()==4)
    {
      System.out.println("PASSED: add method");
    }else{
      System.out.println("FAILED!!!: add method");
    }
    System.out.println();
    
    System.out.println("END of TEST");
  }
}
