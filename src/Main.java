import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        if (input.isEmpty() || input.isBlank() || input.length() == 1) {
            System.out.print(0);
            return;
        }

        char[] chars = input.toCharArray();

        int rights = 0;
        for (char ch : chars) {
            if (ch == ')') rights++;
        }

        int rightsDecr = rights, diff = 0, leftsIncr = 0;
        for (char ch : chars) {
            if (ch == '(' && leftsIncr < rightsDecr) {
                sb.append('(');
                diff++;
                leftsIncr++;
            }

            if (ch == ')' && diff == 0) rightsDecr--;

            if (ch == ')' && diff > 0) {
                sb.append(')');
                diff--;
            }
        }

        String output = sb.toString();

        if (output.isEmpty()) {
            System.out.print(0);
        } else {
            System.out.print(output.length() + " - " + output);
        }

        sc.close();
    }
}