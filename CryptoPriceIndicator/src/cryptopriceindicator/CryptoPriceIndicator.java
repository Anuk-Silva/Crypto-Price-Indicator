/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptopriceindicator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Anuk
 */
public class CryptoPriceIndicator extends JFrame implements ActionListener{
    
    private JPanel coinsPanel;
    
    private JLabel name;
    private JLabel price;
    private JLabel rank;
    
    private JLabel firstCoinRank;
    private JLabel firstCoin;
    private JLabel firstCoinPrice;
    
    public static String firstCoinTicker;
    public static String firstCoinTickerTrimmed;
    
    public static String firstCoinTempPrice;
    public static String firstCoinRankString;
    
    public CryptoPriceIndicator(){
        
        this.setResizable(false);
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Crypto Prices");
        
        coinsPanel = new JPanel(new GridBagLayout());
        coinsPanel.setBackground(Color.lightGray);
        this.getContentPane().add(coinsPanel, BorderLayout.NORTH);

        GridBagConstraints c = new GridBagConstraints();
        
        rank = new JLabel("#");
        rank.setForeground(Color.black);
        rank.setFont(new Font("Arial", Font.BOLD, 20));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20, -50, 10, 250);
        
        coinsPanel.add(rank, c);

        name = new JLabel("Name");
        name.setForeground(Color.black);
        name.setFont(new Font("Arial", Font.BOLD, 20));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 0;

        coinsPanel.add(name, c);

        price = new JLabel("Price");
        price.setForeground(Color.black);
        price.setFont(new Font("Arial", Font.BOLD, 20));
        c.gridx = 2;
        c.gridy = 0;

        coinsPanel.add(price, c);
        
        firstCoinRank = new JLabel();
        firstCoinRank.setText(firstCoinRankString);
        firstCoinRank.setForeground(Color.black);
        firstCoinRank.setFont(new Font("Arial", Font.BOLD, 30));
        
        c.gridx = 0;
        c.gridy = 1;

        coinsPanel.add(firstCoinRank, c);
        
        firstCoin = new JLabel();
        firstCoin.setText(firstCoinTickerTrimmed + ":");
        firstCoin.setForeground(Color.black);
        firstCoin.setFont(new Font("Arial", Font.BOLD, 30));
        c.gridx = 1;
        c.gridy = 1;

        coinsPanel.add(firstCoin, c);

        firstCoinPrice = new JLabel();
        firstCoinPrice.setText(firstCoinTempPrice);
        firstCoinPrice.setForeground(Color.orange);
        firstCoinPrice.setFont(new Font("Arial", Font.BOLD, 30));

        c.gridx = 2;
        c.gridy = 1;
        coinsPanel.add(firstCoinPrice, c);
        
        
        
        
        this.setVisible(true);
    }
    
    static void webScrape1stCoin() {
        int count = 0;
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    String num1ToRemove = "1";
                    firstCoinTicker = row.select("td:nth-of-type(3)").text();
                    firstCoinTickerTrimmed = firstCoinTicker.substring(0, firstCoinTicker.length() - 3);
                    System.out.println(firstCoinTicker.substring(0, firstCoinTicker.length() - 3));
                    if (firstCoinTickerTrimmed.contains(num1ToRemove)) {
                        firstCoinTickerTrimmed = firstCoinTickerTrimmed.replaceAll(num1ToRemove, "");
                    }
                    firstCoinTempPrice = row.select("td:nth-of-type(4)").text();
                    System.out.println(firstCoinTempPrice);
                    
                    firstCoinRankString = row.select("td:nth-of-type(2)").text();
                    System.out.println(firstCoinRankString);
                    
                }
                count++;
                if (count == 1) {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        webScrape1stCoin();
        new CryptoPriceIndicator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
