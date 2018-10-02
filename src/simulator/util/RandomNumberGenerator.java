package simulator.util;

import java.util.Random;

/**
 * Created by Shamitha on 15-Sep-18.
 */
public class RandomNumberGenerator
{
    /**
     * This method generates all the random numbers to be generated for the simulator
     * @param min Minimum (inclusive) value
     * @param max Maximum (inclusive) value
     * @return random value inside the range
     */
    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
