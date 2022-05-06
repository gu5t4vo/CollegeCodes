package lista4.sale;

import java.util.ArrayList;

public class Shelf {
    private final ArrayList<Product> shelf;

    public Shelf(){
        shelf = new ArrayList<>();
    }

    public void addToShelf(Product item){
        if (item.getAmount() > 0) shelf.add(item);
    }

    public ArrayList<Product> getShelf(){
        return shelf;
    }
}
