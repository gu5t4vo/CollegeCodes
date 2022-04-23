package lista3;
import java.util.Scanner;

public class Q13 {
    public static int mdc(int x, int y){
        if (x == 0) return y;
        else if (y == 0) return x;
        else return mdc(y, x % y);
    }



    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("=-=-=-=- GREATEST COMMON DIVISOR -=-=-=-=\n");
        System.out.print("Enter x:\040");
        int x = read.nextInt();
        System.out.print("Enter y:\040");
        int y = read.nextInt();
        System.out.printf("The greatest common divisor between %d and %d is %d", x, y, mdc(x, y));
    }
}
