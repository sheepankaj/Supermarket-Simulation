package simulator.entity;

/**
 * @author Juliyanage Silva 18059546 
 * This is the trolley for the customer
 */
public class Trolley {
    private int productCount;
    
    public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public Trolley(int productCount)
    {
    	this.productCount = productCount;
    }
}
