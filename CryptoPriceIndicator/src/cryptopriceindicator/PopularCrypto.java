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
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
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
public class PopularCrypto extends JFrame implements ActionListener{
    
    private JPanel headerPanel;
    private JPanel coinsPanel;
    
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
    
    private JLabel solRank;
    private JLabel sol;
    private JLabel solPrice;
    private JLabel solMC;
    private JLabel solCS;
  
    public static String[] solRow;
    public static String solNameCell;
    public static String solName;
    public static String solTicker;
    
    public static String solTempPrice;
    public static String solTempRank;
    public static String solTempMC;
    public static String solTempCS;
    
    BufferedImage btcPic = null;
    ImageIcon btcIcon;
    JLabel btcLabel;
    BufferedImage ethPic = null;
    JLabel ethLabel;
    BufferedImage adaPic = null;
    JLabel adaLabel;
        

    
    public PopularCrypto(){
        
        this.setResizable(false);
        this.setSize(1350, 700);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Popular Cryptocurrencies and Prices");
        
        try {
            btcPic = ImageIO.read(new File("src/crypto_icons/btc.png"));
            ethPic = ImageIO.read(new File("src/crypto_icons/eth.png"));
        } catch (IOException ex) {
            Logger.getLogger(PopularCrypto.class.getName()).log(Level.SEVERE, null, ex);
        }
        btcLabel = new JLabel(new ImageIcon(btcPic));
        ethLabel = new JLabel(new ImageIcon(btcPic));
        
        
        headerPanel = new JPanel(new GridBagLayout());
        coinsPanel = new JPanel(new GridBagLayout());
        
        headerPanel.setBackground(Color.LIGHT_GRAY);
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
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(name, c);

        price = new JLabel("Price");
        price.setToolTipText("Current price of the cryptocurrency according to CoinMarketCap.com");
        price.setForeground(Color.white);
        price.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(price, c);
        
        marketCap = new JLabel("Market Cap");
        marketCap.setToolTipText("The total market value of a cryptocurrency's circulating supply. It is analogous to the free-float capitalization in the stock market.");
        marketCap.setForeground(Color.white);
        marketCap.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 0;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(marketCap, c);
        
        circulatingSupply = new JLabel("Circulating Supply");
        circulatingSupply.setToolTipText("The amount of coins that are circulating in the market and are in public hands.");
        circulatingSupply.setForeground(Color.white);
        circulatingSupply.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 5;
        c.gridy = 0;
        c.insets = new Insets(20, -50, 40, 0);

        coinsPanel.add(circulatingSupply, c);
        
        //BTC Below
        
        btcRank = new JLabel();
        btcRank.setText(btcTempRank);
        btcRank.setForeground(Color.white);
        btcRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(20, -50, 40, 160);
        
        coinsPanel.add(btcRank, c);
        
        c.gridx = 1;
        c.gridy = 1;
        //c.insets = new Insets(0, 5, 5, 100);
        //c.insets = new Insets(0, 0, 0, 0);
        c.anchor = GridBagConstraints.EAST;
        coinsPanel.add(btcLabel,c);
        
        btc = new JLabel();
        btc.setText(btcName + ":");
        btc.setForeground(Color.white);
        btc.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(20, -120, 40, 80);

        coinsPanel.add(btc, c);

        btcPrice = new JLabel();
        btcPrice.setText(btcTempPrice);
        btcPrice.setForeground(Color.white);
        btcPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 3;
        c.gridy = 1;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(btcPrice, c);
        
        btcMC = new JLabel();
        btcMC.setText(btcTempMC);
        btcMC.setForeground(Color.white);
        btcMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 1;
        c.insets = new Insets(20, -50, 40, 80);        


        coinsPanel.add(btcMC, c);
        
        btcCS = new JLabel();
        btcCS.setText(btcTempCS);
        btcCS.setForeground(Color.white);
        btcCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 5;
        c.gridy = 1;
        c.insets = new Insets(20, -50, 40, 0);

        coinsPanel.add(btcCS, c);
        
        //ETH Below
        
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
        
        //ADA Below
        
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
        
        //Solana Below
        
        solRank = new JLabel();
        solRank.setText(solTempRank);
        solRank.setForeground(Color.white);
        solRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(solRank, c);
        
        c.anchor = GridBagConstraints.WEST;
        sol = new JLabel();
        sol.setText(solName + ":");
        sol.setForeground(Color.white);
        sol.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(sol, c);

        solPrice = new JLabel();
        solPrice.setText(solTempPrice);
        solPrice.setForeground(Color.white);
        solPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(solPrice, c);
        
        solMC = new JLabel();
        solMC.setText(solTempMC);
        solMC.setForeground(Color.white);
        solMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 4;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(solMC, c);
        
        solCS = new JLabel();
        solCS.setText(solTempCS);
        solCS.setForeground(Color.white);
        solCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 4;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(solCS, c);

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
    
    static void webScrapeSOL() {
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    solNameCell = row.select("td:nth-of-type(3)").text(); //Gets data from the Name cell of the given row
                    if (solNameCell.contains("Solana"))
                    {
                        solRow = solNameCell.split(" ");
                        solName = solRow[0];
                        System.out.println(solName);
                        solTicker = solRow[2];
                        System.out.println(solTicker);
                        solName = solName + " " + solTicker;
                        System.out.println(solName);
                        solNameCell = solNameCell.split(" ")[0];
                        System.out.println("This is Solana");
                        System.out.println(solNameCell);
                    }
                    else{
                        System.out.println("This is not Solana");
                    }
                    
                    solTempPrice = row.select("td:nth-of-type(4)").text();
                    System.out.println(solTempPrice);
                    
                    solTempRank = row.select("td:nth-of-type(2)").text();
                    System.out.println(solTempRank);
                    
                    solTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    System.out.println(solTempMC);
                    
                    solTempCS = row.select("td:nth-of-type(9)").text();
                    System.out.println(solTempCS);
                    
                }
                if(solNameCell.contains("Solana")){
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
    /*public static void main(String[] args) throws Exception{
        // TODO code application logic here
        webScrapeBTC();
        webScrapeETH();
        webScrapeADA();
        webScrapeSOL();
        
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        //String str = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";

        
        UIManager.setLookAndFeel(str);
        new TopTenCrypto();
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
