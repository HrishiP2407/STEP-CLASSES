import java.util.*;
public class StringPerformance {
    public static long concatString(int n) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) s += "a";
        return System.currentTimeMillis() - start;
    }
public static long concatStringBuilder(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("a");
        return System.currentTimeMillis() - start;
    }
public static long concatStringBuffer(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append("a");
        return System.currentTimeMillis() - start;
    }
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Method\tTime(ms)");
        System.out.println("String\t" + concatString(n));
        System.out.println("StringBuilder\t" + concatStringBuilder(n));
        System.out.println("StringBuffer\t" + concatStringBuffer(n));
    }
}
