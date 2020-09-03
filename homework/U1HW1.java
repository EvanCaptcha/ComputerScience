import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class HomeworkOne {
    public static void MexicoPop() {
        int year = 2010;
        double popMil = 111.2;
        while (popMil < 120){
            year++;
            popMil = popMil * 1.013;
        }
        System.out.println("In year " + year + ", Mexicos population will surpass 120m and be " + popMil);
    }
    public static int addOdds(int n) {
        int base = 0;
        for (int x = 1; x<=n; x = x+2){
            base= base + x;
        }
        return base;
    }
    public List<Integer> lst;

    public static void addAll(int n) {
        while (n >= 10){
            System.out.println("Input over 10...");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a positive integer under 10: ");
            n = input.nextInt();
        }
        int base = 0;
        System.out.println('\n');
        for (int x = 1; x<=n; x++){
            base = base + x;
            if (x==n){
                System.out.println("\r" + x + " = " + base);
            }
            else {
                System.out.println("\r" + x + " + ");
            }

        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a positive integer under 10: ");
        int userInput = input.nextInt();
        addAll(userInput);
        MexicoPop();
        System.out.println(addOdds(5));

    }



}
