/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.CustomerList;
import Model.Customer;

/**
 *
 * @author nemsi
 */
public class OrderController {
    
    public static CustomerList list=new CustomerList();
    
    public static double burgerPrice=500;
    
    public static int size(){
	return list.size();
    } 
                              		
    public static Customer get(int index){
	return list.get(index);
    }
    
    public static void add(Customer data){
	list.add(data);
    }
    
    //--------------------Generate ID--------------------------------------- 

    public static String generateOrderId(){
	int id1;
	if (list.size()>0){
		id1=Integer.parseInt(list.get(list.size()-1).getOrderId().split("[O]")[1]);
		id1++;
	}else{
		return "O0001";
	}
		return String.format("O%04d",id1);
    }
    
    public static Customer getOrderDetail(String orderId){
		String line="";
		for (int i = 0; i < list.size() ; i++) {
			if (orderId.equals(list.get(i).getOrderId())) {
                                return list.get(i);
			}
		}		return null;
	}
    
    public static Customer getOrderDetail2(String customerId){
		String line="";
		for (int i = 0; i < list.size() ; i++) {
			if (customerId.equals(list.get(i).getPhoneNumber())) {
                                return list.get(i);
			}
		}		return null;
    }
    
    public static boolean isValidId(String Id){
			
	for (int i = 0; i <list.size(); i++){
		if(list.get(i).getOrderId().equals(Id)){
			return true;
		}else{
                        continue;
		}
	}
	return false;		
    }
    
    public static boolean isValidPhoneNumber(String number){
	if(number.length()==10 && number.charAt(0)=='0'){
	if(number.charAt(1)=='7'||number.charAt(1)=='1' || number.charAt(1)=='2'|| number.charAt(1)=='3'|| number.charAt(1)=='4'|| number.charAt(1)=='5'|| number.charAt(1)=='6') return true;
	if(number.charAt(2)=='0'||number.charAt(2)=='1'|| number.charAt(2)=='2'||number.charAt(2)=='4'||number.charAt(2)=='5'||number.charAt(2)=='6'||number.charAt(2)=='7'||number.charAt(2)=='8') return true;
	}				
            return false;	
    }
    
    public static boolean isExistCustomer(String number){

	for (int i = 0; i <list.size(); i++){
		if(list.get(i).getPhoneNumber().equals(number)){
			return true;
		}else{
			continue;
		}
	}
		
		return false;
    }

    
    
}
