package Day2.MapInterface;
import java.util.*;

class Employee {
    String name;
    Department department;

    Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Department {
    HR, IT, SALES, MARKETING
}

public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", Department.HR));
        employees.add(new Employee("Bob", Department.IT));
        employees.add(new Employee("Carol", Department.HR));

        Map<Department, List<Employee>> groupedByDepartment = new HashMap<>();

        for (Employee employee : employees) {
            groupedByDepartment
                    .computeIfAbsent(employee.department, k -> new ArrayList<>())
                    .add(employee);
        }

        for (Map.Entry<Department, List<Employee>> entry : groupedByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
