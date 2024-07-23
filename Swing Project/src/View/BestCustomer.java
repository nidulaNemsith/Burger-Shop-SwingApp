/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import java.awt.Color;
import java.awt.FlowLayout;
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
public class BestCustomer extends JFrame{
    
    private double BURGERPRICE=500;
    
    DefaultTableModel dtm;
    JLabel lblTitle;
    JTable tblCusDetails;
    JPanel tblPanel,titlePanel;
    JButton btnBack,btnExit;
    
    
    
    public BestCustomer(){
        
        setSize(800,700);
        setTitle("Best Customer");
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

        lblTitle=new JLabel("Best Customer");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Tahoma",1,36));
        lblTitle.setBounds(250,0,800,100);
        
        titlePanel.add(lblTitle);
        
        add(titlePanel);
        
        //-------------------Remove Duplicate-----------------------------------
	
		String [] tempPhoneNumber=new String[0];
		
		for (int i = 0; i <OrderController.size(); i++){
				boolean isExist=false;
			for (int j = 0; j <tempPhoneNumber.length; j++){
					if(OrderController.get(i).getPhoneNumber().equals(tempPhoneNumber[j])){
						isExist=true;
					}
				}
				if(!isExist){
					String [] tempPhoneNumber_2=new String[tempPhoneNumber.length+1];
					for (int j = 0; j <tempPhoneNumber.length; j++){
						tempPhoneNumber_2[j]=tempPhoneNumber[j];
					}
					tempPhoneNumber_2[tempPhoneNumber_2.length-1]=OrderController.get(i).getPhoneNumber();
					tempPhoneNumber=tempPhoneNumber_2;
	
			}	
		}	
       
        //----------------------Best in Customer--------------------------------

	String [] dupRemovedArray =tempPhoneNumber;	
	double [] tempValue=new double[dupRemovedArray.length];
	int [] tempQty=new int[dupRemovedArray.length];
	String [] name=new String[dupRemovedArray.length];	
	
	for (int i = 0; i <dupRemovedArray.length; i++){
		for (int j = 0; j <OrderController.size(); j++){
			if(OrderController.get(j).getPhoneNumber().equals(dupRemovedArray[i])){
				
					tempQty[i]+=OrderController.get(j).getQuantity();
					tempValue[i]+=OrderController.get(j).getQuantity()*BURGERPRICE;
					name[i]=OrderController.get(j).getCustomerName();
				
			}	
		}	
	}
	
//-----------------------sort(Best Customer)-------------------------


	for (int i =0; i<tempQty.length; i++){
			for (int j = 0; j<tempQty.length-1; j++){
				if(tempQty[j]<tempQty[j+1]){
					
					int temp=tempQty[j];
					tempQty[j]=tempQty[j+1];
					tempQty[j+1]=temp;
					
					String tempId=dupRemovedArray[j];
					dupRemovedArray[j]=dupRemovedArray[j+1];
					dupRemovedArray[j+1]=tempId;
					
					String tempName=name[j];
					name[j]=name[j+1];
					name[j+1]=tempName;
					
					double tempTot=tempValue[j];
					tempValue[j]=tempValue[j+1];
					tempValue[j+1]=tempTot;
			}
		}
	}
        
        
        tblPanel=new JPanel();
        tblPanel.setLayout(null);
       
        String [] columnName={"Customer ID","Name","Total"};
        dtm=new DefaultTableModel(columnName,0);
        
        tblCusDetails=new JTable(dtm);
        
        JScrollPane tablePane=new JScrollPane(tblCusDetails);
        tablePane.setBounds(50,30,600,450);
        tblPanel.add(tablePane);
        tblPanel.setBounds(50,100,800,600);
        
        
        for(int i=0; i<dupRemovedArray.length; i++){
            
            Object [] rowData={dupRemovedArray[i],name[i],tempValue[i]};
            dtm.addRow(rowData);
        }
        
        btnBack=new JButton("Back");
        btnBack.setFont(new Font("",1,20));
        btnBack.setBackground(Color.GREEN);
        btnBack.setBounds(600,500,100,40);
        btnBack.setFocusable(false);
        btnBack.addActionListener(evt ->{
            new SearchPage().setVisible(true);
            setVisible(false);
        
        });
        tblPanel.add(btnBack);
        
        add(tblPanel);
    
    
    
    
    
    
    }
  
}
