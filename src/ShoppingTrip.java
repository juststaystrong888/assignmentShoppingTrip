//import ArrayList, Scanner libraries
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingTrip {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
//Create three products objects:Diamond,Crown Jewels with given prices
		Product product1 = new Product("Diamond",40);
		Product product2 = new Product("Crown Jewels",100);
		Product product3 = new Product("Silver Locket",60);
		
		Shop shop = new Shop("Hidden Hideaway",125);//create object Hidden Hideaway shop with 125 coins in coin box
		shop.addProduct(product1);//store product1,2,3 in shop
		shop.addProduct(product2);
		shop.addProduct(product3);
        
		System.out.println(shop.toString());//Print the shop's details to the terminal, including its name, the number of gold coins in the coin box and its products

		Customer customer = new Customer("BlackBeard",100);
		
	    System.out.println("Customer "+customer.getName()+", total amount of coins in your purse: "+customer.totalAmountOfCoins());
	    
	    System.out.println("Hello, Welcome to our shop!");//print introductory message to the user 
	    String speach;//declare local String variable speech
	   do{ //do following instructions until speech is not exit
		   shop.shopList();//present the products in the shop, the shopping basket and print the total number of coins in the customer's wallet to the user
	       customer.basket();
	       System.out.println("Total amount of coins in your purse: "+customer.totalAmountOfCoins());
	       System.out.println("How we can help you?");//ask about further actions
	       speach= scan.nextLine();//user's input
	       if(speach.equals("exit")){
	       		break;//break loop when speech is exit
	       }
	       if(speach.equals("add product")){//if speech is "add product"
	    	   System.out.println("what product from the shop list would you like to add?");//ask user about chosen product
	    	   String product = scan.nextLine();//user's input
	    	  
	    	   if(shop.searchProduct(product)!=null){//if there is such product then
	    		   customer.addToShoppingBasket(shop.searchProduct(product));//add this product to customer's shopping basket
	    		   shop.removeProduct(shop.searchProduct(product));//remove this product from the shop
	    	   }
	    	   else{//otherwise
	    		   System.out.println("There is no such product in our shop list. Please choose only products from the shop list!");
	    	   }
	    	   
	       }
	       if(speach.equals("remove product")){//if speech is "remove product" then
	    	   System.out.println("what product from the shopping basket list would you like to remove?");
	    	   String item=scan.nextLine();//user's input
	    	 
	    	   if(customer.searchShoppingBasket(item)!=null){//if there is such product in the shopping basket then
	    		   shop.addProduct(customer.searchShoppingBasket(item));//return product to shop list
	    		   customer.removeFromShoppingBasket(item);//remove this product from the shopping basket
	    	   }
	    	   else {//otherwise
	    		   System.out.println("There is no such product in your shopping basket");
	    	   }
	    	   
	       }
	       if(speach.equals("purchase")){//if speech is "purchase" 
	    		   
	    	  if(customer.purchaseProducts(customer,shop)==false){//if total cost is higher than money in the customer's purse then
	    	
	    		  System.out.println("You are out of coins.");
	    	  }
	    	 
	       }
	   }
	   while(!speach.equals("exit"));//while loop until speech is "exit"
	   
	       
	  
	
	}
}
