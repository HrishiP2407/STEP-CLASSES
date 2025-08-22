import java.util.*;
public class CaseConverter {
    public static char toUpper(char c) {
        if (c >= 'a' && c <= 'z') return (char)(c - 32);
        return c;
    }
 public static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c + 32);
        return c;
    }
public static String toUpperCaseManual(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) sb.append(toUpper(c));
        return sb.toString();
    }
 public static String toLowerCaseManual(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) sb.append(toLower(c));
        return sb.toString();
    }
public static String toTitleCase(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                start = true;
            } else if (start) {
                sb.append(toUpper(c));
                start = false;
            } else sb.append(toLower(c));
        }
        return sb.toString();
    }
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String upper = toUpperCaseManual(text);
        String lower = toLowerCaseManual(text);
        String title = toTitleCase(text);
        System.out.println("Text\tManual\tBuilt-in");
        System.out.println("Upper\t" + upper + "\t" + text.toUpperCase());
        System.out.println("Lower\t" + lower + "\t" + text.toLowerCase());
        System.out.println("Title\t" + title);
    }
}
