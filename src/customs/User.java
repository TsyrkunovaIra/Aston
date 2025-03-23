package src.customs;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    private String mail;

    public User(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
    }
}
