public class ChatBot{

	public int age;
	public String name;
	public String location;
	public String color; 
	public String hobby;
	public String username;

  public ChatBot(String n,String l){
    name = n;
    location = l;
  }


  public String greeting(){
    return("Hi there, what's your name");
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







}