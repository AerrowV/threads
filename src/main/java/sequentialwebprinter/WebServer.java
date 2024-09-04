package sequentialwebprinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private static final int PORT = 9090;

    private PrintWriter out;
    private BufferedReader in;
    private Socket clientSocket;
    private boolean keepRunning;

    public static void main(String[] args) {
        WebServer server = new WebServer();
        server.startConnection(PORT);
    }

    public void startConnection(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            keepRunning = true;
            while (keepRunning) {
                clientSocket = serverSocket.accept(); // blocking call
                new Thread(new clientHandler(clientSocket)).start();


            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stopConnection();
        }
    }

    public void stopConnection() {
        try {
            System.out.println("Closing down socket ...");
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

