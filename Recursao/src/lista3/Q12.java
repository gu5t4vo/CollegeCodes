package lista3;

import java.util.Scanner;

public class Q12 {
    public static int tetranacciTerm(int t0, int t1, int t2, int t3, int index){
        if (index == 0) return t0;
        else if (index == 1) return t1;
        else if (index == 2) return t2;
        else if (index == 3) return t3;
        else {
            return tetranacciTerm(t0, t1, t2, t3, index - 1) +
                    tetranacciTerm(t0, t1, t2, t3, index - 2)+
                    tetranacciTerm(t0, t1, t2, t3, index - 3) +
                    tetranacciTerm(t0, t1, t2, t3, index - 4);
        }
    }



    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("=-=-=-=- TETRANACCI SEQUENCE -=-=-=-=\n");
        System.out.print("1st term:\040");
        int t0 = read.nextInt();
        System.out.print("2nd term:\040");
        int t1 = read.nextInt();
        System.out.print("3rd term:\040");
        int t2 = read.nextInt();
        System.out.print("4th term:\040");
        int t3 = read.nextInt();
        System.out.println("--------------------------------------");
        System.out.print("How many terms do you want to see?\040");
        int index = read.nextInt();
        for (int i = 0; i < index; i++) {
            System.out.printf("[ %d ]\t ", tetranacciTerm(t0, t1, t2, t3, i));
            if ((i + 1) % 7 == 0){
                System.out.println();
            }
        }
    }
}
