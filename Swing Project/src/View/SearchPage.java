/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author nemsi
 */
public class SearchPage extends JFrame{
    
    JButton btnBestCustomer,btnSearchCustomer,btnSearchOrder,btnExit,btnhomePage;
    JPanel titlePanel;
    JLabel lblTitle;
    
    
    public SearchPage(){
        
        setSize(600,500);
        setTitle("Search Page");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/2.jpg")));
        setLayout(null);
        setVisible(true);
        
        titlePanel=new JPanel();
        titlePanel.setBackground(Color.LIGHT_GRAY);
        titlePanel.setLayout(null);
        titlePanel.setBounds(0,0,600,100);
        
        lblTitle=new JLabel("Search Page");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Tahoma",1,36));
        lblTitle.setBounds(190,0,600,100);
        
        titlePanel.add(lblTitle);
        
        btnBestCustomer=new JButton("Best Customer");
        btnBestCustomer.setForeground(Color.black);
        btnBestCustomer.setFont(new Font("", 1,20));
        btnBestCustomer.setBackground(Color.yellow);
        btnBestCustomer.setBounds(175,130,250,60);
        btnBestCustomer.setFocusable(false);
        btnBestCustomer.addActionListener(evt ->{
            new BestCustomer().setVisible(true);
            setVisible(false);
        });
        
        btnSearchCustomer=new JButton("Search Customer");
        btnSearchCustomer.setForeground(Color.black);
        btnSearchCustomer.setFont(new Font("", 1,20));
        btnSearchCustomer.setBackground(Color.yellow);
        btnSearchCustomer.setBounds(175,210,250,60);
        btnSearchCustomer.setFocusable(false);
        btnSearchCustomer.addActionListener(evt ->{
            new SearchCustomer().setVisible(true);
            setVisible(false);
            
        });
        
        btnSearchOrder=new JButton("Search Order");
        btnSearchOrder.setForeground(Color.black);
        btnSearchOrder.setFont(new Font("", 1,20));
        btnSearchOrder.setBackground(Color.yellow);
        btnSearchOrder.setBounds(175,290,250,60);
        btnSearchOrder.setFocusable(false);
        btnSearchOrder.addActionListener(evt ->{
            new SearchOrder().setVisible(true);
            setVisible(false);
        });
        
        btnExit=new JButton("Back");
        btnExit.setForeground(Color.black);
        btnExit.setFont(new Font("", 1,20));
        btnExit.setBackground(Color.green);
        btnExit.setBounds(450,400,100,40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{
            new HomePage().setVisible(true);
            setVisible(false);
            
        });
        
        /*
        btnhomePage=new JButton("Home");
        btnhomePage.setForeground(Color.black);
        btnhomePage.setFont(new Font("", 1,30));
        btnhomePage.setBackground(Color.red);
        btnhomePage.setBounds(420,570,150,60);
        btnhomePage.setFocusable(false);
        btnhomePage.addActionListener(evt ->{
            
        });
        
        */
        
        
        
        
        add(btnBestCustomer);
        add(btnSearchCustomer);
        add(btnSearchOrder);
        add(btnExit);
        //add(btnhomePage);
 
        add(titlePanel);
        
        
    
    
    
    }
    
}
