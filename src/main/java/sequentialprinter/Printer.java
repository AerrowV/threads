package sequentialprinter;

public class Printer {

    private static Printer printer = new Printer();

    public void print(PrintJob job){
        for(int i = 0; i < job.getNoOfPrints(); i++){
            System.out.println(job.getName() + ": " + job.getMsg());
        }
    }

    private Printer(){

    }

    public static Printer getPrinter(){
        return printer;
    }

}
