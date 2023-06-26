import java.awt.*;
import java.util.Scanner;

public class Driver
{
    public static void main (String args[])
    {
        Item vCut = new Item(100, 30, "V-Cut");
        Item cheezy = new Item(90, 25, "Cheezy");
        ItemSlot vCutSlots = new ItemSlot(vCut, 1, 10);
        ItemSlot cheezySlots = new ItemSlot(cheezy, 5, 10);

        Money money1000 = new Money(1000, 5);
        Money money500 = new Money(500, 5);
        Money money200 = new Money(200, 5);
        Money money100 = new Money(100, 5);
        Money money50 = new Money(50, 5);
        Money money20 = new Money(20, 10);
        Money money10 = new Money(10, 10);
        Money money5 = new Money(5, 10);
        Money money1 = new Money(1, 10);

        ItemSlot slots[] = {vCutSlots, cheezySlots};
        Money money[] = {money1, money5, money10, money20, money50, money100, money200, money500, money1000};
        RVM r = new RVM(slots, money);
        Menu m = new Menu(r);

        m.MainMenu();

    }
}