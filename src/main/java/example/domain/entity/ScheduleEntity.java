package example.domain.entity;

import java.time.LocalDateTime;

public class ScheduleEntity {
    private int id;
    private String title;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private ScheduleTypeEntity scheduleTypeEntity;


    public ScheduleEntity(int id, String title, String content,LocalDateTime startDate, LocalDateTime endDate, LocalDateTime createdAt,
            LocalDateTime updatedAt,ScheduleTypeEntity scheduleTypeEntity) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.scheduleTypeEntity = scheduleTypeEntity;
    }

    public ScheduleEntity(int id, String title,String content, LocalDateTime startDate, LocalDateTime endDate,
            ScheduleTypeEntity scheduleTypeEntity) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.scheduleTypeEntity = scheduleTypeEntity;
    }


//
//    public ScheduleEntity(int id, String content, Timestamp startDate, Timestamp endDate,)

    //My batisはデフォコンがないとうまく動かないから忘れないこと
    public ScheduleEntity() {
        super();
        // TODO 自動生成されたコンストラクター・スタブ
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

    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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
    public ScheduleTypeEntity getScheduleTypeEntity() {
        return scheduleTypeEntity;
    }
    public void setScheduleTypeEntity(ScheduleTypeEntity scheduleTypeEntity) {
        this.scheduleTypeEntity = scheduleTypeEntity;
    }
}
