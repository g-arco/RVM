import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocPrintJob;

public class Maintenance
{

    private ArrayList<ItemSlot> startingSlots = new ArrayList<>();
    private ArrayList<ItemSlot> currentSlots = new ArrayList<>();
    private int totalSlots;
    private Money totalmoney[];

    public Maintenance(ItemSlot itemSlot[], int size, Money money[])
    {
        int i = 0;
        
        totalSlots = size;
        while (i < size)
        {
            startingSlots.add(itemSlot[i]);
            currentSlots.add(itemSlot[i]);
            i++;
        }

        this.totalmoney = money;
    }

    public void addMoreSlots(ItemSlot itemslot)
    {
        startingSlots.add(itemslot);
        totalSlots += 1;
    }

    public void restockItem()
    {
        Scanner s = new Scanner(System.in);
        int inputIndex, inputQuantity, i;

        System.out.println("Which item slot do you want to restock?");
        for(i = 0; i < startingSlots.size(); i++)
        {
            System.out.print("["+i+"] - " );
            System.out.println(startingSlots.get(i).returnItemName());
        }
        
        do
        {
            inputIndex = s.nextInt();
        } while (inputIndex > i && inputIndex < i);

        System.out.println("How many pieces will you insert?");

        inputQuantity = s.nextInt();

        currentSlots.get(inputIndex).getRestocked(inputQuantity);

        s.close();
    }

    public void setPrice()
    {
        Scanner s = new Scanner(System.in);
        int inputIndex, inputPrice, i;

        System.out.println("Which item do you want to set the price?");
        
        for(i = 0; i < startingSlots.size(); i++)
        {
            System.out.print("["+i+"] - " );
            System.out.println(startingSlots.get(i).returnItemName());
        }

        do
        {
            inputIndex = s.nextInt();
        } while (inputIndex > i && inputIndex < i);

        System.out.println("What will be its new price?");

        inputPrice = s.nextInt();

        currentSlots.get(inputIndex).getItem().changePrice(inputPrice);

        s.close();
    }

    public ArrayList<ItemSlot> getCurrentSLots()
    {
        return this.currentSlots;
    }

    public Money[] getMoney()
    {
        return this.totalmoney;
    }
}