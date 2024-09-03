package runnableprinter;

public class Printer {

    private static Printer printer = new Printer();

    public void print(PrintJob job){
        for(int i = 0; i < job.getNoOfPrints(); i++){
            if (i % 10 == 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(job.getJobName() + ": " + job.getMsg());

        }
    }

    private Printer(){

    }

    public static Printer getPrinter(){
        return printer;
    }

}
