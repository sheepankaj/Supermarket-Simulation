package simulator.util;

import java.util.Random;

/**
 * @author Pankaj Kumar Shee-18125638 
 * This class is responsible of generating random numbers
 */
public class RandomNumberGenerator
{
    /**
     * This method generates all the random numbers to be generated for the simulator
     * @param min Minimum (inclusive) value
     * @param max Maximum (inclusive) value
     * @return random value inside the range
     */
    public int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    public double getRandomDecimalNumberInRange(double min, double max) {
    	if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextDouble()*(max-min) + min;
		
	}
}
