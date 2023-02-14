package upf.at.s4.data;


public class Item {
    private String name;
    private int price;
    private int quantity;

    public Item ()
    {
        super();
        name = "";
        price = 0;
        quantity = 0;
    }

    public Item (String n, int p, int q)
    {
        super();
        name = n;
        price = p;
        quantity = q;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString()
    {
        return "Product name: " + name + "\nPrice: " + price + "\nQuantity " + quantity + "\n";
    }

}