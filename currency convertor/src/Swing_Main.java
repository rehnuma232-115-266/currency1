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
        title.setBounds(0, 20, 500, 40);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(0, 0, 139)); 
        
        bgLabel.add(title);
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

        frame.setVisible(true);
    }
}
