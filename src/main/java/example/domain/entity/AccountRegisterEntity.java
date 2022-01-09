package example.domain.entity;

public class AccountRegisterEntity {
    private String name;

    private String password;

    public AccountRegisterEntity() {
        super();
        // TODO 自動生成されたコンストラクター・スタブ
    }

    public AccountRegisterEntity(String name, String password) {
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
