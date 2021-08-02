package example.application.controller.schedule;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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


    /**
     * スケジュール管理トップへの遷移
     * @param model
     * @return
     */
    @RequestMapping(path = "schedule/top", method = RequestMethod.GET)
    public String createTopPage(Model model) {

        Map<String,String> map = scheduleHelper.getNowDateMap();

        model.addAttribute("scheduleIndexForm",

                new ScheduleIndexForm(
                      scheduleHelper.scheduleTypeEntitiyListToScheduleTypeFormList(scheduleService.getScheduleTypeEntityAll()),
                      map,scheduleHelper.createDayInfoForm(map, scheduleHelper.getScheduleFormListForIndex(
                              scheduleService.getAllScheduleEntityByMonth(Integer.parseInt(map.get("year")),Integer.parseInt(map.get("month")))))));

        return "schedule/schedule-top";
    }

    /**
     * カレンダー切替（前月、次月）
     * @param reservationStatusForm
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(path="schedule/top", method=RequestMethod.POST)
    @ResponseBody
    public ScheduleIndexForm makeAjaxCalendar(@ModelAttribute(FORM_NAME) ScheduleSessionForm session,@RequestBody ScheduleIndexForm scheduleIndexForm, Model model) throws Exception{

        Map<String,String> map = scheduleHelper.getDateMap(Integer.parseInt(scheduleIndexForm.getCalendar().get("year")),Integer.parseInt(scheduleIndexForm.getCalendar().get("month")));

        return new ScheduleIndexForm(
                scheduleHelper.scheduleTypeEntitiyListToScheduleTypeFormList(scheduleService.getScheduleTypeEntityAll()),
                map,scheduleHelper.createDayInfoForm(map, scheduleHelper.getScheduleFormListForIndex(
                        scheduleService.getAllScheduleEntityByMonth(Integer.parseInt(map.get("year")),Integer.parseInt(map.get("month"))))));

    }

    /**
     * スケジュール新規作成画面への遷移
     * @param scheduleSessionForm
     * @param model
     * @return
     */
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

    /**
     * スケジュール確認画面への遷移
     * @param scheduleSessionForm
     * @param model
     * @return
     */
    @RequestMapping(path = "schedule/confirm", method = RequestMethod.POST)
    public String newSchedulePage(@ModelAttribute(FORM_NAME)ScheduleSessionForm scheduleSessionForm,Model model) {

        model.addAttribute("scheduleSessionForm", scheduleSessionForm);
        scheduleSessionForm.setBtnExec(btnNameChange("登録"));
        scheduleSessionForm.setBtnPrev(btnNameChange("戻る"));

        return "schedule/schedule-confirm";
    }

    /**
     * スケジュール登録完了画面
     * @param scheduleSessionForm
     * @param model
     * @return
     */
    @RequestMapping(path = "/schedule/complete", method = RequestMethod.POST)
    public String completeSchedulePage(@ModelAttribute(FORM_NAME)ScheduleSessionForm scheduleSessionForm, Model model) {
        ScheduleEntity scheduleEntity = scheduleHelper.scheduleFormToScheduleEntity(scheduleSessionForm.getScheduleForm());


        int result = scheduleService.setScheduleEntityAdd(scheduleEntity);

        return "schedule/schedule-complete";
    }

    /**
     * スケジュール詳細画面への遷移
     * @param scheduleSessionForm
     * @param model
     * @return
     */
    @RequestMapping(path="/schedule/details/{scheduleId}", method = RequestMethod.GET)
    public String showScheduleDetail(@ModelAttribute(FORM_NAME)ScheduleSessionForm scheduleSessionForm, Model model, @PathVariable int scheduleId) {

        scheduleSessionForm.setScheduleForm(scheduleHelper.scheduleEntityToScheduleForm(scheduleService.getScheduleEntityById(scheduleId)));
        model.addAttribute("scheduleSessionForm", scheduleSessionForm);

        return "schedule/schedule-details";
    }

    /**
     * スケジュール編集画面への遷移
     * @param scheduleSessionForm
     * @param model
     * @return
     */
    @RequestMapping(path="/schedule/edit/{scheduleId}", method = RequestMethod.GET)
    public String editSchedule(@ModelAttribute(FORM_NAME)ScheduleSessionForm scheduleSessionForm, Model model, @PathVariable int scheduleId) {

        model.addAttribute("scheduleSessionForm", scheduleSessionForm);

        return "schedule/schedule-edit";
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
