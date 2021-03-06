// Author: Joe Do
// Date: January 22, 2018
// CS320 - Programming Language
// Program objective: Write a Java application that provides the user
// with the course schedule for a particular course in a given program at BC.

import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BCCourseSchedule{
  public static void main(String[] args) throws IOException{
    Scanner userInput = new Scanner(System.in);

    System.out.print("Enter quarter: ");
    String quarterInput = userInput.next();

    System.out.print("Enter year (2017 or 2018): ");
    int yearInput = userInput.nextInt();

    System.out.print("Enter the initial for the program: ");
    String programInput = userInput.next();
    System.out.println();
    System.out.print("Programs: ");

    System.out.println();
    String url = "https://www.bellevuecollege.edu/classes/" + quarterInput + yearInput + "?letter=" + programInput;

    URL quarterURL = new URL(url);
    BufferedReader in = new BufferedReader(new InputStreamReader(quarterURL.openStream()));

    String input = "";
    String text = "";

    while((input = in.readLine())!= null){
      text += input +"\n";
    }

    Pattern pattern = Pattern.compile("classes/(spring|winter|summer|fall)(2017|2018)/(.*){1,4}\\W{2}(.*)</a>(.*)");
    Matcher matcher = pattern.matcher(text);
    while(matcher.find()){
      System.out.print(matcher.group(4));
      System.out.println(matcher.group(5));
    }
    System.out.println();
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the program's name: ");
    String programName = scn.nextLine();
    System.out.print("Enter the course ID: ");
    String courseID = scn.nextLine();

    // capture course ID and update the url accordingly
    String delims = "[ ]+";
    String[] tokens = courseID.split(delims);
    url = "https://www.bellevuecollege.edu/classes/" + quarterInput + yearInput + "/" + tokens[0];

    // Present course info to users
    System.out.println();
    System.out.println(programName + " Courses in " + quarterInput + " " + yearInput);
    System.out.println("==================================");
    System.out.println("Code: " + courseID);

    URL courseInfo = new URL(url);
    BufferedReader scan = new BufferedReader(new InputStreamReader(courseInfo.openStream()));

    String secondInput = "";
    String secondText = "";

    while((secondInput = scan.readLine())!= null){
      secondText += secondInput +"\n";
    }

    Pattern pattern0 = Pattern.compile("<span class=\"courseID\">"+tokens[0].toUpperCase()+"\\s"+tokens[1]+"</span>.*?<span class=\"courseTitle\">(.*?)</span>(.*?)Item number: </span>(.*?)</span>(.*?)<a href=(.*?)>(.*?)</a>", Pattern.DOTALL);
    Matcher matcher1 = pattern0.matcher(secondText);
    while(matcher1.find()){
      System.out.println("Item#: " + matcher1.group(3));
      System.out.println("Course Title: " + matcher1.group(1));
      System.out.println("Instructor: " + matcher1.group(6));
      System.out.println("==================================");
    }
  }
}
