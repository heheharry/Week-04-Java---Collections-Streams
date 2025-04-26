package Day5.ProblemStatements;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return policyNumber + " " + holderName + " " + premiumAmount;
    }
}

public class InsuranceOperations {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
                new InsurancePolicy("P001", "Alice Smith", 1500),
                new InsurancePolicy("P002", "Bob Johnson", 2500),
                new InsurancePolicy("P003", "Charlie Brown", 1100),
                new InsurancePolicy("P004", "David White", 1800),
                new InsurancePolicy("P005", "Eve Black", 900)
        );

        List<InsurancePolicy> premiumAbove1200 = policies.stream()
                .filter(p -> p.premiumAmount > 1200)
                .collect(Collectors.toList());

        List<InsurancePolicy> sortedByHolderName = policies.stream()
                .sorted(Comparator.comparing(p -> p.holderName))
                .collect(Collectors.toList());

        double totalPremium = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .sum();

        policies.forEach(p -> System.out.println(p.policyNumber + " - " + p.holderName + " - $" + p.premiumAmount));

        List<InsurancePolicy> premiumBetween1000And2000 = policies.stream()
                .filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000)
                .collect(Collectors.toList());

        Optional<InsurancePolicy> highestPremiumPolicy = policies.stream()
                .max(Comparator.comparingDouble(p -> p.premiumAmount));

        Map<Character, List<InsurancePolicy>> groupByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));

        double averagePremium = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .average()
                .orElse(0);

        List<InsurancePolicy> sortedByPremium = policies.stream()
                .sorted(Comparator.comparingDouble(p -> p.premiumAmount))
                .collect(Collectors.toList());
        sortedByPremium.forEach(System.out::println);

        boolean anyPolicyAbove2000 = policies.stream()
                .anyMatch(p -> p.premiumAmount > 2000);

        Map<String, Long> premiumRanges = policies.stream()
                .collect(Collectors.groupingBy(
                        p -> p.premiumAmount <= 1000 ? "$0-$1000" : p.premiumAmount <= 2000 ? "$1001-$2000" : ">$2000",
                        Collectors.counting()
                ));

        List<String> uniqueHolderNames = policies.stream()
                .map(p -> p.holderName)
                .distinct()
                .collect(Collectors.toList());

        List<InsurancePolicy> holdersWithSubstring = policies.stream()
                .filter(p -> p.holderName.contains("Smith"))
                .collect(Collectors.toList());

        Map<String, Double> policyToPremium = policies.stream()
                .collect(Collectors.toMap(p -> p.policyNumber, p -> p.premiumAmount));

        String text = "Java is great. Java is powerful. Java is fun. Programming in Java is enjoyable.";
        List<String> words = Arrays.asList(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"));

        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> topWords = wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());
        topWords.forEach(System.out::println);

        Optional<Map.Entry<String, Long>> secondMostRepeated = wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst();
        secondMostRepeated.ifPresent(System.out::println);
    }
}
