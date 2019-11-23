import java.util.Scanner;

public class ChatBot {

	public int age;
	public String name = "Dobby";
	public String location;
	public String color; 
	public String hobby;
	public String username;

  // Constructor
  public ChatBot(String n, String l) {
    name = n;
    location = l;
  }

  // Response Generating Helpers
  private String greeting() {
    return "How may I be of assitance master?";
  }

  private String nameGreeting(String message) {
    return "Hi " + getUsername() + " my name is Dobby";
  }

  private String goodBye(String message) {
    return "farewell master " + getUsername();
  }

  // Message Parsing Helpers
  private Boolean isQuestion(String message) {
    return message.contains("?");
  }

  // Handlers for the different types of messages
  private String handleHelloGreeting(String message) {
    if (message.contains("Hello") || message.contains("Hi") && !isQuestion(message)) {
      username = parseUsername(message);

      return "Hello " + username + ". Nice to meet you.";
    }
  }

  private String howQuestionHandler(String message) {
    if (message.contains("old") && message.contains("you")) {
      return "I was created at the start of this century";
    }
  }

  private String whereQuestionHandler(String message) { 
    if (message.contains("you")) {
      if (message.contains("go")) {
        return "I return to ... the cloud";
      }
      else if (message.contains("live")) {
        return "I live in ... the cloud";
      }
      else if (message.contains("from")) {
        return "I am from Hogwarts";
      }
      else if (message.contains("are")) {
        return "I am currently in the cloud above you";
      }
    }
  }

  private String handleNameQuestion(String message) {
    if (message.contains("name")
        || (message.contains("call")
            && message.contains("you"))) {

      return "My name is Dobby the elf";
    }
  }

  private String handleMathQuestion(String message) {
    String operator = parseMathOperator(message);
    Integer firstNum = parseMathNumber(message);
    Integer secondNum = parseMathNumber(message);
    Integer answer = null;

    if (message.contains(" plus ") || message.contains(" + ")) {
      Integer operand1 = message.
      return "+";
    }
    else if (message.contains(" minus ") || message.contains(" - ")) {
      return "-";
    }
    else if (message.contains("times") || message.contains("multiplied by") || message.contains(" x ") || message.contains(" x ")) {
    }
    else if (message.contains("divided by") || message.contains("/")) {
    }
    
    if (answer != null) {
      return "It is " + answer + ".";
    } else {
      return null;
    }
  }

  // higher level method that parses the user's message
  // and returns a response using the first handler that matches
  public String parse(String message) {
    Optional<String> response;

    // try all of the various message handlers in order

    response = handleHelloGreeting(message);
    if (response) {return response;}

    

    // What is your name? / Can I have your name please?
    response = parseNameQuestion(message);
    if (response) {return response};

    // How old are you?
    response = parseWhatAgeQuestion(message);
    if (response) {return response};

    // Where are you from? / Are you from ____?
    response = parseWhereFromQuestion(message);
    if (response) {return response};

    // What is <num> <op> <num>
    response = handleMathQuestion(message);
    if (response) {return mathResponse;}

    // What is ____?
    response = parseWhatIsQuestion(message);
    if (response) {return response};

    // if none, succeed, attempt to distract them instead
    return handleUknownQuestion(message);
  }

  public static void main(String[] args) {
	  ChatBot bot = new ChatBot();
    Scanner scanner = new Scanner(System.in);

    // Print initial greeting message
    System.out.println(
      "Welcome to the chatbot program, type " +
      "'Hello, my name is abcdef.'" + 
      " to get started!"
    );

    while (true) {
      // 1. Get message from user
      String message = scanner.next();

      // 2. Process the message and get a response
      String response = bot.parse(message);

      // 3. Print the response and repeat
      System.out.println(response);
    }
  }
}