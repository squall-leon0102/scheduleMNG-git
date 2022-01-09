package example.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import example.application.form.schedule.ScheduleIndexForm;
import example.application.helper.ScheduleHelper;
import example.domain.service.ScheduleService;

@Component
public class EntityUtils {

    @Autowired
    ScheduleHelper scheduleHelper;

    @Autowired
    ScheduleService scheduleService;

    /**
     * カレンダーの月を変更するときに新たな月の情報を渡す
     * @param scheduleIndexForm
     * @return
     */
    public ScheduleIndexForm makeScheduleIndexFormForCalendar(ScheduleIndexForm scheduleIndexForm) {

        int chYear = Integer.parseInt(scheduleIndexForm.getCalendar().get("year"));
        int chMonth = Integer.parseInt(scheduleIndexForm.getCalendar().get("month"));

        Map<String,String> map = scheduleHelper.getDateMap(chYear,chMonth);

        return new ScheduleIndexForm(
                scheduleHelper.scheduleTypeEntitiyListToScheduleTypeFormList(scheduleService.getScheduleTypeEntityAll()),
                map,scheduleHelper.createDayInfoForm(map, scheduleHelper.getScheduleFormListForIndex(
                        scheduleService.getAllScheduleEntityByMonth(Integer.parseInt(map.get("year")),Integer.parseInt(map.get("month"))))));
    }

}
