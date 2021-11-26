/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptopriceindicator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
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
    private JLabel marketCap;
    private JLabel circulatingSupply;
    
    private JLabel firstCoinRank;
    private JLabel firstCoin;
    private JLabel firstCoinPrice;
    private JLabel firstCoinMC;
    private JLabel firstCoinCS;
  
    public static String firstCoinTicker;
    public static String firstCoinTickerTrimmed;
    
    public static String firstCoinTempPrice;
    public static String firstCoinTempRank;
    public static String firstCoinTempMC;
    public static String firstCoinTempCS;
    
    private JLabel secondCoinRank;
    private JLabel secondCoin;
    private JLabel secondCoinPrice;
    private JLabel secondCoinMC;
    private JLabel secondCoinCS;
    
    public static String secondCoinTicker;
    public static String secondCoinTickerTrimmed;
    
    public static String secondCoinTempPrice;
    public static String secondCoinTempRank;
    public static String secondCoinTempMC;
    public static String secondCoinTempCS;
    
    private JLabel thirdCoinRank;
    private JLabel thirdCoin;
    private JLabel thirdCoinPrice;
    private JLabel thirdCoinMC;
    private JLabel thirdCoinCS;
  
    public static String thirdCoinTicker;
    public static String thirdCoinTickerTrimmed;
    
    public static String thirdCoinTempPrice;
    public static String thirdCoinTempRank;
    public static String thirdCoinTempMC;
    public static String thirdCoinTempCS;
    
    private JLabel fourthCoinRank;
    private JLabel fourthCoin;
    private JLabel fourthCoinPrice;
    private JLabel fourthCoinMC;
    private JLabel fourthCoinCS;
  
    public static String fourthCoinTicker;
    public static String fourthCoinTickerTrimmed;
    
    public static String fourthCoinTempPrice;
    public static String fourthCoinTempRank;
    public static String fourthCoinTempMC;
    public static String fourthCoinTempCS;
    
    public CryptoPriceIndicator(){
        
        this.setResizable(false);
        //this.setSize(1550, 700);
        this.setSize(1350, 700);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Crypto Prices");
        
        coinsPanel = new JPanel(new GridBagLayout());
        coinsPanel.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(coinsPanel, BorderLayout.NORTH);

        GridBagConstraints c = new GridBagConstraints();
        
        rank = new JLabel("#");
        rank.setToolTipText("Rank is based on Market Cap");
        rank.setForeground(Color.white);
        rank.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20, -50, 40, 150);
        
        coinsPanel.add(rank, c);

        name = new JLabel("Name");
        name.setForeground(Color.white);
        name.setFont(new Font("Arial", Font.BOLD, 25));
        //c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(name, c);

        price = new JLabel("Price");
        price.setToolTipText("Current price of the cryptocurrency according to CoinMarketCap.com");
        price.setForeground(Color.white);
        price.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(price, c);
        
        marketCap = new JLabel("Market Cap");
        marketCap.setToolTipText("The total market value of a cryptocurrency's circulating supply. It is analogous to the free-float capitalization in the stock market.");
        marketCap.setForeground(Color.white);
        marketCap.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(marketCap, c);
        
        circulatingSupply = new JLabel("Circulating Supply");
        circulatingSupply.setToolTipText("The amount of coins that are circulating in the market and are in public hands.");
        circulatingSupply.setForeground(Color.white);
        circulatingSupply.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 0;
        c.insets = new Insets(20, -50, 40, 0);

        coinsPanel.add(circulatingSupply, c);
        
        firstCoinRank = new JLabel();
        firstCoinRank.setText(firstCoinTempRank);
        firstCoinRank.setForeground(Color.white);
        firstCoinRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(20, -50, 40, 160);
        
        coinsPanel.add(firstCoinRank, c);
        
        firstCoin = new JLabel();
        firstCoin.setText(firstCoinTickerTrimmed + ":");
        firstCoin.setForeground(Color.white);
        firstCoin.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(20, -120, 40, 80);

        coinsPanel.add(firstCoin, c);

        firstCoinPrice = new JLabel();
        firstCoinPrice.setText(firstCoinTempPrice);
        firstCoinPrice.setForeground(Color.white);
        firstCoinPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(firstCoinPrice, c);
        
        firstCoinMC = new JLabel();
        firstCoinMC.setText(firstCoinTempMC);
        firstCoinMC.setForeground(Color.white);
        firstCoinMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 1;
        c.insets = new Insets(20, -50, 40, 80);        


        coinsPanel.add(firstCoinMC, c);
        
        firstCoinCS = new JLabel();
        firstCoinCS.setText(firstCoinTempCS);
        firstCoinCS.setForeground(Color.white);
        firstCoinCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 4;
        c.gridy = 1;
        c.insets = new Insets(20, -50, 40, 0);

        coinsPanel.add(firstCoinCS, c);
        
        //2nd coin below
        
        secondCoinRank = new JLabel();
        secondCoinRank.setText(secondCoinTempRank);
        secondCoinRank.setForeground(Color.white);
        secondCoinRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(secondCoinRank, c);
        
        secondCoin = new JLabel();
        secondCoin.setText(secondCoinTickerTrimmed + ":");
        secondCoin.setForeground(Color.white);
        secondCoin.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(secondCoin, c);
        c.anchor = GridBagConstraints.EAST;

        secondCoinPrice = new JLabel();
        secondCoinPrice.setText(secondCoinTempPrice);
        secondCoinPrice.setForeground(Color.white);
        secondCoinPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(secondCoinPrice, c);
        
        secondCoinMC = new JLabel();
        secondCoinMC.setText(secondCoinTempMC);
        secondCoinMC.setForeground(Color.white);
        secondCoinMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 2;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(secondCoinMC, c);
        
        secondCoinCS = new JLabel();
        secondCoinCS.setText(secondCoinTempCS);
        secondCoinCS.setForeground(Color.white);
        secondCoinCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 2;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(secondCoinCS, c);
        
        //3rd coin below
        
        thirdCoinRank = new JLabel();
        thirdCoinRank.setText(thirdCoinTempRank);
        thirdCoinRank.setForeground(Color.white);
        thirdCoinRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(thirdCoinRank, c);
        
        thirdCoin = new JLabel();
        thirdCoin.setText(thirdCoinTickerTrimmed + ":");
        thirdCoin.setForeground(Color.white);
        thirdCoin.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(thirdCoin, c);

        thirdCoinPrice = new JLabel();
        thirdCoinPrice.setText(thirdCoinTempPrice);
        thirdCoinPrice.setForeground(Color.white);
        thirdCoinPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(thirdCoinPrice, c);
        
        thirdCoinMC = new JLabel();
        thirdCoinMC.setText(thirdCoinTempMC);
        thirdCoinMC.setForeground(Color.white);
        thirdCoinMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 3;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(thirdCoinMC, c);
        
        thirdCoinCS = new JLabel();
        thirdCoinCS.setText(thirdCoinTempCS);
        thirdCoinCS.setForeground(Color.white);
        thirdCoinCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 3;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(thirdCoinCS, c);
        
        //Fourth Coin below
        
        fourthCoinRank = new JLabel();
        fourthCoinRank.setText(fourthCoinTempRank);
        fourthCoinRank.setForeground(Color.white);
        fourthCoinRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(fourthCoinRank, c);
        
        fourthCoin = new JLabel();
        fourthCoin.setText(fourthCoinTickerTrimmed + ":");
        fourthCoin.setForeground(Color.white);
        fourthCoin.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(fourthCoin, c);

        fourthCoinPrice = new JLabel();
        fourthCoinPrice.setText(fourthCoinTempPrice);
        fourthCoinPrice.setForeground(Color.white);
        fourthCoinPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(fourthCoinPrice, c);
        
        fourthCoinMC = new JLabel();
        fourthCoinMC.setText(fourthCoinTempMC);
        fourthCoinMC.setForeground(Color.white);
        fourthCoinMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 4;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(fourthCoinMC, c);
        
        fourthCoinCS = new JLabel();
        fourthCoinCS.setText(fourthCoinTempCS);
        fourthCoinCS.setForeground(Color.white);
        fourthCoinCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 4;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(fourthCoinCS, c);
        
        /*
        START***
        GridBagConstraints separatorConstraint = new GridBagConstraints();
        separatorConstraint.anchor = GridBagConstraints.WEST;
        separatorConstraint.gridx = 0;
        separatorConstraint.gridy = 1;
        //separatorConstraint.weightx = 1.0;
        separatorConstraint.fill = GridBagConstraints.HORIZONTAL;
        separatorConstraint.gridwidth = GridBagConstraints.REMAINDER;
        //separatorConstraint.gridwidth = GridBagConstraints.REMAINDER;
        
        JSeparator sep = new JSeparator();
        sep.setPreferredSize(new Dimension(30, 100));
        sep.setBackground(Color.black);
        
        coinsPanel.add(sep, separatorConstraint);
        //coinsPanel.add(new JSeparator(JSeparator.HORIZONTAL), separatorConstraint);
        END***
        */
        
        /*
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        c.insets = new Insets(100, 0, 100, 100);
        c.gridx = 0;
        c.gridy = 5;
        //c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.gridwidth = GridBagConstraints.REMAINDER;
        //c.gridwidth = GridBagConstraints.RELATIVE;
        //c.gridwidth = 50;
        
        JSeparator sep = new JSeparator();
        sep.setBorder(border);
        //sep.setPreferredSize(new Dimension(700,10));
        sep.setBackground(Color.black);
        
        coinsPanel.add(sep,c);
        */
        
        //pack();
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
                    
                    firstCoinTempRank = row.select("td:nth-of-type(2)").text();
                    System.out.println(firstCoinTempRank);
                    
                    firstCoinTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    System.out.println(firstCoinTempMC);
                    
                    firstCoinTempCS = row.select("td:nth-of-type(9)").text();
                    System.out.println(firstCoinTempCS);
                    
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
    
    static void webScrape2ndCoin() {
        int count = 0;
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    String num1ToRemove = "2";
                    secondCoinTicker = row.select("td:nth-of-type(3)").text();
                    secondCoinTickerTrimmed = secondCoinTicker.substring(0, secondCoinTicker.length() - 3);
                    System.out.println(secondCoinTicker.substring(0, secondCoinTicker.length() - 3));
                    if (secondCoinTickerTrimmed.contains(num1ToRemove)) {
                        secondCoinTickerTrimmed = secondCoinTickerTrimmed.replaceAll(num1ToRemove, "");
                    }
                    secondCoinTempPrice = row.select("td:nth-of-type(4)").text();
                    System.out.println(secondCoinTempPrice);
                    
                    secondCoinTempRank = row.select("td:nth-of-type(2)").text();
                    System.out.println(secondCoinTempRank);
                    
                    secondCoinTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    System.out.println(secondCoinTempMC);
                    
                    secondCoinTempCS = row.select("td:nth-of-type(9)").text();
                    System.out.println(secondCoinTempCS);
                    
                }
                count++;
                if (count == 2) {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static void webScrape3rdCoin() {
        int count = 0;
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    String num1ToRemove = "3";
                    thirdCoinTicker = row.select("td:nth-of-type(3)").text();
                    thirdCoinTickerTrimmed = thirdCoinTicker.substring(0, thirdCoinTicker.length() - 3);
                    System.out.println(thirdCoinTicker.substring(0, thirdCoinTicker.length() - 3));
                    if (thirdCoinTickerTrimmed.contains(num1ToRemove)) {
                        thirdCoinTickerTrimmed = thirdCoinTickerTrimmed.replaceAll(num1ToRemove, "");
                    }
                    thirdCoinTempPrice = row.select("td:nth-of-type(4)").text();
                    System.out.println(thirdCoinTempPrice);
                    
                    thirdCoinTempRank = row.select("td:nth-of-type(2)").text();
                    System.out.println(thirdCoinTempRank);
                    
                    thirdCoinTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    System.out.println(thirdCoinTempMC);
                    
                    thirdCoinTempCS = row.select("td:nth-of-type(9)").text();
                    System.out.println(thirdCoinTempCS);
                    
                }
                count++;
                if (count == 3) {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static void webScrape4thCoin() {
        int count = 0;
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    String num1ToRemove = "4";
                    fourthCoinTicker = row.select("td:nth-of-type(3)").text();
                    fourthCoinTickerTrimmed = fourthCoinTicker.substring(0, fourthCoinTicker.length() - 3);
                    System.out.println(fourthCoinTicker.substring(0, fourthCoinTicker.length() - 3));
                    if (fourthCoinTickerTrimmed.contains(num1ToRemove)) {
                        fourthCoinTickerTrimmed = fourthCoinTickerTrimmed.replaceAll(num1ToRemove, "");
                    }
                    fourthCoinTempPrice = row.select("td:nth-of-type(4)").text();
                    System.out.println(fourthCoinTempPrice);
                    
                    fourthCoinTempRank = row.select("td:nth-of-type(2)").text();
                    System.out.println(fourthCoinTempRank);
                    
                    fourthCoinTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    System.out.println(fourthCoinTempMC);
                    
                    fourthCoinTempCS = row.select("td:nth-of-type(9)").text();
                    System.out.println(fourthCoinTempCS);
                    
                }
                count++;
                if (count == 4) {
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
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        webScrape1stCoin();
        webScrape2ndCoin();
        webScrape3rdCoin();
        webScrape4thCoin();
        
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        //String str = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";

        
        UIManager.setLookAndFeel(str);
        new CryptoPriceIndicator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
