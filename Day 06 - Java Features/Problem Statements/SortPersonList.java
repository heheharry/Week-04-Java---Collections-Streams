package Day5.ProblemStatements;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " " + age + " " + salary;
    }
}

public class SortPersonList {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("John", 25, 50000),
                new Person("Alice", 22, 60000),
                new Person("Bob", 28, 55000)
        );
        Collections.sort(persons, (p1, p2) -> p1.age - p2.age);
        persons.forEach(System.out::println);
    }
}
