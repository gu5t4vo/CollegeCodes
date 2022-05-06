package lista4.sale;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean buying = true;
        Shelf shelf = new Shelf();
        Cart cart = new Cart();

        System.out.println("=-=-=-=-" + "AMAZON STORE" + "-=-=-=-=\n");

        Product freezer = new Product("Freezer", 900, 5);
        shelf.addToShelf(freezer);

        Product ps4 = new Product("Playstation 4", 1500, 10);
        shelf.addToShelf(ps4);

        Product guitar = new Product("Guitar", 300, 20);
        shelf.addToShelf(guitar);


        int ans;
        int opt = 1;
        do {
            System.out.println("Enter what do you want to put in the cart:");
            for (Product item: shelf.getShelf()) {
                System.out.println(String.format("[%d] ", opt) + item.toStringShowStock());
                opt++;
            }
            System.out.printf("[%d] * Add another item", shelf.getShelf().size()+1);
            System.out.print("\n\nAnswer:\040");
            ans = read.nextInt();
            opt = 1;
            if(ans == shelf.getShelf().size() + 1){
                System.out.print("Name of the product you want to add:\040");
                String name = read.next();
                System.out.print("Price of the product:\040");
                float price = read.nextFloat();
                shelf.getShelf().add(new Product(name, price, 10));
            } else if (ans > shelf.getShelf().size()){
                buying = false;
            } else {
                if (shelf.getShelf().get(ans - 1).getAmount() == 0){
                    System.out.println("Sorry, sold off");
                } else cart.addToCart(shelf.getShelf().get(ans - 1));
            }
        }while (buying);
        System.out.println(cart);
        System.out.println("\nTotal price: $" + cart.getTotalPrice());
        if (cart.getDiscount() != 0){
            System.out.printf("Price with %.0f%% off: $%.2f", cart.getRelativeDiscount(), cart.discountPrice());
        }
    }
}
