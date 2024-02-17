package myclient;

import finance.Financial;
import finance.RateUnavailableException;

import java.util.Arrays;
import java.util.List;

/**
 * javac -cp ./lib/MyFinancialLib.jar src/myclient/*.java -d classes
 * java -cp ./lib/MyFinancialLib.jar:./classes myclient.SimpleClient
 *
 */
public class SimpleClient {

    public static void main(String[] args) {
        Financial financial = new Financial();

        List<Double> doubleList = Arrays.asList(1D, 2D, 3D, 4D);
        double avg = financial.calculateAverage(doubleList);
        System.out.println("Avg : " + avg);

        try {
            double amount = financial.calculateChange("CHF", "USD", 500D);
            System.out.println("Montant du change : " + amount);
        } catch (RateUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }
}