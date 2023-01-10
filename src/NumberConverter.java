public class NumberConverter {
    int[] digits;
    int base;
    final String digitMap = "0123456789ABCDEF";

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int convertToBase(int num[], int base, int resultBase) {
        int result = 0;
        String number = displayOriginalNumber();
        int pow = num.length - 1;
        for (int i = 0; i < num.length; i++) {
            result += digitMap.indexOf(number.charAt(i)) * Math.pow(base, number.length() - i - 1);
        }
        boolean powFound = false;
        int currentPow = 0;
        int last = 0;
        while (!powFound) {
            if (Math.pow(2, currentPow) > result) {
                powFound = true;
            }
            else {
                currentPow++;
            }
        }
        for (int i = currentPow - 1; i >= 0 ; i--) {
            last += Integer.parseInt(number) / (int) (Math.pow(base, i));
        }
        return last;
    }
    public int convertToDecimal() {
        return convertToBase(digits, base, 10);
    }

    public int convertToBinary() {
        return convertToBase(digits, base, 2);
    }

    public int convertToOctal() {
        return convertToBase(digits, base, 8);
    }
}

