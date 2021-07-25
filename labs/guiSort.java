import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GuiSort extends JFrame{
   public GuiSort(int[] arr) throws InterruptedException {
       setSize(1020,500);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setVisible(true);
       Scanner sc = new Scanner(System.in);  // Create a Scanner object
       System.out.println("Ready to sort?");
       String ln = sc.nextLine();
       insertionSort(getGraphics(), arr);


   }
   public static void insertionSort(Graphics g, int[] arr) throws InterruptedException {
       int temp;
       Thread.sleep(1000);
       paintStep(g, arr);
       for (int i = 1; i < arr.length; i++) {
           for(int j = i ; j > 0 ; j--){
               if(arr[j] < arr[j-1]){
                   temp = arr[j];
                   arr[j] = arr[j-1];
                   arr[j-1] = temp;
                   g.clearRect(0, 0, 1020, 500);
                   paintStep(g, arr);
                   Thread.sleep(1000);

               }
           }
       }
   }
   public static void main(String[] args) throws InterruptedException {
       int[] arr = {50, 412, 130, 450, 210, 70, 90, 189, 360};
       new GuiSort(arr);

   }
@Override
   public void paint(Graphics g){
   }
   public static void paintStep(Graphics g, int[] arr){
       int div = 1000 / arr.length;
       int pos = 10;
       for (int j: arr){
           g.drawRect(pos, 500-j, div, j);
           pos = pos+div;
       }

   }
}

