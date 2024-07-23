/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import Model.Customer;
/**
 *
 * @author nemsi
 */
public class CustomerList{

	private Node front;

	class Node{

		Node next;
		private Customer data;

		Node(Customer data){
			this.data=data;
		}
	}
	
	private boolean isEmpty(){
		return front==null;
	}

	public void add(Customer customer){
		Node n1=new Node(customer);
		if(isEmpty()){
			front=n1;
			return;
		}
		Node current=front;

			while (current.next!=null) {
				current=current.next;
			}
			current.next=n1;

		}
		

	public void add(int index,Customer data){
		
		if(index>=0 && index<=size()){
			Node n1=new Node(data);
			if(isEmpty()){
				n1.next=front;
				front=n1;
				return;
			}
			Node current=front;
			Node previous=current;
			int count=0;
			while (count<index) {
				previous=current;
				current=current.next;	
			}
			previous.next=n1;
			n1.next=current;
			
		}
	}
	
	public int size(){
		int count=0;
		Node temp=front;
		while (temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;

	}
	
	public Customer get(int index){
		if(index>=0 && index<=size()){
				if (index==0) {
					return front.data;
				}
		Node current=front;
		int count=0;
		while (count<index) {
			current=current.next;
			count++;	
		}
			return current.data;
		}
			return null;
	}
	
	
	
	public void clear(){
		front=null;
	}
	
	public void printList(){
		Node current=front;
		System.out.print("[");
		while (current!=null) {
			System.out.print(current.data.getCustomerDetalil());
			
		}
		System.out.println(isEmpty() ? "Empty]" : "\b\b]");
	}
	
	public int search(Customer data){
		Node current=front;
		int index=0;

		while (current!=null) {
			if (current.data==data) {
				return index;
			}
			index++;
			current=current.next;
		}
		return -1;
	}
	public boolean contains(Customer data){
			return search(data)!=-1;
	}
	
	public Customer peek(){
		if(isEmpty()){
			return null;
		}
		return front.data;
	}
	
	public Customer[] toArray(){
		Customer [] array=new Customer[size()];
		Node current=front;
		int i=0;

		while (current!=null) {
			array[i++]=current.data;
			current=current.next;
		}

		return array;
		
	}
	
	public int indexOf(Customer data){
		Node current=front;
		int index=0;

		while (current.data==data) {
			return index;
		}
		index++;
		current=current.next;

		return -1;
		
	}
	



}
	



