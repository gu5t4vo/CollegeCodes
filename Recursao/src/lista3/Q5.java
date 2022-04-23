package lista3;

import java.util.Scanner;

public class Q5 {

    public static int doubleFactorial(int num){
        if(num % 2 == 0){
            return -1;
        }
        else{
            if(num == 1){
                return 1;
            }
            else {
                return num * doubleFactorial(num-2);
            }
        }
    }



    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter a number:\040");
        int num = read.nextInt();
        System.out.println("Double factorial of " + num);
        if(doubleFactorial(num) == -1){
            System.out.println("Invalid number");
        } else {
            for (int i = num; i >= 1; i -= 2) {
                System.out.printf("%d ", i);
                if (i == 1) {
                    System.out.print("= " + doubleFactorial(num));
                } else {
                    System.out.print("x ");
                }
            }
        }
    }
}
