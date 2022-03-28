package co1105.cw2.aam65;

public class Swim extends Activity{
    private int poolSize;
    private int numLengths;

    /**
     * Run
     * @param psize - size of the pool used (in metres). Must be greater than 0m and no more than 100m
     * @param num - number of lengths that are swim. Must be greater than 0 and no more than 1000
     * @param t - the time taken (in seconds) Must be greater than 0s
     * @return public
     * @throws InvalidActivityException - if the Swim parameters are not valid
     */
    public Swim(int psize, int num, int t) throws InvalidActivityException {
        super(t);
        poolSize=psize;
        numLengths=num;
        effort=(getDistance()*20)/(double)t;
        if (!((0<numLengths)&&(numLengths<1000))) throw new InvalidActivityException("Number of lengths must be between 1 and 1000");
        else if (!((0<poolSize)&&(poolSize<100))) throw new InvalidActivityException("Pool size must be between 1m and 100m");
        else if (!((getDistance()/t)<4)) throw new InvalidActivityException("Recorded time and distance is not possible");
    }

    /**
     * Get the distance of the activity
     * @return the distance covered in the swim (in metres)
     */
    public int getDistance(){
        return poolSize*numLengths;
    }

    @Override
    /**
     * String representation of a Swim.
     * @return a String representation of the activity
     */
    public String toString(){
        return String.format("S%02d: effort score %#4.1f (%d x %02dm in %#4.1fminutes)", getID(),effort,numLengths,poolSize,(float)getTime()/60);
    }

    @Override
    /**
     * hashCode should be based on the distance and time attributes
     * @return a hashcode
     */
    public int hashCode(){
        int result = poolSize;
        result = 7 * result + numLengths;
        result = 13 * result + getTime();
        return result;
    }

    @Override
    /**
     * equals should be based on the distance and time attributes of the 2 runs.
     * @return a boolean value
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Swim other = (Swim) obj;
        return numLengths == other.numLengths && poolSize == other.poolSize && time == other.time;
    }


}