import java.util.ArrayList;
import java.util.Arrays;

public class RVM
{
    private ItemSlot currentSlots[];
    private int numOfItemsSold;
    private int sale;
    private ArrayList<String> listOfSoldItems;

    private Money money[];
    private Money change[];

    public RVM(ItemSlot itemSlot[], Money money[])
    {
        this.currentSlots = itemSlot;
        this.numOfItemsSold = 0;
        this.listOfSoldItems = new ArrayList<String>();
        this.sale = 0;
        this.money = money;
        this.change = money;
        initializeChange();
    }

    public void initializeChange()
    {
        for(int i=0; i < 9; i++)
            this.change[i].setQuantity(0);
    }

    public void setCurrentSlots(ItemSlot currentSlots[])
    {
        this.currentSlots = currentSlots;
    }

    public ItemSlot[] getCurrentSlots() {
        return this.currentSlots;
    }

    public boolean pickItem(Item item)
    {
        for (int i = 0; i < currentSlots.length; i++)
        {
            if (currentSlots[i].getItem() == item && currentSlots[i].getNumItems() != 0)
            {
                return true;
            }
            else if (currentSlots[i].getNumItems() != 0)
            {
                System.out.println("Sorry, this item is out of stock!");
            }
            else if (currentSlots[i].getItem() != item)
            {
                System.out.println("Make sure to put a number in the given choices. Please try again!");
            }
        }

        return false;
    }

    public boolean payRVM(Item item, int paidMoney)
    {

        for (int i = 0; i < currentSlots.length; i++)
        {
            if (currentSlots[i].getItem() == item)
            {
                if (paidMoney >= currentSlots[i].getItem().getPrice())
                {
                    if(paidMoney > item.getPrice())
                    {
                        int extraM = paidMoney - item.getPrice();

                        for (int j = this.change.length-1; j >= 0; j--)
                        {
                            this.change[j].setQuantity(extraM/this.change[j].getValue());
                            extraM = extraM%this.change[j].getValue();

                            if(this.change[j].getQuantity() > this.money[j].getQuantity())
                                return false;

                        }

                        System.out.println("Change is: ");
                        for (int j = this.change.length-1; j >= 0; j--)
                        {
                            if (this.change[j].getQuantity() != 0)
                                System.out.println("    +"+this.change[j].getQuantity()+" of "+this.change[j].getValue()+" pesos");
                        }

                    }

                    this.sale+= item.getPrice();
                    this.listOfSoldItems.add(item.getName());
                    this.numOfItemsSold++;
                    this.currentSlots[i].setBoughtNumItems();


                    return true;

                }
            }
        }
        return false;
    }

    public Money[] getMoney() {
        return this.money;
    }

}