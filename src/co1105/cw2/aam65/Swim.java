package co1105.cw2.aam65;

public class Swim extends Activity{
    private int poolSize;
    private int numLengths;

    public Swim(int psize, int num, int t) throws InvalidActivityException {
        super(t);
        poolSize=psize;
        numLengths=num;
        effort=(getDistance()*20)/(double)t;
        if ((numLengths<0)&&(numLengths>1000)) throw new InvalidActivityException("Number of lengths must be between 1 and 1000");
        else if ((poolSize<0)&&(poolSize>100)) throw new InvalidActivityException("Pool size must be between 1m and 100m");
        else if (!((getDistance()/t)<4)) throw new InvalidActivityException("Recorded time and distance is not possible");
    }

    public int getDistance(){
        return poolSize*numLengths;
    }

    @Override
    public String toString(){
        return String.format("S%02d: effort score %#4.1f (%d x %dm in %#4.1fminutes)", getID(),effort,numLengths,poolSize,(float)getTime()/60);
    }

    @Override
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

    @Override
    public int hashCode(){
        int result = poolSize;
        result = 7 * result + numLengths;
        result = 13 * result + getTime();
        return result;
    }
}