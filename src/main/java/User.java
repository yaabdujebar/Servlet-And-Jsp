public class User {
    private String userName;
    private String password;
    private boolean flag=false;

    User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    User(String userName, String password,boolean flag){
        this.userName = userName;
        this.password = password;
        this.flag=flag;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return userName+", "+password;
    }
}
