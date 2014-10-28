import java.util.Scanner;

/**
 * Write a description of class CountMatches here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountMatches
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.nextLine(); // read entire line, not just word
        boolean found = false;
        int index = 0;
        char ch = 'j';        
        while ( index < str.length())
        {
            ch = str.charAt(index);
            if (ch == ' ')
            {
                break;
            }
            index++;
        }
        
        if (ch == ' ')
        {
            System.out.println("There is a space at " + index);
        }
    }

}
