
public class Product {
	//private fields of Product class
	private String name;
	private int price;
	
	public Product(String name, int price){//Product constructor with name and price
		this.name=name;
		this.price=price;
		
		}
	
	public String getName(){//method return name of the product 
		return name;
	}
	public int getPrice(){//name returns the price of the product
		return price;
		
	}
	
	public String toString(){//returns statement of product's name = price
		return getName()+"="+getPrice();
	}
	

}
