package lista3;

import java.util.Scanner;

public class Q6 {
    public static int factorial(int num){
        if (num == 1 || num == 0){
            return 1;
        } else{
            return num * factorial(num - 1);
        }
    }

    public static long superFactorial(int num){
        if (num == 1 || num == 0){
            return 1;
        } else{
            return factorial(num) * superFactorial(num - 1);
        }
    }



    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter a number:\040");
        int num = read.nextInt();
        for (int i = num; i >= 1 ; i--) {
            System.out.print(i + "! ");
            if(i == 1){
                System.out.print("= " + superFactorial(num));
            } else {
                System.out.print("x ");
            }
        }
    }
}
