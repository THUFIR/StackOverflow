package ratios;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;

public class Ratios {

    private String input = "AB: 272/272  CD: 204/529  EFGH: 105 HIJKL: 105  MN: 0 OPQ: 0%";
    private Map<String, String> ms = new HashMap<>();
    private Map<String, Ratio> mr = new HashMap<>();

    public Ratios() {
        populateMap();
        ratios();
        printMap(mr);
    }

    public static void main(String[] args) {
        new Ratios();
    }

    private  void ratios() {
        Pattern pattern = Pattern.compile("(\\d+)/(\\d+)");
        Pattern p2 = Pattern.compile("(\\w+)");
        Matcher m2;
        int num, den;
        Ratio ratio = null;
        for (Map.Entry<String, String> e : ms.entrySet()) {
            ratio = null;
            num = 0;
            den = 1;
            Matcher matcher = pattern.matcher(e.getValue());
            while (matcher.find()) {
                num = Integer.parseInt(matcher.group(1));
                den = Integer.parseInt(matcher.group(2));
                ratio = new Ratio(num, den);
            }
            if (ratio == null) {
                m2 = p2.matcher(e.getValue());
                while (m2.find()) {
                    num = Integer.parseInt(m2.group());
                    den = 1;
                    ratio = new Ratio(num, den);
                }
            }
           mr.put(e.getKey(), ratio);
        }
    }

    private void populateMap() {
        Pattern pattern = Pattern.compile("(\\w+): +(\\S+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            ms.put(matcher.group(1), matcher.group(2));
        }
    }

    private void printMap(Map<?, ?> m) {
        for (Map.Entry<?, ?> e : m.entrySet()) {
            String key = e.getKey().toString();
            String val = e.getValue().toString();
            out.println(key + "\t\t" + val);
        }
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