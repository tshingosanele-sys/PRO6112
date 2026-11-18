//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the g
 void main() {;
    import java.util.Scanner;

    public class Main {;

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            // One-dimensional array storing product names.

            String[] products = {

                    "Cozy Nights Monarch",

                    "Restonic Barbados",

                    "Sealy Phuk"

            };

            // Two-dimensional array storing sales for three months.

            int[][] monthlySales = new int[3][3];

            // Collect sales information for each product.

            for (int i = 0; i < products.length; i++) {

                for (int j = 0; j < 3; j++) {

                    System.out.print("Enter number of sales for month "

                            + (j + 1) + " for " + products[i] + " mattress: ");

                    monthlySales[i][j] = input.nextInt();

                }

                System.out.println();

            }

            // Create Product object.

            Product productReport = new Product(products, monthlySales);

            // Display the sales report.

            System.out.println("\nPRODUCT SALES REPORT - 2026");

            System.out.println("***************************************");

            System.out.println("TOTAL PRODUCT SALES: "

                    + productReport.getTotalProductsSold());

            System.out.printf("AVERAGE PRODUCT SALES: %.0f%n",

                    productReport.getAverageProductsSold());

            System.out.println("MOST POPULAR PRODUCT: "

                    + productReport.getMostPopularProduct());

            System.out.println("***************************************");

            input.close();

        }

    }
