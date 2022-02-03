package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not  found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
        User[] users = {new User("Petr", true)};
        User user = findUser(users, "Petr");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
        } catch (UserNotFoundException uf) {
            uf.printStackTrace();
        }
    }
}