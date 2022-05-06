package lista4.sale;

public class Product {
    private String name;
    private float price;
    private int amount;
    private int sold = 0;

    public Product(String name, float price, int amount){
        this.name = setName(name);
        this.price = setPrice(price);
        this.amount = setAmount(amount);

    }


    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public float getPrice() {
        return price;
    }

    public float setPrice(float price) {
        if (price > 0) {
            this.price = price;
            return this.price;
        }
        return 0;
    }

    public int getAmount() {
        return amount;
    }

    private int setAmount(int amount) {
        if (amount >= 0){
            this.amount = amount;
            return this.amount;
        }
        return 0;
    }

    public int pickItem(){
        amount--;
        return amount;
    }

    public void buy(){
        amount--;
        sold++;
    }

    public void buy(int amountToBuy){
        amount -= amountToBuy;
        sold += amountToBuy;
    }


    public int getSold() {
        return sold;
    }

    public int setSold(int sold){
        this.sold = sold;
        return this.sold;
    }
    

    public String toString(){
        return String.format("* %-15s %s", getName(), String.format("$%.2f", price));
    }

    public String toStringShowStock(){
        return String.format("* %-15s %-10s Stock: %-5s", getName(), String.format("$%.2f", price), getAmount());
    }

}