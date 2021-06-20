package example.application.form.calendar;

import java.util.List;

import example.application.form.schedule.ScheduleForm;

public class DayInfoForm {

    private String day;

    private List<ScheduleForm> scheduleFormList;

    public DayInfoForm() {
        super();
        // TODO 自動生成されたコンストラクター・スタブ
    }

    public DayInfoForm(String day) {
        super();
        this.day = day;
    }

    public DayInfoForm(String day, List<ScheduleForm> scheduleFormList) {
        super();
        this.day = day;
        this.scheduleFormList = scheduleFormList;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<ScheduleForm> getScheduleFormList() {
        return scheduleFormList;
    }

    public void setScheduleFormList(List<ScheduleForm> scheduleFormList) {
        this.scheduleFormList = scheduleFormList;
    }



}
