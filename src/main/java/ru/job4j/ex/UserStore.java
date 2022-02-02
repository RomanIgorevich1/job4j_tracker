package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            } else {
                throw new UserNotFoundException("User not  found");
            }
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() | user.getUsername().length() < 3) {
            throw new UserInvalidException("User invalid");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr", true)};
        try {
        User user = findUser(users, "Petr");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
        } catch (UserNotFoundException uf) {
            uf.printStackTrace();
        }
    }
}