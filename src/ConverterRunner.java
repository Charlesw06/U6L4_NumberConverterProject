import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, 16, or s {base 10 to any base}): ");

        boolean specialConvert = false;
        Scanner s = new Scanner(System.in);
        String base = s.nextLine();

        while ((!base.equals("2")) && (!base.equals("8")) && (!base.equals("10")) && (!base.equals("16")) && (!base.equals("s"))) {
            System.out.print("Please enter a valid base: ");
            base = s.nextLine();
        }

        if (base.equals("s")) {
            specialConvert = true;
            base = "10";
        }
        System.out.print("Enter your number: ");
        String number = s.nextLine();
        boolean validNum = false;

        while (!validNum) {
            validNum = true;
            for (int i = 0; i < number.length(); i++) {
                char x = number.charAt(i);
                int index = NumberConverter.digitMap.indexOf(x);
                if ((index == -1) || (index >= Integer.parseInt(base))) {
                    validNum = false;
                }
            }
            if (number.equals("")) {
                validNum = false;
            }
            if (!validNum) {
                System.out.print("Please enter a valid number for the base: ");
                number = s.nextLine();
            }
        }

        NumberConverter nc = new NumberConverter(number, Integer.parseInt(base));
        String[] digits = nc.getDigits();
        System.out.println("\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());

        if (specialConvert) {
            System.out.print("Enter a base to convert the number to (2 to 64): ");
            Scanner sc = new Scanner(System.in);
            String newBase = sc.nextLine();
            boolean validBase = false;

            while (!validBase) {
                validBase = true;
                for (int i = 0; i < newBase.length(); i++) {
                    if (!Character.isDigit(newBase.charAt(i))) {
                        validBase = false;
                    }
                }
                if (validBase) {
                    if ((newBase.equals("")) || (Integer.parseInt(newBase) <= 1) || (Integer.parseInt(newBase) > 64)) {
                        validBase = false;
                    }
                }
                if (!validBase) {
                    System.out.print("Please enter a valid base: ");
                    newBase = sc.nextLine();
                }
            }
            String convertedNum = nc.convertToBase(Integer.parseInt(newBase));
            System.out.println("Converted number: " + convertedNum);
        }
        else {
            if (base.equals("2")) {
                System.out.println("Decimal Number: " + nc.convertToDecimal());
                System.out.println("Octal Number: " + nc.convertToOctal());
                System.out.println("Hexadecimal Number: " + nc.convertToHex());
            }
            if (base.equals("8")) {
                System.out.println("Decimal Number: " + nc.convertToDecimal());
                System.out.println("Binary Number: " + nc.convertToBinary());
                System.out.println("Hexadecimal Number: " + nc.convertToHex());
            }
            if (base.equals("10")) {
                System.out.println("Binary Number: " + nc.convertToBinary());
                System.out.println("Octal Number: " + nc.convertToOctal());
                System.out.println("Hexadecimal Number: " + nc.convertToHex());
            }
            if (base.equals("16")) {
                System.out.println("Decimal Number: " + nc.convertToDecimal());
                System.out.println("Binary Number: " + nc.convertToBinary());
                System.out.println("Octal Number: " + nc.convertToOctal());
            }
        }
    }
}