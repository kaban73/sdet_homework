package lection2;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super();
    }
    public WrongPasswordException(String msg) {
        super(msg);
    }
}
