import java.util.Scanner;

public class Array{
  Scanner keyboard = new Scanner(System.in);
  int userInput = 0;
  String[] person = new String [5];
  int personCount = 4;



  while(userInput != 3){
    System.out.println();
    System.out.println("Press 1 to add name to list");
    System.out.println("Press 2 to show all names in list");
    System.out.println("Press 3 to exit");

    String input = keyboard.nextLine();
    if (input == "1"){
      System.out.println("Please enter the name you would like to add")
    }
  }
}