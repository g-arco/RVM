public class ItemSlot
{
    private Item item;
    private int numItems;
    private int capacity;

    public ItemSlot(Item item, int numItems, int capacity)
    {
        this.item = item;
        this.numItems = numItems;
        this.capacity = capacity;
    }

    public void getRestocked(int i)
    {
        numItems += i;
    }

    public String returnItemName()
    {
        return item.getName();
    }

    public int getCapacity()
    {
        return capacity;
    }

    public int getNumItems()
    {
        return numItems;
    }

    public void setBoughtNumItems()
    {
        this.numItems--;
    }

    public Item getItem()
    {
        return item;
    }
}