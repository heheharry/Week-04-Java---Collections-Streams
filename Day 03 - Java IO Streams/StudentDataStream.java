package Day1;
import java.io.*;
public class StudentDataStream {
    public static void main(String[] args) {
        String filename = "unbuffered_copy.dat";

        int rollNumber = 101;
        String name = "Alice";
        double gpa = 3.85;

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing student data:");
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int r = dis.readInt();
            String n = dis.readUTF();
            double g = dis.readDouble();

            System.out.println("Retrieved Student Data:");
            System.out.println("Roll Number: " + r);
            System.out.println("Name: " + n);
            System.out.println("GPA: " + g);
        } catch (IOException e) {
            System.err.println("Error reading student data:");
            e.printStackTrace();
        }
    }
}
