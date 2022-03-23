package co1105.cw2.aam65;

public class Run extends Activity {
    private int distance;

    public Run(int d, int t) throws InvalidActivityException{
        super(t);
        distance=d;
        effort=(4*distance)/(double)t;

        if (!((d>0)&&(d<100000))) throw new InvalidActivityException("Distance must be between 0m and 100000m");
        else if ((d/t)>20) throw new InvalidActivityException("Recorded time and distance are not plausible");
    }

    public int getDistance(){
    return distance;
    }

    @Override
    public String toString(){
        return String.format("R%02d: effort score %.1f (%#4.1fkm in %#4.1fminutes)", getID(),effort,((double)(distance)/1000),((double)(getTime())/60));
    }

    @Override
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

    @Override
    public int hashCode() {
        int result = getTime();
        result = 67 * result + getDistance();
        return result;
    }
}