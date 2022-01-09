package example.domain.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import example.application.form.login.AccountInfo;

public class UserDetailsImp extends User {

    private final AccountInfo account;

    public UserDetailsImp(AccountInfo account,Collection<GrantedAuthority> authorities) {
        super(account.getName(), account.getPassword(),true, true, true, true, authorities);
        this.account = account;
    }

    public AccountInfo getAccount() {
        return account;
    }

}
