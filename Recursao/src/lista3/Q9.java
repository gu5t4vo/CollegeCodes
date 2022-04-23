package lista3;

import java.util.Scanner;

public class Q9 {
    public static int fetuccineNumb(int t0, int t1, int index){
        if (index == 0){
            return t0;
        } else if (index == 1){
            return t1;
        } else {
            if(index % 2 == 0){
                return fetuccineNumb(t0, t1, index - 1) -
                        fetuccineNumb(t0, t1, index - 2);
            } else{
                return fetuccineNumb(t0, t1, index - 1) +
                        fetuccineNumb(t0, t1, index - 2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("=-=-=-=- FETUCCINE SEQUENCE -=-=-=-=\n");
        System.out.print("Enter the first term of the sequence:\040");
        int t0 = read.nextInt();
        System.out.print("Enter the second term of the sequence:\040");
        int t1 = read.nextInt();
        System.out.print("How many terms do you want to see?\040");
        int index = read.nextInt();
        for (int i = 0; i < index; i++) {
            System.out.print("[ " + fetuccineNumb(t0, t1, i) + " ]\t ");
            if (i != 0 && (i + 1) % 7 == 0){
                System.out.println();
            }
        }

    }
}
