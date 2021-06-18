package example.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import example.domain.entity.UserEntity;

@Mapper
@Repository
public class UserRepository {


    public UserEntity findOneByIdAndPass(int id, String password) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }



}
