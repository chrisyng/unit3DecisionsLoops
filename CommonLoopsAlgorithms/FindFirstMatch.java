import java.util.Scanner;

/**
 * Write a description of class FindFirstMatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindFirstMatch
{
    /**
     * computes the index of the first space (' ') in the string, if any
     */
   public static void main (String[] args)
   {
       Scanner in = new Scanner(System.in);
       System.out.println("Enter a string: ");
       String input = in.nextLine();
       boolean foundSpace = false;
       int index = 0;
       
       while (!foundSpace)
       {
           if (input.charAt(index) == ' ')
           {
               System.out.println("Space at "+index);
           }
           else
           {
               index++;
           }
       }       
    
   }
}