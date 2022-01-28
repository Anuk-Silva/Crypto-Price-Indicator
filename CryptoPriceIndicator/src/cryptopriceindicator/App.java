/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptopriceindicator;

import javax.swing.UIManager;
import static cryptopriceindicator.TopTenCrypto.webScrapeFirstCoin;
import static cryptopriceindicator.TopTenCrypto.webScrapeSecondCoin;
import static cryptopriceindicator.TopTenCrypto.webScrapeThirdCoin;
import static cryptopriceindicator.TopTenCrypto.webScrapeFourthCoin;

/**
 *
 * @author Anuk
 */
public class App {
    
    public static void main(String[] args) throws Exception{
        new MenuWindow();
        // TODO code application logic here
        TopTenCrypto.webScrapeFirstCoin();
        TopTenCrypto.webScrapeSecondCoin();
        TopTenCrypto.webScrapeThirdCoin();
        TopTenCrypto.webScrapeFourthCoin();
        PopularCrypto.webScrapeBTC();
        PopularCrypto.webScrapeETH();
        PopularCrypto.webScrapeBNB();
        PopularCrypto.webScrapeADA();
        PopularCrypto.webScrapeSOL();
        
        String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        //String str = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";

        
        UIManager.setLookAndFeel(str);
        //new TopTenCrypto();
    }
    
}
