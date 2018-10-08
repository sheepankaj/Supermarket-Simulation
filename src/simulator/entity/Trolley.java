package simulator.entity;

/**
 * Created by Shamitha on 15-Sep-18.
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
