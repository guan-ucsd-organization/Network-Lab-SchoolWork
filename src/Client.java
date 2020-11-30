
import java.net.*;
import java.io.*;
import java.io.IOException;
import java.net.Socket;



public class Client {

    public static void main(String[] args) throws IOException {


        DataOutputStream toServer = null;
        DataInputStream fromServer = null;


        int number = 5;

        Socket socket = new Socket("localhost", 5000);

        fromServer = new DataInputStream(socket.getInputStream());
        toServer = new DataOutputStream(socket.getOutputStream());

        //send the number to the server
        toServer.writeInt(number);
        toServer.flush();

        //get the double value from the server.
        int answer = fromServer.readInt();

        System.out.println("The answer is " + answer);


    }
}
