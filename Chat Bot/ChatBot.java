public class ChatBot{

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


  public String greeting(){
    return("How may I be of assitance master?");
  }

  public String getUsername(){
    return username;
  }
  
  public void setUsername(n){
    username = n;
  }

  public void setAge(a){
    age = a;
  }

  public String howResponse(String phrase){
    if(phrase.contains("old")&&phrase.contains("you")){
      return "I only remember the last few centuries...";
    }
    else if()
  }

  public String whatResponse(String phrase){
    if(phrase.contains("name")||(phrase.contains("call")&&phrase.contains("you"))){
      return "My name is Dobby the elf";
    }
  }

  public String whereResponse(String phrase){
    if(phrase.contains("you")&&phrase.contains("do")){
      if(phrase.contains("go")){
        return "I return to ... the cloud";
      }
      else if(phrase.contains("live")){
        return "I live in ... the cloud";
      }
    }
  }

  public String goodBye(String phrase){
    return "farewell master " + getUsername();
  }







}