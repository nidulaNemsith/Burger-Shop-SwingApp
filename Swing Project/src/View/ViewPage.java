/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nemsi
 */
public class ViewPage extends JFrame{
    
    JPanel titlePanel;
    JLabel lblTitle;
    JButton btnPreparing,btnDelivered,btnCancel,btnBack;
    
    public ViewPage(){
        
        setSize(600,500);
        setTitle("View Orders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/2.jpg")));
        setLayout(null);
        setVisible(true);
        
        titlePanel=new JPanel();
        titlePanel=new JPanel();
        titlePanel.setBackground(Color.LIGHT_GRAY);
        titlePanel.setLayout(null);
        titlePanel.setBounds(0,0,600,100);

        lblTitle=new JLabel("View Orders");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Tahoma",1,36));
        lblTitle.setBounds(190,0,600,100);
        
        titlePanel.add(lblTitle);
        
        btnPreparing=new JButton("Preparing Orders");
        btnPreparing.setFont(new Font("",1,20));
        btnPreparing.setBackground(Color.YELLOW);
        btnPreparing.setBounds(175,130,250,60);
        btnPreparing.setFocusable(false);
        btnPreparing.addActionListener(evt ->{
            new PreparingOrders().setVisible(true);
            setVisible(false);
           
        });
        add(btnPreparing);
        
        btnDelivered=new JButton("Delivered Orders");
        btnDelivered.setFont(new Font("",1,20));
        btnDelivered.setBackground(Color.YELLOW);
        btnDelivered.setBounds(175,210,250,60);
        btnDelivered.setFocusable(false);
        btnDelivered.addActionListener(evt ->{
            new DeliveredOrders().setVisible(true);
            setVisible(false);
           
        });
        add(btnDelivered);
        
        btnCancel=new JButton("Cancel Orders");
        btnCancel.setFont(new Font("",1,20));
        btnCancel.setBackground(Color.YELLOW);
        btnCancel.setBounds(175,290,250,60);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(evt ->{
            new CancelOrders().setVisible(true);
            setVisible(false);
           
        });
        add(btnCancel);
        
        btnBack=new JButton("Back");
        btnBack.setFont(new Font("",1,20));
        btnBack.setBackground(Color.GREEN);
        btnBack.setBounds(450,400,100,40);
        btnBack.setFocusable(false);
        btnBack.addActionListener(evt ->{
           new HomePage().setVisible(true);
            setVisible(false);
        });
        add(btnBack);
        
        
        
       add(titlePanel);
    
        
    
    
    
    
    }
    
}
