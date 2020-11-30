
import java.net.*;
import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) throws IOException {

        Student S = new Student("Jerry", 0 , 0);
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(S);
            out.close();
            fileOutputStream.close();
            System.out.printf("Serialized data is saved in src");
        }
        catch(IOException i){
            i.printStackTrace();
        }


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
