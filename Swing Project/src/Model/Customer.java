/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nemsi
 */
public class Customer{
	
	  private String orderId;
	  private String phoneNumber;
	  private String customerName;
	  private int quantity;
	  private double total;
	  private int orderStatus;
	
	public Customer(){}
	
	public Customer(String orderId,String phoneNumber,String customerName,int quantity,double total,int orderStatus){
	
		this.orderId=orderId;
		this.phoneNumber=phoneNumber;
		this.customerName=customerName;
		this.quantity=quantity;
		this.total=total;
		this.orderStatus=orderStatus;
	
	
	}
	
	public String getOrderId(){
		return orderId;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getCustomerName(){
		return customerName;
	}

	public int getQuantity(){
		return quantity;
	}
	
	public double getTotal(){
		return total;
	}
	
	public int getOrderStatus(){
		return orderStatus;
	}
	
	public void setOrderId(String orderId){
		this.orderId=orderId;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	
	public void setCustomerName(String customerName){
		this.customerName=customerName;
	}

	public void setQuantity(int quantity){
		this.quantity=quantity;
	}

	public void setTotal(double total){
		this.total=total;
	}

	public void setOrderStatus(int orderStatus){
		this.orderStatus=orderStatus;
	}

	public String getCustomerDetalil(){
		return "{" + orderId +" - " + customerName + " - " + phoneNumber + " - " + quantity + " - " + total + "}";
	}

}




