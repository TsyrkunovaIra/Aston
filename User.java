import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private String mail;
    private String password;

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    private User(UserBuilder UB)
    {
        name = UB.name;
        mail = UB.mail;
        password = UB.password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(mail, user.mail) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail, password);
    }

    @Override
    public int compareTo(User other)
    {
        if(!this.name.equals(other.name))
            return this.name.compareTo(other.name);
        if(!this.mail.equals(other.mail))
            return this.mail.compareTo(other.mail);
        return this.password.compareTo(other.password); //сравнение по паролю, сомнительно, но окэй
    }

    public static class UserBuilder
    {
        private String name;
        private String mail;
        private String password;
        public UserBuilder(String name)
        {
            this.name = name;
        }
        public UserBuilder setMail(String mail)
        {
            this.mail = mail;
            return this;
        }
        public UserBuilder setPassword(String password)
        {
            this.password = password;
            return this;
        }
        public User build()
        {
            return new User(this);
        }

    }

}
