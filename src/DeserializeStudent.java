import java.io.IOException;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class DeserializeStudent {

    public static void main(String[] args) throws IOException {


        Student student = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("student.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            student = (Student) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }
        catch (IOException i) {
            i.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Student...");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Grades: " + student.getGrades());



//        ServerSocket serverSocket = new ServerSocket(5000); //Create a server socket
//
//        Socket socket = serverSocket.accept(); //Listen for connection request;
//
//        //create data input and output streams;
//        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
//        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
//
//        while(true){
//            int number = inputFromClient.readInt();
//            int returnNumber = number * 2;
//            outputToClient.writeInt(returnNumber);
//        }

    }
}
