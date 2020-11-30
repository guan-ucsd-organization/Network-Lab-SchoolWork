import java.io.IOException;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class DeserializeStudent {

    public static void main(String[] args) throws IOException {


        Student student = null;
        byte[] objByte = null;

        ServerSocket serverSocket = new ServerSocket(5000); //Create a server socket

        Socket socket = serverSocket.accept(); //Listen for connection request;

        //create data input and output streams;
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());

        while(true){
            objByte = inputFromClient.readAllBytes();
            if (objByte != null){
                break;
            }
        }

        ByteArrayInputStream bis = new ByteArrayInputStream(objByte);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            Student o = (Student) in.readObject();

            System.out.println("Deserialized Student...");
            System.out.println("Name: " + o.getName());
            System.out.println("Age: " + o.getAge());
            System.out.println("Grades: " + o.getGrades());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }






//        try {
//            FileInputStream fileInputStream = new FileInputStream("student.ser");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            student = (Student) objectInputStream.readObject();
//            objectInputStream.close();
//            fileInputStream.close();
//        }
//        catch (IOException i) {
//            i.printStackTrace();
//            return;
//        }
//        catch (ClassNotFoundException c) {
//            System.out.println("Student class not found");
//            c.printStackTrace();
//            return;
//        }








    }
}
