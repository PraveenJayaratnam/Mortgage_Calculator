import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage_Calculator {
    public static void main(String[] args) {
        int principal = 0;
        float annualInterest = 0;
        byte years = 0;

        principal = (int)(readNumber("Principal ($1K-$1M): ",1000,1_000_000));
        annualInterest = (float)(readNumber("Annual Interest: ",0,30));
        years = (byte)readNumber("Periods (Years): ",0,30);

        double mortgage = mortgageCalculator(principal,annualInterest,years);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + formattedMortgage);
    }

    public static double readNumber(String  prompt,double min,double max){
        Scanner sc = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = sc.nextFloat();
            if ((value > min) && (value <= max))
                break;
            System.out.println("Enter value between " +min+" and "+max);
        }
        return value;
    }

    public static double mortgageCalculator(int principal, float annualInterest, byte years) {
        final byte months_in_year = 12;
        final byte percentage = 100;
        float monthly_interest = annualInterest / months_in_year / percentage;
        short number_of_payments = (short) (years * months_in_year);
        double mortgage = principal * (monthly_interest * Math.pow(1 + monthly_interest,
                number_of_payments)) / (Math.pow(1 + monthly_interest, number_of_payments) - 1);
        return mortgage;
    }

}

