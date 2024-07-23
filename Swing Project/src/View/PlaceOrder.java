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
//import Controller.OrderController;
//import Model.OrderDetails;
//import DB.OrderList;
import Controller.OrderController;
import static Controller.OrderController.list;
import Model.Customer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class PlaceOrder extends JFrame implements KeyListener{

    JLabel lblTitle,lblOrderId,lblCustomerId,lblName,lblQty,lblTotal,lblStatus,lblTotalValue,lblStName,lblIdAlert,msg;
    JButton BtnPlaceOrder,BtnHomePage,BtnExit,BtnAdd;
    JTextField txtOrderId,txtCustomerId,txtName,txtQty;
    JPanel titlePanel;
    
    
    private int total;
    private String name="";

    public PlaceOrder(){

        setSize(1000,700);
        setTitle("Burger Shop");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        titlePanel=new JPanel();
        titlePanel.setBackground(Color.LIGHT_GRAY);
        titlePanel.setLayout(null);
        titlePanel.setBounds(0,0,1000,100);


        lblTitle=new JLabel("Place Order");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Tahoma",1,36));
        lblTitle.setBounds(400,0,700,100);

        titlePanel.add(lblTitle);

        add(titlePanel);

        lblOrderId=new JLabel("Order ID : ");
        lblOrderId.setFont(new Font("",1,20));
        lblOrderId.setBounds(80,170,200,40);
        add(lblOrderId);

        txtOrderId=new JTextField();
        txtOrderId.setFont(new Font("",1,20));
        txtOrderId.setEditable(false);
        txtOrderId.setBounds(300,170,200,40);
        txtOrderId.setText(OrderController.generateOrderId());
        add(txtOrderId);

        lblCustomerId=new JLabel("Customer ID : ");
        lblCustomerId.setFont(new Font("",1,20));
        lblCustomerId.setBounds(80,250,200,40);
        add(lblCustomerId);

        txtCustomerId=new JTextField();
        txtCustomerId.setFont(new Font("",1,20));
        txtCustomerId.setBounds(300,250,200,40);
        txtCustomerId.addKeyListener(this);
        txtCustomerId.addActionListener(evt ->{
        
            boolean isExist=false;
			 
		for (int i = 0; i <list.size(); i++){
			if(list.get(i).getPhoneNumber().equals(txtCustomerId.getText())){
                            name=list.get(i).getCustomerName();
                            isExist=true;
                            break;		
			} 
		}
			 
		if(isExist){	
                    txtName.setText(name);
                    txtName.setEditable(false);
		}else{
                    txtName.setText(null);
                    txtName.setEditable(true);
                    
		}

        });
        add(txtCustomerId);
        
        lblIdAlert=new JLabel();
        lblIdAlert.setFont(new Font("",1,15));
        lblIdAlert.setForeground(Color.red);
        lblIdAlert.setBounds(500,250,50,40);
        add(lblIdAlert);

        lblName=new JLabel("Name : ");
        lblName.setFont(new Font("",1,20));
        lblName.setBounds(80,330,200,40);
        add(lblName);

        txtName=new JTextField();
        txtName.setFont(new Font("",1,20));
        txtName.setBounds(300,330,200,40);
        add(txtName);

        lblQty=new JLabel("QTY : ");
        lblQty.setFont(new Font("",1,20));
        lblQty.setBounds(80,410,200,40);
        add(lblQty);

        txtQty=new JTextField();
        txtQty.setFont(new Font("",1,20));
        txtQty.setBounds(300,410,200,40);
        txtQty.addKeyListener(this);
        add(txtQty);
        
        lblStatus=new JLabel("Order Status  : ");
        lblStatus.setFont(new Font("",1,20));
        lblStatus.setBounds(80,490,200,40);
        add(lblStatus);
        
        lblStName=new JLabel("Preparing");
        lblStName.setForeground(Color.green);
        lblStName.setFont(new Font("",1,20));
        lblStName.setBounds(300,490,200,40);
        add(lblStName);
        
        msg=new JLabel();
        msg.setForeground(Color.red);
        msg.setFont(new Font("Tahoma",1,17));
        msg.setBounds(520,250,200,40);
        add(msg);


        BtnPlaceOrder=new JButton("Place Order");
        BtnPlaceOrder.setFont(new Font("",1,20));
        BtnPlaceOrder.setBackground(Color.GREEN);
        BtnPlaceOrder.setBounds(690,200,200,40);
        BtnPlaceOrder.setFocusable(false);
        BtnPlaceOrder.addActionListener(evt ->{
           
            Customer customer=new Customer(
                    
                txtOrderId.getText(),
                txtCustomerId.getText(),
                txtName.getText(),
                Integer.parseInt(txtQty.getText()),
                total,    
                0
            );
            
        int result= JOptionPane.showConfirmDialog(null,"Do you want proceed this order?","Confirmation",JOptionPane.YES_NO_OPTION);
            
            if(result==JOptionPane.YES_OPTION){
               OrderController.add(customer);
               JOptionPane.showMessageDialog(null,"Order Place Successfully..!","Alert",JOptionPane.INFORMATION_MESSAGE);
            
               System.out.println("Order Placed");
               
               txtOrderId.setText(OrderController.generateOrderId());
               txtCustomerId.setText(null);
               txtName.setText(null);
               txtQty.setText(null);
               lblTotalValue.setText(null);
               
               System.out.println(customer.toString());
               
            }else{
               JOptionPane.showMessageDialog(null, "Cancel","Alert",JOptionPane.ERROR_MESSAGE);
            }
   
        });
        
        add(BtnPlaceOrder);

        BtnHomePage=new JButton("Home Page");
        BtnHomePage.setFont(new Font("",1,20));
        BtnHomePage.setBackground(Color.YELLOW);
        BtnHomePage.setBounds(690,270,200,40);
        BtnHomePage.setFocusable(false);
        BtnHomePage.addActionListener(evt ->{
           new HomePage().setVisible(true);
           setVisible(false);
        });
        add(BtnHomePage);

        BtnExit=new JButton("Exit");
        BtnExit.setFont(new Font("",1,20));
        BtnExit.setBackground(Color.YELLOW);
        BtnExit.setBounds(690,340,200,40);
        BtnExit.setFocusable(false);
        BtnExit.addActionListener(evt ->{
            System.exit(0);
        });
        add(BtnExit);
        
        lblTotal=new JLabel("Net Total : ");
        lblTotal.setFont(new Font("",1,20));
        lblTotal.setBounds(690,450,200,40);
        add(lblTotal);
        
        lblTotalValue=new JLabel();
        lblTotalValue.setFont(new Font("",1,20));
        lblTotalValue.setForeground(Color.red);
        lblTotalValue.setBounds(770,450,200,40);
        add(lblTotalValue);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/2.jpg")));


        


    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
     
        if(OrderController.isValidPhoneNumber(txtCustomerId.getText())){
          
            msg.setText(null);
            txtName.setEditable(true);
            txtQty.setEditable(true);
            
            total=Integer.parseInt(txtQty.getText());
            total*=OrderController.burgerPrice;
               
            if(txtQty.getText().equals(null)){
                lblTotalValue.setText(null);
            }else{
               lblTotalValue.setText("    "+total+".00");
            }

        }else{
            msg.setText("INVALID NUMBER");
            txtName.setEditable(false);
            txtQty.setEditable(false);
        }
    }
  

}