package lista3;

import java.util.Scanner;

public class Q10 {
    public static int q10Sequence(int index){
        if (index == 0) {
            return 1;
        } else if (index == 1) {
            return 4;
        } else {
            return q10Sequence(index - 1) + 1 + (2 * index);
        }
    }



    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("=-=-=-=- 10th QUESTION SEQUENCE -=-=-=-=");
        System.out.print("\nUp to what term you want to see?\040");
        int index = read.nextInt();
        for (int i = 0; i < index; i++) {
            System.out.printf("[ %d ]\t",  q10Sequence(i));
            if (i != 0 && (i + 1) % 7 == 0){
                System.out.println();
            }
        }
    }
}
