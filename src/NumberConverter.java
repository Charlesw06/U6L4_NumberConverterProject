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
        int numInDecimal = 0;
        String number = displayOriginalNumber();
        for (int i = 0; i < num.length; i++) {
            numInDecimal += digitMap.indexOf(number.charAt(i)) * Math.pow(base, number.length() - i - 1);
        }
        boolean powFound = false;
        int currentPow = 0;
        String result = "";
        int tempNum = Integer.parseInt(number);
        int newDigit = 0;
        while (!powFound) {
            if (Math.pow(base, currentPow) > numInDecimal) {
                powFound = true;
            }
            else {
                currentPow++;
            }
        }
        for (int i = currentPow - 1; i >= 0 ; i--) {
            newDigit = tempNum / (int) (Math.pow(base, i));
            result += newDigit;
            tempNum -= newDigit * (int) (Math.pow(base, i));
        }
        return Integer.parseInt(result);
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

