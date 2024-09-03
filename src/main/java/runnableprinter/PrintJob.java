package runnableprinter;

public class PrintJob implements Runnable {

    private String msg;
    private String name;
    private int noOfPrints;

    public PrintJob(String name, String msg, int noOfPrints){
        this.name = name;
        this.msg = msg;
        this.noOfPrints = noOfPrints;
    }

    public String getMsg(){
        return msg;
    }

    public String getJobName(){
        return name;
    }

    public int getNoOfPrints(){
        return noOfPrints;
    }

    public void run(){
        Printer printer = Printer.getPrinter();
        printer.print(this);
    }



}
