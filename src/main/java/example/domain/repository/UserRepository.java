package example.domain.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import example.application.form.login.AccountInfo;
import example.domain.entity.AccountRegisterEntity;
import example.domain.entity.UserEntity;

@Mapper
@Repository
public interface UserRepository {

    @Select(value = { "" })
    public UserEntity findOneByIdAndPass(int id, String password);

    @Select(value = {"SELECT name, password FROM USER WHERE name = #{name}"})
    @Results({
        @Result(property="name", column="name"),
        @Result(property="password", column="password")
    })
    public AccountInfo findAccount(String name);

    /**
     * アカウント登録処理
     * @param facility
     * @return
     */
    @Insert("insert into user (name, password, created_at, created_user) "
            + "values (#{name},#{password},now(),'system')")
    public boolean insertAccountInfo(AccountRegisterEntity entity);



}
