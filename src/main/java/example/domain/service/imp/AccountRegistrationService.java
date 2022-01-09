package example.domain.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import example.domain.entity.AccountRegisterEntity;
import example.domain.repository.UserRepository;

@Service
public class AccountRegistrationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public int registerAccount(AccountRegisterEntity entity) {
        //パスワードをハッシュ化して、insertMemberInfo()に渡すオブジェクトにセット。
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        return userRepository.insertAccountInfo(entity)?1:0;

    }

}
