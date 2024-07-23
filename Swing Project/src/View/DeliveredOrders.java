/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nemsi
 */
public class DeliveredOrders extends JFrame{
    
    JPanel titlePanel,tblPanel;
    JLabel lblTitle;
    JButton btnBack;
    DefaultTableModel dtm;
    JTable tblCusDetails;
    
    
    public DeliveredOrders(){
        
        setSize(800,700);
        setTitle("Delivered Orders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/2.jpg")));
        setLayout(null);
        setVisible(true);
        
        titlePanel=new JPanel();
        titlePanel=new JPanel();
        titlePanel.setBackground(Color.LIGHT_GRAY);
        titlePanel.setLayout(null);
        titlePanel.setBounds(0,0,800,100);

        lblTitle=new JLabel("Delivered Orders");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Tahoma",1,36));
        lblTitle.setBounds(250,0,800,100);
        
        titlePanel.add(lblTitle);
        
        add(titlePanel);
        
        tblPanel=new JPanel();
        tblPanel.setLayout(null);
       
        String [] columnName={"Order ID","Customer ID","Name","Order QTY","Total"};
        dtm=new DefaultTableModel(columnName,0);
        
        tblCusDetails=new JTable(dtm);
        
        JScrollPane tablePane=new JScrollPane(tblCusDetails);
        tablePane.setBounds(50,30,600,450);
        tblPanel.add(tablePane);
        tblPanel.setBounds(50,100,800,600);
        
        for(int i=0; i<OrderController.size(); i++){
            
            if(OrderController.get(i).getOrderStatus()==1){
                Object [] rowData={
                    OrderController.get(i).getOrderId(),
                    OrderController.get(i).getPhoneNumber(),
                    OrderController.get(i).getCustomerName(),
                    OrderController.get(i).getQuantity(),
                    OrderController.get(i).getTotal(),   
                };
                dtm.addRow(rowData);
            }
        }
    
        add(tblPanel);
        
        btnBack=new JButton("Back");
        btnBack.setFont(new Font("",1,20));
        btnBack.setBackground(Color.GREEN);
        btnBack.setBounds(600,500,100,40);
        btnBack.setFocusable(false);
        btnBack.addActionListener(evt ->{
            new ViewPage().setVisible(true);
            setVisible(false);
        
        });
        tblPanel.add(btnBack);
    
    
    
    
    
    }
    
    
}
