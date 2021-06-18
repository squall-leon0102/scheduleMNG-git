package example.application.helper;

import org.springframework.stereotype.Component;

import example.application.form.auth.AuthLoginForm;
import example.domain.entity.UserEntity;

@Component
public class AuthHelper {

    public UserEntity convertToUserEntityFromAuthLoginForm(final AuthLoginForm authLoginForm) {
        return new UserEntity(authLoginForm.getLogId(), authLoginForm.getPass());
    }

}
