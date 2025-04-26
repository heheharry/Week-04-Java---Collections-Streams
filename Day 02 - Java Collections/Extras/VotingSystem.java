package Day2.Extras;
import java.util.*;
public class VotingSystem {
    private Map<String, Integer> votesHashMap;
    private Map<String, Integer> votesTreeMap;
    private Map<String, Integer> votesLinkedHashMap;

    public VotingSystem() {
        votesHashMap = new HashMap<>();
        votesTreeMap = new TreeMap<>();
        votesLinkedHashMap = new LinkedHashMap<>();
    }

    public void addVote(String candidate) {
        votesHashMap.put(candidate, votesHashMap.getOrDefault(candidate, 0) + 1);
        votesLinkedHashMap.put(candidate, votesLinkedHashMap.getOrDefault(candidate, 0) + 1);
        votesTreeMap.put(candidate, votesTreeMap.getOrDefault(candidate, 0) + 1);
    }

    public int getVotes(String candidate) {
        return votesHashMap.getOrDefault(candidate, 0);
    }

    public void displayResultsSortedByCandidate() {
        System.out.println("Voting Results (Sorted by Candidate):");
        for (Map.Entry<String, Integer> entry : votesTreeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displayResultsInVotingOrder() {
        System.out.println("Voting Results (In Voting Order):");
        for (Map.Entry<String, Integer> entry : votesLinkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displayResultsUnsorted() {
        System.out.println("Voting Results (Unsorted):");
        for (Map.Entry<String, Integer> entry : votesHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.addVote("Alice");
        votingSystem.addVote("Bob");
        votingSystem.addVote("Alice");
        votingSystem.addVote("Charlie");
        votingSystem.addVote("Bob");
        votingSystem.addVote("Alice");

        votingSystem.displayResultsSortedByCandidate();
        System.out.println();
        votingSystem.displayResultsInVotingOrder();
        System.out.println();
        votingSystem.displayResultsUnsorted();
    }
}
