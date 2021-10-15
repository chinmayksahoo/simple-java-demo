package lambda;

import java.util.Arrays;
import java.util.List;

public class ProductList {

    public static List<Product> getProductList() {
        return Arrays.asList(
                new Product(Category.TV, "", 10.03),
                new Product(Category.PHONE, "", 6.03),
                new Product(Category.AC, "", 5.01)
        );
    }

}
