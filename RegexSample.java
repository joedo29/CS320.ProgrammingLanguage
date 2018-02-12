
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexSample{
  public static void main(String[] args){
    // Pattern pattern = Pattern.compile("cat\\.");
    Pattern pattern = Pattern.compile("([a-z]*([0-9]+)([a-z]*))");
    // Include ^ to search for everything except for
    // Ranges: such as letter a thru h => [a-h]
    // [a-zA-Z] will match any letter of the alphabet from a-z and A-Z
    String input = "abc123xyz";
    Matcher matcher = pattern.matcher(input);
    if(matcher.find()){
      System.out.println(matcher.group(0));
      // System.out.println(matcher.group(1));
      System.out.println(matcher.group(2));

    } else{System.out.println("Not Found!");}

  }

}
