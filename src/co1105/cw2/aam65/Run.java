package co1105.cw2.aam65;

public class Run extends Activity {
    private int distance;

    /**
     * Run
     * @param d - the distance run (in metres) Must be greater than 0m and less than 100000m
     * @param t - the time taken (in seconds) Must be greater than 0s
     * @return public
     * @throws InvalidActivityException - if the parameters mean that a Run cannot be constructed
     */
    public Run(int d, int t) throws InvalidActivityException{
        super(t);
        distance=d;
        effort=(4*distance)/(double)t;

        if (!((d>0)&&(d<100000))) throw new InvalidActivityException("Distance must be between 0m and 100000m");
        else if ((d/t)>20) throw new InvalidActivityException("Recorded time and distance are not plausible");
    }

    /**
     * Get the distance of the activity
     * @return the distance in metres covered in the run
     */
    public int getDistance(){
    return distance;
    }

    @Override
    /**
     * String representation of a Run.
     * @return a String representation of the activity
     */
    public String toString(){
        return String.format("R%02d: effort score %#4.1f (%#4.1fkm in %#4.1fminutes)", getID(),effort,((double)(distance)/1000),((double)(getTime())/60));
    }

    @Override
    /**
     * hashCode should be based on the distance and time attributes
     * @return a hashcode
     */
    public int hashCode() {
        int result = getTime();
        result = 67 * result + getDistance();
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
        Run other = (Run) obj;
        return distance == other.distance && time == other.time;
    }
}