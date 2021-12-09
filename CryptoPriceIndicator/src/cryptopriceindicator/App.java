/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptopriceindicator;

import static cryptopriceindicator.CryptoPriceIndicator.webScrape4thCoin;
import static cryptopriceindicator.CryptoPriceIndicator.webScrapeADA;
import static cryptopriceindicator.CryptoPriceIndicator.webScrapeBTC;
import static cryptopriceindicator.CryptoPriceIndicator.webScrapeETH;
import javax.swing.UIManager;

/**
 *
 * @author Anuk
 */
public class App {
    
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
    
}
