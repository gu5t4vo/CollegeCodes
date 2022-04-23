package lista3;

import java.util.Scanner;

public class Q11 {
    public static int q11SequenceTerm(int index){
        if (index == 0) return 1;
        else if (index == 1 || index == 2) return 4;
        else {
            if (index % 3 == 0) return 1 + index/3;
            else {
                if(index % 3 == 1) return q11SequenceTerm(index - 1) + 3;
                else return q11SequenceTerm(index - 2) + 3;
            }
        }
    }



    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        System.out.println("=-=-=-=-=- Q11 SEQUENCE -=-=-=-=-=\n");
        System.out.print("How many terms do you want to print?\040");
        int index = read.nextInt();
        for (int i = 0; i < index; i++) {
            System.out.printf("[ %d ]\t ", q11SequenceTerm(i));
            if ((i + 1) % 7 == 0){
                System.out.println();
            }
        }
    }
}
