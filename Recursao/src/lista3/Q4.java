package lista3;

public class Q4 {
    public static void printEvenNumbers(int end){
        if (end % 10 == 0){
            System.out.println();
        }
        if (end == 0){
            return;
        }
        else if(end % 2 == 1){
            printEvenNumbers(end - 1);
        }
        else{
            System.out.print(end + "\t");
            printEvenNumbers(end - 2);
        }
    }

    public static void main(String[] args) {
        printEvenNumbers(100);
    }
}
