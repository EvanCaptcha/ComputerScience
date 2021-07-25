package com.company;

import java.util.Scanner;

class DCLL {


   //create node structure
   static class Node {
       String data;
       Node next;
       Node previous;
   }

//add a node to the end of the list
   static Node add(Node s, String value) {

       if (s == null) {
           Node new_node = new Node();
           new_node.data = value;
           new_node.next = new_node.previous = new_node;
           s = new_node;
           return s;
       }

       Node last = (s).previous;
       Node new_node = new Node();
       new_node.data = value;
       new_node.next = s;
       (s).previous = new_node;
       new_node.previous = last;
       last.next = new_node;
       return s;
   }

//delete a node from a list given a string that matches with a node
   static Node del(Node s, String Val) {

       if (s == null)
           return null;
       Node current = s, previous_1 = null;
       while (!current.data.equals(Val)) {
           if (current.next == s) {
               System.out.println("\nValue " + Val + " not in list.");
               return s;
           }

           previous_1 = current;
           current = current.next;
       }

       if (current.next == s && previous_1 == null) {
           (s) = null;
           return s;
       }

       if (current == s) {
           previous_1 = (s).previous;
           s = (s).next;
           previous_1.next = s;
           (s).previous = previous_1;
       } else if (current.next == s) {
           previous_1.next = s;
           (s).previous = previous_1;
       } else {
           Node temp = current.next;

           previous_1.next = temp;
           temp.previous = previous_1;
       }
       return s;
   }
   //print the entire doubly circular linked list times number of times
   static void printll(Node first, int times){
       Node temp = first;
       int ct = 0;
       boolean done = false;
       while (!done) {
           while (ct<times){
               System.out.println(temp.data);

               if (temp.next == first){
                   ct++;

               }
               temp = temp.next;
           }
            { System.out.println("\n");
               done = true;
           }

       }


   }

   public static void main(String[] args) {
       Node start = null;
       start = add(start, "Today's Headlines:");
       Scanner scan = new Scanner(System.in);
       boolean exit = false;
       while (!exit) {
           System.out.println("""
               Would you like to:
               a. Add a headline
               d. Delete a headline
               e. Exit and start printing""");
           String in = scan.nextLine();

           switch (in) {
               case "a" -> {
                   System.out.println("Input the headline to add:");
                   String add = "-" + scan.nextLine();
                   start = add(start, add);
                   break;
               }
               case "d" -> {
                   System.out.println("Input the headline to delete:");
                   String del = "-" + scan.nextLine();
                   start = del(start, del);
                   break;
               }
               case "e" -> exit = true;
           }

       }
       System.out.println("How many times would you like to print the list?");
       int t = scan.nextInt();
       printll(start, t);

   }
}
