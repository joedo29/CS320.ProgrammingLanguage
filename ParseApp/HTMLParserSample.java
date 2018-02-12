// Joe Do
// Steps: access file > read content to a string
import java.io.*;
import java.util.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HTMLParserSample{
  public static void main(String[] args) throws FileNotFoundException{
    File file = new File("table.html");
    Scanner scanner = new Scanner(file);

    String input = "";
    String text = "";
    while(scanner.hasNextLine()){
      input = scanner.nextLine(); // Read file
      text += input + "\n";
    }
    Pattern pattern = Pattern.compile("<td>.*</td>\\s*<td>.*</td>\\s*<td>(.*)</td>");
    Matcher matcher = pattern.matcher(text);
    while(matcher.find()){
      System.out.println(matcher.group(1));
    }
  }
}
