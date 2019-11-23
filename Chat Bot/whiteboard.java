  public String whatResponse(String phrase) {
    if (phrase.contains("name")
        || (phrase.contains("call") && phrase.contains("you"))) {
          
      return "My name is Dobby the elf";
    }
  }

  public extractNumbers(String message) {