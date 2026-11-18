public class product {
    public class Product implements IProducts {

        // One-dimensional array containing product names.

        private String[] productNames;

        // Two-dimensional array containing sales for three months.

        private int[][] sales;

        // Constructor

        public Product(String[] productNames, int[][] sales) {

            this.productNames = productNames;

            this.sales = sales;

        }

        // Calculate the total number of products sold.

        @Override

        public int getTotalProductsSold() {

            int total = 0;

            for (int i = 0; i < sales.length; i++) {

                for (int j = 0; j < sales[i].length; j++) {

                    total += sales[i][j];

                }

            }

            return total;

        }

        // Calculate the average sales across all monthly entries.

        @Override

        public double getAverageProductsSold() {

            int total = getTotalProductsSold();

            int count = 0;

            for (int i = 0; i < sales.length; i++) {

                count += sales[i].length;

            }

            return (double) total / count;

        }

        // Identify the product with the highest total sales.

        @Override

        public String getMostPopularProduct() {

            int highestSales = 0;

            String popularProduct = "";

            for (int i = 0; i < sales.length; i++) {

                int productTotal = 0;

                for (int j = 0; j < sales[i].length; j++) {

                    productTotal += sales[i][j];

                }

                if (productTotal > highestSales) {

                    highestSales = productTotal;

                    popularProduct = productNames[i];

                }

            }

            return popularProduct + " (" + highestSales + ")";

        }

    }
}

