package lista3;

import java.util.Arrays;

public class Q2 {
    public static int summation(int[] vet){
        int i = 0;
        while (vet[i] == 0){
            i++;
            if (vet[vet.length - 1] == 0){
                return vet[i];
            }
        }
        int save = vet[i];
        vet[i] = 0;
        return save + summation(vet);
    }

    public static int[] newRandomVet(int size){
        int[] vet = new int[size];
        for(int i = 0; i < size; i++){
            vet[i] = (int)(Math.random()*20);
        }
        return vet;
    }

    public static void main(String[] args) {
        int[] vet = newRandomVet(10);
        System.out.println(Arrays.toString(vet));
        System.out.println(summation(vet));
    }
}
