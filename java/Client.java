
import java.io.*;
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
public class Client{
  public static void main(String[] args)throws IOException   {
    RemoteControl control = new RemoteControl();
    Light light1 = new Light();
    Command lightsOn = new LightOnCommand(light1);
    Command lightsOff = new LightOffCommand(light1);

    //switch on
  control.setCommand(lightsOn);
    control.pressButton();

    //switch off
    control.setCommand(lightsOff);
    control.pressButton();
	System.out.println("\n Command For ON/OFF LIGHT is Processs !\n");
  }
}