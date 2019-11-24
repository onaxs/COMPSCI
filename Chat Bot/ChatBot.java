import java.util.Scanner;
import java.util.Random;

public class ChatBot {
  // Info about the bot (never changed)
  private String bot_name;
  private String bot_origin;
  private int bot_age = 16;
    
  // Info about the person chatting with the bot
  // (updated once we learn their name)
  private String user_name = "Mystery person";

  // Constructor
  public ChatBot(String n, String o, int a) {
    bot_name = n;
    bot_origin = o;
    bot_age = a;
  }

  /* **************************************************** */
  // Message Parsing Helpers
  private Boolean isQuestion(String message) {
    return message.contains("?");
  }

  // given a string and a list of substring patterns
  // look for the first occurence of each pattern and return the index of the first match
  // if none are found, return null
  private Integer findOperator(String message, String ... patterns) {
    for (String pattern: patterns) {
      int idx = message.indexOf(pattern);
      if (idx > 0) {return idx;}
    }
    return null;
  }

  // given a string containing some ints, return a list of the ints
  private int[] parseNumbers(String message) {
    // e.g. "123 abc 345 def 346. 989"
    //  -> [123, 345, 346, 989]
    Scanner scanner = new Scanner(message);
    List<Integer> list = new ArrayList<Integer>();
    while (scanner.hasNextInt()) {
        list.add(scanner.nextInt());
    }
    return list;
  }

  /* **************************************************** */
  // Handlers for the different types of messages

  // Hello, my name is <username>.                -> "Hello <username>. Nice to meet you"
  private String parseUserNameStatement(String message) {
    if (message.contains("Hello") || message.contains("Hi") && !isQuestion(message)) {
      // TODO: parse the users name
      user_name = "Mr. Teacher person";

      return "Hello " + user_name + ". Nice to meet you.";
    }
    return null;
  }

  // What is your name?                           -> <name>
  // Can I have your name please?                 -> <name>
  private String parseBotNameQuestion(String message) {
    if (message.contains("name")
        || (message.contains("call")
            && message.contains("you"))) {

      return "My name is Dobby the elf";
    }
    return null;
  }

  // How old are you?                             -> <age>
  private String parseBotAgeQuestion(String message) {
    if (message.contains("old") && message.contains("you")) {
      return "I was created in 2003 ... so 16.";
    }
    return null;
  }

  // Where are you from?                          -> <location>
  // Are you from <location>?                     -> Yes/No
  private String parseBotOriginQuestion(String message) { 
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
    return null;
  }

  // What is <num> <op> <num>?                    -> <answer>
  // What is the answer of <num> <op> <num>?      -> <answer>
  // Can you tell me what <num> <op> <num> is?    -> <answer>
  private String parseMathQuestion(String message) {
    Integer answer = null;
    Integer op_idx = null;
    int[] nums = parseNumbers(message);

    // math questions must have exactly two integers in them, otherwise fail early
    if (nums.length != 2) {return null;}

    // handle addition
    if (findOperator(message, " plus ", " + ")) {
      return "It is " + (nums[0] + nums[1]) + ".";
    };

    // handle subtraction
    if (findOperator(message, " minus ", " - ")) {
      return "It is " + (nums[0] - nums[1]) + ".";
    }

    // handle multiplication
    if (findOperator(message, " times ", " multiplied by ", " * ", " x ")) {
      return "It is " + (nums[0] * nums[1]) + ".";
    }

    // handle division
    if (findOperator(message, " divided by ", " / ")) {
      return "It is " + (nums[0] / nums[1]) + ".";
    }
    
    // otherwise return null response so we continue down the list in parse()
    // and try the next possible handler
    return null;
  }

  // What is ____?                                -> "Not sure..."
  private String parseWhatQuestion(String message) {
    // handle random question with suggestion to google it
    if (message.startsWith("What ")) {
      return "Say 'what?' again motherfucker, I dare you!";
    }
    return null;
  }

  // Uknown message                               -> random funny thing
  private String parseUnknownMessage(String message) {
    // handle unknown mesage by returning random funny response
    
    String[] random_funny_messages = {
      "There’s a passage I got memorized.",
      "The path of the righteous man is beset on all sides by the inequities of the selfish and the tyranny of evil men.",
      "He is truly his brother’s keeper and the finder of lost children.",
      "But that shit ain’t the truth.",
      "English motherfucker, do you speak it?",
    };

    java.util.Random random = new java.util.Random();
    int random_idx = random.nextInt(random_funny_messages.length);
    return random_funny_messages[random_idx];

    // return "There’s a passage I got memorized. Ezekiel 25:17. “The path of the righteous man is beset on all sides by the inequities of the selfish and the tyranny of evil men. Blessed is he who, in the name of charity and good will, shepherds the weak through the valley of the darkness, for he is truly his brother’s keeper and the finder of lost children. And I will strike down upon thee with great vengeance and furious anger those who attempt to poison and destroy My brothers. And you will know I am the Lord when I lay My vengeance upon you.” Now… I been sayin’ that shit for years. And if you ever heard it, that meant your ass. You’d be dead right now. I never gave much thought to what it meant. I just thought it was a cold-blooded thing to say to a motherfucker before I popped a cap in his ass. But I saw some shit this mornin’ made me think twice. See, now I’m thinking: maybe it means you’re the evil man. And I’m the righteous man. And Mr. 9mm here… he’s the shepherd protecting my righteous ass in the valley of darkness. Or it could mean you’re the righteous man and I’m the shepherd and it’s the world that’s evil and selfish. And I’d like that. But that shit ain’t the truth. The truth is you’re the weak. And I’m the tyranny of evil men. But I’m tryin’," + user_name + ". I’m tryin’ real hard to be the shepherd."
  }

  /* **************************************************** */
  // higher level method that parses the user's message
  // and returns a response using the first handler that matches
  public String parse(String message) {
    String response = null;

    // Try all of the various message handlers in order

    // Hello, my name is <username>.                -> "Hello <username>. Nice to meet you"
    response = parseUserNameStatement(message);
    if (response != null) {return response;}

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

    // Uknown message                               -> random funny thing
    return parseUnknownMessage(message);
  }

  /* **************************************************** */
  public static void main(String[] args) {
    ChatBot bot = new ChatBot("Xano", "New York", 16);
    Scanner scanner = new Scanner(System.in);

    // Print initial greeting message (is this needed?)
    System.out.println("Welcome to the chatbot program, type 'Hello, my name is abcdef.' to get started!");

    while (true) {
      // 1. Get message from user
      String message = scanner.nextLine();

      // 2. Process the message and get a response
      String response = bot.parse(message);

      // 3. Print the response and repeat
      System.out.println(response);
    }
  }
}
