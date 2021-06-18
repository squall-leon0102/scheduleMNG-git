package example.domain.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.domain.entity.ScheduleTypeEntity;
import example.domain.repository.ScheduleTypeRepository;
import example.domain.service.ScheduleTypeService;

@Service
@Transactional
public class ScheduleTypeServiceImp implements ScheduleTypeService{

    @Autowired
    ScheduleTypeRepository scheduleTypeRepository;

    @Override
    public List<ScheduleTypeEntity> getScheduleTypeList(){
        return scheduleTypeRepository.findAll();
    }

    @Override
    public ScheduleTypeEntity getScheduleTypeEntity(int id) {
        return scheduleTypeRepository.findOneById(id);
    }

    @Override
    public void setScheduleTypeRepository(ScheduleTypeRepository scheduleTypeRepository) {
        this.scheduleTypeRepository = scheduleTypeRepository;

    }
}
