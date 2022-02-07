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
import javax.swing.JScrollPane;
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
    
    private JLabel bnbRank;
    private JLabel bnb;
    private JLabel bnbPrice;
    private JLabel bnbMC;
    private JLabel bnbCS;
  
    public static String[] bnbRow;
    public static String bnbNameCell;
    public static String bnbName;
    public static String bnbTicker;
    
    public static String bnbTempPrice;
    public static String bnbTempRank;
    public static String bnbTempMC;
    public static String bnbTempCS;
    
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
    
    private JLabel xrpRank;
    private JLabel xrp;
    private JLabel xrpPrice;
    private JLabel xrpMC;
    private JLabel xrpCS;
  
    public static String[] xrpRow;
    public static String xrpNameCell;
    public static String xrpName;
    public static String xrpTicker;
    
    public static String xrpTempPrice;
    public static String xrpTempRank;
    public static String xrpTempMC;
    public static String xrpTempCS;
    
    private JLabel dogeRank;
    private JLabel doge;
    private JLabel dogePrice;
    private JLabel dogeMC;
    private JLabel dogeCS;
  
    public static String[] dogeRow;
    public static String dogeNameCell;
    public static String dogeName;
    public static String dogeTicker;
    
    public static String dogeTempPrice;
    public static String dogeTempRank;
    public static String dogeTempMC;
    public static String dogeTempCS;
    
    BufferedImage btcPic = null;
    JLabel btcLabel;
    BufferedImage ethPic = null;
    JLabel ethLabel;
    BufferedImage bnbPic = null;
    JLabel bnbLabel;
    BufferedImage adaPic = null;
    JLabel adaLabel;
    BufferedImage solPic = null;
    JLabel solLabel;
    BufferedImage xrpPic = null;
    JLabel xrpLabel;
    BufferedImage dogePic = null;
    JLabel dogeLabel;
        
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
            bnbPic = ImageIO.read(new File("src/crypto_icons/bnb.png"));
            adaPic = ImageIO.read(new File("src/crypto_icons/ada.png"));
            solPic = ImageIO.read(new File("src/crypto_icons/sol.png"));
            xrpPic = ImageIO.read(new File("src/crypto_icons/xrp.png"));
            dogePic = ImageIO.read(new File("src/crypto_icons/doge.png"));
        } catch (IOException ex) {
            Logger.getLogger(PopularCrypto.class.getName()).log(Level.SEVERE, null, ex);
        }
        btcLabel = new JLabel(new ImageIcon(btcPic));
        ethLabel = new JLabel(new ImageIcon(ethPic));
        bnbLabel = new JLabel(new ImageIcon(bnbPic));
        adaLabel = new JLabel(new ImageIcon(adaPic));
        solLabel = new JLabel(new ImageIcon(solPic));
        xrpLabel = new JLabel(new ImageIcon(xrpPic));
        dogeLabel = new JLabel(new ImageIcon(dogePic));
        
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
        
        c.gridx = 1;
        c.gridy = 2;
        //c.insets = new Insets(0, 5, 5, 100);
        //c.insets = new Insets(0, 0, 0, 0);
        c.anchor = GridBagConstraints.EAST;
        coinsPanel.add(ethLabel,c);
        
        eth = new JLabel();
        eth.setText(ethName + ":");
        eth.setForeground(Color.white);
        eth.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(eth, c);
        c.anchor = GridBagConstraints.EAST;

        ethPrice = new JLabel();
        ethPrice.setText(ethTempPrice);
        ethPrice.setForeground(Color.white);
        ethPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 2;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(ethPrice, c);
        
        ethMC = new JLabel();
        ethMC.setText(ethTempMC);
        ethMC.setForeground(Color.white);
        ethMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 2;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(ethMC, c);
        
        ethCS = new JLabel();
        ethCS.setText(ethTempCS);
        ethCS.setForeground(Color.white);
        ethCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 5;
        c.gridy = 2;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(ethCS, c);
        
        //BNB below
        
        bnbRank = new JLabel();
        bnbRank.setText(bnbTempRank);
        bnbRank.setForeground(Color.white);
        bnbRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(bnbRank, c);
        
        c.gridx = 1;
        c.gridy = 3;
        //c.insets = new Insets(0, 5, 5, 100);
        //c.insets = new Insets(0, 0, 0, 0);
        c.anchor = GridBagConstraints.EAST;
        coinsPanel.add(bnbLabel,c);
        
        bnb = new JLabel();
        bnb.setText(bnbName + ":");
        bnb.setForeground(Color.white);
        bnb.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(bnb, c);
        c.anchor = GridBagConstraints.EAST;

        bnbPrice = new JLabel();
        bnbPrice.setText(bnbTempPrice);
        bnbPrice.setForeground(Color.white);
        bnbPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 3;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(bnbPrice, c);
        
        bnbMC = new JLabel();
        bnbMC.setText(bnbTempMC);
        bnbMC.setForeground(Color.white);
        bnbMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 3;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(bnbMC, c);
        
        bnbCS = new JLabel();
        bnbCS.setText(bnbTempCS);
        bnbCS.setForeground(Color.white);
        bnbCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 5;
        c.gridy = 3;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(bnbCS, c);
        
        //ADA Below
        
        adaRank = new JLabel();
        adaRank.setText(adaTempRank);
        adaRank.setForeground(Color.white);
        adaRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(adaRank, c);
        
        c.gridx = 1;
        c.gridy = 4;
        //c.insets = new Insets(0, 5, 5, 100);
        //c.insets = new Insets(0, 0, 0, 0);
        c.anchor = GridBagConstraints.EAST;
        coinsPanel.add(adaLabel,c);
        
        c.anchor = GridBagConstraints.WEST;
        ada = new JLabel();
        ada.setText(adaName + ":");
        ada.setForeground(Color.white);
        ada.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 4;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(ada, c);
        c.anchor = GridBagConstraints.EAST;
        adaPrice = new JLabel();
        adaPrice.setText(adaTempPrice);
        adaPrice.setForeground(Color.white);
        adaPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 3;
        c.gridy = 4;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(adaPrice, c);
        
        adaMC = new JLabel();
        adaMC.setText(adaTempMC);
        adaMC.setForeground(Color.white);
        adaMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 4;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(adaMC, c);
        
        adaCS = new JLabel();
        adaCS.setText(adaTempCS);
        adaCS.setForeground(Color.white);
        adaCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 5;
        c.gridy = 4;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(adaCS, c);
        
        //Solana Below
        
        solRank = new JLabel();
        solRank.setText(solTempRank);
        solRank.setForeground(Color.white);
        solRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(solRank, c);
        
        c.gridx = 1;
        c.gridy = 5;
        //c.insets = new Insets(0, 5, 5, 100);
        c.anchor = GridBagConstraints.EAST;
        coinsPanel.add(solLabel,c);
        
        c.anchor = GridBagConstraints.WEST;
        sol = new JLabel();
        sol.setText(solName + ":");
        sol.setForeground(Color.white);
        sol.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 5;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(sol, c);

        solPrice = new JLabel();
        solPrice.setText(solTempPrice);
        solPrice.setForeground(Color.white);
        solPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 3;
        c.gridy = 5;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(solPrice, c);
        
        solMC = new JLabel();
        solMC.setText(solTempMC);
        solMC.setForeground(Color.white);
        solMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 5;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(solMC, c);
        
        solCS = new JLabel();
        solCS.setText(solTempCS);
        solCS.setForeground(Color.white);
        solCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 5;
        c.gridy = 5;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(solCS, c);
        
        //XRP Below
        
        xrpRank = new JLabel();
        xrpRank.setText(xrpTempRank);
        xrpRank.setForeground(Color.white);
        xrpRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(xrpRank, c);
        
        c.gridx = 1;
        c.gridy = 6;
        //c.insets = new Insets(0, 5, 5, 100);
        c.anchor = GridBagConstraints.EAST;
        coinsPanel.add(xrpLabel,c);
        
        c.anchor = GridBagConstraints.WEST;
        xrp = new JLabel();
        xrp.setText(xrpName + ":");
        xrp.setForeground(Color.white);
        xrp.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 6;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(xrp, c);

        xrpPrice = new JLabel();
        xrpPrice.setText(xrpTempPrice);
        xrpPrice.setForeground(Color.white);
        xrpPrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 3;
        c.gridy = 6;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(xrpPrice, c);
        
        xrpMC = new JLabel();
        xrpMC.setText(xrpTempMC);
        xrpMC.setForeground(Color.white);
        xrpMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 6;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(xrpMC, c);
        
        xrpCS = new JLabel();
        xrpCS.setText(xrpTempCS);
        xrpCS.setForeground(Color.white);
        xrpCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 5;
        c.gridy = 6;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(xrpCS, c);
        
        //DogeCoin Below
        
        dogeRank = new JLabel();
        dogeRank.setText(dogeTempRank);
        dogeRank.setForeground(Color.white);
        dogeRank.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(20, -50, 40, 160);

        coinsPanel.add(dogeRank, c);
        
        c.gridx = 1;
        c.gridy = 7;
        //c.insets = new Insets(0, 5, 5, 100);
        c.anchor = GridBagConstraints.EAST;
        coinsPanel.add(dogeLabel,c);
        
        c.anchor = GridBagConstraints.WEST;
        doge = new JLabel();
        doge.setText(dogeName + ":");
        doge.setForeground(Color.white);
        doge.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 2;
        c.gridy = 7;
        c.insets = new Insets(20, -120, 40, 150);

        coinsPanel.add(doge, c);

        dogePrice = new JLabel();
        dogePrice.setText(dogeTempPrice);
        dogePrice.setForeground(Color.white);
        dogePrice.setFont(new Font("Arial", Font.BOLD, 25));
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 3;
        c.gridy = 7;
        c.insets = new Insets(20, -120, 40, 150);
        
        coinsPanel.add(dogePrice, c);
        
        dogeMC = new JLabel();
        dogeMC.setText(dogeTempMC);
        dogeMC.setForeground(Color.white);
        dogeMC.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 4;
        c.gridy = 7;
        c.insets = new Insets(20, -50, 40, 80);

        coinsPanel.add(dogeMC, c);
        
        dogeCS = new JLabel();
        dogeCS.setText(dogeTempCS);
        dogeCS.setForeground(Color.white);
        dogeCS.setFont(new Font("Arial", Font.BOLD, 25));
        c.gridx = 5;
        c.gridy = 7;
        c.insets = new Insets(20, -50, 40, 0);
        
        coinsPanel.add(dogeCS, c);
        
        JScrollPane scrollPane = new JScrollPane(coinsPanel);
        add(scrollPane);

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
                        //System.out.println(btcName);
                        btcTicker = btcRow[2];
                        //System.out.println(btcTicker);
                        btcName = btcName + " " + btcTicker;
                        //System.out.println(btcName);
                        btcNameCell = btcNameCell.split(" ")[0];
                        System.out.println("This is Bitcoin");
                        //System.out.println(btcNameCell);
                    }
                    else{
                        System.out.println("This is not Bitcoin");
                    }
                    
                    btcTempPrice = row.select("td:nth-of-type(4)").text();
                    //System.out.println(btcTempPrice);
                    
                    btcTempRank = row.select("td:nth-of-type(2)").text();
                    //System.out.println(btcTempRank);
                    
                    btcTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    //System.out.println(btcTempMC);
                    
                    btcTempCS = row.select("td:nth-of-type(9)").text();
                    //System.out.println(btcTempCS);
                    
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
                        //System.out.println(ethName);
                        ethTicker = ethRow[2];
                        //System.out.println(ethTicker);
                        ethName = ethName + " " + ethTicker;
                        //System.out.println(ethName);
                        ethNameCell = ethNameCell.split(" ")[0];
                        System.out.println("This is Ethereum");
                        //System.out.println(ethNameCell);
                    }
                    else{
                        System.out.println("This is not Ethereum");
                    }
                    
                    ethTempPrice = row.select("td:nth-of-type(4)").text();
                    //System.out.println(ethTempPrice);
                    
                    ethTempRank = row.select("td:nth-of-type(2)").text();
                    //System.out.println(ethTempRank);
                    
                    ethTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    //System.out.println(ethTempMC);
                    
                    ethTempCS = row.select("td:nth-of-type(9)").text();
                    //System.out.println(ethTempCS);
                    
                }
                if(ethNameCell.contains("Ethereum")){
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static void webScrapeBNB() {
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    bnbNameCell = row.select("td:nth-of-type(3)").text(); //Gets data from the Name cell of the given row
                    if (bnbNameCell.contains("BNB"))
                    {
                        bnbRow = bnbNameCell.split(" ");
                        bnbName = bnbRow[0];
                        //System.out.println(bnbName);
                        bnbTicker = bnbRow[2];
                        //System.out.println(bnbTicker);
                        bnbName = bnbName + " " + bnbTicker;
                        //System.out.println(bnbName);
                        bnbNameCell = bnbNameCell.split(" ")[0];
                        System.out.println("This is BNB");
                        //System.out.println(bnbNameCell);
                    }
                    else{
                        System.out.println("This is not BNB");
                    }
                    
                    bnbTempPrice = row.select("td:nth-of-type(4)").text();
                    //System.out.println(bnbTempPrice);
                    
                    bnbTempRank = row.select("td:nth-of-type(2)").text();
                    //System.out.println(bnbTempRank);
                    
                    bnbTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    //System.out.println(bnbTempMC);
                    
                    bnbTempCS = row.select("td:nth-of-type(9)").text();
                    //System.out.println(bnbTempCS);
                    
                }
                if(bnbNameCell.contains("BNB")){
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
                        //System.out.println(adaName);
                        adaTicker = adaRow[2];
                        //System.out.println(adaTicker);
                        adaName = adaName + " " + adaTicker;
                        //System.out.println(adaName);
                        adaNameCell = adaNameCell.split(" ")[0];
                        System.out.println("This is Ethereum");
                        //System.out.println(adaNameCell);
                    }
                    else{
                        System.out.println("This is not Ethereum");
                    }
                    
                    adaTempPrice = row.select("td:nth-of-type(4)").text();
                    //System.out.println(adaTempPrice);
                    
                    adaTempRank = row.select("td:nth-of-type(2)").text();
                    //System.out.println(adaTempRank);
                    
                    adaTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    //System.out.println(adaTempMC);
                    
                    adaTempCS = row.select("td:nth-of-type(9)").text();
                    //System.out.println(adaTempCS);
                    
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
                        //System.out.println(solName);
                        solTicker = solRow[2];
                        //System.out.println(solTicker);
                        solName = solName + " " + solTicker;
                        //System.out.println(solName);
                        solNameCell = solNameCell.split(" ")[0];
                        System.out.println("This is Solana");
                        //System.out.println(solNameCell);
                    }
                    else{
                        System.out.println("This is not Solana");
                    }
                    
                    solTempPrice = row.select("td:nth-of-type(4)").text();
                    //System.out.println(solTempPrice);
                    
                    solTempRank = row.select("td:nth-of-type(2)").text();
                    //System.out.println(solTempRank);
                    
                    solTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    //System.out.println(solTempMC);
                    
                    solTempCS = row.select("td:nth-of-type(9)").text();
                    //System.out.println(solTempCS);
                    
                }
                if(solNameCell.contains("Solana")){
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static void webScrapeXRP() {
        final String url = "https://coinmarketcap.com/";

        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    xrpNameCell = row.select("td:nth-of-type(3)").text(); //Gets data from the Name cell of the given row
                    if (xrpNameCell.contains("XRP"))
                    {
                        xrpRow = xrpNameCell.split(" ");
                        //System.out.println(xrpNameCell);
                        xrpName = xrpRow[0];
                        //System.out.println(xrpName);
                        xrpTicker = xrpRow[2];
                        //System.out.println(xrpTicker);
                        xrpName = xrpName + " " + xrpTicker;
                        //System.out.println(xrpName);
                        xrpNameCell = xrpNameCell.split(" ")[0];
                        System.out.println("This is XRP");
                        //System.out.println(xrpNameCell);
                    }
                    else{
                        System.out.println("This is not XRP");
                    }
                    
                    xrpTempPrice = row.select("td:nth-of-type(4)").text();
                    //System.out.println(xrpTempPrice);
                    
                    xrpTempRank = row.select("td:nth-of-type(2)").text();
                    //System.out.println(xrpTempRank);
                    
                    xrpTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    //System.out.println(xrpTempMC);
                    
                    xrpTempCS = row.select("td:nth-of-type(9)").text();
                    //System.out.println(xrpTempCS);
                    
                }
                if(xrpNameCell.contains("XRP")){
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static void webScrapeDOGE() {
        final String url = "https://coinmarketcap.com/";
        try {
            final Document document = Jsoup.connect(url).userAgent("Mozilla/17.0").timeout(10000).get();

            for (Element row : document.select(
                    "table.h7vnx2-2.czTsgW.cmc-table tr")) {
                if (row.select("td:nth-of-type(3)").text().equals("")) {
                    continue;
                } else {
                    dogeNameCell = row.select("td:nth-of-type(3)").text(); //Gets data from the Name cell of the given row
                    if (dogeNameCell.contains("Dogecoin"))
                    {
                        dogeRow = dogeNameCell.split(" ");
                        //System.out.println(dogeNameCell);
                        dogeName = dogeRow[0];
                        System.out.println(dogeName);
                        //dogeTicker = dogeRow[0];
                        //System.out.println(dogeTicker);
                        //dogeName = dogeName;// + " " + dogeTicker;
                        System.out.println(dogeName);
                        //dogeNameCell = dogeNameCell.split(" ")[0];
                        System.out.println("This is DOGE");
                        System.out.println(dogeNameCell);
                    }
                    else{
                        System.out.println("This is not Dogecoin");
                    }
                    
                    dogeTempPrice = row.select("td:nth-of-type(4)").text();
                    System.out.println(dogeTempPrice);
                    
                    dogeTempRank = row.select("td:nth-of-type(2)").text();
                    System.out.println(dogeTempRank);
                    
                    dogeTempMC = row.select(".ieFnWP.sc-1ow4cwt-1").text();
                    System.out.println(dogeTempMC);
                    
                    dogeTempCS = row.select("td:nth-of-type(9)").text();
                    System.out.println(dogeTempCS);
                    
                }
                if(dogeNameCell.contains("Dogecoin")){
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
