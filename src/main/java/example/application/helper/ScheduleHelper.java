package example.application.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import example.application.form.schedule.ScheduleForm;
import example.application.form.schedule.ScheduleTypeForm;
import example.domain.entity.ScheduleEntity;
import example.domain.entity.ScheduleTypeEntity;

@Component
public class ScheduleHelper {

    /**
     * @param scheduleForm
     * @return
     * ScheduleFormからScheduleEntityへの変換
     */
    public ScheduleEntity scheduleFormToScheduleEntity(final ScheduleForm scheduleForm) {
        return new ScheduleEntity(scheduleForm.getId(),scheduleForm.getTitle(),scheduleForm.getContent(),
                mixDateAndTime(scheduleForm.getStartDate(),scheduleForm.getStartTime()),
                mixDateAndTime(scheduleForm.getEndDate(),scheduleForm.getEndTime()),
                scheduleTypeFormToScheduleTypeEntity(scheduleForm.getScheduleTypeForm()));
    }

    /**
     * ScheduleEntityからScheduleFormへの変換
     * @param scheduleEntity
     * @return
     */
    public ScheduleForm scheduleEntityToScheduleForm(final ScheduleEntity scheduleEntity) {
        return new ScheduleForm(scheduleEntity.getId(),scheduleEntity.getTitle(),scheduleEntity.getContent(),scheduleEntity.getStartDate().toLocalDate(),
                scheduleEntity.getStartDate().toLocalTime(),scheduleEntity.getEndDate().toLocalDate(),scheduleEntity.getEndDate().toLocalTime(),
                scheduleEntity.getCreatedAt(),scheduleEntity.getUpdatedAt(),scheduleTypeEntityToScheduleTypeForm(scheduleEntity.getScheduleTypeEntity()));
    }

    /**
     * @param localDate
     * @param localTime
     * @return
     * 日付と時刻を合体させる
     */
    public LocalDateTime mixDateAndTime(LocalDate localDate, LocalTime localTime) {
//        String originDate = new SimpleDateFormat("yyyy-MM-dd").format(localDate);
//        String originTime = new SimpleDateFormat("hh:mm:ss").format(localTime);

        return LocalDateTime.of(localDate, localTime);
    }


    /**
     * @param scheduleTypeForm
     * @return
     * スケジュール種別フォームからスケジュール種別エンティティへの変換
     */
    public ScheduleTypeEntity scheduleTypeFormToScheduleTypeEntity(ScheduleTypeForm scheduleTypeForm) {
        return new ScheduleTypeEntity(scheduleTypeForm.getId(), scheduleTypeForm.getName());
    }

    /**
     * スケジュール種別エンティティからスケジュール種別フォームへの変換
     * @param scheduleTypeEntity
     * @return
     */
    public ScheduleTypeForm scheduleTypeEntityToScheduleTypeForm(ScheduleTypeEntity scheduleTypeEntity) {
        return new ScheduleTypeForm(scheduleTypeEntity.getId(),scheduleTypeEntity.getName());
    }

    /**
     * スケジュール種別エンティティリストからスケジュール種別フォームリストへのへんかん
     * @param scheduleTypeEntityList
     * @return
     */
    public List<ScheduleTypeForm> scheduleTypeEntitiyListToScheduleTypeFormList(List<ScheduleTypeEntity> scheduleTypeEntityList){
        List<ScheduleTypeForm> retList = new ArrayList<ScheduleTypeForm>();

        for(ScheduleTypeEntity entity : scheduleTypeEntityList) {
            retList.add(scheduleTypeEntityToScheduleTypeForm(entity));
        }

        return retList;
    }

    /**
     * ScheduleEntityのリストをScheduleFormのリストに変換
     * @param scheduleEntityList
     * @return
     */
    public List<ScheduleForm> getScheduleFormListForIndex(List<ScheduleEntity> scheduleEntityList){

        List<ScheduleForm> list = new ArrayList<ScheduleForm>();

        for(ScheduleEntity scheduleEntity: scheduleEntityList) {
            list.add(scheduleEntityToScheduleForm(scheduleEntity));
        }

        return list;
    }



}
