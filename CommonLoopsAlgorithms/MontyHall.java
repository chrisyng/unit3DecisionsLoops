import java.util.Random;
import java.util.Scanner;
public class MontyHall
{
    public static void main (String[] args)
    {
        boolean door1;
        boolean door2;
        boolean door3;
        int nonSwitchStrategyWins=0;
        int switchStrategyWins=0;
        Random generator = new Random();
        for (int iterations=1; iterations<=1000; iterations++)
        {
            int carDoor = generator.nextInt(3)+1; //chooses door with car
            //System.out.println("Car Door:"+carDoor);
            int doorChosen = generator.nextInt(3)+1; //randomly chosen door by person
            //System.out.println("Door Chosen"+doorChosen);
            int hostDoor = generator.nextInt(3)+1; // randomly chosen door by host
            while (hostDoor==carDoor || hostDoor==doorChosen)
            {
                hostDoor = generator.nextInt(3)+1;  
            }
            //System.out.println("Final Host Door value"+hostDoor);
            //Non-Switching Strategy
            if (doorChosen == carDoor)
            {
                nonSwitchStrategyWins += 1;
            }
            else
            {
                //Switching Door Strategy
                int lastDoorChosen;
                do
                {
                    //System.out.println("Door Chosen"+doorChosen);
                    lastDoorChosen = doorChosen;
                    //System.out.println("Last Door Chosen"+lastDoorChosen);
                    doorChosen = generator.nextInt(3)+1;
                }
                while (doorChosen==lastDoorChosen || doorChosen == hostDoor);

                if(doorChosen == carDoor)
                {
                    switchStrategyWins += 1;
                }
            }
            System.out.println();
        }
        System.out.println("Non-Switch Wins:"+nonSwitchStrategyWins);
        System.out.println("Switch Wins:"+switchStrategyWins);
    }
}
