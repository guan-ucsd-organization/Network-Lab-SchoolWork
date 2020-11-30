import java.io.IOException;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class DeserializeStudent {

    public static void main(String[] args) throws IOException {


        Student student = null;
        byte[] objBytes = null;
        byte[] yourBytes = null;

        ServerSocket serverSocket = new ServerSocket(5000); //Create a server socket

        Socket socket = serverSocket.accept(); //Listen for connection request;

        //create data input and output streams;
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());

        try {
            while(true) {
                int length = inputFromClient.readInt();

                if (length > 0) {
                    yourBytes = new byte[length];
                    inputFromClient.readFully(yourBytes, 0, length);
                    break;
                }
            }

            ByteArrayInputStream bis = new ByteArrayInputStream(yourBytes);
            ObjectInput in = null;
            try {
                in = new ObjectInputStream(bis);

                Student o = (Student) in.readObject();

                System.out.println("Deserialized Student...");
                System.out.println("Name: " + o.getName());
                System.out.println("Age: " + o.getAge());
                System.out.println("Grades: " + o.getGrades());

            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    // ignore close exception
                }
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
