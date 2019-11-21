import java.util.Scanner;
public class ChatbotRunner
{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    
    //Add your information directly to the Chatbot instant variables
    Chatbot me = new Chatbot();
    
    System.out.println(me.greeting());
    
    String answer = "";
    String question;
    while(!answer.toLowerCase().trim().equals("bye")){
      question = keyboard.nextLine();
      System.out.println("User: " + question);
      System.out.println("Bot: " + me.response(question));
      System.out.println();
    }
  }
}