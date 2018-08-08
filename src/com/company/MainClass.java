package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        List<String> myStrings = Arrays.asList("ali", "kailm", "ba");
        Collections.sort(myStrings, new MyComparator());
        System.out.println(myStrings);
    }
}

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1 == null || s2 == null) {
            if (s1 == null && s2 != null)
                return -1;
            if (s1 != null && s2 == null)
                return 1;
            return 0;
        }
        return s1.length() - s2.length();
    }
}