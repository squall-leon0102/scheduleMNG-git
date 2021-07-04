package example.application.form.schedule;

import java.util.List;
import java.util.Map;

import example.application.form.calendar.DayInfoForm;

public class ScheduleIndexForm {

    private List<ScheduleForm> scheduleFormList;

    //予約種別の保持
    private List<ScheduleTypeForm> scheduleTypeFormList;

    //カレンダー作成に必要な情報保持
    private Map<String, String> calendar;

    //日付情報保持（日付、その日の予定のリスト）
    private List<DayInfoForm> dayInfoFormList;

    public ScheduleIndexForm() {

    }

    public ScheduleIndexForm(List<ScheduleForm> scheduleFormList, List<ScheduleTypeForm> scheduleTypeFormList,
            Map<String, String> calendar, List<DayInfoForm> dayInfoFormList) {
        super();
        this.scheduleFormList = scheduleFormList;
        this.scheduleTypeFormList = scheduleTypeFormList;
        this.calendar = calendar;
        this.dayInfoFormList = dayInfoFormList;
    }

    public ScheduleIndexForm(List<ScheduleTypeForm> scheduleTypeFormList,
            Map<String, String> calendar, List<DayInfoForm> dayInfoFormList) {
        super();
        this.scheduleTypeFormList = scheduleTypeFormList;
        this.calendar = calendar;
        this.dayInfoFormList = dayInfoFormList;
    }

    public List<ScheduleForm> getScheduleFormList() {
        return scheduleFormList;
    }

    public void setScheduleFormList(List<ScheduleForm> scheduleFormList) {
        this.scheduleFormList = scheduleFormList;
    }

    public List<ScheduleTypeForm> getScheduleTypeFormList() {
        return scheduleTypeFormList;
    }

    public void setScheduleTypeFormList(List<ScheduleTypeForm> scheduleTypeFormList) {
        this.scheduleTypeFormList = scheduleTypeFormList;
    }

    public Map<String, String> getCalendar() {
        return calendar;
    }

    public void setCalendar(Map<String, String> calendar) {
        this.calendar = calendar;
    }

    public List<DayInfoForm> getDayInfoFormList() {
        return dayInfoFormList;
    }

    public void setDayInfoFormList(List<DayInfoForm> dayInfoFormList) {
        this.dayInfoFormList = dayInfoFormList;
    }



}
