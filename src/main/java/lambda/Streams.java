package lambda;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<Product> productList = ProductList.getProductList();

        productList.forEach(
                System.out::println
        );

        System.out.println("Stream :");

        productList.forEach(System.out::println);

        Stream<Product> productStream = productList.stream();

        productStream.forEach(System.out::println);


        productList.stream()
                .map(Product::getPrice)
                .forEach(System.out::println);


        productList.stream()
                .map(Product::getName)
                .forEach(System.out::println);


        System.out.println("Filter.. ");
        productList.stream()
                .filter(product -> product.getPrice() > 6)
                .forEach(System.out::println);


        System.out.println("Map.. ");
        productList.stream()
                .filter(product -> product.getPrice() > 6)
                .map(Product::getName)
                .forEach(System.out::println);

        System.out.println("Find First: ");
        Optional<Product> optionalProduct = productList.stream()
                .filter(product -> product.getPrice() > 6)
                .findFirst();

        optionalProduct.ifPresent(System.out::println);

        System.out.println("Find Any: ");
        Optional<Product> optionalProduct2 = productList.stream()
                .filter(product -> product.getPrice() > 6)
                .findAny();

        optionalProduct2.ifPresent(System.out::println);


        System.out.println("Reduce :");

        List<String> productName = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());

        System.out.println(productName);

        String names = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        System.out.println(names);

        System.out.println("Reduce .. ");
        Optional<Double> result = productList.stream()
                .map(Product::getPrice)
                .reduce(Double::sum);

        result.ifPresent(System.out::println);
    }
}
