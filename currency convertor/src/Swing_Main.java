import java.awt.*;
import javax.swing.*;

public class Swing_Main {

    public static void main(String[] args) {
    	JFrame frame = new JFrame("Currency Converter");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        
        ImageIcon icon = new ImageIcon("img/pp.jfif");
        Image scaledImg = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        JLabel bgLabel = new JLabel(new ImageIcon(scaledImg));
        bgLabel.setBounds(0, 0, 500, 400);
        frame.add(bgLabel);

        
        JLabel title = new JLabel("Currency Converter", SwingConstants.CENTER);
        title.setBounds(120, 20, 260, 50);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(0, 0, 139)); 
        title.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); 
        title.setOpaque(true);
        title.setBackground(new Color(255, 255, 255, 180)); 
        bgLabel.add(title);

       
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(80, 100, 150, 30);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 18));
        amountLabel.setForeground(new Color(0, 0, 139)); 
        bgLabel.add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(220, 100, 180, 30);
        bgLabel.add(amountField);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(80, 150, 100, 30);
        fromLabel.setFont(new Font("Arial", Font.BOLD, 18));
        fromLabel.setForeground(new Color(0, 0, 139)); 
        bgLabel.add(fromLabel);

        String[] currencies = {"BDT", "USD", "EUR", "INR", "GBP"};
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(150, 150, 100, 30);
        bgLabel.add(fromCurrency);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(280, 150, 50, 30);
        toLabel.setFont(new Font("Arial", Font.BOLD, 18));
        toLabel.setForeground(new Color(0, 0, 139)); 
        bgLabel.add(toLabel);

        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(330, 150, 100, 30);
        bgLabel.add(toCurrency);

        
        JButton convertBtn = new JButton("Convert");
        convertBtn.setBounds(120, 300, 120, 40);
        convertBtn.setFont(new Font("Arial", Font.BOLD, 16));
        convertBtn.setBackground(new Color(0, 153, 76)); 
        convertBtn.setForeground(Color.WHITE);
        convertBtn.setFocusPainted(false);
        convertBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        bgLabel.add(convertBtn);

        
        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(280, 300, 100, 40);
        exitBtn.setFont(new Font("Arial", Font.BOLD, 16));
        exitBtn.setBackground(new Color(204, 0, 0)); 
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setFocusPainted(false);
        exitBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        bgLabel.add(exitBtn);

       
        exitBtn.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
