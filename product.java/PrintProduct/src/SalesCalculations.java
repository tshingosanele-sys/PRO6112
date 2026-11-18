
    import javax.swing.*;

import java.awt.*;

import java.math.BigDecimal;

import java.math.RoundingMode;

import java.text.DecimalFormat;

    class SalesCalculation extends JFrame {

        // Input components

        private JTextField txtCustomerName;

        private JComboBox<String> cmbProduct;

        private JTextField txtPrice;

        // Output components

        private JTextField txtVAT;

        private JTextField txtCommission;

        private JTextField txtTotal;

        private final DecimalFormat moneyFormat =

                new DecimalFormat("R #,##0.00");

        public SalesCalculation() {

            setTitle("Sales Calculation Application");

            setSize(500, 500);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setLocationRelativeTo(null);

            // Main panel

            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 15));

            panel.setBorder(BorderFactory.createEmptyBorder(

                    25, 25, 25, 25));

            // Heading

            JLabel heading = new JLabel(

                    "SALES CALCULATION SYSTEM",

                    SwingConstants.CENTER);

            heading.setFont(new Font("Arial", Font.BOLD, 18));

            add(heading, BorderLayout.NORTH);

            // Customer name

            panel.add(new JLabel("Customer Name:"));

            txtCustomerName = new JTextField();

            panel.add(txtCustomerName);

            // Product selection

            panel.add(new JLabel("Select Product:"));

            String[] products = {

                    "Computer Hardware",

                    "Computer Software",

                    "Computer Accessories",

                    "Other Products"

            };

            cmbProduct = new JComboBox<>(products);

            panel.add(cmbProduct);

            // Purchase price

            panel.add(new JLabel("Enter Price (R):"));

            txtPrice = new JTextField();

            panel.add(txtPrice);

            // VAT amount

            panel.add(new JLabel("VAT Amount (15%):"));

            txtVAT = new JTextField();

            txtVAT.setEditable(false);

            panel.add(txtVAT);

            // Commission amount

            panel.add(new JLabel("Commission (5%):"));

            txtCommission = new JTextField();

            txtCommission.setEditable(false);

            panel.add(txtCommission);

            // Total sale amount

            panel.add(new JLabel("Total Sale Amount:"));

            txtTotal = new JTextField();

            txtTotal.setEditable(false);

            panel.add(txtTotal);

            // Process button

            JButton btnProcess = new JButton("PROCESS");

            btnProcess.addActionListener(e -> calculateSale());

            panel.add(btnProcess);

            // Clear button

            JButton btnClear = new JButton("CLEAR");

            btnClear.addActionListener(e -> clearFields());

            panel.add(btnClear);

            add(panel, BorderLayout.CENTER);

            setVisible(true);

        }

        // Method to calculate the sale

        private void calculateSale() {

            String customerName =

                    txtCustomerName.getText().trim();

            String priceText = txtPrice.getText().trim();

            // Validate customer name

            if (customerName.isEmpty()) {

                JOptionPane.showMessageDialog(

                        this,

                        "Please enter the customer name.",

                        "Input Error",

                        JOptionPane.ERROR_MESSAGE);

                return;

            }

            // Validate purchase price

            try {

                BigDecimal price = new BigDecimal(priceText);

                if (price.compareTo(BigDecimal.ZERO) <= 0) {

                    JOptionPane.showMessageDialog(

                            this,

                            "Please enter a price greater than zero.");

                    return;

                }

                // Calculate VAT (15%)

                BigDecimal vat = price.multiply(

                        new BigDecimal("0.15"));

                // Calculate commission (5%)

                BigDecimal commission = price.multiply(

                        new BigDecimal("0.05"));

                // Calculate total sale amount

                BigDecimal total = price.add(vat).add(commission);

                // Round amounts to two decimal places

                vat = vat.setScale(2, RoundingMode.HALF_UP);

                commission = commission.setScale(

                        2, RoundingMode.HALF_UP);

                total = total.setScale(2, RoundingMode.HALF_UP);

                // Display calculated results

                txtVAT.setText(moneyFormat.format(vat));

                txtCommission.setText(

                        moneyFormat.format(commission));

                txtTotal.setText(moneyFormat.format(total));

                // Display confirmation

                JOptionPane.showMessageDialog(

                        this,

                        "Sales calculation completed successfully!\n\n"

                                + "Customer: " + customerName

                                + "\nProduct: " + cmbProduct.getSelectedItem()

                                + "\nTotal Sale Amount: "

                                + moneyFormat.format(total),

                        "Sales Results",

                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(

                        this,

                        "Please enter a valid numerical price.",

                        "Invalid Price",

                        JOptionPane.ERROR_MESSAGE);

            }

        }

        // Method to clear all fields

        private void clearFields() {

            txtCustomerName.setText("");

            txtPrice.setText("");

            txtVAT.setText("");

            txtCommission.setText("");

            txtTotal.setText("");

            cmbProduct.setSelectedIndex(0);

        }

        // Main method

        public static void main(String[] args) {

            SwingUtilities.invokeLater(() -> {

                new SalesCalculation();

            });

        }

    }

