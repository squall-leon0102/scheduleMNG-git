package example.application.form.auth;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//スコープの指定によりController全体で共通使用できるようになる
@Scope(value="session" , proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthSessionForm implements Serializable{

    /**
     * ログイン中ユーザー名
     */
    private String userName;

    /**
     * 権限レベル
     */
    private int authLevel;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(int authLevel) {
        this.authLevel = authLevel;
    }

    public AuthSessionForm() {

    }

    public AuthSessionForm(String userName, int authLevel) {
        super();
        this.userName = userName;
        this.authLevel = authLevel;
    }



}
