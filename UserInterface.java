import java.util.Scanner;

public class UserInterface
{
    String mainSelect[] = {"upgrade", "collect", "produce", "end"};
    String upgradeSelect[] = {"nursery", "wax", "honey", "hospital"};
    Scanner scanner = new Scanner(System.in);

    /*
     * Function used to compare users input to a list of valid inputs for the turn
     */
    public String validInput(String userIn, String validMoves[])
    {
        //Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < validMoves.length; i ++)
        {
            if(userIn.equals(validMoves[i]))
            {
                //scanner.close();
                return userIn;
            }
        }
        System.out.println("Please select a valid option!");
        
        userIn = scanner.nextLine();
        userIn = userIn.toLowerCase();
        
        userIn = validInput(userIn, validMoves);
        //scanner.close();
        return userIn;
    }
}