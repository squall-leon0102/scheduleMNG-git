package example.domain.service;

import example.domain.entity.UserEntity;

public interface AuthService {

    public UserEntity checkLoginAccount(final UserEntity userEntity);

}
