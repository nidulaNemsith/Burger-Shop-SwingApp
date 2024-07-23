/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author nemsi
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


//import javafx.scene.paint.Color;


 public class HomePage extends JFrame{

    JPanel panel01,panel02;
    JLabel titleLabel,imgLabel;
    JButton placeOrderBtn,searchBtn,viewOrdersBtn,updateOrderBtn,exitBtn;
    ImageIcon img;

    
    public HomePage(){

        setSize(800,500);
        setTitle("Burger Shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(null);
        setVisible(true);

        panel01=new JPanel();
        panel01.setLayout(null);
        panel01.setBackground(Color.WHITE);
        panel01.setBounds(0,0,400,500);

        titleLabel=new JLabel("Welcome to the Burger Shop");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Tahoma",1,20));
        titleLabel.setBounds(50,30,300,50);
        panel01.add(titleLabel);
        
        //img = new ImageIcon(getClass().getResource("2.jpg"));
	//imgLabel.setIcon(img);
	//imgLabel.setBounds(60, 50, 300, 300);
        //panel01.add(imgLabel);
        
        add(panel01);

        panel02=new JPanel();
        panel02.setLayout(null);
        panel02.setBackground(Color.LIGHT_GRAY);
        panel02.setBounds(400,0,400,500);

        placeOrderBtn=new JButton("Place Order");
        placeOrderBtn.setFont(new Font("",1,20));
        placeOrderBtn.setBackground(Color.YELLOW);
        placeOrderBtn.setBounds(100,90,200,40);
        placeOrderBtn.setFocusable(false);
        placeOrderBtn.addActionListener(evt ->{
            new PlaceOrder().setVisible(true);
            setVisible(false);
        });
        panel02.add(placeOrderBtn);

        searchBtn=new JButton("Search");
        searchBtn.setFont(new Font("",1,20));
        searchBtn.setBackground(Color.YELLOW);
        searchBtn.setBounds(100,140,200,40);
        searchBtn.setFocusable(false);
        searchBtn.addActionListener(evt ->{
            new SearchPage().setVisible(true);
            setVisible(false);
        });
        
        panel02.add(searchBtn);

        viewOrdersBtn=new JButton("View Orders");
        viewOrdersBtn.setFont(new Font("",1,20));
        viewOrdersBtn.setBackground(Color.YELLOW);
        viewOrdersBtn.setBounds(100,190,200,40);
        viewOrdersBtn.setFocusable(false);
        viewOrdersBtn.addActionListener(evt ->{
            new ViewPage().setVisible(true);
            setVisible(false);
        });
        panel02.add(viewOrdersBtn);

        updateOrderBtn=new JButton("Update Orders");
        updateOrderBtn.setFont(new Font("",1,20));
        updateOrderBtn.setBackground(Color.YELLOW);
        updateOrderBtn.setBounds(100,240,200,40);
        updateOrderBtn.setFocusable(false);
        updateOrderBtn.addActionListener(evt ->{
            new UpdateOrder().setVisible(true);
            setVisible(false);
        });
        panel02.add(updateOrderBtn);

        exitBtn=new JButton("Exit");
        exitBtn.setFont(new Font("",1,20));
        exitBtn.setBackground(Color.YELLOW);
        exitBtn.setBounds(200,310,100,40);
        exitBtn.setFocusable(false);
        exitBtn.addActionListener(evt ->{
            System.exit(0);
        });

        panel02.add(exitBtn);

        add(panel02);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/2.jpg")));
        
        
    }
}
