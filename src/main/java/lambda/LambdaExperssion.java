package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        System.out.println("Products :");
        System.out.println(productList);

        productList.sort(
                (p1, p2) -> p1.getPrice().compareTo(p2.getPrice())
        );

        System.out.println("Sorted products :");
        System.out.println(productList);

        final Double MIN_LIMIT = 5.0;
        final Double MAX_LIMIT = 10.0;

        System.out.println("Min Range :");
        listProduct(productList, product -> product.getPrice() > MIN_LIMIT);

        System.out.println("Max Range :");
        listProduct(productList, product -> product.getPrice() < MAX_LIMIT);

        List<Product> affordableProducts = new ArrayList<>();

        productList.forEach(product -> {
            if (product.getPrice() < MAX_LIMIT)
                affordableProducts.add(product);
        });

        System.out.println("Affordable products :");
        affordableProducts.forEach(System.out::println);

        System.out.println("Method Reference :");
        productList.forEach(LambdaExperssion::iPrint);

        System.out.println("Steam :");
        productList.stream().map(Product::getName).forEach(System.out::println);

        System.out.println("Product Factory :");
        ProductFactory productFactory = Product::new;

        System.out.println(productFactory.create(Category.TV, "S A M S U N G", 15.03));
    }

    private static void iPrint(Object product) {
        System.out.println(product);
    }

    interface ProductFactory {
        Product create(Category category, String name, Double price);
    }
}
