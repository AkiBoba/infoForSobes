package src.algoses;

import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();
        List chars = new ArrayList();
        String maxSubString = "";
        int maxSub = 0;
        for (String chr : str.split("")) {
            if (chars.contains(chr) && maxSub <= chars.size()) {
                maxSub = chars.size();
                maxSubString = String.join(", ", chars);
                chars.clear();
                chars.add(chr);
            } else chars.add(chr);
        }

        System.out.println(maxSub);
        System.out.println(maxSubString);
    }
}
