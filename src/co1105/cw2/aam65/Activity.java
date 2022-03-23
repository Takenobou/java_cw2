package co1105.cw2.aam65;

public abstract class Activity implements Comparable<Activity> {
    private static int activityCounter = 0;
    protected final int activityID;
    protected double effort;
    protected final int time;
    public abstract String toString();
    public abstract boolean equals(Object o);
    public abstract int hashCode();

    public Activity(int t) throws InvalidActivityException {
        time = t;
        activityID=++activityCounter;
        if (time < 1) throw new InvalidActivityException("Recorded time must be greater than 0s");
    }

    public int getID(){
        return activityID;
    }

    public double getEffort() {
        return effort;
    }

    public int getTime() {
        return time;
    }

    public int compareTo(Activity other) {
        if (this.equals(other)) return 0;
        else{
            if (this.effort > other.effort) return 1;
            else return -1;
        }
    }
}
