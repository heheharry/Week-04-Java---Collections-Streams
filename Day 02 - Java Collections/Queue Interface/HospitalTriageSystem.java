package Day2.QueueInterface;
import java.util.PriorityQueue;
import java.util.Queue;
class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        Queue<Patient> priorityQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

        priorityQueue.add(new Patient("John", 3));
        priorityQueue.add(new Patient("Alice", 5));
        priorityQueue.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");

        while (!priorityQueue.isEmpty()) {
            Patient patient = priorityQueue.poll();
            System.out.println(patient.name + " with severity " + patient.severity);
        }
    }
}
