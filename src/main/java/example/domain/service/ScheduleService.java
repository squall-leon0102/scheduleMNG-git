package example.domain.service;

import java.util.List;

import example.domain.entity.ScheduleEntity;
import example.domain.entity.ScheduleTypeEntity;

public interface ScheduleService {

    /**
     * @return
     * スケジュール全件取得
     */
    public List<ScheduleEntity> getScheduleList();

    /**
     * @param id
     * @return
     * スケジュール1件取得
     */
    public ScheduleEntity getScheduleEntityById(int id);

    /**
     * @param scheduleEntity
     * スケジュール新規登録
     */
    public int setScheduleEntityAdd(ScheduleEntity scheduleEntity);

    /**
     * スケジュール種別全件取得
     * @return
     */
    public List<ScheduleTypeEntity> getScheduleTypeEntityAll();

    /**
     * スケジュール全件取得
     * @return
     */
    public List<ScheduleEntity> getScheduleEntityAll();

}
