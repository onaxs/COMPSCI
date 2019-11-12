public class nestedForLoops{
   
  public static void method1(){
    for(int r = 1; r<=5; r++){
      for(int c = 1;c<=r+2;c++){
        System.out.print(c+" ");
      }
    System.out.println();

    }
  }
  public static void method2(){
    for(int r = 1; r <= 9; r++){
      for(int c = r; c <= r*9; c=c+r){
        System.out.print(c + " ");
      }
    System.out.println();
    }
  }
  public static void method3(){
    for(int r = 1; r <= 9; r++){
      for(int c = 1; c <= 10; c++){
        if(c<=r){
          System.out.print("+");
        }
        else{
          System.out.print("*");
        }
      }
    System.out.println();
    }
  }
}
