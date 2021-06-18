//package example.domain.service.imp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import example.domain.entity.UserEntity;
//import example.domain.repository.UserRepository;
//import example.domain.service.AuthService;
//
//public class AuthServiceImp implements AuthService{
//
//    @Autowired
//    UserRepository repo;
//
//    @Override
//    public UserEntity checkLoginAccount(UserEntity userEntity) {
//        // TODO 自動生成されたメソッド・スタブ
//        return repo.findOneByIdAndPass(userEntity.getId(), userEntity.getPassword());
//    }
//
//
//
//}
