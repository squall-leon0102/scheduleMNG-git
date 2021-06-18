package example.application.form.schedule;

import java.util.List;

public class ScheduleSessionForm {

    private ScheduleForm scheduleForm;
    private List<ScheduleTypeForm> scheduleTypeFormList;
    private String btnExec;
    private String btnPrev;

    public ScheduleSessionForm() {
    }

    public ScheduleSessionForm(ScheduleForm scheduleForm, List<ScheduleTypeForm> scheduleTypeFormList) {
        super();
        this.scheduleForm = scheduleForm;
        this.scheduleTypeFormList = scheduleTypeFormList;
    }

    public ScheduleForm getScheduleForm() {
        return scheduleForm;
    }

    public void setScheduleForm(ScheduleForm scheduleForm) {
        this.scheduleForm = scheduleForm;
    }

    public List<ScheduleTypeForm> getScheduleTypeFormList() {
        return scheduleTypeFormList;
    }

    public void setScheduleTypeFormList(List<ScheduleTypeForm> scheduleTypeFormList) {
        this.scheduleTypeFormList = scheduleTypeFormList;
    }

    public String getBtnExec() {
        return btnExec;
    }

    public void setBtnExec(String btnExec) {
        this.btnExec = btnExec;
    }

    public String getBtnPrev() {
        return btnPrev;
    }

    public void setBtnPrev(String btnPrev) {
        this.btnPrev = btnPrev;
    }
}
