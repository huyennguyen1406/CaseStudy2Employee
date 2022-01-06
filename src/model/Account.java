package model;

public class Account {
    private String acc;
    private String pass;
    private String role;

    public Account() {
    }

    public Account(String acc, String pass, String role) {
        this.acc = acc;
        this.pass = pass;
        this.role = role;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String write1(){
        return acc + "," + pass + "," + role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acc='" + acc + '\'' +
                ", pass='" + pass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
