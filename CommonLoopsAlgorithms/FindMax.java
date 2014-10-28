import java.util.Scanner;

/**
 * Write a description of class FindMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindMax
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a series of numbers (type 'q' to quit)");
        double maxValue = in.nextDouble();
        while (in.hasNextDouble())
        {
            double value = in.nextDouble();
            if (value > maxValue)
            {
                maxValue = value;
            }
            
        }
        System.out.println("Maximum value: " + maxValue);
    }

}
