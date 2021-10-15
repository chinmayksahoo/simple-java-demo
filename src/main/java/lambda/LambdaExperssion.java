package lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExperssion {

    interface ProductCompare {
        boolean compareWith(Product product);
    }

    public static void listProduct(List<Product> productList, ProductCompare compare) {
        for (Product product:
             productList) {
            if (compare.compareWith(product)) {
                System.out.println(product);
            }
        }
    }
    public static void main(String[] args) {
        List<Product> productList = ProductList.getProductList();

        System.out.println(productList);

        productList.sort(
                (p1, p2) -> p1.getPrice().compareTo(p2.getPrice())
        );

        System.out.println(productList);

        final Double MIN_LIMIT = 10.0;

        listProduct(productList, product -> product.getPrice() > MIN_LIMIT);

    }
}
