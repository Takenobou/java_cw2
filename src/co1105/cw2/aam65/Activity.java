package co1105.cw2.aam65;

public abstract class Activity implements Comparable<Activity> {
    protected double effort;
    protected final int time;
    protected final int activityID;
    private static int activityCounter = 0;

    public abstract String toString();
    public abstract boolean equals(Object o);
    public abstract int hashCode();

    /**
     * Default constructor. Sets the unique activityID attribute using the activityCounter static attribute
     * @param t - the time in seconds taken for the activity; must be greater than 0.
     * @throws InvalidActivityException - if the time is invalid
     */
    public Activity(int t) throws InvalidActivityException {
        time = t;
        activityID=++activityCounter;
        if (time < 1) throw new InvalidActivityException("Recorded time must be greater than 0s");
    }

    /**
     * Get the ID of the activity
     * @return the unique ID of this activity
     */
    public int getID(){
        return activityID;
    }

    /**
     * Get the effort score for this activity
     * @return the effort score for this activity
     */
    public double getEffort() {
        return effort;
    }

    /**
     * Get the time recorded for this activity
     * @return the time for this activity
     */
    public int getTime() {
        return time;
    }

    /**
     * Comparison based on the effort score of the 2 activities.
     * @param other - Activity to compare to this
     * @return zero if the two activities have the same effort score; negative if this has lower effort score and positive if this has larger effort score.
     */
    public int compareTo(Activity other) {
        if (this.equals(other)) return 0;
        else{
            if (this.effort > other.effort) return 1;
            else return -1;
        }
    }
}
