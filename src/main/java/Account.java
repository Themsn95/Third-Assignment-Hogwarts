import java.util.UUID;

import static java.util.Objects.hash;

public class Account implements AccountManagement {
    private String username;
    // TODO: Passwords should hashed
    private String password;
    private UUID accountID;

    public Account(String username, String password) {
        this.username = username;
        this.password = String.valueOf(hash(password));
        this.accountID = UUID.randomUUID();
    }

    public UUID getAccountID() {
        return accountID;
    }

//    @Override
//    public boolean validatePassword(String enteredPassword) {
//        //TODO
//        return hash(enteredPassword);
//    }

    @Override
    public void changeUsername(String newUsername) {
        //TODO
        this.username = newUsername ;
    }

    @Override
    public void changePassword(String newPassword) {
        //TODO
        this.password = String.valueOf(hash(newPassword));
    }

    public String getUsername() {
        return username;
    }
}
