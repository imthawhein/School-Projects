import javax.swing.JOptionPane;
import java.util.Random;

public class Online_shopping_lazada {

    public static void main(String[] args) {
        Welcome();
        String productName;

        boolean continueShopping = true;
        while (continueShopping) {
            productName = InputUser();
            if (productName != null) {
                ProductSearch(productName);
            } else {
                JOptionPane.showMessageDialog(null, "No product selected. Exiting.");
                break; 
            }

            continueShopping = AnotherProduct();
            if (!continueShopping) {
                JOptionPane.showMessageDialog(null, "Thank You For Shopping With Lazada");
                System.out.println("------------------------------------------");
                System.out.println("Thank You For Shopping With Lazada");
            }
        }
    }

    private static void Welcome() {
        String welcome = "Welcome To Online Shopping Lazada";
        JOptionPane.showMessageDialog(null, welcome);
        System.out.println(welcome);
        System.out.println("------------------------------------------");
    }

    private static String InputUser() {
        String[] products = {"Tops", "Pants", "Groceries", "Beverages", "Cosmetics",
                "Sunglasses", "Pharmacy", "Shoes", "Belts", "Dress"};
        return (String) JOptionPane.showInputDialog(null, "Choose the product:",
                "Product Selection", JOptionPane.QUESTION_MESSAGE, null,
                products, products[0]);
    }

    private static void ProductSearch(String productName) {
        Random price = new Random();
        int Price = price.nextInt(500);
        char currencySymbol = '$';
        JOptionPane.showMessageDialog(null, "Product: " + productName + "\nOriginal Price: " + currencySymbol + Price);
        System.out.println("Product: " + productName + "\nOriginal Price: " + currencySymbol + Price);

        String code = JOptionPane.showInputDialog("Enter the discount code");
        System.out.println("Discount code: "+code);
        
        double discountPercentage = 0.0;
        if (code.equals("DISCOUNT10")) {
            discountPercentage = 10.0;
        } else if (code.equals("DISCOUNT20")) {
            discountPercentage = 20.0;
        } else {
            discountPercentage = 5.0;
        }

        double Price1 = Price - (Price * (discountPercentage / 100));

        JOptionPane.showMessageDialog(null, "Price after discount: " + currencySymbol + Price1);
        System.out.println("Price after discount: " + currencySymbol + Price1);

        int randomDiscount = price.nextInt(11);
        JOptionPane.showMessageDialog(null, "Today's special discount: " + currencySymbol + randomDiscount);
        System.out.println("Today's special discount: " + currencySymbol + randomDiscount);

        double totalPrice = Price1 - randomDiscount;
        JOptionPane.showMessageDialog(null, "Total Price: " + currencySymbol + totalPrice);
        System.out.println("Total Price: " + currencySymbol + totalPrice);

        int voucherCode = Math.abs(new Random().nextInt());
        JOptionPane.showMessageDialog(null, "Voucher Code: " + voucherCode);
        System.out.println("Voucher Code: " + voucherCode);
    }
        
    
    private static boolean AnotherProduct() {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to search for another product?", "Product Search", JOptionPane.YES_NO_OPTION);
        return response == JOptionPane.YES_OPTION;
    }
}
