public class printProduct {
    import java.util.List;

    public class PrintProduct {

        private List<Product> products;

        public PrintProduct(List<Product> products) {

            this.products = products;

        }

        // Display total product sales

        public void printTotalProductSales() {

            int total = 0;

            for (Product product : products) {

                total += product.getSales();

            }

            System.out.println("Total Product Sales: " + total);

        }

        // Display average product sales

        public void printAverageProductSales() {

            if (products.isEmpty()) {

                System.out.println("Average Product Sales: 0");

                return;

            }

            int total = 0;

            for (Product product : products) {

                total += product.getSales();

            }

            double average = (double) total / products.size();

            System.out.println("Average Product Sales: " + average);

        }

        // Display the most popular product

        public void printMostPopularProductSale() {

            if (products.isEmpty()) {

                System.out.println("No products available.");

                return;

            }

            Product popular = products.get(0);

            for (Product product : products) {

                if (product.getSales() > popular.getSales()) {

                    popular = product;

                }

            }

            System.out.println("Most Popular Product: "

                    + popular.getProductName());

            System.out.println("Sales: " + popular.getSales());

        }

    }
}
