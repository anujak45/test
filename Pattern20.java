import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;



class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;
   /* lots of memory consumptive private data that is not necessary to define the
    * state and should thus not be saved. Hence the small memento object. */

    public void setState(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public Memento save() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }
    public void restore(Memento m) {
        state = m.getState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }
}

class Caretaker {
    private ArrayList<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getMemento() {
        return mementos.get(1);
    }
}


class Mediator {
    // 4. The Mediator arbitrates
    private boolean slotFull = false;
    private int number;

    public synchronized void storeMessage(int num) {
        // no room for another message
        while (slotFull == true) {
            try {
                wait();
            }
            catch (InterruptedException e ) {
                Thread.currentThread().interrupt();
            }
        }
        slotFull = true;
        number = num;
        notifyAll();
    }

    public synchronized int retrieveMessage() {
        // no message to retrieve
        while (slotFull == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        slotFull = false;
        notifyAll();
        return number;
    }
}

class Producer implements Runnable {
    // 2. Producers are coupled only to the Mediator
    private Mediator med;
    private int id;
    private static int num = 1;

    public Producer(Mediator m) {
        med = m;
        id = num++;
    }

    @Override
    public void run() {
        int num;
        while (true) {
            med.storeMessage(num = (int)(Math.random()*100));
            System.out.print( "p" + id + "-" + num + "  " );
        }
    }
}

class Consumer implements Runnable {
    // 3. Consumers are coupled only to the Mediator
    private Mediator med;
    private int    id;
    private static int num = 1;

    public Consumer(Mediator m) {
        med = m;
        id = num++;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("c" + id + "-" + med.retrieveMessage() + "  ");
        }
    }
}


 class StrategyDemo {
    // client code here
     void execute(Strategy strategy) {
        strategy.solve();
    }}
interface Strategy {
    void solve();
}

// 2. Bury implementation
@SuppressWarnings("ALL")
abstract class StrategySolution implements Strategy {
    // 3. Template Method
    public void solve() {
        start();
        while (nextTry() && !isSolution()) {}
        stop();
    }

    abstract void start();
    abstract boolean nextTry();
    abstract boolean isSolution();
    abstract void stop();
}

class FOO extends StrategySolution {
    private int state = 1;

    protected void start() {
        System.out.print("Start  ");
    }

    protected void stop() {
        System.out.println("Stop");
    }

    protected boolean nextTry() {
        System.out.print("NextTry-" + state++ + "  ");
        return true;
    }

    protected boolean isSolution() {
        System.out.print("IsSolution-" + (state == 3) + "  ");
        return (state == 3);
    }
}

// 2. Bury implementation
abstract class StrategySearch implements Strategy {
    // 3. Template Method
    public void solve() {
        while (true) {
            preProcess();
            if (search()) {
                break;
            }
            postProcess();
        }
    }

    abstract void preProcess();
    abstract boolean search();
    abstract void postProcess();
}

@SuppressWarnings("ALL")
class BAR extends StrategySearch {
    private int state = 1;

    protected void preProcess()  {
        System.out.print("PreProcess  ");
    }

    protected void postProcess() {
        System.out.print("PostProcess  ");
    }

    protected boolean search() {
        System.out.print("Search-" + state++ + "  ");
        return state == 3 ? true : false;
    }
}



interface AlarmListener {
    void alarm();
}

class SensorSystem {
    private Vector listeners = new Vector();

    public void register(AlarmListener alarmListener) {
        listeners.addElement(alarmListener);
    }

    public void soundTheAlarm() {
        for (Enumeration e = listeners.elements(); e.hasMoreElements();) {
            ((AlarmListener) e.nextElement()).alarm();
        }
    }
}

class Lighting implements AlarmListener {
    public void alarm() {
        System.out.println("lights up");
    }
}

class Gates implements AlarmListener {
    public void alarm() {
        System.out.println("gates close");
    }
}

class CheckList {
    // Template Method design pattern
    public void byTheNumbers() {
        localize();
        isolate();
        identify();
    }

    protected void localize() {
        System.out.println("   establish a perimeter");
    }

    protected void isolate() {
        System.out.println("   isolate the grid");
    }

    protected void identify() {
        System.out.println("   identify the source");
    }
}

// class inherit.
// type inheritance
class Surveillance extends CheckList implements AlarmListener {
    public void alarm() {
        System.out.println("Surveillance - by the numbers:");
        byTheNumbers();
    }

    protected void isolate() {
        System.out.println("   train the cameras");
    }
}




class NullOutputStream extends OutputStream {
    public void write(int b) {
        // Do nothing
    }
}

class NullPrintStream extends PrintStream {
    public NullPrintStream() {
        super(new NullOutputStream());
    }
}

class Application {
    private PrintStream debugOut;
    public Application(PrintStream debugOut) {
        this.debugOut = debugOut;
    }

    public void doSomething() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            debugOut.println("i = " + i);
        }
        System.out.println("sum = " + sum);
    }
}


interface Prototype {
    Prototype clone();
    String getName();
    void execute();
}

class PrototypeModule {
    // 2. "registry" of prototypical objs
    private static List<Prototype> prototypes = new ArrayList<>();

    // Adds a feature to the Prototype attribute of the PrototypesModule class
    // obj  The feature to be added to the Prototype attribute
    public static void addPrototype(Prototype p) {
        prototypes.add(p);
    }

    public static Prototype createPrototype(String name) {
        // 4. The "virtual ctor"
        for (Prototype p : prototypes) {
            if (p.getName().equals(name)) {
                return p.clone();
            }
        }
        System.out.println(name + ": doesn't exist");
        return null;
    }
}

// 5. Sign-up for the clone() contract.
// Each class calls "new" on itself FOR the client.
class PrototypeAlpha implements Prototype {
    private String name = "AlphaVersion";

    @Override
    public Prototype clone() {
        return new PrototypeAlpha();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println(name + ": does something");
    }
}

class PrototypeBeta implements Prototype {
    private String name = "BetaVersion";

    @Override
    public Prototype clone() {
        return new PrototypeBeta();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println(name + ": does something");
    }
}

class ReleasePrototype implements Prototype {
    private String name = "ReleaseCandidate";
    @Override
    public Prototype clone() {
        return new ReleasePrototype();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println(name + ": does real work");
    }
}
 class PrototypeDemo {
public static void initializePrototypes() {
        PrototypeModule.addPrototype(new PrototypeAlpha());
        PrototypeModule.addPrototype(new PrototypeBeta());
        PrototypeModule.addPrototype(new ReleasePrototype());
    }
}


class Pizza {
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
}

/* "Abstract Builder" */
abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {
    public void buildDough() {
        pizza.setDough("cross");
    }

    public void buildSauce() {
        pizza.setSauce("mild");
    }

    public void buildTopping() {
        pizza.setTopping("ham+pineapple");
    }
}

/* "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
    public void buildDough() {
        pizza.setDough("pan baked");
    }

    public void buildSauce() {
        pizza.setSauce("hot");
    }

    public void buildTopping() {
        pizza.setTopping("pepperoni+salami");
    }
}

/* "Director" */
class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}


abstract class State {
    public void pull(Chain wrapper) {
        wrapper.setState(new Off());
        System.out.println("   turning off");
    }
}

class Chain {
    private State current;

    public Chain() {
        current = new Off();
    }

    public void setState(State state) {
        current = state;
    }

    public void pull() {
        current.pull(this);
    }
}

class Off extends State {
    public void pull(Chain wrapper) {
        wrapper.setState(new Low());
        System.out.println( "   low speed" );
    }
}

class Low extends State {
    public void pull(Chain wrapper) {
        wrapper.setState(new Medium());
        System.out.println("   medium speed");
    }
}

class Medium extends State {
    public void pull(Chain wrapper) {
        wrapper.setState(new High());
        System.out.println("   high speed");
    }
}

class High extends State { }



abstract class Generalization {
    // 1. Standardize the skeleton of an algorithm in a "template" method
    void findSolution() {
        stepOne();
        stepTwo();
        stepThr();
        stepFor();
    }
    // 2. Common implementations of individual steps are defined in base class
    private void stepOne() {
        System.out.println("Generalization.stepOne");
    }
    // 3. Steps requiring peculiar implementations are "placeholders" in the base class
    abstract void stepTwo();
    abstract void stepThr();

    void stepFor() {
        System.out.println( "Generalization.stepFor" );
    }
}

abstract class Specialization extends Generalization {
    // 4. Derived classes can override placeholder methods
    // 1. Standardize the skeleton of an algorithm in a "template" method
    protected void stepThr() {
        step3_1();
        step3_2();
        step3_3();
    }
    // 2. Common implementations of individual steps are defined in base class
    private void step3_1() {
        System.out.println("Specialization.step3_1");
    }
    // 3. Steps requiring peculiar implementations are "placeholders" in the base class
    abstract protected void step3_2();

    private void step3_3() {
        System.out.println("Specialization.step3_3");
    }
}

class Realization extends Specialization {
    // 4. Derived classes can override placeholder methods
    protected void stepTwo() {
        System.out.println("Realization.stepTwo");
    }

    protected void step3_2() {
        System.out.println( "Realization.step3_2");
    }

    // 5. Derived classes can override implemented methods
    // 6. Derived classes can override and "call back to" base class methods
    protected void stepFor() {
        System.out.println("Realization.stepFor");
        super.stepFor();
    }
}


interface Image {
    String process();
}

class IR implements Image {
    public String process() {
        return "IR";
    }
}

class LS implements Image {
    public String process() {
        return "LS";
    }
}

class Processor {
    private static final Random RANDOM = new Random();
    private static int nextID = 1;
    private int id = nextID++;

    public boolean execute(Image img) {
        if (RANDOM.nextInt(2) != 0) {
            System.out.println("   Processor " + id + " is busy");
            return false;
        }
        System.out.println("Processor " + id + " - " + img.process());
        return true;
    }
}

class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

/* The NEW */
class RoundHole {
    private final int radius;

    public RoundHole(int radius) {
        this.radius = radius;
        System.out.println("RoundHole: max SquarePeg is " + radius * Math.sqrt(2));
    }

    public int getRadius() {
        return radius;
    }
}

// Design a "wrapper" class that can "impedance match" the old to the new
class SquarePegAdapter {
    // The adapter/wrapper class "has a" instance of the legacy class
    private final SquarePeg squarePeg;

    public SquarePegAdapter(double w) {
        squarePeg = new SquarePeg(w);
    }

    // Identify the desired interface
    public void makeFit(RoundHole roundHole) {
        // The adapter/wrapper class delegates to the legacy object
        double amount = squarePeg.getWidth() - roundHole.getRadius() * Math.sqrt(2);
        System.out.println( "reducing SquarePeg " + squarePeg.getWidth() + " by " + ((amount < 0) ? 0 : amount) + " amount");
        if (amount > 0) {
            squarePeg.setWidth(squarePeg.getWidth() - amount);
            System.out.println("   width is now " + squarePeg.getWidth());
        }
    }
}

interface LCD {
    void write(String[] s);
    void read(String[] s);
}

class Core implements LCD {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void write(String[] s) {
        System.out.print("INPUT:    ");
        try {
            s[0] = in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void read(String[] s) {
        System.out.println("Output:   " + s[0]);
    }
}

class Decorator implements LCD {
    private LCD inner;

    public Decorator(LCD i) {
        inner = i;
    }

    public void write(String[] s) {
        inner.write(s);
    }

    public void read(String[] s) {
        inner.read(s);
    }
}

class Scramble extends Decorator {
    public Scramble(LCD inner) {
        super(inner);
    }

    public void write( String[] s ) {
        super.write(s);
        System.out.println("encrypt:");
        StringBuilder sb = new StringBuilder(s[0]);
        for (int i=0; i < sb.length(); i++) {
            sb.setCharAt(i, (char)(sb.charAt(i) - 5));
        }
        s[0] = sb.toString();
    }

    public void read(String[] s) {
        StringBuilder sb = new StringBuilder(s[0]);
        for (int i=0; i < sb.length(); i++) {
            sb.setCharAt(i, (char)(sb.charAt(i) + 5));
        }
        s[0] = sb.toString();
        System.out.println( "decrypt:" );
        super.read(s);
    }
}
 class DecoratorDemo extends Decorator {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public DecoratorDemo(LCD inner) {
        super(inner);
    }

    public void write(String[] s) {
        System.out.print("PASSWORD: ");
        try {
            in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        super.write( s );
    }

    public void read(String[] s) {
        System.out.print("PASSWORD: ");
        try {
            in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        super.read(s);
    }
}

class PointCartesian {
    private double x, y;
    public PointCartesian(double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public void  move( int x, int y ) {
        this.x += x;
        this.y += y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

// 1. Subsystem
class PointPolar {
    private double radius, angle;

    public PointPolar(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public void  rotate(int angle) {
        this.angle += angle % 360;
    }

    public String toString() {
        return "[" + radius + "@" + angle + "]";
    }
}

// 1. Desired interface: move(), rotate()
class Point {
    // 2. Design a "wrapper" class
    private PointCartesian pointCartesian;

    public Point(double x, double y) {
        pointCartesian = new PointCartesian(x, y);
    }

    public String toString() {
        return pointCartesian.toString();
    }

    // 4. Wrapper maps
    public void move(int x, int y) {
        pointCartesian.move(x, y);
    }

    public void rotate(int angle, Point o) {
        double x = pointCartesian.getX() - o.pointCartesian.getX();
        double y = pointCartesian.getY() - o.pointCartesian.getY();
        PointPolar pointPolar = new PointPolar(Math.sqrt(x * x + y * y),Math.atan2(y, x) * 180 / Math.PI);
        // 4. Wrapper maps
        pointPolar.rotate(angle);
        System.out.println("  PointPolar is " + pointPolar);
        String str = pointPolar.toString();
        int i = str.indexOf('@');
        double r = Double.parseDouble(str.substring(1, i));
        double a = Double.parseDouble(str.substring(i + 1, str.length() - 1));
        pointCartesian = new PointCartesian(r*Math.cos(a*Math.PI/180) + o.pointCartesian.getX(),
                r*Math.sin(a * Math.PI / 180) + o.pointCartesian.getY());
    }
}

class Line {
    private Point o, e;
    public Line(Point ori, Point end) {
        o = ori;
        e = end;
    }

    public void  move(int x, int y) {
        o.move(x, y);
        e.move(x, y);
    }

    public void  rotate(int angle) {
        e.rotate(angle, o);
    }

    public String toString() {
        return "origin is " + o + ", end is " + e;
    }
}


abstract class Entity {
    protected static StringBuffer indent = new StringBuffer();
    protected static int level = 1;

    public abstract void traverse(int[] levels);

    protected boolean printThisLevel(int[] levels) {
        for (int value : levels) {
            if (level == value) {
                return true;
            }
        }
        return false;
    }
}

class Product extends Entity {
    private int value;
    public Product(int value) {
        this.value = value;
    }

    public void traverse(int[] levels) {
        if (printThisLevel(levels)) {
            System.out.println(indent.toString() + value);
        }
    }
}

class Box extends Entity {
    private List children = new ArrayList();
    private int value;
    public Box(int val) {
        value = val;
    }

    public void add(Entity c) {
        children.add(c);
    }

    public void traverse(int[] levels) {
        if (printThisLevel(levels)) {
            System.out.println(indent.toString() + value);
            indent.append( "   " );
        }
        level++;
        for (Object child : children) {
            ((Entity)child).traverse(levels);
        }
        level--;
        if (printThisLevel(levels)) {
            indent.setLength(indent.length() - 3);
        }
    }
}
class CompositeDemo
{
	 private static Box initialize() 
	{
        		Box[] nodes = new Box[7];
        		nodes[1] = new Box( 1 );
        		int[] waves = {1, 4, 7};
        		for (int i=0; i < 3; i++) 
		{
            		nodes[2] = new Box(21+i);
            		nodes[1].add(nodes[2]);
            		int level = 3;
            		for (int j=0; j < 4; j++)
		{
                			nodes[level-1].add( new Product(level*10 + waves[i]));
                			nodes[level] = new Box(level*10 + waves[i]+1);
                			nodes[level-1].add(nodes[level]);
                			nodes[level-1].add(new Product(level*10 + waves[i]+2));
                			level++;
            		}
        		}
	return nodes[1];
	}
        

}

class Node {
    public int value;
    public Node prev, next;

    public Node(int value) {
        this.value = value;
    }
}

class StackArray {
    private int[] items;
    private int size = -1;

    public StackArray() {
        this.items = new int[12];
    }

    public StackArray(int cells) {
        this.items = new int[cells];
    }

    public void push(int i) {
        if (!isFull()) {
            items[++size] = i;
        }
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public boolean isFull() {
        return size == items.length - 1;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return items[size];
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return items[size--];
    }
}

class StackList {
    private Node last;
    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.next = new Node(i);
            last.next.prev = last;
            last = last.next;
        }
    }
    public boolean isEmpty() {
        return last == null;
    }
    public boolean isFull() {
        return false;
    }
    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return last.value;
    }
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int ret = last.value;
        last = last.prev;
        return ret;
    }
}

class StackFIFO extends StackArray {
    private StackArray stackArray = new StackArray();
    public int pop() {
        while (!isEmpty()) {
            stackArray.push(super.pop());
        }
        int ret = stackArray.pop();
        while (!stackArray.isEmpty()) {
            push(stackArray.pop());
        }
        return ret;
    }
}

class StackHanoi extends StackArray {
    private int totalRejected = 0;
    public int reportRejected() {
        return totalRejected;
    }
    public void push(int in) {
        if (!isEmpty() && in > top()) {
            totalRejected++;
        } else {
            super.push(in);
        }
    }
}



class Gazillion {
    private int row;

    public Gazillion(int row) {
        this.row = row;
        System.out.println("CTOR :"  + this.row);
    }

    void report(int col) {
        System.out.print(  + row + col);
    }
}

class Factory {
    private Gazillion[] pool;

    public Factory(int maxRows) {
        pool = new Gazillion[maxRows];
    }

    public Gazillion getFlyweight(int row) {
        if (pool[row] == null) {
            pool[row] = new Gazillion(row);
        }
        return pool[row];
    }
}


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
class Pattern20 implements ExpensiveObject
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
	 int ROWS = 6, COLS = 10;
	
	int ch,ch1;
	do
	{
		System.out.println("\n Select options from Below to Run The Code : \n");
		System.out.println("\n 1. Proxy Pattern \n 2. Factory Pattern \n 3. Command Pattern\n 4. MVC Pattern \n 5. FlyWeight Pattern \n 6. Bridge Pattern \n 7. Composite Demo Pattern \n 8. Facade Pattern \n 9. Decorator Pattern \n 10. Adapter Pattern \n 11. Chain Pattern \n 12. Template Pattern  \n 13. State Pattern \n 14. Builder Pattern \n 15.  Prototype Pattern \n 16. NuLLObject Pattern \n 17. Observer Pattern \n 18. Strategy Pattern \n 19.  Mediator Pattern \n 20. Memento Pattern \n");
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
			case 5:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE FlyWeight PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				Factory theFactory = new Factory(ROWS);
       				for (int i=0; i <ROWS; i++)
				{
            					for (int j=0; j <COLS; j++)
                						theFactory.getFlyweight(i).report(j);
            					System.out.println();
        				}
				break;
			case 6:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE BRIDGE PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				StackArray[] stacks = {new StackArray(), new StackFIFO(), new StackHanoi()};
      				StackList stackList = new StackList();
        				for (int i = 1, num; i < 15; i++) {
            				stacks[0].push(i);
            				stackList.push(i);
            				stacks[1].push(i);
        				}
        				Random rn = new Random();
       				 for (int i = 1, num; i < 15; i++) {
            				stacks[2].push(rn.nextInt(20));
        				}
       				 while (!stacks[0].isEmpty()) {
            				System.out.print(stacks[0].pop() + "  ");
        				}
        				System.out.println();
        				while (!stackList.isEmpty()) {
           				 System.out.print(stackList.pop() + "  ");
        				}
        				System.out.println();
        				while (!stacks[1].isEmpty()) {
            				System.out.print(stacks[1].pop() + "  ");
        				}
        				System.out.println();
        				while (!stacks[2].isEmpty()) {
            				System.out.print(stacks[2].pop() + "  ");
        				}
        				System.out.println();
        				System.out.println("total rejected is "+ ((StackHanoi) stacks[2]).reportRejected());
				break;
			case 7:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE  COMPOSITE DEMO PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n****Execute Successfully*****\n");
				System.out.println("\n Composite Demo\n");
        				//Box root = initialize();
        				int[] levels = new int[args.length];
        				for (int i=0; i < args.length; i++) {
            				levels[i] = Integer.parseInt(args[i]);
        				}
        				//root.traverse( levels );
				break;
			case 8:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE  FACADE PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				Line lineA = new Line(new Point(2, 4), new Point(5, 7));
        				lineA.move(-2, -4);
        				System.out.println( "after move:  " + lineA );
        				lineA.rotate(45);
       				System.out.println( "after rotate: " + lineA );
        				Line lineB = new Line( new Point(2, 1), new Point(2.866, 1.5));
        				lineB.rotate(30);
        				System.out.println("30 degrees to 60 degrees: " + lineB);
				break;
			case 9:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE DECORATOR PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				LCD stream = new DecoratorDemo(new Scramble(new Core()));
        				String[] str = {""};
        				stream.write(str);
        				System.out.println("main:     " + str[0]);
        				stream.read(str);
				break;
			case 10:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE ADAPTER PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				RoundHole roundHole = new RoundHole( 5 );
        				SquarePegAdapter squarePegAdapter;
       				 for (int i = 6; i < 10; i++) {
            				squarePegAdapter = new SquarePegAdapter((double)i);
            				squarePegAdapter.makeFit(roundHole);}
				break;
			case 11:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE Chain PATTERN CODE --* \n");
				Image[] inputImages = {new IR(), new IR(), new LS(), new IR(), new LS(), new LS()};
        Processor[] processors = {new Processor(), new Processor(), new Processor()};
        for (int i=0, j; i < inputImages.length; i++) {
            System.out.println("Operation #" + (i + 1) + ":");
            j = 0;
            while (!processors[j].execute(inputImages[i])) {
                j = (j + 1) % processors.length;
            }
            System.out.println();
        }
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				break;
			case 12:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE TEMPLATE PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				Generalization algorithm = new Realization();
        				algorithm.findSolution();
				break;
			case 13:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE STATE PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				InputStreamReader is = new InputStreamReader( System.in );
       				 Chain chain = new Chain();
        				while (true) {
           				 System.out.print( "Press 'Enter'" );
            				is.read();
            				chain.pull();
				}
				//break;
			case 14:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE BUILDER PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				 Waiter waiter = new Waiter();
       				 PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        				PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();
				waiter.setPizzaBuilder( hawaiianPizzabuilder );
       				 waiter.constructPizza();
				Pizza pizza = waiter.getPizza();
				System.out.println("\n *-- OUTPUT OF THE BUILDER PATTERN CODE --* \n     BUILDER PATTERN EXECUTED      \n ");
				break;
			case 15:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE PROTOTYPE PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				PrototypeDemo d1=new PrototypeDemo();
				if (args.length > 0) {
          				  d1.initializePrototypes();
           				 List<Prototype> prototypes = new ArrayList<>();
            				// 6. Client does not use "new"
            				for (String protoName : args) {
               				 Prototype prototype = PrototypeModule.createPrototype(protoName);
                				if (prototype != null) {
                    			prototypes.add(prototype);
                				}
            				}
            				for (Prototype p : prototypes) {
               				 p.execute();
            				}
       				 } else {
           				 System.out.println("Run again with arguments of command string ");
       				 }
				break;
			case 16:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE NULL_OBJECT_PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				Application app = new Application(new NullPrintStream());
       				 app.doSomething();
				break;
			case 17:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE OBSERVER PATTERN CODE --* \n");
				SensorSystem sensorSystem = new SensorSystem();
       				 sensorSystem.register(new Gates());
       				 sensorSystem.register(new Lighting());
       				 sensorSystem.register(new Surveillance());
       				 sensorSystem.soundTheAlarm();
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				break;
			case 18:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE STRATEGY PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				StrategyDemo d2 =new StrategyDemo();
				Strategy[] algorithms1 = {new FOO(), new BAR()};
        				for (Strategy algorithm2 : algorithms1) {
           				d2.execute(algorithm2);
				}
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				break;
			case 19:
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE  MEDIATOR PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				List<Thread> producerList = new ArrayList<>();
       				Scanner scanner = new Scanner(System.in);
       				System.out.println("Press ENTER for exit");
      				Mediator mb = new Mediator();
       				producerList.add(new Thread(new Producer(mb)));
      				producerList.add(new Thread(new Producer(mb)));
   				producerList.add(new Thread(new Consumer(mb)));
       				producerList.add(new Thread(new Consumer(mb)));
    			    	producerList.add(new Thread(new Consumer(mb)));
    			    	producerList.add(new Thread(new Consumer(mb)));
     			   	for (Thread p : producerList) {
            				p.start();
       		 		}
        				boolean stop = false;
       				String exit = scanner.nextLine();
        				while (!stop) {
            				if (exit.equals("")) {
                				stop = true;
                				for (Thread p : producerList) {
                   				 //noinspection deprecation
                    			p.stop();
                				}
            				}
       				 }
				break;
			case 20 :
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				System.out.println("\n *-- OUTPUT OF THE MEMENTO PATTERN CODE --* \n");
				System.out.println("\n---------*-----------*------------*---------------------* \n");
				Caretaker caretaker = new Caretaker();
        				Originator originator = new Originator();
        				originator.setState("State1");
     				originator.setState("State2");
       				caretaker.addMemento( originator.save() );
       				originator.setState("State3");
        				caretaker.addMemento( originator.save() );
       				originator.setState("State4");
       				originator.restore( caretaker.getMemento() );
				break;
			
		}
		System.out.println("\n  ********** For Repeat Press '1' *********** \n" );
		ch1=Integer.parseInt(br.readLine());
	}while(ch1==1);
    
}
}