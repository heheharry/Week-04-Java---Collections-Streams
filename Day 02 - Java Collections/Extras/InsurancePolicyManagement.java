package Day2.Extras;
import java.util.*;

class InsurancePolicy {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName +
                ", ExpiryDate: " + expiryDate + ", CoverageType: " + coverageType +
                ", PremiumAmount: " + premiumAmount;
    }
}
public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policiesHashMap;
    private Map<String, InsurancePolicy> policiesLinkedHashMap;
    private Map<String, InsurancePolicy> policiesTreeMap;

    public InsurancePolicyManagement() {
        policiesHashMap = new HashMap<>();
        policiesLinkedHashMap = new LinkedHashMap<>();
        policiesTreeMap = new TreeMap<>(Comparator.comparing((String policyNumber) -> {
            InsurancePolicy policy = policiesHashMap.get(policyNumber);
            return policy != null ? policy.expiryDate : new Date();
        }));
    }

    // Store policy in all maps
    public void addPolicy(InsurancePolicy policy) {
        policiesHashMap.put(policy.policyNumber, policy);
        policiesLinkedHashMap.put(policy.policyNumber, policy);
        policiesTreeMap.put(policy.policyNumber, policy);
    }

    // Retrieve a policy by policy number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policiesHashMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<InsurancePolicy> listPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date limitDate = calendar.getTime();

        for (InsurancePolicy policy : policiesHashMap.values()) {
            if (policy.expiryDate != null && policy.expiryDate.before(limitDate) && policy.expiryDate.after(currentDate)) {
                expiringPolicies.add(policy);
            }
        }

        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<InsurancePolicy> listPoliciesByPolicyholder(String policyholderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policiesHashMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        Date currentDate = new Date();
        policiesHashMap.values().removeIf(policy -> policy.expiryDate.before(currentDate));
        policiesLinkedHashMap.values().removeIf(policy -> policy.expiryDate.before(currentDate));
        policiesTreeMap.values().removeIf(policy -> policy.expiryDate.before(currentDate));
    }

    public void printPolicies(Map<String, InsurancePolicy> policies) {
        for (InsurancePolicy policy : policies.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement management = new InsurancePolicyManagement();

        // Sample policies
        InsurancePolicy policy1 = new InsurancePolicy("P123", "John Doe", new GregorianCalendar(2025, Calendar.MAY, 15).getTime(), "Health", 1200);
        InsurancePolicy policy2 = new InsurancePolicy("P124", "Jane Doe", new GregorianCalendar(2025, Calendar.APRIL, 20).getTime(), "Auto", 800);
        InsurancePolicy policy3 = new InsurancePolicy("P125", "John Smith", new GregorianCalendar(2025, Calendar.MAY, 10).getTime(), "Home", 1500);
        InsurancePolicy policy4 = new InsurancePolicy("P126", "Alice Brown", new GregorianCalendar(2025, Calendar.MARCH, 30).getTime(), "Health", 1300);

        // Add policies
        management.addPolicy(policy1);
        management.addPolicy(policy2);
        management.addPolicy(policy3);
        management.addPolicy(policy4);

        // Retrieve and print policies
        System.out.println("Policy with P123: " + management.getPolicyByNumber("P123"));

        System.out.println("\nPolicies expiring soon:");
        List<InsurancePolicy> expiringPolicies = management.listPoliciesExpiringSoon();
        for (InsurancePolicy policy : expiringPolicies) {
            System.out.println(policy);
        }

        System.out.println("\nPolicies held by John Doe:");
        List<InsurancePolicy> johnPolicies = management.listPoliciesByPolicyholder("John Doe");
        for (InsurancePolicy policy : johnPolicies) {
            System.out.println(policy);
        }

        // Remove expired policies
        management.removeExpiredPolicies();

        System.out.println("\nPolicies after removing expired ones:");
        management.printPolicies(management.policiesHashMap);
    }
}
