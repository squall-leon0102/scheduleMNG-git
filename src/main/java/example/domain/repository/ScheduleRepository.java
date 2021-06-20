package example.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import example.domain.entity.ScheduleEntity;

@Mapper
@Repository
public interface ScheduleRepository {

    //    @Select("select * from schedule where id=#{id}")
    //    @Results({
    //        @Result(property="scheduleTypeEntity", column="type_id", one = @One(select = "jp.co.ginga.domain.repository.FacilityTypeRepository.findOneById", fetchType = FetchType.EAGER)),
    //        @Result(property="insertDate", column="insert_date"),
    //        @Result(property="updateDate", column="update_date"),
    //    })
    //    public FacilityEntity findOneById(int id);

    /**
     * スケジュール登録処理
     * @param facility
     * @return
     */
    @Insert("insert into schedule (title, start_date, end_date, created_at,type_id,content) "
            + "values (#{title},#{startDate},#{endDate},now(),#{scheduleTypeEntity.id},#{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int add(ScheduleEntity scheduleEntity);

    /**
     * スケジュール全件取得
     * @return
     */
    @Select("select * from schedule")
    @Results({
        @Result(property="scheduleTypeEntity", column="type_id", one = @One(select = "example.domain.repository.ScheduleTypeRepository.findOneById",
                fetchType = FetchType.EAGER)),
        @Result(property="insertDate", column="insert_date"),
        @Result(property="updateDate", column="update_date")
    })
    public List<ScheduleEntity> findAll();

    /**
     * 指定月のスケジュールを取得
     * @return
     */
    @Select("select * from schedule where year(start_date)=#{year} AND month(start_date)=#{month} ORDER BY start_date")
    @Results({
        @Result(property="scheduleTypeEntity", column="type_id", one = @One(select = "example.domain.repository.ScheduleTypeRepository.findOneById",
                fetchType = FetchType.EAGER)),
        @Result(property="insertDate", column="insert_date"),
        @Result(property="updateDate", column="update_date")
    })
    public List<ScheduleEntity> findAllByMonth(int year, int month);
}
