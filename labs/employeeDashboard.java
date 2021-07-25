package com.company;

import java.util.*;


public class EmployeesSystem {
   public static ArrayList<Person> personArrayList = new ArrayList<>();
   public static ArrayList<Employee> employeeArrayList = new ArrayList<>();
   public static ArrayList<Manager> managerArrayList = new ArrayList<>();
   public static void main(String[] args) {
       Manager e = new Manager(16, "Evan", "M1837");
       Scanner scan = new Scanner(System.in);
       System.out.println("Hello! Please login using your ID: ");
       String ID = scan.nextLine();
       if(ID.charAt(0) == 'M'){
           for (Manager m : managerArrayList){
               if(ID.equals(m.id)){
                   boolean exit = false;
                   while(!exit){
                       System.out.println("Would you like to: \n1. Add an employee\n2. Print information on employees\n3. Fire an employee\n4. Give an employee a raise\n5. Exit");
                       String opt = scan.nextLine();
                       switch(opt){
                           case "1":
                               System.out.println("What is the employees name?");
                               String n = scan.nextLine();
                               System.out.println("What is the employees age?");
                               String a = scan.nextLine();
                               int age = Integer.parseInt(a);
                               System.out.println("What is the employees ID?");
                               String i = scan.nextLine();
                               System.out.println("What is the employees salary?");
                               String s = scan.nextLine();
                               int sal = Integer.parseInt(s);
                               new Employee(m, sal, n, age, i);
                               System.out.println("Employee successfully added.");
                               break;
                           case "2":
                               if (m.workers.size() == 0){
                                   System.out.println("You have no employees!");
                               }
                               int ct = 1;
                               for (Employee t : m.workers){
                                   System.out.println("Employee " + ct + ": " + t.name + " |ID: " + t.id + " |AGE: " + t.age + " |Salary: " + t.salary);
                                   ct++;
                               }
                               break;
                           case "3":
                               System.out.println("Enter the ID of the Employee you'd like to fire: ");
                               String id = scan.nextLine();
                               int counter = 0;
                               int counter2 = 0;
                               int workToRemove = -1;
                               int listToRemove = -1;
                               for (Employee t : m.workers){
                                   if (t.id.equals(id)){
                                       workToRemove = counter2;
                                       for (Employee ee: employeeArrayList){
                                           if(ee.id.equals(id)){
                                               listToRemove = counter;
                                           }
                                           counter++;

                                       }
                                       counter2++;
                                   }

                               }
                               m.workers.remove(workToRemove);
                               employeeArrayList.remove(listToRemove);
                               break;
                           case "4":
                               System.out.println("Enter the employee ID you'd like to give a raise to: ");
                               String raiseID = scan.nextLine();
                               System.out.println("Enter the raise amount you'd like to give: ");
                               String raiseamt = scan.nextLine();
                               int raise = Integer.parseInt(raiseamt);
                               int count = 0;
                               for (Employee t : m.workers){
                                   if (t.id.equals(raiseID)){
                                       t.salary = t.salary + raise;
                                       }
                                   count++;
                               }
                               break;
                           case "5":
                               exit = true;
                               break;
                       }
                   }
               }
           }

       }
       else if (ID.charAt(0) == 'E'){
           for(Employee emp: employeeArrayList){
               if(emp.id == ID){
                   System.out.println("Hello, " + emp.name +"! Would you like to:\n1. View your salary\n2. View information about your manager");
                   String choice = scan.nextLine();
                   switch ()
               }



           }
       }

   }
}
class Person {
   public String id;
   public String name;
   public int age;
   public Person(){
       EmployeesSystem.personArrayList.add(this);
   }


}
class Employee extends Person{
   public int salary;
   public Manager manager;
   public Employee (Manager manager, int salary, String name, int age, String ID){
       super();
       this.name = name;
       this.age = age;
       this.id = ID;
       this.manager = manager;
       EmployeesSystem.employeeArrayList.add(this);
       manager.workers.add(this);
   }

   @Override
   public String toString() {
       return "Employee{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", salary=" + salary +
               ", manager=" + manager +
               '}';
   }
}
class Manager extends Person {
   public ArrayList<Employee> workers = new ArrayList<>();
   public Manager(int age, String name, String ID){
       super();
       this.age = age;
       this.name = name;
       this.id = ID;
       EmployeesSystem.managerArrayList.add(this);
   }

   @Override
   public String toString() {
       return "Manager{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", workers=" + workers +
               '}';
   }
}


