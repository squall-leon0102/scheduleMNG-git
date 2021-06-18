package example.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import example.domain.entity.ScheduleTypeEntity;

@Mapper
@Repository
public interface ScheduleTypeRepository {

    /**
     * 施設種別IDによる1件、検索処理
     * @param id
     * @return
     */
    @Select("select * from schedule_type where id=#{id}")
    @Results({
        @Result(property="insertDate", column="insert_date"),
        @Result(property="updateDate", column="update_date"),
    })
    public ScheduleTypeEntity findOneById(int id);


    /**
     * 施設種別全件取得
     * @return
     */
    @Select("select * from schedule_type")
    @Results({
        @Result(property="insertDate", column="insert_date"),
        @Result(property="updateDate", column="update_date"),
    })
    public List<ScheduleTypeEntity> findAll();

}
