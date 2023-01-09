public class NumberConverter {
    int[] digits;
    int base;

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

    public int convertToDecimal() {
        int numInDecimal = 0;
        if ((base == 2) || (base == 8) || (base == 10)) {
            int pow = digits.length;
            for (int i = 0; i < digits.length; i++) {
                pow--;
                numInDecimal += digits[i] * Math.pow(base, pow);
            }
        }
        return numInDecimal;
    }

    public int convertToBinary() {
        int numInDecimal = convertToDecimal();
        String numInBinary = "";
        if ((base == 8) || (base == 10) || (base == 2)) {
            boolean powFound = false;
            int currentPow = 0;
            while (!powFound) {
                if (Math.pow(2, currentPow) > numInDecimal) {
                    powFound = true;
                }
                else {
                    currentPow++;
                }
            }
            for (int i = currentPow - 1; i >= 0 ; i--) {
                numInBinary += numInDecimal / (int) (Math.pow(2, i));
            }
        }
        return Integer.parseInt(numInBinary);
    }

    public int convertToOctal() {
        int numInDecimal = convertToDecimal();
        String numInOctal = "";
        if ((base == 2) || (base == 10) || (base == 8)) {
            boolean powFound = false;
            int currentPow = 0;
            while (!powFound) {
                if (Math.pow(2, currentPow) > numInDecimal) {
                    powFound = true;
                }
                else {
                    currentPow++;
                }
            }
            for (int i = currentPow - 1; i >= 0 ; i--) {
                numInOctal += numInDecimal / (int) (Math.pow(8, i));
            }
        }
        return Integer.parseInt(numInOctal);
    }
}

