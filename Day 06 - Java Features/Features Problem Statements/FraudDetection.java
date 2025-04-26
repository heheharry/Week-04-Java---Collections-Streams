package Day5.FeaturesProblemStatements;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.stream.Collectors;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudSummary {
    String policyNumber;
    long fraudCount;
    double totalFraudAmount;

    FraudSummary(String policyNumber, long fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    public String toString() {
        return policyNumber + " FraudCount: " + fraudCount + " TotalFraudAmount: " + totalFraudAmount;
    }
}

public class FraudDetection {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P001", 15000, "2024-01-01", true),
                new Transaction("T002", "P001", 20000, "2024-02-01", true),
                new Transaction("T003", "P002", 8000, "2024-03-01", true),
                new Transaction("T004", "P001", 12000, "2024-04-01", true),
                new Transaction("T005", "P003", 60000, "2024-05-01", true),
                new Transaction("T006", "P001", 14000, "2024-06-01", true),
                new Transaction("T007", "P001", 13000, "2024-07-01", true),
                new Transaction("T008", "P003", 55000, "2024-08-01", true)
        );

        Map<String, List<Transaction>> grouped = transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.groupingBy(t -> t.policyNumber));

        List<FraudSummary> alerts = grouped.entrySet().stream()
                .map(e -> {
                    long count = e.getValue().size();
                    double total = e.getValue().stream().mapToDouble(t -> t.amount).sum();
                    return new FraudSummary(e.getKey(), count, total);
                })
                .filter(f -> f.fraudCount > 5 || f.totalFraudAmount > 50000)
                .collect(Collectors.toList());

        System.out.println(alerts);
    }
}
