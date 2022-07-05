package com.develogical;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " + "English poet, playwright, and " + "actor, widely regarded as the greatest " + "writer in the English language and the world's " + "pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("name")) {
            return "Julian";
        } else if (query.toLowerCase().contains("plus")) {
            String[] f = query.toLowerCase().split("plus");
            String[] g = f[0].split(" ");
            String s1 = g[g.length - 1].trim();
            String s2 = f[1].trim();
            return (Integer.parseInt(s1) + Integer.parseInt(s2)) + "";
        } else if (query.toLowerCase().contains("largest")) {
            String[] f = query.toLowerCase().split("largest:");
            String number = f[1].trim();
            String[] numbers = number.split(",");
            List<String> nrs = Arrays.asList(numbers);
            Optional<Integer> g = nrs.stream().map(e -> Integer.parseInt(e.trim())).max(Integer::compare);
            if (!g.isPresent()) {
                throw new RuntimeException("no numbers");
            }
            return g.get() + "";
        }
        return "";
    }
}
