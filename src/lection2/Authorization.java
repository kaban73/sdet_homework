package lection2;

public class Authorization {
    private static void isConfirmPasswordEqualPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.equals(confirmPassword))
            throw new WrongPasswordException("Confirm password is not equal to the password");
    }
    private static void isLengthCorrect(String login, String password) throws WrongLoginException, WrongPasswordException {
        boolean isLengthLoginCorrect = login.length() < 20 && !login.isEmpty();
        boolean isLengthPasswordCorrect = password.length() < 20 && !password.isEmpty();

        if (!isLengthLoginCorrect)
            throw new WrongLoginException("Length of login is incorrect");
        if (!isLengthPasswordCorrect)
            throw new WrongPasswordException("Length of password is incorrect");
    }
    private static void areCharactersCorrect(String login, String password) throws WrongLoginException, WrongPasswordException {
        String regex = "^[a-zA-Z0-9_]+$";
        boolean isLoginCorrect = login.matches(regex);
        boolean isPasswordCorrect = password.matches(regex);

        if (!isLoginCorrect)
            throw new WrongLoginException("Login contains invalid characters");
        if (!isPasswordCorrect)
            throw new WrongPasswordException("Password contains invalid characters");
    }
    private static void checkData(String login,String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        isLengthCorrect(login, password);
        areCharactersCorrect(login, password);
        isConfirmPasswordEqualPassword(password ,confirmPassword);
    }
    public static boolean authorization(String login, String password, String confirmPassword) {
        try {
            checkData(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
