import java.io.IOException;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000); //Create a server socket

        Socket socket = serverSocket.accept(); //Listen for connection request;

        //create data input and output streams;
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

        while(true){
            int number = inputFromClient.readInt();
            int returnNumber = number * 2;
            outputToClient.writeInt(returnNumber);
        }

    }
}
