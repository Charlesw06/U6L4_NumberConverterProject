import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        while ((base != 2) && (base != 8) && (base != 10)) {
            choice = s.nextLine();
            base = Integer.parseInt(choice);
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();

        boolean correctNum = false;

        while (!correctNum) {
            if (base == 2) {

            }
            if (base == 8) {

            }
            if (base == 10) {

            }
        }

        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
    }
}