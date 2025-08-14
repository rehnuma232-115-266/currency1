import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class Swing_Main {

    public static void main(String[] args) {
    	 // Main frame create kora
        JFrame frame = new JFrame("Currency Converter"); 
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Center e show korbe

        // Background image load and set kora
        ImageIcon icon = new ImageIcon("img/pp.jfif");
        Image scaleImg = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        JLabel bgLabel = new JLabel(new ImageIcon(scaleImg));
        bgLabel.setBounds(0, 0, 500, 400);
        frame.add(bgLabel);

        // Title label set kora
        JLabel title = new JLabel("Currency Converter", SwingConstants.CENTER);
        title.setBounds(120, 20, 260, 50);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(0, 0, 139));
        title.setOpaque(true);
        title.setBackground(new Color(255, 255, 255, 180));
        title.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        bgLabel.add(title);

        // Amount input label
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(80, 90, 150, 30);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 18));
        amountLabel.setForeground(new Color(0, 0, 139));
        amountLabel.setOpaque(true);
        amountLabel.setBackground(new Color(255, 255, 255, 180));
        bgLabel.add(amountLabel);

        // Amount input field
        JTextField amountField = new JTextField();
        amountField.setBounds(220, 90, 180, 30);
        amountField.setOpaque(true);
        amountField.setBackground(new Color(255, 255, 255, 200));
        bgLabel.add(amountField);

        // Currency selection panel (From - To)
        JPanel currencyPanel = new JPanel();
        currencyPanel.setLayout(null);
        currencyPanel.setBounds(70, 140, 360, 110);
        currencyPanel.setBackground(new Color(255, 255, 255, 180));
        currencyPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        bgLabel.add(currencyPanel);

        // "From" label
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(10, 10, 80, 25);
        fromLabel.setFont(new Font("Arial", Font.BOLD, 18));
        fromLabel.setForeground(new Color(0, 0, 139));
        currencyPanel.add(fromLabel);

        // Currency combo box - From
        String[] currencies = {"BDT", "USD", "EUR", "INR", "GBP"};
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(80, 10, 100, 25);
        currencyPanel.add(fromCurrency);

        // "To" label
        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(200, 10, 40, 25);
        toLabel.setFont(new Font("Arial", Font.BOLD, 18));
        toLabel.setForeground(new Color(0, 0, 139));
        currencyPanel.add(toLabel);

        // Currency combo box - To
        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(240, 10, 100, 25);
        currencyPanel.add(toCurrency);

        // Result show korar jonno label
        JLabel resultLabel = new JLabel("Result will appear here");
        resultLabel.setBounds(30, 50, 300, 40);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setForeground(new Color(0, 0, 139));
        resultLabel.setOpaque(true);
        resultLabel.setBackground(new Color(255, 255, 255, 200));
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        currencyPanel.add(resultLabel);

        // Convert button
        JButton convertBtn = new JButton("Convert");
        convertBtn.setBounds(120, 300, 120, 40);
        convertBtn.setFont(new Font("Arial", Font.BOLD, 16));
        convertBtn.setBackground(new Color(51, 153, 255));
        convertBtn.setForeground(Color.WHITE);
        convertBtn.setFocusPainted(false);
        convertBtn.setBorder(BorderFactory.createLineBorder(new Color(30, 120, 200), 2));
        convertBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bgLabel.add(convertBtn);

        // Exit button
        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(280, 300, 100, 40);
        exitBtn.setFont(new Font("Arial", Font.BOLD, 16));
        exitBtn.setBackground(new Color(153, 0, 0));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setFocusPainted(false);
        exitBtn.setBorder(BorderFactory.createLineBorder(new Color(120, 0, 0), 2));
        exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bgLabel.add(exitBtn);

        // Clear button
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(420, 330, 60, 30);
        clearBtn.setFont(new Font("Arial", Font.BOLD, 12));
        clearBtn.setBackground(new Color(102, 102, 102));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFocusPainted(false);
        clearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearBtn.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80), 1));
        bgLabel.add(clearBtn);

        // Convert button click korle ki hobe
        convertBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText()); // TextField theke amount read
                String from = (String) fromCurrency.getSelectedItem(); // Source currency
                String to = (String) toCurrency.getSelectedItem();     // Target currency

                if (from.equals(to)) {
                    resultLabel.setText("Same currency selected");
                    resultLabel.setForeground(Color.RED);
                } else {
                    double result = convertRate(amount, from, to); // Conversion calculation
                    resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, from, result, to));
                    resultLabel.setForeground(new Color(0, 0, 139));
                }
            } catch (Exception ex) {
                resultLabel.setText("Please enter a valid amount"); // Exception handle
                resultLabel.setForeground(Color.RED);
            }
        });

        // Clear button click korle input & result clear
        clearBtn.addActionListener(e -> {
            amountField.setText("");
            resultLabel.setText("Result will appear here");
            resultLabel.setForeground(new Color(0, 0, 139));
        });

        // Exit button click korle program bondho hobe
        exitBtn.addActionListener(e -> System.exit(0));

        frame.setVisible(true); 
    }

    // Currency conversion rate calculation
    private static double convertRate(double amount, String from, String to) {
        Map<String, Double> rates = new HashMap<>();
        rates.put("BDT", 1.0);       
        rates.put("USD", 121.70);     
        rates.put("EUR", 137.16);    
        rates.put("INR", 1.47);       
        rates.put("GBP", 150.08);     

        double inBDT = amount * rates.get(from);   // From currency ke BDT te convert
        return inBDT / rates.get(to);              //BDT theke To currency te convert
    }
}
