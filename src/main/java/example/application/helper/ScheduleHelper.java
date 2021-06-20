package example.application.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import example.application.form.calendar.DayInfoForm;
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

    /**
     * 指定年月から日付情報を取得
     * @param year
     * @param month
     * @return
     */
    public Map<String,String> getDateMap(int year, int month){

        Map<String,String> map = new HashMap<String, String>();
        LocalDate localDate = LocalDate.of(year,month,1);
        map.put("year", String.valueOf(year));
        map.put("month", String.valueOf(month));
        map.put("days", String.valueOf(localDate.lengthOfMonth()));
        map.put("weekday", String.valueOf(localDate.getDayOfWeek().getValue()));
        return map;
    }

    /**
     * 現在の日付の日付情報を取得
     * @return
     */
    public Map<String,String> getNowDateMap(){
        LocalDate now = LocalDate.now();
        return getDateMap(now.getYear(), now.getMonthValue());
    }

    /**
     * 日付とその日のスケジュール情報をまとめたマップを返す
     * @param map
     * @param slist
     * @return
     */
    public Map<String, List<ScheduleForm>> createDayInfoMap(Map<String,String> map, List<ScheduleForm> slist){

        Map<String, List<ScheduleForm>> retMap = new HashMap<String, List<ScheduleForm>>();

        int count = 0;
        List<ScheduleForm> list = null;

        for(ScheduleForm form: slist) {
            if(count != form.getStartDate().getDayOfMonth()) {
                count = form.getStartDate().getDayOfMonth();
                list = new ArrayList<ScheduleForm>();
                list.add(form);
            }else {
                list.add(form);
            }
            retMap.put(String.valueOf(count),list);
        }

        return retMap;
    }

    /**
     * カレンダー作成
     * @param map
     * @param slist
     * @return
     */
    public List<DayInfoForm> createDayInfoForm(Map<String,String> map,List<ScheduleForm> slist){

        Map<String, List<ScheduleForm>> dayMap= createDayInfoMap(map,slist);

        List<DayInfoForm> retList = new ArrayList<DayInfoForm>();
        int weekDay = Integer.parseInt(map.get("weekday"));
        int daysNum = Integer.parseInt(map.get("days"));

        int firstBlanc = weekDay - 1;
        int count = 0;
        for(int i = 0; i<firstBlanc; i++) {
            retList.add(new DayInfoForm("-"));
            count++;
        }

        for (int i = 1; i <= daysNum; i++) {
            retList.add(new DayInfoForm(String.valueOf(i), dayMap.get("i")));
            count++;
        }

        if (count % 7 != 0) {
            for (int i = 0; i < 7 - (count % 7); i++) {
                retList.add(new DayInfoForm("-"));
            }
        }

        return retList;
    }

}

