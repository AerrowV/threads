package sequentialwebprinter;

import concurrentwebprinter.Client;

public class ConnectionThree {

    public static void main(String[] args) {
        concurrentwebprinter.Client client = new Client();
        client.connectToServer();
    }
}