spublic class ChatBot{

	public int age;
	public String name = "Dobby";
	public String location;
	public String color; 
	public String hobby;
	public String username;

  public ChatBot(String n,String l){
    name = n;
    location = l;
  }



  public String getUsername(){
    return username;
  }
  
  public void setUsername(String n){
    username = n;
  }

  public void setAge(int a){
    age = a;
  }


  public String greeting(){
    return("How may I be of assitance master?");
  }

  public String nameGreeting(String phrase){
    return "Hi "+getUsername()+" my name is Dobby"
  }

  public String goodBye(String phrase){
    return "farewell master " + getUsername();
  }


  public String howResponse(String phrase){
    if(phrase.contains("old")&&phrase.contains("you")){
      return "I only remember the last few centuries...";
    }
    else if(){
      
    }
  }

  public String whatResponse(String phrase){
    if(phrase.contains("name")||(phrase.contains("call")&&phrase.contains("you"))){
      return "My name is Dobby the elf";
    }
    else if(phrase.contains(" plus ")||phrase.contains("+")||phrase.contains("minus")||phrase.contains("-")||phrase.contains("divided by")||phrase.contains("/"){
    }
  }

  public String whereResponse(String phrase){
    if(phrase.contains("you")){
      if(phrase.contains("go")){
        return "I return to ... the cloud";
      }
      else if(phrase.contains("live")){
        return "I live in ... the cloud";
      }
      else if(phrase.contains("from")){
        return "I am from Hogwarts";
      }
      else if(phrase.contains("are")){
        return "I am currently in the cloud above you";
      }
    }
  }

  public String mathResponse(String phrase){ 
    if(phrase.contains("plus")||phrase.contains("+"){

    }
    else if(phrase.contains("minus")||phrase.contains("-")){

    }
    else if(phrase.contains("times")||phrase.contains("multiplied by")||phrase.contains(" x ")||phrase.contains(" x ")){

    }
    else if(phrase.contains("divided by")||phrase.contains("/")){

    }
  }








}