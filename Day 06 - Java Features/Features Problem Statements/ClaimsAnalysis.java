package Day5.FeaturesProblemStatements;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.stream.Collectors;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;

    Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class PolicyClaims {
    String policyNumber;
    double totalClaimAmount;
    double averageClaimAmount;

    PolicyClaims(String policyNumber, double totalClaimAmount, double averageClaimAmount) {
        this.policyNumber = policyNumber;
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }

    public String toString() {
        return policyNumber + " Total: " + totalClaimAmount + " Average: " + averageClaimAmount;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "P001", 7000, "2024-01-01", "Approved"),
                new Claim("C002", "P002", 3000, "2024-02-01", "Pending"),
                new Claim("C003", "P001", 9000, "2024-03-01", "Approved"),
                new Claim("C004", "P003", 8000, "2024-04-01", "Approved"),
                new Claim("C005", "P002", 12000, "2024-05-01", "Approved"),
                new Claim("C006", "P004", 6000, "2024-06-01", "Approved")
        );

        Map<String, List<Claim>> groupedClaims = claims.stream()
                .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
                .collect(Collectors.groupingBy(c -> c.policyNumber));

        List<PolicyClaims> policyClaimsList = groupedClaims.entrySet().stream()
                .map(e -> {
                    double total = e.getValue().stream().mapToDouble(c -> c.claimAmount).sum();
                    double average = e.getValue().stream().mapToDouble(c -> c.claimAmount).average().orElse(0);
                    return new PolicyClaims(e.getKey(), total, average);
                })
                .sorted((p1, p2) -> Double.compare(p2.totalClaimAmount, p1.totalClaimAmount))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(policyClaimsList);
    }
}
