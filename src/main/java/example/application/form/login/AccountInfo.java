package example.application.form.login;

import org.springframework.stereotype.Component;

@Component
public class AccountInfo {
    private String name;

    private String password;

    public AccountInfo() {
        super();
        // TODO 自動生成されたコンストラクター・スタブ
    }

    public AccountInfo(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
