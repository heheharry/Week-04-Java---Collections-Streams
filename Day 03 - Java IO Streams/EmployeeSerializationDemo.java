package Day1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}
public class EmployeeSerializationDemo {
    public static void main(String[] args) {
        String filename = "employees.ser";

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice", "HR", 50000));
        employeeList.add(new Employee(102, "Bob", "IT", 60000));
        employeeList.add(new Employee(103, "Charlie", "Finance", 55000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employeeList);
            System.out.println("Employees have been serialized to " + filename);
        } catch (IOException e) {
            System.err.println("Error during serialization:");
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> deserializedList = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employees:");
            for (Employee emp : deserializedList) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization:");
            e.printStackTrace();
        }
    }
}
