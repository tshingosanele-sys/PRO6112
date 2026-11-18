
}
import javax.swing.*;

import java.awt.*;

import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;

import java.math.BigDecimal;

import java.math.RoundingMode;

public class Main extends JFrame {

    private JTextField txtCustomerName;

    private JComboBox<String> cmbProduct;

    private JTextField txtPrice;

    private BigDecimal vat;

    private BigDecimal commission;

    private BigDecimal total;

    public Main() {

        setTitle("Mattress Sales Application");

        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 15));

        panel.setBorder(

                BorderFactory.createEmptyBorder(25, 25, 25, 25)

        );

        JLabel heading = new JLabel(

                "MATTRESS SALES CALCULATION",

                SwingConstants.CENTER

        );

        heading.setFont(new Font("Arial", Font.BOLD, 18));

        add(heading, BorderLayout.NORTH);

        // Customer name

        panel.add(new JLabel("Customer Name:"));

        txtCustomerName = new JTextField();

        panel.add(txtCustomerName);

        // Product selection

        panel.add(new JLabel("Product Name:"));

        String[] products = {

                "Cozy Nights Monarch",

                "Restonic Barbados",

                "Sealy Phuket"

        };

        cmbProduct = new JComboBox<>(products);

        panel.add(cmbProduct);

        // Product price

        panel.add(new JLabel("Product Price (R):"));

        txtPrice = new JTextField();

        panel.add(txtPrice);

        // Process button

        JButton btnProcess = new JButton("PROCESS");

        btnProcess.addActionListener(e -> processSale());

        panel.add(btnProcess);

        // Clear button

        JButton btnClear = new JButton("CLEAR");

        btnClear.addActionListener(e -> clearFields());

        panel.add(btnClear);

        add(panel, BorderLayout.CENTER);

        setVisible(true);

    }

    // Calculate the sale

    private void processSale() {

        String customerName =

                txtCustomerName.getText().trim();

        String productName =

                (String) cmbProduct.getSelectedItem();

        String priceInput = txtPrice.getText().trim();

        if (customerName.isEmpty()) {

            JOptionPane.showMessageDialog(

                    this,

                    "Please enter the customer name."

            );

            return;

        }

        try {

            BigDecimal price = new BigDecimal(priceInput);

            if (price.compareTo(BigDecimal.ZERO) <= 0) {

                JOptionPane.showMessageDialog(

                        this,

                        "Enter a price greater than zero."

                );

                return;

            }

            // VAT calculation (15%)

            vat = price.multiply(

                    new BigDecimal("0.15")

            ).setScale(2, RoundingMode.HALF_UP);

            // Commission calculation (5%)

            commission = price.multiply(

                    new BigDecimal("0.05")

            ).setScale(2, RoundingMode.HALF_UP);

            // Total sale calculation

            total = price.add(vat).add(commission)

                    .setScale(2, RoundingMode.HALF_UP);

            // Save information

            saveData(customerName, productName);

            // Display results

            JOptionPane.showMessageDialog(

                    this,

                    "Customer Name: " + customerName

                            + "\nProduct: " + productName

                            + "\nVAT: R " + vat.toPlainString()

                            + "\nCOMMISSION: R " + commission.toPlainString()

                            + "\nTOTAL: R " + total.toPlainString(),

                    "Sales Results",

                    JOptionPane.INFORMATION_MESSAGE

            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(

                    this,

                    "Please enter a valid product price."

            );

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(

                    this,

                    "Unable to save the data file: " + ex.getMessage()

            );

        }

    }

    // Save information in data.txt

    private void saveData(

            String customerName,

            String productName

    ) throws IOException {

        try (BufferedWriter writer =

                     new BufferedWriter(

                             new FileWriter("data.txt", true))) {

            writer.write("DATA LOG");

            writer.newLine();

            writer.write("********************************");

            writer.newLine();

            writer.write("Customer Name: " + customerName);

            writer.newLine();

            writer.write("Product: " + productName);

            writer.newLine();

            writer.write("VAT: R " + vat.toPlainString());

            writer.newLine();

            writer.write("COMMISSION: R "

                    + commission.toPlainString());

            writer.newLine();

            writer.write("TOTAL: R " + total.toPlainString());

            writer.newLine();

            writer.write("********************************");

            writer.newLine();

            writer.newLine();

        }

    }

    // Clear the form

    private void clearFields() {

        txtCustomerName.setText("");

        txtPrice.setText("");

        cmbProduct.setSelectedIndex(0);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new Main();

        });

    }

}