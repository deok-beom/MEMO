package Miniproject2.src.application.Entity;

public class User {
    String memoId;
    String password;

    public User(String memoId, String password) {
        this.memoId = memoId;
        this.password = password;
    }

    public String getLoginId() {
        return memoId;
    }

    public String getLoginPw() {
        return password;
    }
}