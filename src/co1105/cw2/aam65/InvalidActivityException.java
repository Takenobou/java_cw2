package co1105.cw2.aam65;

/**
 * The class Invalid activity exception extends exception
 */
public class InvalidActivityException extends Exception {
    public InvalidActivityException () {super();}
    /**
     * Invalid activity exception, take message as param
     */
    public InvalidActivityException (String message) {
        super(message);
    }
}
