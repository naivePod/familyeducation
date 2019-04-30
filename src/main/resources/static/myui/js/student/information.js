var information = {
    init : function () {
        $.get(app.URL.getStudentUrl(),function (res) {
            if(res && res['status'] == 0) {
                alert("a");
            } else {
                alert("b");
            }
        },"json");
    },

    student_form : function () {

        var sName = $('#sname').val();
        var address = $('#address').val();
        var city = $('#city').val();
        var grade = $('#grade').val();
        var rank = $('#rank').val();
        var comment = $('#comment').val();
        console.log("s");
        //需要注册学生
        console.log("a");
        if(!sName || !address ||  !grade  || !city || !rank || !comment) {
            alert("有未填写的数据");
            return false;
        }

        $.ajax(
            {
                url: app.URL.createStudentUrl(),
                data: {
                    sName:sName,
                    address:address,
                    city:city,
                    grade:grade,
                    rank:rank,
                    comment:comment
                },
                type:"post",
                beforeSend:function () {
                    $("#tip").html("<span style='color:blue'>正在处理...</span>");
                    return true;
                },
                success:function (data) {
                    var status = data.status;
                    console.log(status);
                    if(status == 1) {

                        $("#tip_create").html("<span style='color:blueviolet'>恭喜，成功建立档案！</span>");
                        //刷新页面
                        window.location.reload();
                    } else {
                        $("#tip_create").html("<span style='color:red'>失败，请重试</span>");
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
    },
    update_student : function() {
        //修改学生信息
        var student_id = $('#student_id').val();
        var sName = $('#up_sname').val();
        var address = $('#up_address').val();
        var city = $('#up_city').val();
        var grade = $('#up_grade').val();
        var rank = $('#up_rank').val();
        var comment = $('#up_comment').val();

        if(!sName || !address ||  !grade  || !city || !rank || !comment) {
            alert("有未填写的数据");
            return false;
        }
        $.ajax(
            {
                url: app.URL.updateStudentUrl(),
                data:{
                    sName:sName,
                    address:address,
                    city:city,
                    grade:grade,
                    rank:rank,
                    comment:comment
                },
                type:"put",
                beforeSend:function () {
                    $("#tip").html("<span style='color:blue'>正在处理...</span>");
                    return true;
                },
                success:function (data) {
                    var status = data.status;
                    console.log(status);
                    if(status == 1) {

                        $("#tip").html("<span style='color:blueviolet'>恭喜，编辑成功！</span>");
                        //刷新页面
                        window.location.reload();
                    } else {
                        $("#tip").html("<span style='color:red'>失败，请重试</span>");
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