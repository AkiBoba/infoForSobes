package src.algoses;

import java.util.Scanner;

public class recurs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number a: ");
        int a = Integer.parseInt(in.nextLine());
        System.out.print("Input a number b: ");
        int b = Integer.parseInt(in.nextLine());
        System.out.println(mult(a, b));


    }
    static int mult(int a, int b){
        if (b == 0) return 0;
        if (b == 1) return a;
        else {
            a += a + mult(a, b - 1);
        }
return a;
    }
}
