/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import Model.Customer;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nemsi
 */
public class SearchCustomer extends JFrame implements KeyListener{
    
    JPanel titlePanel,titlePanel2,tablePanel;
    JLabel lblTitle,lblCustomerID,lblName,lblTitle2,lblAlert;
    JTextField txtCustomerId,txtName;
    JButton btnBack;
    DefaultTableModel dtm;
    JTable tblCusDetails;
    
    public SearchCustomer(){
        
        setSize(800,700);
        setTitle("Search Customer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/2.jpg")));
        setLayout(null);
        setVisible(true);
        
        titlePanel=new JPanel();
        titlePanel.setBackground(Color.LIGHT_GRAY);
        titlePanel.setLayout(null);
        titlePanel.setBounds(0,0,800,100);

        lblTitle=new JLabel("Search Customer");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Tahoma",1,36));
        lblTitle.setBounds(220,0,800,100);
        
        titlePanel.add(lblTitle);
        
        add(titlePanel);
        
        lblCustomerID=new JLabel("Customer ID :");
        lblCustomerID.setFont(new Font("",1,20));
        lblCustomerID.setBounds(80,90,200,150);
        add(lblCustomerID);
        
        txtCustomerId=new JTextField();
        txtCustomerId.setFont(new Font("",1,20));
        txtCustomerId.setBounds(250,150,200,30);
        txtCustomerId.addKeyListener(this);
        txtCustomerId.addActionListener(evt ->{
         
        });
        
        add(txtCustomerId);
        
        lblAlert=new JLabel();
        lblAlert.setFont(new Font("Tahoma",1,16));
        lblAlert.setBounds(470,90,200,150);
        lblAlert.setForeground(Color.red);
        add(lblAlert);
        
        lblName=new JLabel("Name :");
        lblName.setFont(new Font("",1,20));
        lblName.setBounds(80,150,200,150);
        add(lblName);
        
        txtName=new JTextField();
        txtName.setFont(new Font("",1,20));
        txtName.setBounds(250,210,200,30);
        txtName.setEditable(false);
        txtName.addActionListener(evt ->{
        
        });
        
        add(txtName);
        
        titlePanel2=new JPanel();
        titlePanel2.setBackground(Color.LIGHT_GRAY);
        titlePanel2.setLayout(null);
        titlePanel2.setBounds(0,250,800,80);

        lblTitle2=new JLabel("Order Details");
        lblTitle2.setForeground(Color.BLACK);
        lblTitle2.setFont(new Font("Tahoma",1,36));
        lblTitle2.setBounds(250,0,800,80);
        
        titlePanel2.add(lblTitle2);
        
        add(titlePanel2);
        
        tablePanel=new JPanel();
        tablePanel.setLayout(null);
        String [] columnName={"Order ID","Order QTY","Total"};
        dtm=new DefaultTableModel(columnName,0);
        
        tblCusDetails=new JTable(dtm);
        
        JScrollPane tablePane=new JScrollPane(tblCusDetails);
        tablePane.setBounds(10,10,500,150);
        tablePanel.add(tablePane);
        tablePanel.setBounds(110,350,600,200);
        add(tablePanel);
 
        btnBack=new JButton("Back");
        btnBack.setFont(new Font("",1,20));
        btnBack.setBackground(Color.green);
        btnBack.setBounds(650,600,100,40);
        btnBack.setFocusable(false);
        btnBack.addActionListener(evt ->{
           new SearchPage().setVisible(true);
           setVisible(false);
        });
        add(btnBack);
        
        
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String searchValue=txtCustomerId.getText();
        Customer search=OrderController.getOrderDetail2(searchValue);
        
         if(OrderController.isExistCustomer(txtCustomerId.getText())){
        
                txtName.setText(search.getCustomerName());
            
                for(int i=0; i<OrderController.size(); i++){
                    if(OrderController.get(i).getPhoneNumber().equals(searchValue)){
                    Object [] rowData={OrderController.get(i).getOrderId(),OrderController.get(i).getQuantity(),OrderController.get(i).getTotal()};
                    dtm.addRow(rowData);
                    }
                }
                
                lblAlert.setText("");
        }else{
             
             lblAlert.setText("Invalid ID");
             txtName.setText(null);
             dtm.setRowCount(0);

         }
        
           
    }
    
}
