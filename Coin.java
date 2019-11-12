public class Coin{
  boolean faceValueHead;
  static int numOfCoins = 0;

  Coin(){
    toss();
    numOfCoins++;
  }

  Coin(boolean n){
    faceValueHead=n;
    numOfCoins++;
  }

  public boolean isHead(){
    if(faceValueHead == true){
      return true;
    }
    else{
      return false;
    }
  }

  public boolean toss(){
    int random = (int)(Math.random()*11);
    if(random < 5){
      faceValueHead = true;
    }
    else{
      faceValueHead = false;
    }
    return faceValueHead;
  }

  public String toString(){
    if(faceValueHead == true){
      return "True";
    }
    else{
      return "False";
    } 
  }

  public boolean equals(Coin other){
    if (faceValueHead == other.faceValueHead){
      return true;
    }
    else{
      return false;
    }
  }

  public static int getNumOfCoins(){
    return numOfCoins;
  }
}