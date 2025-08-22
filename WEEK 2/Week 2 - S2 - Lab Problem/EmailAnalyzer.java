import java.util.*;
public class EmailAnalyzer {
    public static boolean isValidEmail(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.lastIndexOf('.');
        return at > 0 && at == lastAt && dot > at + 1 && dot < email.length() - 1;
    }
 public static String[] extractParts(String email) {
        int at = email.indexOf('@');
        int dot = email.lastIndexOf('.');
        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        String domainName = email.substring(at + 1, dot);
        String extension = email.substring(dot + 1);
        return new String[]{username, domain, domainName, extension};
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) emails.add(sc.nextLine());
        int valid = 0, invalid = 0, totalLen = 0;
        Map<String, Integer> domainCount = new HashMap<>();
        System.out.println("Email\tUsername\tDomain\tDomainName\tExtension\tValid/Invalid");
        for (String e : emails) {
            if (isValidEmail(e)) {
                valid++;
                String[] parts = extractParts(e);
                totalLen += parts[0].length();
                domainCount.put(parts[1], domainCount.getOrDefault(parts[1], 0) + 1);
                System.out.println(e + "\t" + parts[0] + "\t" + parts[1] + "\t" + parts[2] + "\t" + parts[3] + "\tValid");
            } else {
                invalid++;
                System.out.println(e + "\t-\t-\t-\t-\tInvalid");
            }
        }
String mostCommonDomain = domainCount.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("None");
        System.out.println("Valid: " + valid + ", Invalid: " + invalid);
        System.out.println("Most Common Domain: " + mostCommonDomain);
        if (valid > 0) System.out.println("Average Username Length: " + (totalLen / valid));
    }
}
