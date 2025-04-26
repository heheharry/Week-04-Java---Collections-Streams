package Day5.FeaturesProblemStatements;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String toString() {
        return holderId + " " + name + " " + riskScore;
    }
}

public class PolicyHolderRiskAssessment {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H001", "Alice", 65, "Life", 40000),
                new PolicyHolder("H002", "Bob", 70, "Life", 30000),
                new PolicyHolder("H003", "Charlie", 55, "Health", 25000),
                new PolicyHolder("H004", "David", 68, "Life", 35000),
                new PolicyHolder("H005", "Eve", 72, "Life", 20000)
        );

        List<RiskAssessment> assessments = holders.stream()
                .filter(h -> h.policyType.equals("Life") && h.age > 60)
                .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
                .sorted((r1, r2) -> Double.compare(r2.riskScore, r1.riskScore))
                .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorized = assessments.stream()
                .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        System.out.println(categorized);
    }
}
