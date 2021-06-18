package example.domain.entity;

import java.time.LocalDateTime;

public class ScheduleTypeEntity {
    private int id;
    private String name;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;

    public ScheduleTypeEntity() {

    }

    public ScheduleTypeEntity(int id, String name, LocalDateTime insertDate, LocalDateTime updateDate) {
        super();
        this.id = id;
        this.name = name;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }

    /**
     * @param id
     * @param name
     * FormからEntityへの変換用
     */
    public ScheduleTypeEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDateTime getInsertDate() {
        return insertDate;
    }
    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
