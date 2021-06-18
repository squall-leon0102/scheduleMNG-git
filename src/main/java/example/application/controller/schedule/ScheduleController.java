package example.application.controller.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import example.application.form.schedule.ScheduleForm;
import example.application.form.schedule.ScheduleIndexForm;
import example.application.form.schedule.ScheduleSessionForm;
import example.application.form.schedule.ScheduleTypeForm;
import example.application.helper.ScheduleHelper;
import example.domain.entity.ScheduleEntity;
import example.domain.entity.ScheduleTypeEntity;
import example.domain.service.ScheduleService;

@Controller
@SessionAttributes(names = "scheduleSessionForm")
public class ScheduleController {

    private static final String FORM_NAME = "scheduleSessionForm";

    @Autowired
    ScheduleHelper scheduleHelper;

    @Autowired
    ScheduleService scheduleService;

    /**
     * 施設情報管理コントローラー内で使用するセッションオブジェクトの生成処理
     * @return
     */
    @ModelAttribute(value = "scheduleSessionForm")
    public ScheduleSessionForm scheduleSessionForm() {
        return new ScheduleSessionForm();
    }


    @RequestMapping(path = "schedule/top", method = RequestMethod.GET)
    public String createTopPage(Model model) {

        model.addAttribute("scheduleIndexForm",
                new ScheduleIndexForm(scheduleHelper.getScheduleFormListForIndex(scheduleService.getScheduleEntityAll()),
                        scheduleHelper.scheduleTypeEntitiyListToScheduleTypeFormList(scheduleService.getScheduleTypeEntityAll())));
        return "schedule/schedule-top";
    }

    @RequestMapping(path = "schedule/create", method = RequestMethod.GET)
    public String createSchedulePage(@ModelAttribute(FORM_NAME)ScheduleSessionForm scheduleSessionForm,Model model) {

//        String key = BindingResult.MODEL_KEY_PREFIX + FORM_NAME;
        List<ScheduleTypeEntity> entityList = scheduleService.getScheduleTypeEntityAll();
        List<ScheduleTypeForm> formList = scheduleHelper.scheduleTypeEntitiyListToScheduleTypeFormList(entityList);
        scheduleSessionForm.setScheduleForm(new ScheduleForm());
        scheduleSessionForm.getScheduleForm().setScheduleTypeForm(new ScheduleTypeForm());
        scheduleSessionForm.setScheduleTypeFormList(formList);
        model.addAttribute("scheduleSessionForm", scheduleSessionForm);

        return "schedule/schedule-create";
    }

    @RequestMapping(path = "schedule/confirm", method = RequestMethod.POST)
    public String newSchedulePage(@ModelAttribute(FORM_NAME)ScheduleSessionForm scheduleSessionForm,Model model) {

        model.addAttribute("scheduleSessionForm", scheduleSessionForm);
        scheduleSessionForm.setBtnExec(btnNameChange("登録"));
        scheduleSessionForm.setBtnPrev(btnNameChange("戻る"));

        return "schedule/schedule-confirm";
    }

    @RequestMapping(path = "/schedule/complete", method = RequestMethod.POST)
    public String completeSchedulePage(@ModelAttribute(FORM_NAME)ScheduleSessionForm scheduleSessionForm, Model model) {
        ScheduleEntity scheduleEntity = scheduleHelper.scheduleFormToScheduleEntity(scheduleSessionForm.getScheduleForm());


        int result = scheduleService.setScheduleEntityAdd(scheduleEntity);

        return "schedule/schedule-complete";
    }

    private String btnNameChange(String viewName) {

        String btnName = null;

        switch(viewName) {
            case "登録": btnName = "登録";
                break;
            case "変更": btnName = "変更";
                break;
            case "削除": btnName = "削除";
                break;
            case "戻る": btnName = "戻る";
                break;
            default: break;
        }
        return btnName;
    }

}
