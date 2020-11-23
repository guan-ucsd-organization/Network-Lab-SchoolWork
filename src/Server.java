import java.io.IOException;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept(); //read the socket

        System.out.println("Client User Connected!");

    }
}
