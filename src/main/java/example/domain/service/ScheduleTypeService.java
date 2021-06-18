package example.domain.service;

import java.util.List;

import example.domain.entity.ScheduleTypeEntity;
import example.domain.repository.ScheduleTypeRepository;

public interface ScheduleTypeService {

    public List<ScheduleTypeEntity> getScheduleTypeList();

    public ScheduleTypeEntity getScheduleTypeEntity(int id);

    public void setScheduleTypeRepository(ScheduleTypeRepository scheduleTypeRepository);

}
