package ratios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;

public class Ratios {

    private static String input = "AB: 272/272  CD: 204/529  EFGH: 105 HIJKL: 105  MN: 0 OPQ: 0%";

    public Ratios() {
        regex();
    }

    public static void main(String[] args) {
        new Ratios();
    }

    private void regex() {
        Pattern pattern = Pattern.compile("(?<key>\\w+)\\s*:\\s*(?<numerator>\\d+)/*(?<denominator>\\d*)%*");
        Matcher matcher = pattern.matcher(input);
        String k, n, d;
        while (matcher.find()) {
            k = matcher.group("key");
            n = matcher.group("numerator");
            d = matcher.group("denominator");
            out.printf("Key: %s, Numerator: %s, Denominator: %s\n", k, n, d);
        }
    }
}