import javax.swing.JOptionPane;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Step 1: Currency Selection
        String baseCurrency = JOptionPane.showInputDialog(null, "Enter the base currency (e.g., USD):");
        String targetCurrency = JOptionPane.showInputDialog(null, "Enter the target currency (e.g., EUR):");

        // Step 2: Currency Rates (Simulated)
        // In a real implementation, you would fetch exchange rates from an API
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        // Step 3: Amount Input
        String amountStr = JOptionPane.showInputDialog(null, "Enter the amount to convert:");
        double amount = Double.parseDouble(amountStr);

        // Step 4: Currency Conversion
        double convertedAmount = amount * exchangeRate;

        // Step 5: Display Result
        String message = String.format("%.2f %s is equivalent to %.2f %s", amount, baseCurrency, convertedAmount, targetCurrency);
        JOptionPane.showMessageDialog(null, message, "Currency Conversion Result", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to fetch exchange rate (Simulated)
    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Simulated exchange rates
        // In a real implementation, this method would fetch rates from an API
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85; // Simulated exchange rate for USD to EUR
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return 1.18; // Simulated exchange rate for EUR to USD
        } else {
            // For other currency pairs, you would need to provide appropriate exchange rates
            return 1.0; // Assuming same currency, no conversion needed
        }
    }
}
