import java.util.ArrayList;
import java.util.Scanner;

public class PolygonArea {
   //arrays to hold x and y cords
   private ArrayList<Double> x = new ArrayList<>();
   private ArrayList<Double> y = new ArrayList<>();
   private double area;
   //default constructor
   public PolygonArea(){
       int i = 0;
       area = 0;
       Scanner scan = new Scanner(System.in);
       System.out.print("Enter how many coordinates pairs there will be: ");
       int cords = scan.nextInt();
       for (int b  = 0; b<cords; b++){
           System.out.println("Enter an x coordinate: ");
           double xx = scan.nextDouble();
           x.add(xx);
           System.out.println("Enter a corresponding y coordinate: ");
           double yy = scan.nextDouble();
           y.add(yy);



       }
       if (x.size()<3 || y.size() < 3){
           System.out.println("Error with input..Not a polygon");
       }
       else {

           area = polygonArea(x, y, i, area);
           System.out.println("Area of polygon :");
           System.out.println(area);
       }

   }
   //area getter
   public double getArea() {
       return area;
   }

   //recursively get the area of a polygon by splitting it up into triangles and adding them together.
   public double polygonArea (ArrayList<Double> x, ArrayList<Double> y, int i, double area){
       if (i == x.size()-2){
           return Math.abs(area) ;
       }
       else{
           area += (x.get(0) * y.get(i + 1) + x.get(i + 1) * y.get(i + 2) +
                   x.get(i + 2) * y.get(0) - y.get(0) * x.get(i + 1) -
                   y.get(i + 1) * x.get(i + 2) - y.get(i + 2) * x.get(0))/2;
           return polygonArea(x, y, i+1, area);
       }

   }
}
