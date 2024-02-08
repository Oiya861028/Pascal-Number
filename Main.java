import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class Main{
    public static Map<Integer, Integer> isKnown = new HashMap<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        int n = sc.nextInt();
        pascal(n);
    }

    static int factorial(int n){
        if(n<=1) return 1;
        else if (isKnown.containsKey(n)) return isKnown.get(n);
        else {
            isKnown.put(n, (n*factorial(n-1)));
            return isKnown.get(n);
        }
    }
    static int nCk(int n, int k){
        return factorial(n)/(factorial(k)*factorial(n-k));
    }
    static void printRow(int row, int col){
        if(col>row) return;
        System.out.print(nCk(row, col)+" ");
        printRow(row, col+1);
    }
    static void pascal(int n){
        if(n==0){
            System.out.println(1);
        }
        else{
            pascal(n-1);
            printRow(n, 0);
            System.out.println();
        }
    }
}