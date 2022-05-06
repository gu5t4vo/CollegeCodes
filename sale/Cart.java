package lista4.sale;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart{
    private final ArrayList<Product> shoppingCart;

    public Cart(){
        shoppingCart = new ArrayList<>();
    }
    private float totalPrice = 0;

    public float discountPrice(){
        totalPrice = 0;
        for (Product item: shoppingCart) {
            totalPrice += item.getPrice();
        }
        if (totalPrice < 100){
            return totalPrice;
        } else if (totalPrice > 100 && totalPrice < 200){
            return (float) (totalPrice * 0.9);
        } else if (totalPrice > 200 & totalPrice < 500){
            return (float) (totalPrice * 0.8);
        }
        return (float) (totalPrice * 0.75);
    }

    public float getTotalPrice(){
        totalPrice = 0;
        for (Product item: shoppingCart) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public float getDiscount(){
        return getTotalPrice() - discountPrice();
    }

    public float getRelativeDiscount(){
        return (getDiscount()*100)/getTotalPrice();
    }

    public void addToCart(Product item){
        if(item.getAmount() > 0) {
            item.pickItem();
            shoppingCart.add(item);
        }
    }

    public String toString() {
        HashMap<String, Integer> virtualCart = new HashMap<>();
        for (Product item: shoppingCart) {
            Integer repeats = virtualCart.get(item.toString());
            if (repeats == null){
                repeats = 0;
            }
            virtualCart.put(item.toString(), repeats + 1);
        }

        String product = "";
        for (String item: virtualCart.keySet()) {
            product = product.concat(item + String.format("(%dx)\n", virtualCart.get(item)));
        }
        return product;
    }

    public HashMap<Product, Integer> getCart(){
        HashMap<Product, Integer> cart = new HashMap<>();
        for (Product item: shoppingCart) {
            Integer repeats = cart.get(item);
            if (repeats == null){
                repeats = 0;
            }
            cart.put(item, repeats + 1);
        }
        return cart;
    }

}
