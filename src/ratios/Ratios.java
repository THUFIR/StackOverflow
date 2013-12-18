package ratios;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;

public class Ratios {

    private String input = "AB: 272/272  CD: 204/529  EFGH: 105 HIJKL: 105  MN: 0 OPQ: 0%";
    private Map<String, String> map1 = new HashMap<>();
    private Map<String, Ratio> map2 = new HashMap<>();

    public Ratios() {
        firstMap();
        secondMap();
        printMap(map2);
    }

    public static void main(String[] args) {
        new Ratios();
    }

    private void secondMap() {
        Pattern fraction = Pattern.compile("(\\d+)/(\\d+)");
        Pattern whole = Pattern.compile("(\\d+)");
        Pattern percent = Pattern.compile("(\\d+)%");
        Matcher matcher;
        int num, den;
        Ratio ratio = null;
        for (Map.Entry<String, String> e : map1.entrySet()) {

            matcher = whole.matcher(e.getValue());
            while (matcher.find()) {
                num = Integer.parseInt(matcher.group(1));
                den = 1;
                ratio = new Ratio(num, den);
            }

            matcher = fraction.matcher(e.getValue());
            while (matcher.find()) {
                num = Integer.parseInt(matcher.group(1));
                den = Integer.parseInt(matcher.group(2));
                ratio = new Ratio(num, den);
            }


            matcher = percent.matcher(e.getValue());
            while (matcher.find()) {
                num = Integer.parseInt(matcher.group(1));
                den = 100;
                ratio = new Ratio(num, den);
            }


            map2.put(e.getKey(), ratio);
        }
    }

    private void firstMap() {
        Pattern pattern = Pattern.compile("(\\w+): +(\\S+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            map1.put(matcher.group(1), matcher.group(2));
        }
    }

    private void printMap(Map<?, ?> m) {
        for (Map.Entry<?, ?> e : m.entrySet()) {
            String key = e.getKey().toString();
            String val = e.getValue().toString();
            out.println(key + "\t\t" + val);
        }
    }
}