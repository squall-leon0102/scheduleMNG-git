package example.application.form.schedule;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ScheduleForm implements Serializable{

    private int id;

    private String title;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    private LocalTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private LocalTime endTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private ScheduleTypeForm scheduleTypeForm;

    /**
     * デフォルトコンストラクタ
     */
    public ScheduleForm() {

    }

    /**
     * @param id
     * @param title
     * @param content
     * @param startDate
     * @param startTime
     * @param endDate
     * @param endTime
     * @param createdAt
     * @param updatedAt
     * @param userForm
     */
    public ScheduleForm(int id, String title, String content, LocalDate startDate, LocalTime startTime,
            LocalDate endDate, LocalTime endTime, LocalDateTime createdAt, LocalDateTime updatedAt,ScheduleTypeForm scheduleTypeForm) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.scheduleTypeForm = scheduleTypeForm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ScheduleTypeForm getScheduleTypeForm() {
        return scheduleTypeForm;
    }

    public void setScheduleTypeForm(ScheduleTypeForm scheduleTypeForm) {
        this.scheduleTypeForm = scheduleTypeForm;
    }

//    public UserForm getUserForm() {
//        return userForm;
//    }
//
//    public void setUserForm(UserForm userForm) {
//        this.userForm = userForm;
//    }



}
