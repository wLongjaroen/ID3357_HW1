
import java.util.Scanner;

public class TexCalculator {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        // Field
        int[] IncomeRange = new int[4];
        int[] TaxRate = new int[4];
        int TotalTax = 0;
        int Income = 0;
        int MaxTaxRate = 0;

        // Get IncomeRange and TaxRate
        for (int i = 0; i < 4; i++) {
            System.out.print("Please enter income and  tax rate  in tax bracket ");
            System.out.print(i + 1);
            System.out.print(" : ");
            IncomeRange[i] = sn.nextInt();
            TaxRate[i] = sn.nextInt();
        }

        // input MaxTaxRtae
        System.out.print("Please enter tax rate if income > ");
        System.out.print(IncomeRange[3]);
        System.out.print(" : ");
        MaxTaxRate = sn.nextInt();

        // input Income
        System.out.print("Please enter income : ");
        Income = sn.nextInt();

        // Calculate tax and print detail
        int base = 0;
        for (int i = 0; i < 4; i++) {
            if (Income >= IncomeRange[i]) {
                int tax = (int)((IncomeRange[i] - base) * (TaxRate[i] / 100.0));
                if (i == 0) {
                    System.out.print((base) + " - " + IncomeRange[i] + " you pay " + 0);
                } else {
                    System.out.print((base + 1) + " - " + IncomeRange[i] + " you pay " + (IncomeRange[i] - base) + " x " + (TaxRate[i] / 100.0));
                    System.out.print(" = " + tax);
                }
                System.out.println(" baht");
                TotalTax = TotalTax + tax;
                base = IncomeRange[i];
            } else {
                int tax = (int) ((Income - base) * (TaxRate[i] / 100.0));
                System.out.print((base + 1) + " - " + Income + " you pay " + (Income - base) + " x " + (TaxRate[i] / 100.0));
                System.out.println(" = " + tax +" baht");
                TotalTax = TotalTax + tax;
            }
        }

        if (Income > IncomeRange[3]) {
            int tax = (int) ((Income - IncomeRange[3]) * (MaxTaxRate / 100.0));
            System.out.print((base + 1) + " - " + Income + " you pay " + (Income - IncomeRange[3]) + " x " + (MaxTaxRate / 100.0) + " baht");
            System.out.println(" = " + tax + " baht");
            TotalTax = TotalTax + (int) ((Income - IncomeRange[3]) * (MaxTaxRate / 100.0));
        }

        // print Total tax
        System.out.print("Total Tax : ");
        System.out.print(TotalTax);
        System.out.println(" baht");
    }

}
