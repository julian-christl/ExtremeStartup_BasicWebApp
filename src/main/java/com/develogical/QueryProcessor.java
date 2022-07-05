package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " + "English poet, playwright, and " +
                    "actor, widely regarded as the greatest " + "writer in the English language and the world's " +
                    "pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("name")) {
            return "Julian";
        } else if (query.toLowerCase().contains("plus")){
            String [] f = query.toLowerCase().split("plus");
            String[] g = f[0].split(" ");
            String s1 = g[g.length-1].trim();
            String s2 = f[1].trim();
            return (Integer.parseInt(s1) + Integer.parseInt(s2))+"";
        }
        return "";
    }
}
