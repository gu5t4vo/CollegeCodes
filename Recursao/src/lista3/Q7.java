package lista3;

import java.util.Scanner;

public class Q7 {
    public static int pellNumber(int index){
        if (index == 0){
            return 0;
        } else if(index == 1) {
            return 1;
        } else {
            return 2 * pellNumber(index - 1) + pellNumber(index - 2);
        }
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Number of terms of the Pell sequence that you want to see:\040");
        int index = read.nextInt();

        for (int i = 0; i < index; i++) {
            System.out.print(pellNumber(i) + "\t\t");
            if(i > 0 && (i+1) % 10 == 0){
                System.out.println();
            }
        }
    }
}
