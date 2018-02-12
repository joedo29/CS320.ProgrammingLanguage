// Author: Joe Do
// Date: January 12, 2018
// CS320 - Programming Language
// Program objective: Develop a Java application that reads a Java source file
// and extracts all the variables defined in this class.

import java.io.*;
import java.util.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ReadJavaFile{
  public static void main(String[] args) throws FileNotFoundException{
    File file = new File("Test.java");
    Scanner scanner = new Scanner(file);

    String input = "";
    String text = "";

    while(scanner.hasNextLine()){
      input = scanner.nextLine(); // Read file
      text += input + "\n";
    }

    // Capture empty value
    // Example: private static int k;

    Pattern pattern1 = Pattern.compile("(int|double|float|char|String|boolean)\\s(\\w+)(\\w*);");
    Matcher matcher1 = pattern1.matcher(text);
    while(matcher1.find()){
      System.out.println("Type: " + matcher1.group(1));
      System.out.println("Variable Name: " + matcher1.group(2));
      System.out.println("Value: " + matcher1.group(3));
      System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    // Capture existing values
    //Example: private static int q = 12;

    Pattern pattern = Pattern.compile("(int|double|float|char|String|boolean)\\s(.*)=(.*);");
    Matcher matcher = pattern.matcher(text);
    while(matcher.find()){
      System.out.println("group " + matcher.group(0));
      System.out.println("Type: " + matcher.group(1));
      System.out.println("Variable Name: " + matcher.group(2));
      System.out.println("Value: " + matcher.group(3));
      System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
  }
}
