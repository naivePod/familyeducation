var publish = {
    submit : function ( ) {
        var lesson_location = $('#lesson_location').val();
        var city = $('#city').val();
        var lesson_time = $('#lesson_time').val();
        var comment = $('#comment').val();
        var price = $('#price').val();
        var suject = $('#suject').val();
        console.log("s");
        //需要注册学生
        console.log("a");
        if(!lesson_location || !lesson_time || !city || !comment || !price || !suject) {
            alert("有未填写的数据");
            return false;
        }

        $.ajax(
            {
                url: app.URL.publishEducationInformationUrl(),
                data: {
                    lesson_location:lesson_location,
                    lesson_time:lesson_time,
                    city:city,
                    comment:comment,
                    price:price,
                    suject:suject
                },
                type:"post",
                success:function (data) {
                    var status = data.status;
                    console.log(status);
                    if(status == 1) {
                        alert("提交家教信息成功");
                        //$("#tip_create").html("<span style='color:blueviolet'>恭喜，成功建立档案！</span>");
                        //刷新页面
                        window.location.reload();
                    } else {
                        // $("#tip_create").html("<span style='color:red'>失败，请重试</span>");
                        alert(data.msg);
                    }
                },
                error:function()
                {
                    alert('请求出错');
                },
                complete:function()
                {
                    $('#tip').hide();
                }

            }
        );
        return false;
    }
}