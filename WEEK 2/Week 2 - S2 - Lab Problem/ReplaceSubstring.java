import java.util.*;
public class ReplaceSubstring {
    public static int[] findOccurrences(String text, String find) {
        List<Integer> list = new ArrayList<>();
        int index = text.indexOf(find);
        while (index >= 0) {
            list.add(index);
            index = text.indexOf(find, index + 1);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
 public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length();) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
 public static boolean compareResults(String original, String manual, String find, String replace) {
        return original.replace(find, replace).equals(manual);
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String find = sc.nextLine();
        String replace = sc.nextLine();
        String manual = manualReplace(text, find, replace);
        System.out.println("Manual Result: " + manual);
        System.out.println("Built-in Result: " + text.replace(find, replace));
        System.out.println("Match: " + compareResults(text, manual, find, replace));
    }
}
