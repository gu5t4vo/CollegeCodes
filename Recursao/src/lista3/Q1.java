package lista3;

public class Q1 {
    public static void counter(int start, int end){
        if (start < end) {
            System.out.print(start + "\t ");
            start++;
            if(start % 20 == 0){
                System.out.println();
            }
            counter(start, end);
        }
        else{
            System.out.print(start);
        }
    }
    public static void main(String[] args) {
        counter(0, 50);
    }
}
