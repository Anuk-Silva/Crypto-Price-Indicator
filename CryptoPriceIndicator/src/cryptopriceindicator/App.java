/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptopriceindicator;

import static cryptopriceindicator.TopTenCrypto.webScrape4thCoin;
import static cryptopriceindicator.TopTenCrypto.webScrapeADA;
import static cryptopriceindicator.TopTenCrypto.webScrapeBTC;
import static cryptopriceindicator.TopTenCrypto.webScrapeETH;
import javax.swing.UIManager;

/**
 *
 * @author Anuk
 */
public class App {
    
    public static void main(String[] args) throws Exception{
        new MenuWindow();
        // TODO code application logic here
        TopTenCrypto.webScrapeBTC();
        TopTenCrypto.webScrapeETH();
        TopTenCrypto.webScrapeADA();
        TopTenCrypto.webScrape4thCoin();
        PopularCrypto.webScrapeBTC();
        PopularCrypto.webScrapeETH();
        PopularCrypto.webScrapeADA();
        PopularCrypto.webScrapeSOL();
        
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        //String str = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";

        
        UIManager.setLookAndFeel(str);
        //new TopTenCrypto();
    }
    
}
