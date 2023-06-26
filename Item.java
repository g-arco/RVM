public class Item
{
    private int calories;
    private int price;
    private String name;

    public Item(int calories, int price, String name)
    {
        this.calories = calories;
        this.price = price;
        this.name = name;
    }

    public void changePrice(int price)
    {
        this.price = price;
    }
    
    public int getCalories()
    {
        return calories;
    }

    public int getPrice()
    {
        return price;
    }

    public String getName()
    {
        return name;
    }
}