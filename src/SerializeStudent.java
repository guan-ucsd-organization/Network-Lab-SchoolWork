
import java.net.*;
import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class SerializeStudent {

    public static void main(String[] args) throws IOException {

        Student S = new Student("Jerry", 10 , 8);

        //This is the part for Serializing the Student object in the November22Lab directories.
//        try{
//            FileOutputStream fileOutputStream = new FileOutputStream("student.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
//            out.writeObject(S);
//            out.close();
//            fileOutputStream.close();
//            System.out.printf("Serialized data is saved in src");
//        }
//        catch(IOException i){
//            i.printStackTrace();
//        }



        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(S);
            out.flush();
            byte[] yourBytes = bos.toByteArray();
            //convert Btyes to string
            //String s = new String(yourBytes , StandardCharsets.UTF_8);




            DataOutputStream toServer = null;
            DataInputStream fromServer = null;

            Socket socket = new Socket("localhost", 5000);

            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());

            toServer.writeInt(yourBytes.length); //send the byte length
            toServer.write(yourBytes); //send s in as bytes
            toServer.flush();

//            int answer = fromServer.readInt();
//            System.out.println("The answer is " + answer);




        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }
}
