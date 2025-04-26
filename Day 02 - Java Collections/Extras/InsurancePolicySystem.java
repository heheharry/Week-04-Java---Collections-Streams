package Day2.Extras;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
public class InsurancePolicySystem {
    static class Policy {
        private String policyNumber;
        private String policyholderName;
        private LocalDate expiryDate;
        private String coverageType;
        private double premiumAmount;

        public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public String getCoverageType() {
            return coverageType;
        }

        @Override
        public String toString() {
            return "Policy{policyNumber='" + policyNumber + "', policyholderName='" + policyholderName + "', expiryDate=" + expiryDate + ", coverageType='" + coverageType + "', premiumAmount=" + premiumAmount + '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Policy policy = (Policy) obj;
            return policyNumber.equals(policy.policyNumber);
        }

        @Override
        public int hashCode() {
            return policyNumber.hashCode();
        }
    }

    static class PolicyManager {
        private Set<Policy> hashSetPolicies = new HashSet<>();
        private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
        private Set<Policy> treeSetPolicies = new TreeSet<>((policy1, policy2) -> policy1.getExpiryDate().compareTo(policy2.getExpiryDate()));

        // 1. Store unique policies
        public void addPolicy(Policy policy) {
            hashSetPolicies.add(policy);
            linkedHashSetPolicies.add(policy);
            treeSetPolicies.add(policy);
        }

        // 2. Retrieve policies
        public void displayAllPolicies() {
            System.out.println("All Unique Policies:");
            hashSetPolicies.forEach(System.out::println);
        }

        public void displayPoliciesExpiringSoon() {
            LocalDate today = LocalDate.now();
            LocalDate thirtyDaysFromNow = today.plusDays(30);
            System.out.println("Policies Expiring Soon (Within 30 Days):");
            for (Policy policy : hashSetPolicies) {
                if (policy.getExpiryDate().isBefore(thirtyDaysFromNow)) {
                    System.out.println(policy);
                }
            }
        }

        public void displayPoliciesByCoverageType(String coverageType) {
            System.out.println("Policies with coverage type " + coverageType + ":");
            for (Policy policy : hashSetPolicies) {
                if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                    System.out.println(policy);
                }
            }
        }

        // 3. Check for duplicates (based on policy number)
        public void checkForDuplicatePolicies() {
            Set<Policy> duplicates = new HashSet<>();
            Set<String> seenPolicyNumbers = new HashSet<>();

            for (Policy policy : hashSetPolicies) {
                if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                    duplicates.add(policy);
                }
            }

            System.out.println("Duplicate Policies based on policy numbers:");
            duplicates.forEach(System.out::println);
        }

        // 4. Performance Comparison
        public void comparePerformance() {
            long startTime, endTime;

            // HashSet performance
            startTime = System.nanoTime();
            addPolicy(new Policy("P123", "John Doe", LocalDate.now().plusYears(1), "Health", 500));
            endTime = System.nanoTime();
            System.out.println("Time taken by HashSet to add: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            hashSetPolicies.remove(new Policy("P123", "John Doe", LocalDate.now().plusYears(1), "Health", 500));
            endTime = System.nanoTime();
            System.out.println("Time taken by HashSet to remove: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            hashSetPolicies.contains(new Policy("P123", "John Doe", LocalDate.now().plusYears(1), "Health", 500));
            endTime = System.nanoTime();
            System.out.println("Time taken by HashSet to search: " + (endTime - startTime) + " ns");

            // LinkedHashSet performance
            startTime = System.nanoTime();
            linkedHashSetPolicies.add(new Policy("P123", "Jane Doe", LocalDate.now().plusYears(1), "Auto", 600));
            endTime = System.nanoTime();
            System.out.println("Time taken by LinkedHashSet to add: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            linkedHashSetPolicies.remove(new Policy("P123", "Jane Doe", LocalDate.now().plusYears(1), "Auto", 600));
            endTime = System.nanoTime();
            System.out.println("Time taken by LinkedHashSet to remove: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            linkedHashSetPolicies.contains(new Policy("P123", "Jane Doe", LocalDate.now().plusYears(1), "Auto", 600));
            endTime = System.nanoTime();
            System.out.println("Time taken by LinkedHashSet to search: " + (endTime - startTime) + " ns");

            // TreeSet performance
            startTime = System.nanoTime();
            treeSetPolicies.add(new Policy("P123", "Jack Doe", LocalDate.now().plusYears(1), "Home", 700));
            endTime = System.nanoTime();
            System.out.println("Time taken by TreeSet to add: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            treeSetPolicies.remove(new Policy("P123", "Jack Doe", LocalDate.now().plusYears(1), "Home", 700));
            endTime = System.nanoTime();
            System.out.println("Time taken by TreeSet to remove: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            treeSetPolicies.contains(new Policy("P123", "Jack Doe", LocalDate.now().plusYears(1), "Home", 700));
            endTime = System.nanoTime();
            System.out.println("Time taken by TreeSet to search: " + (endTime - startTime) + " ns");
        }
    }

    public static void main(String[] args) {
        PolicyManager policyManager = new PolicyManager();

        // Add some policies
        policyManager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusMonths(2), "Health", 300));
        policyManager.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusMonths(3), "Auto", 400));
        policyManager.addPolicy(new Policy("P003", "Charlie", LocalDate.now().plusMonths(1), "Home", 500));
        policyManager.addPolicy(new Policy("P004", "David", LocalDate.now().plusDays(15), "Health", 350));

        // Retrieve and display policies
        policyManager.displayAllPolicies();
        policyManager.displayPoliciesExpiringSoon();
        policyManager.displayPoliciesByCoverageType("Health");
        policyManager.checkForDuplicatePolicies();

        // Performance comparison
        policyManager.comparePerformance();
    }
}
