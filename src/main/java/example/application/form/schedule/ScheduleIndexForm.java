package example.application.form.schedule;

import java.util.List;

public class ScheduleIndexForm {

    private List<ScheduleForm> scheduleFormList;

    private List<ScheduleTypeForm> scheduleTypeFormList;

    public ScheduleIndexForm() {

    }



    public ScheduleIndexForm(List<ScheduleForm> scheduleFormList, List<ScheduleTypeForm> scheduleTypeFormList) {
        super();
        this.scheduleFormList = scheduleFormList;
        this.scheduleTypeFormList = scheduleTypeFormList;
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



}
