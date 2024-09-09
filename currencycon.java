import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("EUR", 0.93); // 1 USD to EUR
        exchangeRates.put("JPY", 150.00); // 1 USD to JPY
        exchangeRates.put("GBP", 0.76); // 1 USD to GBP
        exchangeRates.put("INR", 83.00); // 1 USD to INR
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the target currency (e.g., EUR, JPY, GBP, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        
        System.out.print("Enter the amount in USD to convert: ");
        double amount = scanner.nextDouble();

        try {
           
            double convertedAmount = convertCurrency(amount, targetCurrency);

           
            if (convertedAmount >= 0) {
                System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
            } else {
                System.out.println("Target currency not available.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    private static double convertCurrency(double amount, String targetCurrency) {
        Double rate = exchangeRates.get(targetCurrency);
        if (rate != null) {
            return amount * rate;
        } else {
            return -1; 
        }
    }
}
