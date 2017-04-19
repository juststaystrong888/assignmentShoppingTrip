import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
	//private fields of class Customer
	private String name;
	private ArrayList<Product> shoppingBasket;
	private ArrayList<Product> ownedProducts;
	private ArrayList<GoldCoin> purse;
	private int total_Spend;
	public Customer(String name, int numberOfCoins){//Constructor Customer with two parameters:name and numberOfCoins
		this.name=name;
		
		this.shoppingBasket=new ArrayList<Product>();//initialize ArrayList shoppingBasket
		this.ownedProducts = new ArrayList<Product>();//initialize ArrayList ownedProducts
		this.purse= new ArrayList<GoldCoin>();//initialize ArrayList purse
		
		for(int i=0; i<numberOfCoins;i++){
			purse.add(new GoldCoin());//fill purse by given numberOfCoins
		}
	}

	public void addToShoppingBasket(Product product){//method adds product to the shopping basket
		shoppingBasket.add(product);
	}
	
	public boolean removeFromShoppingBasket(String name){//method removes product from the shopping basket
		for(int i =0; i<shoppingBasket.size();i++){//by searching each product in shopping basket
			if(shoppingBasket.get(i).getName().equals(name)){//if there is a match with the given product's name
		    shoppingBasket.remove(i);//then remove this product
		    return true;//and return true
			}
		}//otherwise return false
		return false;
	}
	
	public Product searchShoppingBasket(String name){//method searches ShoppingBasket
		for(Product product:shoppingBasket){//seearching through each product from shopping basket on a match with name
			if(product.getName().equals(name))//if there is a match
				return product;//then returns product with this name
		}
		return null;//otherwise it returns null
	}
	public void addCoin(GoldCoin coin){//method adds coin to the purse
		purse.add(coin);
		}
	public void addOwnedProduct(Product product){//method adds products to the ownedProducts
		ownedProducts.add(product);
	}
	public void basket(){//method prints products in the shopping basket
	    
		System.out.println("Your shopping basket: "+Arrays.toString(shoppingBasket.toArray()));
		
	}
	
	public boolean purchaseProducts(Customer customer, Shop shop){//method purchase products
		if(total_Spend<=purse.size()){//if spend money are less than or equal to the money from the purse then
			shop.addGoldCoin(spendCoins());//add spend coins to the coin box
		for(int i=0; i<total_Spend;++i){//and remove spend coins from the purse
			purse.remove(purse.size()-1);
		}
		for(Product product:shoppingBasket){//add all products from the shopping basket to the ownedProducts
			ownedProducts.add(product);
		}
		shoppingBasket.clear();//empty shopping basket
		shop.updateTotalSpend(customer, spendCoins());//update customer's total spend coins
		return true;//return true
		}
		//otherwise
		return false;
		
	}
	public String getName(){//method returns customer's name
		return name;
	}
	
	public int spendCoins(){//method counts and returns total spend money
		for(Product product:shoppingBasket){
			this.total_Spend+=product.getPrice();
		}
		return total_Spend;
	}
	public int totalAmountOfCoins(){//returns purse capacity
		return purse.size();
	}

	
}
