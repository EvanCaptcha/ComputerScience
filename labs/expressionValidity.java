import java.io.*;
import java.util.*;
public class Expression {
   public String myExpression;
   private String open;
   private String close;
   public Expression(String expression, String opener, String closer){
       //constructor for Expression class, i was confused on what to do with the openers and closers so i just made them start and end the expression, respectively.
       myExpression = opener + expression + closer;
       open = opener;
       close = closer;
   }
   public static boolean validExpression(String expression) {
       //determine if an expression is valid, copied and pastied from Expression class, same code still works as i thought we were supposed to do all bracket types for it.
       Stack<Character> s = new Stack<Character>();
       s.push(expression.charAt(0));
       for (int i = 1; i < expression.length(); i++) {
           char c = expression.charAt(i);
           if (c == '(' || c == '{' || c == ']' || c == ')' || c == '}' || c == ']') {
               if (s.empty()) {
                   if (i != expression.length() - 1) {
                       s.push(c);
                   } else {

                       return false;
                   }
               }
               if (s.peek() == '(') {
                   if (c == ')') {
                       s.pop();
                   } else {
                       s.push(c);
                   }
               } else if (s.peek() == '{') {
                   if (c == '}') {
                       s.pop();
                   } else {
                       s.push(c);
                   }
               } else if (s.peek() == '[') {
                   if (c == ']') {
                       s.pop();
                   } else {
                       s.push(c);
                   }
               }
           }
       }
       if (s.isEmpty()) {
           return true;
       } else {
           return false;
       }
   }

   public static void main(String[] args) {
       System.out.println(validExpression("{{test}}"));
   }

}


ValidBracket class (includes the interface within it)
import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;

interface Validity{
   boolean isValidFile() throws IOException;
   void printFile() throws IOException;
   String getOpening() throws IOException;
   String getClosing() throws IOException;
}
public class ValidBracket implements Validity{
   private String path;
   public ValidBracket(String p) throws IOException {
       //ValidBracket default constructor, takes in a file path.
       path = p;

   }
   public boolean validExpression(String expression) {
       //determine if an expression is valid, copied and pastied from Expression class, same code still works as i thought we were supposed to do all bracket types for it.
       Stack<Character> s = new Stack<Character>();
       s.push(expression.charAt(0));
       for (int i = 1; i < expression.length(); i++) {
           char c = expression.charAt(i);
           if (c == '(' || c == '{' || c == ']' || c == ')' || c == '}' || c == ']') {
               if (s.empty()) {
                   if (i != expression.length() - 1) {
                       s.push(c);
                   } else {

                       return false;
                   }
               }
               if (s.peek() == '(') {
                   if (c == ')') {
                       s.pop();
                   } else {
                       s.push(c);
                   }
               } else if (s.peek() == '{') {
                   if (c == '}') {
                       s.pop();
                   } else {
                       s.push(c);
                   }
               } else if (s.peek() == '[') {
                   if (c == ']') {
                       s.pop();
                   } else {
                       s.push(c);
                   }
               }
           }
       }
       if (s.isEmpty()) {
           return true;
       } else {
           return false;
       }
   }
   @Override
   public boolean isValidFile() throws IOException {
       //check the validity of a file based on its brackets
       File file = new File(path);
       Scanner sc = new Scanner(file);
       String st = "";
       while(sc.hasNext()) {
           st = st + sc.next();
       }
       return validExpression(st);
   }


   @Override
   public void printFile() throws IOException {
       //print out a file
       BufferedReader br = new BufferedReader(new FileReader(path));
       StringBuilder sb = new StringBuilder();

       String line = br.readLine();
       while (line != null) {
           sb.append(line).append("\n");
           line = br.readLine();
       }

       String f = sb.toString();
       System.out.println(f);
   }

   @Override
   public String getOpening() throws IOException {
       //returns the expressioner opener
       File file = new File(path);
       Scanner sc = new Scanner(file);
       String st = "";
       while(sc.hasNext()) {
           st = st + sc.next();
       }
       String[] arr = st.split("");
       return arr[0];

   }

   @Override
   public String getClosing() throws IOException {
       //returns the expression closer
       File file = new File(path);
       Scanner sc = new Scanner(file);
       String st = "";
       while(sc.hasNext()) {
           st = st + sc.next();
       }
       String[] arr = st.split("");
       int s = arr.length;
       return arr[s-1];

   }
}


TESTER CODE:

import java.io.IOException;
import java.util.Scanner;

public class BracketTester {
   public static void main(String[] args) throws IOException {
       //main testing method
       System.out.println("Testing validity of (({})) with opener ( and closer )");
       Expression exp = new Expression("(({}))", "(", ")");
       System.out.println("Validity: " + exp.validExpression(exp.myExpression));
       System.out.println("Testing validty of 3/(a+(b*2)) with opener [ and closer ]");
       Expression exp2 = new Expression("3/(a+(b*2))", "[", "]");
       System.out.println("Validity: " + exp2.validExpression(exp.myExpression));
       System.out.println("Testing validty of (a+2(c+4))) with opener { and closer ]");
       Expression exp3 = new Expression("(a+2(c+4)))", "{", "]");
       System.out.println("Validity: " + exp2.validExpression(exp.myExpression));
       System.out.println("Now we will test file1, which includes {{{asasd{{das{{das{{{{{(asdsdaasd){{as}}asd}}}}ddsas}}}}dasasd}}}} (should be valid)");
       ValidBracket vb = new ValidBracket("C:\\Users\\Evan\\IdeaProjects\\CS\\src\\testing.txt");
       System.out.println("Validity: " +  vb.isValidFile());
       System.out.println("Testing print function, then opener and closers.");
       vb.printFile();
       System.out.println("Opener: " + vb.getOpening());
       System.out.println("Closer: " + vb.getClosing());
       System.out.println("Testing file2 validity which includes {{{asd{sdas{das{{as}d}as(d()sa}as}das} (should be invalid)");
       ValidBracket vb2 = new ValidBracket("C:\\Users\\Evan\\IdeaProjects\\CS\\src\\test2.txt");
       System.out.println("Validity: " +  vb2.isValidFile());
       System.out.println("Testing print function, then opener and closers.");
       vb2.printFile();
       System.out.println("Opener: " + vb2.getOpening());
       System.out.println("Closer: " + vb2.getClosing());

   }
}

