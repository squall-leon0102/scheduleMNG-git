

//window.onloadにfunctionを設定することにより、画面の読み込みが終わった後に自動で実行される処理を記述できます。
window.onload = function () {


    //次月へボタン押下時処理
    let nextMonth = document.getElementById("next-month");
    nextMonth.addEventListener("click", function () {

        //画面の年月を取得する
        let year = document.getElementById("year").textContent;
        let month = document.getElementById("month").textContent;

        month++;
        if (month == 13) {
            month = 1;
            year++;
        }

        //Springに引き渡すデータをJSON型にしておく
        let formData = JSON.stringify({
            "calendar": {
                "year": year,
                "month": month
            }
        });


        //HTML部分で追加したPathをdocument.querySelector("#ajax_uri_changeMonth").valueで指定する。
        doAjaxPost(formData, document.querySelector("#ajax_uri_changeMonth").value, function (resData) {
            //Ajaxから正常にデータが返ってきたときの処理
            console.log('next-month OK');

            let dateInf = document.querySelector("#date");
            dateInf.innerHTML = null;
            let divsYear = document.createElement('div');
            divsYear.className = 'year-wrapper';

            let yearDom = document.createElement('p');
            yearDom.className = 'display-month';
            yearDom.id = 'year';
            yearDom.textContent = resData.calendar.year;

            let yearText = document.createElement('p');
            yearText.textContent = '年';

            dateInf.appendChild(divsYear);
            divsYear.appendChild(yearDom);
            divsYear.appendChild(yearText);

            let divsMonth = document.createElement('div');
            divsMonth.className = 'month-wrapper';

            let monthDom = document.createElement('p');
            monthDom.className = 'display-month';
            monthDom.id = 'month';
            monthDom.textContent = resData.calendar.month;

            let monthText = document.createElement('p');
            monthText.textContent = '月';

            dateInf.appendChild(divsMonth);
            divsMonth.appendChild(monthDom);
            divsMonth.appendChild(monthText);

            $('#calendar-days').empty();

            for (let i = 0; i < resData.dayInfoFormList.length; i++) {
                let htmlData = '';
                if (i % 7 == 0
                    && i != 0) {
                    $('#calendar-days').append(
                        '<tr>');
                }

                htmlData += '<td>'
                    + '<p>'
                    + resData.dayInfoFormList[i].day
                    + '</p>';

                for (let j in resData.dayInfoFormList[i].scheduleFormList) {

                    htmlData += '<p><a href="http://localhost:8080//facility-reservation/details/'
                        + resData.dayInfoFormList[i].scheduleFormList[j].id
                        + '/?year='
                        + resData.calendar.year
                        + '&month='
                        + resData.calendar.month
                        + '&date='
                        + resData.dayInfoFormList[i].day
                        + '" \' >'
                        + resData.dayInfoFormList[i].scheduleFormList[j].startTime
                        + '～'
                        + resData.dayInfoFormList[i].scheduleFormList[j].endTime
                        // + '('
                        // + form.calendarForm.dateForm[i].list[j].userForm.loginName
                        // + ')'
                        + '<p>'
                        + '</td>';
                }
                // htmlData += '<p><a href="/facility-reservation/'
                //     + form.facilityForm.id
                //     + '/'
                //     + 'add'
                //     + '/?date='
                //     + form.calendarForm.dateForm[i].day
                //     + '&month='
                //     + form.calendarForm.month
                //     + '&year='
                //     + form.calendarForm.year
                //     + '" \' >'
                //     + '<img src="../../../img/add.png" alt="新規予約"></a></p>'
                //     + '</td>';

                $('#calendar-days').append(
                    htmlData);

                if (i % 7 == 6) {
                    $('#calendar-days').append(
                        '</tr>');
                }

            }

        });
    });

    //前月へボタン押下時処理
    let previousMonth = document.getElementById("previous-month");
    previousMonth.addEventListener("click", function () {

        //画面の年月を取得する
        let year = document.getElementById("year").textContent;
        let month = document.getElementById("month").textContent;

        month--;
        if (month == 0) {
            month = 12;
            year--;
        }

        //Springに引き渡すデータをJSON型にしておく
        let formData = JSON.stringify({
            "calendar": {
                "year": year,
                "month": month
            }
        });


        //HTML部分で追加したPathをdocument.querySelector("#ajax_uri_changeMonth").valueで指定する。
        doAjaxPost(formData, document.querySelector("#ajax_uri_changeMonth").value, function (resData) {
            //Ajaxから正常にデータが返ってきたときの処理
            console.log('previous-month OK');

            let dateInf = document.querySelector("#date");
            dateInf.innerHTML = null;
            let divsYear = document.createElement('div');
            divsYear.className = 'year-wrapper';

            let yearDom = document.createElement('p');
            yearDom.className = 'display-month';
            yearDom.id = 'year';
            yearDom.textContent = resData.calendar.year;

            let yearText = document.createElement('p');
            yearText.textContent = '年';

            dateInf.appendChild(divsYear);
            divsYear.appendChild(yearDom);
            divsYear.appendChild(yearText);

            let divsMonth = document.createElement('div');
            divsMonth.className = 'month-wrapper';

            let monthDom = document.createElement('p');
            monthDom.className = 'display-month';
            monthDom.id = 'month';
            monthDom.textContent = resData.calendar.month;

            let monthText = document.createElement('p');
            monthText.textContent = '月';

            dateInf.appendChild(divsMonth);
            divsMonth.appendChild(monthDom);
            divsMonth.appendChild(monthText);

            $('#calendar-days').empty();

            for (let i = 0; i < resData.dayInfoFormList.length; i++) {
                let htmlData = '';
                if (i % 7 == 0
                    && i != 0) {
                    $('#calendar-days').append(
                        '<tr>');
                }

                htmlData += '<td>'
                    + '<p>'
                    + resData.dayInfoFormList[i].day
                    + '</p>';

                for (let j in resData.dayInfoFormList[i].scheduleFormList) {

                    htmlData += '<p><a href="http://localhost:8080//facility-reservation/details/'
                        + resData.dayInfoFormList[i].scheduleFormList[j].id
                        + '/?year='
                        + resData.calendar.year
                        + '&month='
                        + resData.calendar.month
                        + '&date='
                        + resData.dayInfoFormList[i].day
                        + '" \' >'
                        + resData.dayInfoFormList[i].scheduleFormList[j].startTime
                        + '～'
                        + resData.dayInfoFormList[i].scheduleFormList[j].endTime
                        // + '('
                        // + form.calendarForm.dateForm[i].list[j].userForm.loginName
                        // + ')'
                        + '<p>'
                        + '</td>';
                }
                // htmlData += '<p><a href="/facility-reservation/'
                //     + form.facilityForm.id
                //     + '/'
                //     + 'add'
                //     + '/?date='
                //     + form.calendarForm.dateForm[i].day
                //     + '&month='
                //     + form.calendarForm.month
                //     + '&year='
                //     + form.calendarForm.year
                //     + '" \' >'
                //     + '<img src="../../../img/add.png" alt="新規予約"></a></p>'
                //     + '</td>';

                $('#calendar-days').append(
                    htmlData);

                if (i % 7 == 6) {
                    $('#calendar-days').append(
                        '</tr>');
                }

            }

        });
    });

}

//POST通信のajax処理
function doAjaxPost(data, url, callback) {

    //リクエストのデータ
    let request = new XMLHttpRequest();

    //サーバーのステータスが変わった場合かつ正常に終わった場合Springから受け取ったデータをもとの処理へ返す処理を定義
    request.onreadystatechange = function () {

        //readyStateが4の場合サーバのレスポンスの受信が完了
        //statusが200の場合は通信が成功していることを表す
        if (request.readyState == 4 && request.status == 200) {
            try {
                //responseTextにするとjsonは受け取れない
                callback(request.response);
                return;
            } catch (err) {
                console.log(err.message);
                return;
            }
        }
        return;
    }

    //どういう形で通信を行うか指定(第三引数は省略可、trueにすることで非同期通信となる)
    request.open("POST", url, true);

    //サーバーへ渡すデータタイプをここで指定、今回はJSONの書き方
    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    //戻ってくるデータをJSON型で受け取ることを宣言
    request.responseType = "json";

    //準備ができたらデータを送る
    request.send(data);


}
