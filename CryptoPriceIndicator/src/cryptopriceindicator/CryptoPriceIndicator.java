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
    
    private JPanel headerPanel;
    private JPanel coinsPanel;
    private JPanel testPanel;
    
    private JLabel name;
    private JLabel price;
    private JLabel rank;
    private JLabel marketCap;
    private JLabel circulatingSupply;
    
    private JLabel btcRank;
    private JLabel btc;
    private JLabel btcPrice;
    private JLabel btcMC;
    private JLabel btcCS;
  
    public static String[] btcRow;
    public static String btcNameCell;
    public static String btcName;
    public static String btcTicker;
    
    public static String btcTempPrice;
    public static String btcTempRank;
    public static String btcTempMC;
    public static String btcTempCS;
    
    private JLabel ethRank;
    private JLabel eth;
    private JLabel ethPrice;
    private JLabel ethMC;
    private JLabel ethCS;
    
    public static String[] ethRow;
    public static String ethNameCell;
    public static String ethName;
    public static String ethTicker;
    
    public static String ethTempPrice;
    public static String ethTempRank;
    public static String ethTempMC;
    public static String ethTempCS;
    
    private JLabel adaRank;
    private JLabel ada;
    private JLabel adaPrice;
    private JLabel adaMC;
    private JLabel adaCS;
    
    public static String[] adaRow;
    public static String adaNameCell;
    public static String adaName;
    public static String adaTicker;
    
    public static String adaTempPrice;
    public static String adaTempRank;
    public static String adaTempMC;
    public static String adaTempCS;
    
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
        
        headerPanel = new JPanel(new GridBagLayout());
        coinsPanel = new JPanel(new GridBagLayout());
        testPanel = new JPanel();
        
        headerPanel.setBackground(Color.LIGHT_GRAY);
        coinsPanel.setBackground(Color.LIGHT_GRAY);
        testPanel.setBackground(Color.MAGENTA);
        
        //this.getContentPane().add(headerPanel, BorderLayout.NORTH);
        this.getContentPane().add(coinsPanel, BorderLayout.NORTH);
        this.getContentPane().add(testPanel, BorderLayout.SOUTH);

        
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
        
        btcRank = new JLabel();
        btcRank.setText(btcTempRank);
        btcRank.setForeground(Color.white);
        btcRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(20, -50, 40, 160);
        
        coinsPanel.add(btcRank, c);
        
        btc = new JLabel();
        btc.setText(btcName + ":");
        btc.setForeground(Color.white);
        btc.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(20, -120, 40, 80);

        coinsPanel.add(btc, c);

        btcPrice = new JLabel();
        btcPrice.setText(btcTempPrice);
        btcPrice.setForeground(Color.white);
        btcPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(btcPrice, c);
        
        btcMC = new JLabel();
        btcMC.setText(btcTempMC);
        btcMC.setForeground(Color.white);
        btcMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 1;
        c.insets = new Insets(20, -50, 40, 80);        


        coinsPanel.add(btcMC, c);
        
        btcCS = new JLabel();
        btcCS.setText(btcTempCS);
        btcCS.setForeground(Color.white);
        btcCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 4;
        c.gridy = 1;
        c.insets = new Insets(20, -50, 40, 0);

        coinsPanel.add(btcCS, c);
        
        //2nd coin below
        
        ethRank = new JLabel();
        ethRank.setText(ethTempRank);
        ethRank.setForeground(Color.white);
        ethRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(ethRank, c);
        
        eth = new JLabel();
        eth.setText(ethName + ":");
        eth.setForeground(Color.white);
        eth.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(eth, c);
        c.anchor = GridBagConstraints.EAST;

        ethPrice = new JLabel();
        ethPrice.setText(ethTempPrice);
        ethPrice.setForeground(Color.white);
        ethPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(ethPrice, c);
        
        ethMC = new JLabel();
        ethMC.setText(ethTempMC);
        ethMC.setForeground(Color.white);
        ethMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 2;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(ethMC, c);
        
        ethCS = new JLabel();
        ethCS.setText(ethTempCS);
        ethCS.setForeground(Color.white);
        ethCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 2;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(ethCS, c);
        
        //3rd coin below
        
        adaRank = new JLabel();
        adaRank.setText(adaTempRank);
        adaRank.setForeground(Color.white);
        adaRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(adaRank, c);
        c.anchor = GridBagConstraints.WEST;
        ada = new JLabel();
        ada.setText(adaName + ":");
        ada.setForeground(Color.white);
        ada.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(ada, c);
        c.anchor = GridBagConstraints.EAST;
        adaPrice = new JLabel();
        adaPrice.setText(adaTempPrice);
        adaPrice.setForeground(Color.white);
        adaPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(adaPrice, c);
        
        adaMC = new JLabel();
        adaMC.setText(adaTempMC);
        adaMC.setForeground(Color.white);
        adaMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 3;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(adaMC, c);
        
        adaCS = new JLabel();
        adaCS.setText(adaTempCS);
        adaCS.setForeground(Color.white);
        adaCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 3;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(adaCS, c);
        
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
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        JSeparator sep = new JSeparator();
        sep.setBorder(border);
        sep.setPreferredSize(new Dimension(10000,10));
        sep.setBackground(Color.black);
        
        testPanel.add(sep);
        
        //pack();
        this.setVisible(true);
    }
    
    static void webScrapeBTC() {
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    btcNameCell = row.select("td:nth-of-type(3)").text(); //Gets data from the Name cell of the given row
                    if (btcNameCell.contains("Bitcoin"))
                    {
                        btcRow = btcNameCell.split(" ");
                        btcName = btcRow[0];
                        System.out.println(btcName);
                        btcTicker = btcRow[2];
                        System.out.println(btcTicker);
                        btcName = btcName + " " + btcTicker;
                        System.out.println(btcName);
                        btcNameCell = btcNameCell.split(" ")[0];
                        System.out.println("This is Bitcoin");
                        System.out.println(btcNameCell);
                    }
                    else{
                        System.out.println("This is not Bitcoin");
                    }
                    
                    btcTempPrice = row.select("td:nth-of-type(4)").text();
                    System.out.println(btcTempPrice);
                    
                    btcTempRank = row.select("td:nth-of-type(2)").text();
                    System.out.println(btcTempRank);
                    
                    btcTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    System.out.println(btcTempMC);
                    
                    btcTempCS = row.select("td:nth-of-type(9)").text();
                    System.out.println(btcTempCS);
                    
                }
                if(btcNameCell.contains("Bitcoin")){
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static void webScrapeETH() {
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    ethNameCell = row.select("td:nth-of-type(3)").text(); //Gets data from the Name cell of the given row
                    if (ethNameCell.contains("Ethereum"))
                    {
                        ethRow = ethNameCell.split(" ");
                        ethName = ethRow[0];
                        System.out.println(ethName);
                        ethTicker = ethRow[2];
                        System.out.println(ethTicker);
                        ethName = ethName + " " + ethTicker;
                        System.out.println(ethName);
                        ethNameCell = ethNameCell.split(" ")[0];
                        System.out.println("This is Ethereum");
                        System.out.println(ethNameCell);
                    }
                    else{
                        System.out.println("This is not Ethereum");
                    }
                    
                    ethTempPrice = row.select("td:nth-of-type(4)").text();
                    System.out.println(ethTempPrice);
                    
                    ethTempRank = row.select("td:nth-of-type(2)").text();
                    System.out.println(ethTempRank);
                    
                    ethTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    System.out.println(ethTempMC);
                    
                    ethTempCS = row.select("td:nth-of-type(9)").text();
                    System.out.println(ethTempCS);
                    
                }
                if(ethNameCell.contains("Ethereum")){
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static void webScrapeADA() {
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    adaNameCell = row.select("td:nth-of-type(3)").text(); //Gets data from the Name cell of the given row
                    if (adaNameCell.contains("Cardano"))
                    {
                        adaRow = adaNameCell.split(" ");
                        adaName = adaRow[0];
                        System.out.println(adaName);
                        adaTicker = adaRow[2];
                        System.out.println(adaTicker);
                        adaName = adaName + " " + adaTicker;
                        System.out.println(adaName);
                        adaNameCell = adaNameCell.split(" ")[0];
                        System.out.println("This is Ethereum");
                        System.out.println(adaNameCell);
                    }
                    else{
                        System.out.println("This is not Ethereum");
                    }
                    
                    adaTempPrice = row.select("td:nth-of-type(4)").text();
                    System.out.println(adaTempPrice);
                    
                    adaTempRank = row.select("td:nth-of-type(2)").text();
                    System.out.println(adaTempRank);
                    
                    adaTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    System.out.println(adaTempMC);
                    
                    adaTempCS = row.select("td:nth-of-type(9)").text();
                    System.out.println(adaTempCS);
                    
                }
                if(adaNameCell.contains("Cardano")){
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
                    //System.out.println(fourthCoinTicker.substring(0, fourthCoinTicker.length() - 3));
                    if (fourthCoinTickerTrimmed.contains(num1ToRemove)) {
                        fourthCoinTickerTrimmed = fourthCoinTickerTrimmed.replaceAll(num1ToRemove, "");
                    }
                    fourthCoinTempPrice = row.select("td:nth-of-type(4)").text();
                    //System.out.println(fourthCoinTempPrice);
                    
                    fourthCoinTempRank = row.select("td:nth-of-type(2)").text();
                    //System.out.println(fourthCoinTempRank);
                    
                    fourthCoinTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    //System.out.println(fourthCoinTempMC);
                    
                    fourthCoinTempCS = row.select("td:nth-of-type(9)").text();
                    //System.out.println(fourthCoinTempCS);
                    
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
        webScrapeBTC();
        webScrapeETH();
        webScrapeADA();
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
