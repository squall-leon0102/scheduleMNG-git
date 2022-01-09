package example.domain.service.imp;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.application.form.login.AccountInfo;
import example.domain.entity.UserDetailsImp;
import example.domain.repository.UserRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountInfo account = Optional.ofNullable(userRepository.findAccount(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
        return new UserDetailsImp(account, getAuthorities(account));
    }

    /**
     * 認証が通った時にこのユーザに与える権限の範囲を設定する。
     * @param account DBから取得したユーザ情報。
     * @return 権限の範囲のリスト。
     */
    private Collection<GrantedAuthority> getAuthorities(AccountInfo account) {
        //認可が通った時にこのユーザに与える権限の範囲を設定する。
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }


}
