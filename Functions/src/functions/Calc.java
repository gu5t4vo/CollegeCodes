package functions;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.Thread.sleep;

public class Calc {
    public static int[] newVet(int size) throws InterruptedException {
        System.out.println("A new array will be created");
        sleep(1000);
        System.out.println("New array: \n");
        int[] vet2 = new int[size];
        fuelVet(vet2);
        showVet(vet2);
        return vet2;
    }

    public static void fuelVet(int[] vet) {
        for(int i = 0; i < vet.length; i++) {
            vet[i] = ((int) (Math.random() * 200 - 100));
        }
    }

    public static void showVet(int[] vet){
        System.out.print("{");
        for (int i = 0; i < vet.length; i++) {
            System.out.printf("%d", vet[i]);

            if(i == vet.length - 1){
                System.out.print("}");
            }
            else{
                System.out.print(", ");
            }
        }
    }

    public static int search(int value, int[] vet){
        for(int v = 0; v < vet.length; v++){
            if (vet[v] == value){
                return v;
            }
        }
        return -1;
    } // Return the index

    public static int searchByIndex(int index, int[] vet){
        return vet[index];
    } // Return the element

    public static int positiveCont(int [] vet){
        int acm = 0;
        for (int v: vet) {
            if (v > 0) acm++;
        }
        return acm;
    }

    public static int negativeCont(int[] vet){
        int acm = 0;
        for (int v: vet) {
            if (v < 0) acm++;
        }
        return acm;
    }

    public static void fuelVetNegative(int[] vet, int[] negVet){
        int index = 0;
        for (int v: vet) {
            if (v < 0){
                negVet[index] = v;
                index++;
            }
        }
    }

    public static void fuelVetPositive(int[] vet, int[] positiveVet){
        int index = 0;
        for (int v: vet) {
            if (v > 0){
                positiveVet[index] = v;
                index++;
            }
        }
    }

    public static int vetSummation(int[] vet){
        int acm = 0;
        for (int v: vet) {
            acm += v;
        }
        return acm;
    }

    public static int vetProduct(int[] vet){
        int acm = 1;
        for (int v: vet) {
            acm *= v;
        }
        return acm;
    }

    public static int scalarProduct(int[] vet, int[] vet2){
        int[] productVet = new int[vet.length];
        for (int i = 0; i < vet.length; i++){
            productVet[i] = vet[i] * vet2[i];
        }
        return vetSummation(productVet);
    }

    public static void fuelWithZeros(int[] vet, int value){
        boolean rightValue = false;
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] == value && !rightValue){
                rightValue = true;
            }
            if (rightValue){
                vet[i] = 0;
            }
        }
    }

    public static void pow2Array(int[] vet){
        for(int i = 0; i < vet.length; i++){
            vet[i] = (int) Math.pow(vet[i], 2);
        }
    }

    public static float average(int[] vet){
        return (float) vetSummation(vet)/vet.length;
    }

    public static int max(int[] vet){
        int max = vet[0];
        for (int v: vet){
            if (v > max){
                max = v;
            }
        }
        return max;
    }

    public static int min(int[] vet){
        int min = vet[0];
        for (int v: vet){
            if (v < min){
                min = v;
            }
        }
        return min;
    }

    public static int min(int[] vet, int index){
        int min = vet[index];
        for (int i = index; i < vet.length; i++){
            if(vet[i] < min){
                min = vet[i];
            }
        }
        return min;
    }

    public static Object modalElement(int[] vet){
        int i = 0;
        int[] repeatTerms = new int[vet.length];
        /*If none of the array elements repeats, repeatTerms value
        * will be 1 for all the elements, else, the modal element
        * will be at the index of the highest value present in the array*/

        for(int v: vet){
            for(int k: vet){
                if (v == k){
                    repeatTerms[i]++;
                }
            } i++;
        }
        if (max(repeatTerms) == 1){
            return null;
        }
        else{
            int modalElementIndex = search(max(repeatTerms), repeatTerms);
            return vet[modalElementIndex];
        }
    }

    public static boolean inVet(int item, int[] vet){
        for (int v: vet) {
            if (v == item){
                return true;
            }
        }
        return false;
    }

    public static void vetReplace(int[] vet,int a, int b){
        if(inVet(a, vet) && inVet(b, vet)){
            int indexA = search(a, vet), indexB = search(b, vet);
            vet[indexA] = b;
            vet[indexB] = a;
        }
    }

    public static void sortVet(int[] vet){
        for (int i = 0; i < vet.length; i++){
            vetReplace(vet, min(vet, i), vet[i]);
        }
    }

    public static int median(int[] vet){
        sortVet(vet);
        int medianIndex = (vet.length - 1) / 2;
        return vet[medianIndex];
    }

    public static float standardDeviation(int[] vet){
        float acm = 0;
        for (int v: vet){
            acm += (float) Math.pow(Math.abs(v - average(vet)), 2);
        }
        acm /= vet.length;
        return (float) Math.sqrt(acm);
    }

    public static int[] vetUnion(int[] vet, int[] vet2){
        int[] vetUnion = new int[vet.length + vet2.length];
        int i = 0;
        for (int v: vet){
            vetUnion[i] = v;
            i++;
        }
        for (int v: vet2){
            vetUnion[i] = v;
            i++;
        }
        return vetUnion;
    }

    public static void vetInverter(int[] vet){
        for (int i = 0; i < vet.length/2; i++) {
            vetReplace(vet, vet[i], vet[(vet.length - 1) - i]);
        }
    }

    public static Object intersection(int[] vet, int[] vet2){
        if(contIntersection(vet, vet2) > 0) {
            int repeats = contIntersection(vet, vet2);
            int[] intersection = new int[repeats];
            int index = 0;
            for (int v : vet) {
                for (int k : vet2) {
                    if (k == v) {
                        if(!inVet(k, intersection)) {
                            intersection[index] = k;
                            index++;
                        }
                    }
                }
            }
            return intersection;
        }
        return null;
    }

    public static int contIntersection(int[] vet, int[] vet2){
        int repeats = 0;
        for(int v: vet){
            for (int k: vet2){
                if (k == v){
                    repeats++;
                    break;
                }
            }
        }
        return repeats;
    }

    public static int[] difference(int[] vetA, int[] vetB){
        int[] vetDifference = new int[vetA.length - contIntersection(vetA, vetB)];
        int i = 0;
        for (int a: vetA){
            if(!inVet(a, vetB)){
                vetDifference[i] = a;
                i++;
            }
        }
        return vetDifference;
    }

    public static int vetContPrimes(int[] vet){
        int totPrimes = 0, totDivs = 0;
        for (int v : vet) {
            for (int i = 1; i <= v; i++) {
                if (v % i == 0){
                    totDivs++;
                }
            }
            if(totDivs == 2){
                totPrimes++;
            }
            totDivs = 0;
        }
        return totPrimes;
    }

    public static int[] vetGetPrimes(int[] vet){
        int[] primeVet = new int[vetContPrimes(vet)];
        int index = 0, totDivs = 0;

        for (int v: vet){
            for (int i = 1; i <= v; i++){
                if (v % i == 0){
                    totDivs++;
                }
            }
            if (totDivs == 2){
                primeVet[index] = v;
                index++;
            }
            totDivs = 0;
        }
        return primeVet;
    }

    public static int fibonacciTermCont(int[] vet){
        int totFibonacciTerms = 0;
        int n0 = 0, n1 = 1, n2 = n0 + n1;
        for (int v: vet){
            do{
                n0 = n1;
                n1 = n2;
                n2 = n0 + n1;
                if (n2 == v){
                    totFibonacciTerms++;
                }
            } while (n2 < v);
            n0 = 0;
            n1 = 1;
            n2 = n0 + n1;
        }
        return totFibonacciTerms;
    }

    public static Object vetFibonacciTerms(int[] vet){
        int[] fibonacciTerms = new int[fibonacciTermCont(vet)];
        int index = 0;

        int n0 = 0, n1 = 1, n2 = n0 + n1;
        if(fibonacciTermCont(vet) > 0) {
            for (int v : vet) {
                if (v >= 0) {
                    while (n2 <= v) {
                        if (n2 == v) {
                            fibonacciTerms[index] = v;
                            index++;
                            break;
                        }
                        n0 = n1;
                        n1 = n2;
                        n2 = n0 + n1;
                    }
                    n0 = 0;
                    n1 = 1;
                    n2 = n0 + n1;
                }
            }
            return fibonacciTerms;
        }
        return null;
    }

    public static int[] vetCutter(int[] vet, int start, int end){
        if (end >= vet.length){
            end = vet.length - 1;
        }
        int[] cutVet = new int[end - start];
        int k = 0;
        for (int i = start; i < end; i++){
            cutVet[k] = vet[i];
            k++;
        }
        return cutVet;
    }



    public static void main(String[] args) throws InterruptedException {
        int[] vet = new int[(int) (Math.random() * 20) + 5];
        Scanner read = new Scanner(System.in);
        fuelVet(vet);
        System.out.println("=-=-=- JAVA FUNCTION EXERCISE -=-=-=\n");
        System.out.println("ARRAY:\n");
        showVet(vet);
        System.out.print("""
                                    
                What do you want to do with the array?
                [1] Search              [2] Search by Index         [3] Separation
                                    
                [4] Summation           [5] Product                 [6] Scalar product
                                    
                [7] Fuel with zeros     [8] Square                  [9] Average
                                    
                [10] Max value          [11] Min value              [12] Multimodal
                                    
                [13] Median             [14] Standard deviation     [15] Union
                                    
                [16] Inversion          [17] Intersection           [18] Difference-A
                                    
                [19] Sort               [20] Prime number           [21] Fibonacci
                                    
                [22] Grouping           [23] Exit
                                    
                Answer:\040""");
        int ans = read.nextInt();

        if (ans == 1) {
            System.out.println("Number you want to find: ");
            int value = read.nextInt();
            if (search(value, vet) == -1) {
                System.out.println("Value not found");
            }

            else {
                System.out.printf("""
                        Value  %d
                        Index  %d""", value, search(value, vet));
            }
        } else if (ans == 2) {
            System.out.print("Index: ");
            int index = read.nextInt();
            System.out.printf("""
                    Index   %d
                    Value   %d""", index, searchByIndex(index, vet));

        } else if (ans == 3) {
            int[] positiveVet = new int[positiveCont(vet)];
            int[] negativeVet = new int[negativeCont(vet)];
            fuelVetNegative(vet, negativeVet);
            fuelVetPositive(vet, positiveVet);
            System.out.println("Positive values: " + Arrays.toString(positiveVet));
            System.out.println("Negative values: " + Arrays.toString(negativeVet));

        } else if (ans == 4) {
            System.out.println("The sum of the array terms is " + vetSummation(vet));

        } else if (ans == 5) {
            System.out.println("The product of the array terms is " + vetProduct(vet));

        } else if (ans == 6) {
            int[] vet2 = new int[vet.length];
            vet2 = newVet(vet2.length);
            System.out.println("\n");
            for (int i = 0; i < vet.length; i++) {
                System.out.printf("%d x %d = %d\n", vet[i], vet2[i], vet[i] * vet2[i]);
            }
            System.out.println("\nAdding all the terms together, the dot product is: " +
                    scalarProduct(vet, vet2));
        } else if (ans == 7) {
            System.out.println("From which number should the program start filling? ");
            int num = read.nextInt();
            System.out.println("Array before: " + Arrays.toString(vet));
            fuelWithZeros(vet, num);
            System.out.println("Array now: " + Arrays.toString(vet));
        } else if (ans == 8) {
            System.out.println("Array before: " + Arrays.toString(vet));
            pow2Array(vet);
            System.out.println("Array now: " + Arrays.toString(vet));
        } else if (ans == 9) {
            System.out.println("Average: " + String.format("%.1f", average(vet)));
        } else if (ans == 10) {
            System.out.println("Highest value: " + max(vet));
        } else if (ans == 11) {
            System.out.println("Lowest value: " + min(vet));
        } else if (ans == 12) {
            if (modalElement(vet) == null) {
                System.out.println("There's no repeated elements");
            } else {
                System.out.println("Modal element: " + modalElement(vet));
            }
        } else if (ans == 13) {
            sortVet(vet);
            showVet(vet);
            System.out.println("\n\nMedian: " + median(vet));
        } else if (ans == 14) {
            System.out.println("Standard deviation: " + String.format("%.2f", standardDeviation(vet)));
        } else if (ans == 15) {
            int[] vet2 = new int[vet.length];
            vet2 = newVet(vet2.length);
            System.out.println("\n\nUnion of the 2 arrays:\n");
            showVet(vetUnion(vet, vet2));
        } else if (ans == 16) {
            vetInverter(vet);
            System.out.println("Inverted array:\n");
            showVet(vet);
        } else if (ans == 17) {
            int[] vet2 = new int[vet.length];
            vet2 = newVet(vet2.length);
            System.out.println("\n\nIntersection: " + Arrays.toString((int[]) intersection(vet, vet2)));
        } else if (ans == 18) {
            int[] vet2 = new int[vet.length];
            vet2 = newVet(vet2.length);
            System.out.println("\n\nElements in the first array that are not present at the second array:\n\n");
            System.out.println(Arrays.toString(difference(vet, vet2)));
        } else if (ans == 19) {
            sortVet(vet);
            System.out.println("Sorted array:\n");
            showVet(vet);
        } else if (ans == 20) {
            System.out.println("Prime terms of the array: \n");
            showVet(vetGetPrimes(vet));
        } else if (ans == 21) {
            Object fibonacciVet;
            fibonacciVet = vetFibonacciTerms(vet);
            if (fibonacciVet != null) {
                System.out.println("Array terns that are in the fibonacci sequence:\n");
                showVet((int[]) Objects.requireNonNull(vetFibonacciTerms(vet)));
            } else {
                System.out.println("There are no terms belonging to the Fibonacci sequence");
            }
        } else if (ans == 22) {
            sortVet(vet);
            System.out.print("Group size: ");
            int groupSize = read.nextInt();
            for (int i = 0; i < vet.length; i += groupSize) {
                showVet(vetCutter(vet, i, groupSize + i));
                System.out.println();
            }
        }
    }
}
