
public class GoldCoin {
	//private fields of class GoldCoin
	private int coinNumber;
	private static int numberOfCoins;
	
	public GoldCoin(){
		this.coinNumber=numberOfCoins++;//unique number
		
	}
	
	public int readCoin(){//method returns coin number
		return coinNumber;
	}

}
