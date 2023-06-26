import java.util.Scanner;

public class Menu
{
    RVM rvm;

    public Menu (RVM rvm)
    {
        this.rvm = rvm;
    }

    public void MainMenu()
    {
        Scanner s = new Scanner(System.in);
        int i, inputIndex;

        System.out.println("Hello! Welcome to the Snack Zone!");
        System.out.println("What would you like to buy?");

        for (i = 0; i < 3/*rvm.getArrayList.size()*/; i++)
        {
            System.out.print("["+i+"] - ");
            System.out.println("Hello world!");
        }

        do
        {
            inputIndex = s.nextInt();
        } while (inputIndex >= i || inputIndex < 0);

        // ideally, what I'd put here is call the object located in index inputIndex from arrayList of m (RVM)
    }
}
