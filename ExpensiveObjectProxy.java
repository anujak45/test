import java.io.*;
import java.lang.*;

class Student {
   private String rollNo;
   private String name;
   
   public String getRollNo() {
      return rollNo;
   }
   
   public void setRollNo(String rollNo) {
      this.rollNo = rollNo;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
}

 class StudentView {
   public void printStudentDetails(String studentName, String studentRollNo){
      System.out.println("Student: ");
      System.out.println("Name: " + studentName);
      System.out.println("Roll No: " + studentRollNo);
   }
}



 class StudentController {
   private Student model;
   private StudentView view;

   public StudentController(Student model, StudentView view){
      this.model = model;
      this.view = view;
   }



   public void setStudentName(String name){
      model.setName(name);		
   }

   public String getStudentName(){
      return model.getName();		
   }

   public void setStudentRollNo(String rollNo){
      model.setRollNo(rollNo);		
   }

   public String getStudentRollNo(){
      return model.getRollNo();		
   }

   public void updateView(){				
      view.printStudentDetails(model.getName(), model.getRollNo());
   }	
}


 interface Command{
  public void execute();
}
 class LightOnCommand implements Command{
  //reference to the light
  Light light;
  public LightOnCommand(Light light){
    this.light = light;
  }
  public void execute(){
    light.switchOn();
  }
} 
 class LightOffCommand implements Command{
  //reference to the light
  Light light;
  public LightOffCommand(Light light){
    this.light = light;
  }
  public void execute(){
    light.switchOff();
  }
}
 class Light{
  private boolean on;
  public void switchOn(){
    on = true;
  }
  public void switchOff(){
    on = false;
  }
} class RemoteControl{
  private Command command;
  public void setCommand(Command command){
    this.command = command;
  }
  public void pressButton(){
    command.execute();
  }
}
 

interface Notification {
    void notifyUser();
}
 class SMSNotification implements Notification {
 
  
    public void notifyUser()
    {
        // TODO Auto-generated method stub
        System.out.println("Sending an SMS notification");
    }
}


class EmailNotification implements Notification {
 
   
    public void notifyUser()
    {
      
        System.out.println("Sending an e-mail notification");
    }
}

 class PushNotification implements Notification {
 
   
    public void notifyUser()
    {
        System.out.println("Sending a push notification");
    }
}
 class NotificationFactory 
{
	public Notification createNotification(String channel)
    	{
        		if (channel == null || channel.isEmpty())
		return null;
        		if ("SMS".equals(channel))
		{
            			return new SMSNotification();
       		 }
      		  else if ("EMAIL".equals(channel))
		{
           			 return new EmailNotification();
      		}
        		else if ("PUSH".equals(channel))
		{
            			return new PushNotification();
        		}
        			return null;
   	 }
}
interface ExpensiveObject
{
    void process();
}
class ExpensiveObjectImpl implements ExpensiveObject
{

    public ExpensiveObjectImpl()
{
        heavyInitialConfiguration();
    }
    
    @Override
    public void process()
{
       // LOG.info("processing complete.");
	System.out.println("processing complete.");
    }
    
    private void heavyInitialConfiguration()
{
        //LOG.info("Loading initial configuration...");
	System.out.println("Loading initial configuration...");
    }
    
}
class ExpensiveObjectProxy implements ExpensiveObject
{
	private static ExpensiveObject object;
	
    public void process()
	{
        if (object == null)
	{
            object = new ExpensiveObjectImpl();
       	 }
        object.process();
   	 }

      private static Student retriveStudentFromDatabase(){
      Student student = new Student();
      student.setName("Robert");
      student.setRollNo("10");
      return student;
   }

public static void main(String[] args)throws IOException
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	int ch,ch1;
	do
	{
		System.out.println("\n Select options from Below to Run The Code : \n");
		System.out.println("\n 1. Proxy Pattern \n 2. Factory Pattern \n 3. Command Pattern \n 4. MVC Pattern \n");
		ch=Integer.parseInt(br.readLine());
		switch(ch)
		{
			case 1:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE PROXY PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				ExpensiveObject object = new ExpensiveObjectProxy();
  				object.process();
    				object.process();
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				break;
			case 2:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE FACTORY PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				NotificationFactory notificationFactory = new NotificationFactory();
        				Notification notification = notificationFactory.createNotification("SMS");
        				notification.notifyUser();
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				break;

			case 3:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE COMMAND PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				RemoteControl control = new RemoteControl();
    				Light light1 = new Light();
    				Command lightsOn = new LightOnCommand(light1);
   				Command lightsOff = new LightOffCommand(light1);
				control.setCommand(lightsOn);
    				control.pressButton();
    				control.setCommand(lightsOff);
    				control.pressButton();
				System.out.println("\n Command For ON/OFF LIGHT is Processs !\n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				break;
			case 4:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE MVC PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				Student model  = retriveStudentFromDatabase();
				StudentView view = new StudentView();
				StudentController controller = new StudentController(model, view);
				controller.updateView();
				controller.setStudentName("John");
				controller.updateView();
				break;
		}
		System.out.println("\n  ********** For Repeat Press '1' *********** \n" );
		ch1=Integer.parseInt(br.readLine());
	}while(ch1==1);
    
}
}