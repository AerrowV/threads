package runnableprinter;

public class Main {

    public static void main(String[] args) {

        PrintJob a = new PrintJob("A", "Hello from A", 10);
        PrintJob b = new PrintJob("B", "I print, too!", 10);
        PrintJob c = new PrintJob("C", "My turn now", 10);

        Thread aThread = new Thread(a);
        Thread bThread = new Thread(b);
        Thread cThread = new Thread(c);
        
        aThread.start();
        bThread.start();
        cThread.start();
    }
}
