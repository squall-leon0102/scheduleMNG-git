window.onload = function () {

    let year = document.getElementById("year").textContent;
    let month = document.getElementById("month").textContent;
    let formData = JSON.stringify({
        "calendar":{
            "year" : year,
            "month" : month
        }
    });

    //次月へボタン押下時処理
    let nextMonth = document.getElementById("next-month");
    nextMonth.addEventListener("click", function () {
        doAjaxPost(formData, document.querySelector("#ajax_uri").value, function(resData){

            let dateInf = document.querySelector("#date");
            dateInf.textContent = "";
            dateInf.appendChild = 'OK';
    //                                 <p class="display-month" id="year" th:text="resData[scheduleIndexForm.calendar.get('year')] + '年'"></p>'
    //                                 + form.calendarForm.year
    //                                 + '年'
    //                                 + form.calendarForm.month
    //                                 + '月'
    //                                 + '<input type="button" id="nextMonth" value="次月">'
    //                                 + '<input type="hidden" id="year" value="'+form.calendarForm.year+'">'
    //                                 + '<input type="hidden" id="month" value="'+form.calendarForm.month+'">';

    // <p class="display-month" id="month" th:text="${scheduleIndexForm.calendar.get('month')} + '月'"></p>

        });

    });

}

//POST通信のajax処理
function doAjaxPost(data, url, callback){
    let request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if(request.readyState == 4 && request.status == 200){
            try{
//                let result = JSON.parse(request.responseText);
            	//responseTextにするとjsonは受け取れない
                callback(request.response);
                return;
            }catch(err){
                console.log(err.message);
                return;
            }


        }
        return;

    }

    request.open("POST", url , true);
    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    request.responseType = "json";
    request.send(data);


}