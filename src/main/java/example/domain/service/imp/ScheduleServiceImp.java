package example.domain.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.domain.entity.ScheduleEntity;
import example.domain.entity.ScheduleTypeEntity;
import example.domain.repository.ScheduleRepository;
import example.domain.repository.ScheduleTypeRepository;
import example.domain.service.ScheduleService;

@Service
@Transactional
public class ScheduleServiceImp implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    ScheduleTypeRepository scheduleTypeRepository;

    @Override
    public List<ScheduleEntity> getScheduleList() {
        return null;
    }

    @Override
    public ScheduleEntity getScheduleEntityById(int id) {
        return null;
    }

    @Override
    public int setScheduleEntityAdd(ScheduleEntity scheduleEntity) {
        return scheduleRepository.add(scheduleEntity);
    }

    @Override
    public List<ScheduleTypeEntity> getScheduleTypeEntityAll() {
        return scheduleTypeRepository.findAll();
    }

    @Override
    public List<ScheduleEntity> getScheduleEntityAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<ScheduleEntity> getAllScheduleEntityByMonth(int year, int month) {
        // TODO 自動生成されたメソッド・スタブ
        return scheduleRepository.findAllByMonth(year, month);
    }

}
