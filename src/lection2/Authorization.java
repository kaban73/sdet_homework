package lection2;

public class Authorization {
    private static void checkLogin(String login) throws WrongLoginException {

    }
    private static void checkPasswords(String password, String confirmPasswords) throws WrongPasswordException {

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
