import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
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

public class NullObjectDemo {
    public static void main(String[] args) {
        Application app = new Application(new NullPrintStream());
        app.doSomething();
    }
}
