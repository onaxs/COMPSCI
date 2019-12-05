// Chatbot program that learns the user's name, answers simple questions, and does math.
// Xano Sweeting 2019-11-22
//
// Usage:
//     javac ChatBot.java && java ChatBot

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;


public class Chatbot {
  // Info about the bot (static after class init)
  private String bot_name;
  private String bot_origin;
  private int bot_age = 16;
    
  // Info about the person chatting with the bot (updated via user msgs)
  private String user_name = "Mr. mystery person";
  private String user_place = "mystery place";

  // Constructor
  public Chatbot() {
    bot_name = "Xano";
    bot_origin = "New York";
    bot_age = 16;
  }

  /* **************************************************** */
  // Message Parsing Helpers

  // given a string and a list of substring patterns to look for
  // return true of any of the patterns are in the string
  private Boolean matches(String message, String ... patterns) {
    // for each pattern we're looking for in the list of possible patterns
    for (String pattern: patterns) {
      // if the pattern is present in the message, return true
      if (message.indexOf(pattern) > -1) {
        return true;
      }
    }
    // otherwise no patterns matched, return false
    return false;
  }

  // given a string containing some ints, return a list of the ints
  private List<Integer> parseNumbers(String message) {
    // e.g. "345xyz 346.1 989+343 2"
    //  -> [345, 346, 1, 989, 343, 2]
    List<Integer> list = new ArrayList<Integer>();

    // scan the message and split by any characters that arent digits
    // see: https://stackoverflow.com/a/22936255/2156113
    Scanner line = new Scanner(message);
    line.useDelimiter("\\D+");

    // loop through and add each int to the list
    while (line.hasNextInt()) {
      list.add(line.nextInt());
    }
    return list;
  }

  /* **************************************************** */
  // Handlers for the different types of messages

  // Hello, my name is <username>.                -> "Hello <username>. Nice to meet you."
  private String parseUserNameStatement(String message) {
    if (matches(message, "my name is ", "I'm called ", "you can call me ")) {
      // take the last word in the message and save it as their name
      // (punctuation is already chopped off at the beginning of parse())
      user_name = message.substring(message.lastIndexOf(" ") + 1);

      return "Hello " + user_name + ". Nice to meet you.";
    }
    return null;
  }

  // What is your name?                           -> <name>
  // Can I have your name please?                 -> <name>
  // Is your name ____?                           -> Yes/No
  private String parseBotNameQuestion(String message) {
    if (message.startsWith("is your name ")) {
      if (matches(message, bot_name.toLowerCase())) {
        return "Yes.";
      } else {
        return "No.";
      }
    }
    if (matches(message, "your name", "what should I call you")) {
      return "My name is " + bot_name + ".";
    }
    return null;
  }

  // How old are you?                             -> <age>
  // What's your age?                             -> <age>
  // Are you ___ years old?                       -> Yes/No
  private String parseBotAgeQuestion(String message) {
    if (matches(message, "old are you", "your age")) {
      return "I am " + bot_age + " years old.";
    }
    if (matches(message, "years old") && matches(message, "are you")) {
      int asked_age = parseNumbers(message).get(0);
      if (bot_age == asked_age) {
        return "Yes.";
      } else {
        return "No.";
      }
    }
    return null;
  }

  // Where are you from?                          -> <location>
  // Where were you born?                         -> <location>
  // Are you from <location>?                     -> Yes/No
  private String parseBotOriginQuestion(String message) { 
    if (matches(message, "where are you from", "where were you born")) {
      return "I am from " + bot_origin + ".";
    }
    if (matches(message, "are you from ")) {
      if (matches(message, bot_origin.toLowerCase())) {
        return "Yes.";
      } else {
        return "No.";
      }
    }
    return null;
  }

  // What is <num> <op> <num>?                    -> <answer>
  // What is the answer of <num><op><num>?        -> <answer>
  // Can you tell me what <num> <op> <num> is?    -> <answer>
  private String parseMathQuestion(String message) {
    List<Integer> nums = parseNumbers(message);
    int a, b;

    // math questions must have exactly two integers in them
    if (nums.size() == 2) {
      a = nums.get(0);
      b = nums.get(1);
    } else {
      // otherwise return null, we cant handle it as a math question.
      return null;
    }
    
    // handle addition
    if (matches(message, " plus ", "+")) {
      return "It is " + (a + b) + ", " + user_name + ".";
    };

    // handle subtraction
    if (matches(message, " minus ", "-")) {
      return "It is " + (a - b) + ", " + user_name + ".";
    }

    // handle multiplication
    if (matches(message, " times ", " multiplied by ", "*")) {
      return "It is " + (a * b) + ", " + user_name + ".";
    }

    // handle division
    if (matches(message, " divided by ", "/")) {
      return "It is " + (a / b) + ", " + user_name + ".";
    }
    
    return null;
  }

  // What is ____?                                -> "Not sure..."
  private String parseWhatQuestion(String message) {
    if (message.startsWith("what ")) {
      return "You know I'm not allowed to answer that, " + user_name + ".";
    }
    return null;
  }

  // Uknown message                               -> random funny thing
  private String parseUnknownMessage(String message) {
    // handle unknown mesage by returning random funny response
    
    String[] random_funny_messages = {
      // lets play doctor
      "And how does that make you feel?",
      "Can you tell me a bit more about that?",
      "And have you talked to your spouse about this?",

      // lets play dumb
      "Dumb it down a bit please, I'm not quite smart enough to understand that sort of thing yet...",
      "You're really trying to push my intelligence limits...",
      "Thank you very much for that info.",
      
      // lets be a snarky little robot
      "Can we get back on topic, please?",
      "And why do you think that's relevant?",
      "Why do you think I'd care about that?"
    };

    java.util.Random random = new java.util.Random();
    int random_idx = random.nextInt(random_funny_messages.length);
    return random_funny_messages[random_idx];
  }

  // Goodbye message                            -> System.exit(0)
  private void parseGoodbyeStatement(String message) {
    if (message.startsWith("goodbye") || message.startsWith("bye ")) {
      System.out.println("Goodbye, " + user_name + ".");
      System.exit(0);
    }
  }

  /* **************************************************** */
  // higher level method that parses the user's message
  // and returns a response using the first handler that matches
  public String parse(String message) {
    // Detect if their message is a question or statemnt
    Boolean is_question = message.endsWith("?");
    Boolean is_statement = message.endsWith(".");
    if (is_question || is_statement) {
      // Strip off trailing punctuation to make it easier to parse later
      message = message.substring(0, message.length() - 1);
      // Convert it to lowercase to make it easier to parse later
      message = message.toLowerCase();
    } else {
      // Force the user to be explicit rather than trying to guess
      return "Please end your lines with either a period or question mark.";
    }

    // Try all of the various message handlers in order.
    // Return the first one that has a non-null response.
    String response = null;

    // Handle Questions
    if (is_question) {
      // What is your name?                           -> <name>
      // Can I have your name please?                 -> <name>
      response = parseBotNameQuestion(message);
      if (response != null) {return response;}

      // How old are you?                             -> <age>
      response = parseBotAgeQuestion(message);
      if (response != null) {return response;}

      // Where are you from?                          -> <location>
      // Are you from <location>?                     -> Yes/No
      response = parseBotOriginQuestion(message);
      if (response != null) {return response;}

      // What is <num> <op> <num>?                    -> <answer>
      // What is the answer of <num> <op> <num>?      -> <answer>
      // Can you tell me what <num> <op> <num> is?    -> <answer>
      response = parseMathQuestion(message);
      if (response != null) {return response;}

      // What is ____?                                -> "Not sure..."
      response = parseWhatQuestion(message);
      if (response != null) {return response;}
    }

    // Handle statements
    else {
      // Hello, my name is <username>.                -> "Hello <username>. Nice to meet you."
      response = parseUserNameStatement(message);
      if (response != null) {return response;}

      // Goodbye.                                     -> System.exit(0)
      parseGoodbyeStatement(message);
    }

    // Handle unknown messages
    return parseUnknownMessage(message);
  }



  public String response(String message) {
    return this.parse(message);
  }

  public String greeting() {
    return "Welcome to the chatbot program, to get started, type: \n  Hello, my name is <your name>.";
  }

}
    