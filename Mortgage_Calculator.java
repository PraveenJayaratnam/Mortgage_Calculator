import java.text.NumberFormat;
import java.util.Scanner;
public class Mortgage_Calculator {
    public static void main(String[] args){
        final byte months_in_year = 12;
        final byte percentage = 100;
        Scanner sc = new Scanner(System.in);
        int principal = 0;
        float annual_interest = 0;
        byte periods = 0;

        while(true) {
            System.out.print("Principal ($1K-$1M): ");
            principal = sc.nextInt();
            if ((principal > 1000) && (principal < 1_000_000))
                break;
            System.out.println("Enter value between 1000 and 1 Million");
        }

        while(true) {
            System.out.print("Annual interest(0-30): ");
            annual_interest = sc.nextFloat();
            if ((annual_interest > 0) && (annual_interest < 30))
                break;
            System.out.println("Enter value between 0 and 30");
        }

        while(true) {
            System.out.print("Periods (Years): ");
            periods = sc.nextByte();
            if ((periods > 0) && (periods < 30))
                break;
            System.out.println("Enter value between 0 and 30");
        }

        float monthly_interest = annual_interest/months_in_year/percentage;
        int number_of_payments = periods*months_in_year;
        double mortgage = principal*(monthly_interest*Math.pow(1+monthly_interest,number_of_payments))/(Math.pow(1+monthly_interest,number_of_payments)-1);
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: "+result);

    }
}

