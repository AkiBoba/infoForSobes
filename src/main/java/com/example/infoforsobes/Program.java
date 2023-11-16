package com.example.infoforsobes;

public class Program {
    public static void main (String args[]){

        sum(1, 2, 3);           // 6
        sum(1, 2, 3, 4, 5);     // 15
        sum();                  // 0
    }
    static void sum(int ...nums){

        int result =0;
        for(int n: nums)
            result += n;
        System.out.println(result);
    }
}
