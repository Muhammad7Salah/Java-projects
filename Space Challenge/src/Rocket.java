
public class Rocket implements Spaceship {

	int cost;
	double weight;
	static double weightLimit;
	static double initWeight;
	
	@Override
	public boolean launch() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean land() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canCarry(Item item) {
		// TODO Auto-generated method stub
		
		if(this.weight+item.weight>weightLimit)
			return false;
		
					
		
		return true;
	}

	@Override
	public double carry(Item item) {
		// TODO Auto-generated method stub
		return item.weight;
	}

}
