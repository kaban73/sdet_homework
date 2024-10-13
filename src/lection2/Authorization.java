package lection2;

public class Authorization {
    private static void isConfirmPasswordEqualPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.equals(confirmPassword))
            throw new WrongPasswordException("Confirm password is not equal to the password");
    }
    private static void isLengthPasswordCorrect(String password) throws WrongPasswordException {
        if (password.length() > 20)
            throw new WrongPasswordException("Password is too long");
        else if (password.isEmpty())
            throw new WrongPasswordException("Password can not be empty");
    }
    private static void arePasswordCharactersCorrect(String password) throws WrongPasswordException {
        String regex = "^[a-zA-Z0-9_]+$";
        if (!password.matches(regex))
            throw new WrongPasswordException("Password contains invalid characters");
    }
    private static void isLengthLoginCorrect(String login) throws WrongLoginException{
        if (login.length() > 20)
            throw new WrongLoginException("Login is too long");
        else if (login.isEmpty())
            throw new WrongLoginException("Login can not be empty");
    }
    private static void areLoginCharactersCorrect(String login) throws WrongLoginException {
        String regex = "^[a-zA-Z0-9_]+$";
        if (!login.matches(regex))
            throw new WrongLoginException("Login contains invalid characters");
    }
    private static void checkLogin(String login) throws WrongLoginException {
        isLengthLoginCorrect(login);
        areLoginCharactersCorrect(login);
    }
    private static void checkPasswords(String password, String confirmPasswords) throws WrongPasswordException {
        isLengthPasswordCorrect(password);
        arePasswordCharactersCorrect(password);
        isConfirmPasswordEqualPassword(password, confirmPasswords);
    }
    public static boolean authorization(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPasswords(password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
