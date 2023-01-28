public class NumberConverter {
    String[] digits;
    int base;
    final static String digitMap = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";

    public NumberConverter(String number, int base) {
        digits = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String single = number.substring(i,i+1);
            digits[i] = single;
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

    public String[] getDigits() {
        return digits;
    }

    public String convertToBase(int newBase) {
        int numInDecimal = 0;
        for (int i = 0; i < digits.length; i++) {
            numInDecimal += digitMap.indexOf(digits[i]) * Math.pow(base, digits.length - i - 1);
        }
        String result = "";
        while (numInDecimal != 0) {
            result = digitMap.charAt(numInDecimal % newBase) + result;
            numInDecimal = numInDecimal / newBase;
        }
        return result;
    }

    public String convertToDecimal() {
        return convertToBase(10);
    }

    public String convertToBinary() {
        return convertToBase(2);
    }

    public String convertToOctal() {
        return convertToBase(8);
    }

    public String convertToHex() {
        return convertToBase(16);
    }
}

