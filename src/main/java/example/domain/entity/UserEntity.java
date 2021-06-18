package example.domain.entity;

public class UserEntity {
    private String id;
    private String password;

    //権限レベル
    private int authLevel;


    public UserEntity(String id, String password, int authLevel, String note) {
        super();
        this.id = id;
        this.password = password;
        this.authLevel = authLevel;
    }

    /**
     * AuthLoginFormからの変換用
     * @param id
     * @param password
     */
    public UserEntity(String id, String password) {
        super();
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(int authLevel) {
        this.authLevel = authLevel;
    }
}
