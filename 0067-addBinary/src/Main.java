public class Main {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int maxLength = Math.max(a.length(),b.length());
        a = reserveString(a);
        b = reserveString(b);
        int trailing = 0;
        for (int i=0; i< maxLength;i++) {
            char aC = i < a.length() ? a.charAt(i) : '0';
            char bC = i < b.length() ? b.charAt(i): '0';
            if(aC == '1' && bC == '1') {
                result.append(trailing);
                trailing = 1;
            }
            else if ((aC == '1' && bC == '0') || (aC=='0' && bC == '1')) {
                if (trailing == 1) {
                    result.append(0);
                }
                else {
                    result.append(1);
                }
            }
            else {
                result.append(trailing);
                trailing = 0;
            }
        }

        if (trailing == 1) result.append(trailing);
        return result.reverse().toString();
    }

    public static String reserveString (String s) {
        StringBuilder reversed = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }
}