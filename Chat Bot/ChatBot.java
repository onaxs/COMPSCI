import java.util.Scanner;

public class ChatBot {
  // Info about the bot (never changed)
  private String bot_name = "Xano";
  private String bot_origin = "New York";
	private int bot_age = 16;
	
  // Info about the person chatting with the bot
  // (updated once we learn their name)
	public String user_name = "Mystery person";

  // Constructor
  public ChatBot(String n, String l) {
    name = n;
    location = l;
  }

  /* **************************************************** */
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

  /* **************************************************** */
  // Message Parsing Helpers
  private Boolean isQuestion(String message) {
    return message.contains("?");
  }

  // given a string and a list of substring patterns
  // look for the first occurence of each pattern and return the index of the first match
  // if none are found, return null
  private Optional<int> findOperator(String message, String ... patterns) {
    for (String pattern: patterns) {
      int idx = message.indexOf(pattern);
      if (idx > 0) {return idx;}
    }
    return null;
  }

  // return the number in the word before op_idx in message
  private int parseNumBefore(String message, int op_idx) {
    // 1. get position of last space before op_idx 
    // 2. get the substring between last_space_idx and op_idx
    // 3. return parseInt(last word)
    int last_space_idx = message.lastIndexOf(" ", op_idx);
    String number_str = message.substring(last_space_idx, op_idx);
    return Integer.parseInt(number_str);
  }

  // return the number in the word after op_idx
  private int parseNumAfter(String message, int op_idx) {
    // 1. Find first space after op_indx
    // 2. get substring of op_idx to first space after it
    // 3. get integer of substring
    int first_space_idx = message.indexOf(" ", op_idx);
    String number_str = message.substring(op_idx, first_space_idx);
    return Integer.parseInt(number_str);
  }

  /* **************************************************** */
  // Handlers for the different types of messages
  private String handleHelloGreeting(String message) {
    if (message.contains("Hello") || message.contains("Hi") && !isQuestion(message)) {
      username = parseUsername(message);

      return "Hello " + username + ". Nice to meet you.";
    }
  }

  private String howQuestionHandler(String message) {
    if (message.contains("old") && message.contains("you")) {
      return "I was created in 2003 ... so 16.";
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
    int answer;
    int op_idx;

    // handle addition
    op_idx = findOperator(message, " plus ", " + ");
    if (op_idx) {
      answer = parseNumBefore(message, op_idx) + parseNumAfter(message, op_idx);
    };

    // handle subtraction
    op_idx = findOperator(message, " minus ", " - ");
    if (op_idx && answer != null) {
      answer = parseNumBefore(message, op_idx) - parseNumAfter(message, op_ix);
    }

    // handle multiplication
    op_idx = findOperator(message, " times ", " multiplied by ", " * ", " x ");
    if (op_idx && answer != null) {
      answer = parseNumBefore(message, op_idx) * parseNumAfter(message, op_ix);
    }

    // handle division
    op_idx = findOperator(message, " divided by ", " / ");
    if (op_idx && answer != null) {
      answer = parseNumBefore(message, op_idx) / parseNumAfter(message, op_idx);
    }
    
    // if one of the math expression parsers succeeded and we have an answer
    // return the correctly formatted answer response
    if (answer != null) {
      return "It is " + answer + ".";
    }

    // otherwise return null response so we continue down the list in parse()
    // and try the next possible handler
    return null;
  }

  private String parseWhatQuestion(String message) {
    // handle random question with suggestion to google it
    if (message.startswith("What ")) {
      return "Say 'what?' again motherfucker, I dare you!";
    }
    return null;
  }

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
    Optional<String> response;

    // Try all of the various message handlers in order

    // Hello, my name is <username>.                -> "Hello <username>. Nice to meet you"
    response = parseUserNameStatement(message);
    if (response) {return response;}

    // What is your name?                           -> <name>
    // Can I have your name please?                 -> <name>
    response = parseBotNameQuestion(message);
    if (response) {return response;}

    // How old are you?                             -> <age>
    response = parseBotAgeQuestion(message);
    if (response) {return response;}

    // Where are you from?                          -> <location>
    // Are you from <location>?                     -> Yes/No
    response = parseBotOriginQuestion(message);
    if (response) {return response;}

    // What is <num> <op> <num>?                    -> <answer>
    // What is the answer of <num> <op> <num>?      -> <answer>
    // Can you tell me what <num> <op> <num> is?    -> <answer>
    response = parseMathQuestion(message);
    if (response) {return mathResponse;}

    // What is ____?                                -> "Not sure..."
    response = parseWhatQuestion(message);
    if (response) {return response;}

    // Uknown message                               -> random funny thing
    return parseUnknownMessage(message);
  }

  /* **************************************************** */
  public static void main(String[] args) {
	  ChatBot bot = new ChatBot();
    Scanner scanner = new Scanner(System.in);

    // Print initial greeting message (is this needed?)
    // System.out.println("Welcome to the chatbot program, type 'Hello, my name is abcdef.' to get started!");

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