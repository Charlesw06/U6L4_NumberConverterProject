public class Tester {
    public static void main(String[] args) {
        System.out.println(Tester.baseConversion(505, 16));
    }

    public static String baseConversion (int num, int newBase) {
        String result = "";
        while (num != 0) {
            result = num % newBase + result;
            num = num / newBase;
        }
        return result;
    }
}
