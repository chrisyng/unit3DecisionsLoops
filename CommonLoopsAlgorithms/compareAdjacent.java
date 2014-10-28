import java.util.Scanner;
public class compareAdjacent
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a series of numbers, q to quit");        
        double prevValue = in.nextDouble();        
        while (in.hasNextDouble())
        {
            double value = in.nextDouble();
            if (Math.abs(value-prevValue) < 1e-6)
            {
                System.out.println("Duplicate number!");
            }
            prevValue = value;
        }
        
    }
}
