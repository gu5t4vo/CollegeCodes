package lista3;

import java.util.Scanner;

public class Q8 {
    public static int ricciNumber(int t0, int t1, int index){
        if(index == 0){
            return t0;
        } else if (index == 1){
            return t1;
        } else{
            return ricciNumber(t0, t1, index - 1) + ricciNumber(t0, t1, index - 2);
        }
    }



    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("=-=-=-=- RICCI SEQUENCE -=-=-=-=");
        System.out.print("\nEnter the first term:\040");
        int t0 = read.nextInt();
        System.out.print("Enter the second:\040");
        int t1 = read.nextInt();
        System.out.print("How many terms do you want to see:\040");
        int index = read.nextInt();

        for (int i = 0; i < index; i++) {
            System.out.print(ricciNumber(t0, t1, i) + "\t\t");
            if (i != 0 && i % 10 == 0){
                System.out.println();
            }
        }
    }
}
