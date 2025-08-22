import java.util.*;
public class TextFormatter {
    public static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) words.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) words.add(text.substring(start));
        return words;
    }
public static List<String> justifyText(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        int i = 0;
        while (i < words.size()) {
            int j = i, lineLen = 0;
            while (j < words.size() && lineLen + words.get(j).length() + (j - i) <= width) {
                lineLen += words.get(j).length();
                j++;
            }
            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();
            if (j == words.size() || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words.get(k));
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < width) sb.append(" ");
            } else {
                int spaces = (width - lineLen) / gaps;
                int extra = (width - lineLen) % gaps;
                for (int k = i; k < j; k++) {
                    sb.append(words.get(k));
                    if (k < j - 1) {
                        for (int s = 0; s < spaces; s++) sb.append(" ");
                        if (extra-- > 0) sb.append(" ");
                    }
                }
            }
            lines.add(sb.toString());
            i = j;
        }
        return lines;
    }
 public static List<String> centerAlign(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() + word.length() + 1 > width) {
                int padding = (width - sb.length()) / 2;
                lines.add(" ".repeat(padding) + sb.toString());
                sb = new StringBuilder();
            }
            if (sb.length() > 0) sb.append(" ");
            sb.append(word);
        }
        if (sb.length() > 0) {
            int padding = (width - sb.length()) / 2;
            lines.add(" ".repeat(padding) + sb.toString());
        }
        return lines;
    }
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int width = sc.nextInt();
        List<String> words = splitWords(text);
        List<String> justified = justifyText(words, width);
        List<String> centered = centerAlign(words, width);
        System.out.println("Justified:");
        int lineNum = 1;
        for (String line : justified) System.out.println(lineNum++ + ": " + line + " (" + line.length() + ")");
        System.out.println("Centered:");
        lineNum = 1;
        for (String line : centered) System.out.println(lineNum++ + ": " + line + " (" + line.length() + ")");
    }
}
