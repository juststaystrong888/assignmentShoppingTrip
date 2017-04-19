//import ArrayList and Arrays libraries
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Shop {
	//private fields of class Shop
	private String name;
	private ArrayList<Product> products;
	private ArrayList<GoldCoin> coinBox;
	private TreeMap<String,Integer> customerTotalSpend;
	
	
	public Shop(String name, int numberOfCoins){//Constructor Shop with two parameters:name and numberOfCoins
		this.name=name;
		this.products = new ArrayList<Product>();//initialize ArrayList products
		this.coinBox = new ArrayList<GoldCoin>();//initialize ArrayList coinBox
		this.customerTotalSpend = new TreeMap<String, Integer>();
		
		addGoldCoin(numberOfCoins);//add given number of coins to the coin box
	}
	public void addProduct(Product product){//method adds product to shop list
		products.add(product);
	}
	public void removeProduct(Product product){//method removes product from the shop list
		products.remove(product);
		
	}
	
	public Product searchProduct(String name){//method searches product's name in the shop list
		for(Product product:products){//through all products
			if((product.getName().equals(name)))//if there is a match with the given name
				return product;//then returns product
			
		}
		return null;//returns null
	}
	
	public void addGoldCoin(int coins){//method add given amount of coins to the coin box
		for(int i=0;i<coins;i++){
		coinBox.add(new GoldCoin());
		}
		}
	
	
	public String getShopName(){//method returns sop's name
		return name;
	}
	public int getNumberOfGoldCoins(){//method returns coin box capacity
		return coinBox.size();
	}
	
	public void updateTotalSpend(Customer customer, int coins){//method update total spend coins of the customer by adding name and spend coins
		customerTotalSpend.put(customer.getName(),coins);
		
	}
	
	public void shopList(){//method prints shop list
	System.out.println("Shop"+Arrays.toString(products.toArray()));
	
}
	
	public String  toString(){//method returns statements of shop's name, number of coins in the coin box and shop list
		//System.out.println(getClass()+Arrays.toString(products.toArray()));
		return "Shop: "+getShopName()+". The number of gold coins in the coin box: "+getNumberOfGoldCoins()+". Shop"+Arrays.toString(products.toArray());
	}
	
}
