/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptopriceindicator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Anuk
 */
public class MenuWindow extends JFrame implements ActionListener{
    
    private JPanel panel;
    private JButton popularCrypto;
    private JButton topTenCrypto;
    
    private JLabel appTitle;
    
    public MenuWindow(){
        
        panel = new JPanel(new GridBagLayout());
        
        panel.setBackground(Color.LIGHT_GRAY);
        
        this.getContentPane().add(panel, BorderLayout.NORTH);
        
        GridBagConstraints c = new GridBagConstraints();
        
        appTitle = new JLabel("<html><h1><strong><i>Crypto Price Indicator</i></strong></h1><hr></html>");
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 100, 0, 0);
        
        panel.add(appTitle, c);
        
        popularCrypto = new JButton("Popular Crypto");
        //popularCrypto.setMargin( new Insets(0, 10, 10, 10) );
        popularCrypto.setPreferredSize(new Dimension(200, 50));
        popularCrypto.addActionListener(this);
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(20, 120, 0, 150);
        
        panel.add(popularCrypto, c);
        
        topTenCrypto = new JButton("Top Ten Crypto");
        //topTenCrypto.setMargin( new Insets(10, 10, 10, 10) );
        topTenCrypto.setPreferredSize(new Dimension(200, 50));
        topTenCrypto.addActionListener(this);
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(20, 120, 0, 150);
        
        panel.add(topTenCrypto, c);
        
        //setLayout(new GridBagLayout());
        //GridBagConstraints gbc = new GridBagConstraints();
        //gbc.gridwidth = GridBagConstraints.REMAINDER;
        //gbc.anchor = GridBagConstraints.NORTH;
        //gbc.weighty = 1;
        //add(new JLabel("<html><h1><strong><i>Crypto Price Indicator</i></strong></h1><hr></html>"), gbc);
        //gbc.anchor = GridBagConstraints.CENTER;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        //JPanel buttons = new JPanel(new GridBagLayout());
        //buttons.add(popularCrypto, gbc);
        //buttons.add(topTenCrypto, gbc);
        //gbc.weighty = 1;
        //add(buttons, gbc);
        //this.add(buttons);
        
        this.setResizable(false);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Main Menu");
        this.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == popularCrypto){
            JFrame popularCrypto = new PopularCrypto();
        }
        if (e.getSource() == topTenCrypto){
            JFrame topTenCrypto = new TopTenCrypto();
        }
        
    }
    
}
