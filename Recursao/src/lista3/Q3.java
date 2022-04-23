package lista3;

public class Q3 {
    public static int add(int num, int amount){
        if (num == num + amount){
            return num;
        }
        num++;
        return add(num, amount - 1);
    }

    public static void main(String[] args) {
        int c = 0;
        System.out.println(c);
        c = add(c, 100);
        System.out.println(c);
    }
}
