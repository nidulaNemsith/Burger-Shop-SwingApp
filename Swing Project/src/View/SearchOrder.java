/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import Model.Customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author nemsi
 */
public class SearchOrder extends JFrame implements KeyListener{
    
    JPanel titlePanel;
    JLabel lblTitle,lblOrderId,lblCustomerId,lblName,lblQty,lblTotal,lblStatus,msg;
    JTextField txtOrderId,txtCustomerId,txtName,txtQty,txtTotal,txtStatus;
    JButton btnExit;
    
    String [] dataArray;
    
    OrderController obj=new OrderController();
    
    
    
    public SearchOrder(){
    
        setSize(800,700);
        setTitle("Search Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/2.jpg")));
        setLayout(null);
        setVisible(true);
        
        
        titlePanel=new JPanel();
        titlePanel=new JPanel();
        titlePanel.setBackground(Color.LIGHT_GRAY);
        titlePanel.setLayout(null);
        titlePanel.setBounds(0,0,800,100);

        lblTitle=new JLabel("Search Order");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Tahoma",1,36));
        lblTitle.setBounds(250,0,800,100);
        
        titlePanel.add(lblTitle);
        
        lblOrderId=new JLabel("Order ID : ");
        lblOrderId.setFont(new Font("",1,20));
        lblOrderId.setBounds(80,170,200,40);
        add(lblOrderId);

        txtOrderId=new JTextField();
        txtOrderId.setFont(new Font("",1,20));
        txtOrderId.setBounds(200,170,200,40);
        txtOrderId.addKeyListener(this);
        add(txtOrderId);
        
        msg=new JLabel();
        msg.setFont(new Font("",3,20));
        msg.setForeground(Color.red);
        msg.setFont(new Font("Tahoma",1,15));
        msg.setBounds(450,170,200,40);
        add(msg);
        
        lblCustomerId=new JLabel("Customer ID : ");
        lblCustomerId.setFont(new Font("",1,20));
        lblCustomerId.setBounds(80,280,200,40);
        add(lblCustomerId);

        txtCustomerId=new JTextField();
        txtCustomerId.setFont(new Font("",1,20));
        txtCustomerId.setBounds(230,280,200,40);
        txtCustomerId.setEditable(false);
        add(txtCustomerId);
        
        lblName=new JLabel("Name : ");
        lblName.setFont(new Font("",1,20));
        lblName.setBounds(80,350,200,40);
        add(lblName);

        txtName=new JTextField();
        txtName.setFont(new Font("",1,20));
        txtName.setBounds(230,350,200,40);
        txtName.setEditable(false);
        add(txtName);
        
        lblQty=new JLabel("QTY : ");
        lblQty.setFont(new Font("",1,20));
        lblQty.setBounds(80,420,200,40);
        add(lblQty);

        txtQty=new JTextField();
        txtQty.setFont(new Font("",1,20));
        txtQty.setBounds(230,420,200,40);
        txtQty.setEditable(false);
        add(txtQty);
        
        lblTotal=new JLabel("Total : ");
        lblTotal.setFont(new Font("",1,20));
        lblTotal.setBounds(80,490,200,40);
        add(lblTotal);

        txtTotal=new JTextField();
        txtTotal.setFont(new Font("",1,20));
        txtTotal.setBounds(230,490,200,40);
        txtTotal.setEditable(false);
        add(txtTotal);
        
        lblStatus=new JLabel("Order Status : ");
        lblStatus.setFont(new Font("",1,20));
        lblStatus.setBounds(80,560,200,40);
        add(lblStatus);

        txtStatus=new JTextField();
        txtStatus.setFont(new Font("",1,20));
        txtStatus.setBounds(230,560,200,40);
        txtStatus.setEditable(false);
        add(txtStatus);
        

        btnExit=new JButton("Back");
        btnExit.setFont(new Font("",1,20));
        btnExit.setBackground(Color.green);
        btnExit.setBounds(600,560,100,40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{
            new SearchPage().setVisible(true);
            setVisible(false);
        });
        add(btnExit);
        
        
        
        
        
        add(titlePanel);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

        String searchValue=txtOrderId.getText();
        Customer search=OrderController.getOrderDetail(searchValue);
            
        
        if(OrderController.isValidId(searchValue)){    
            txtCustomerId.setText(search.getPhoneNumber());
            txtName.setText(search.getCustomerName());
            txtQty.setText(search.getQuantity()+"");
            txtTotal.setText(search.getTotal()+"");
            
            String status="";
            
            if(search.getOrderStatus()==0){
                txtStatus.setText("Preparing");
            }else if(search.getOrderStatus()==1){
                txtStatus.setText("Delivered");
            }else{
                txtStatus.setText("Cancel");
            }
            
            msg.setText(null);
        }else{
            txtCustomerId.setText(null);
            txtName.setText(null);
            txtQty.setText(null);
            txtTotal.setText(null);
            txtStatus.setText(null);
            
            msg.setText("Invalid Order ID");
            
        }

    }
        
}
        

    

