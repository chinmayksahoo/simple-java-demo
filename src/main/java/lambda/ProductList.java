package lambda;

import java.util.Arrays;
import java.util.List;

public class ProductList {

    public static List<Product> getProductList() {
        return Arrays.asList(
                new Product(Category.TV, "V U", 10.03),
                new Product(Category.PHONE, "N O K I A", 6.03),
                new Product(Category.AC, "G O D R E J", 5.01)
        );
    }

}
