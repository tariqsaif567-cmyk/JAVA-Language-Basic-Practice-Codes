package Recursion;

import java.util.Scanner;

public class subStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    }

    public String subSets(String str) {

        if (str == "")
            return "";
        String subsets = "" + subSets(str.substring(1) + " " + subSets(str.substring(0, 0)));
    }

}
