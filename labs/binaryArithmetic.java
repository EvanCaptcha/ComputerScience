package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
       boolean exit = false;
       while (!exit){
           Scanner scan = new Scanner(System.in);
           System.out.println("Enter option");

           System.out.println("Would you like to:\n1.Add binary numbers\n2.Multiply binary numbers\n3.Exit");
           String opt = scan.nextLine();
           switch (opt){
               case "1":
                   System.out.println("Adding binary numbers selected");
                   System.out.println("Enter the first binary number: ");
                   String n1 = scan.nextLine().split("_")[0];
                   System.out.println("Enter the second binary number: ");
                   String n2 = scan.nextLine().split("_")[0];
                   System.out.println(addBinaryNumbers(n1, n2) + "_2");
                   break;
               case "2":
                   System.out.println("Multiplying binary numbers selected");
                   System.out.println("Enter the first binary number: ");
                   String n3 = scan.nextLine().split("_")[0];
                   System.out.println("Enter the second binary number: ");
                   String n4 = scan.nextLine().split("_")[0];
                   System.out.println(multiplyByAdding(n3, n4) + "_2");
                   break;
               case "3":
                   exit = true;


           }
       }



   }

   public static String multiplyByAdding(String s1, String s2){
       String f = s1;
       String[] s2a = s2.split("");
       s2 = subtractOne(s2a);
       while (!(Integer.parseInt(s2) == 0)){
           s1 = addBinaryNumbers(f, s1);
           String[] s2arr = s2.split("");
           s2 = subtractOne(s2arr);

       }
       return s1;
   }
   public static String subtractOne(String[] s2arr){
       int len = s2arr.length - 1;
       boolean hitOne = false;

       while(!hitOne){
           if(s2arr[len].equals("0")){
               s2arr[len] = "1";
           }
           else if(s2arr[len].equals("1")){
               s2arr[len] = "0";
               hitOne = true;


           }
           len--;

       }
       StringBuilder builder = new StringBuilder();
       for (String s : s2arr){
           builder.append(s);
       }
       String str = builder.toString();
       return str;
   }
   public static String addBinaryNumbers(String s1, String s2) {
       StringBuilder s = new StringBuilder();
       int i = s1.length() - 1;
       int k = s2.length() -1;
       int c = 0;
       while (i >= 0 ||k >= 0) {
           //initialize sum variable adding the remainder from last iteration
           int sum = c;
           //add value to sum if its greater than 0
           if (k >= 0){
               sum += s2.charAt(k) - '0';
               k--;
           }
           if (i >= 0){
               sum += s1.charAt(i) - '0';
               i--;
           }
           s.append(sum % 2);
           //divide the carry amount by 2 to get remainder
           c = sum / 2;
       }
       //after the loop, append any remainder
       if (c != 0){
           s.append(c);
       }
       //reverse string as it builds backwards
       return s.reverse().toString();
   }

}
