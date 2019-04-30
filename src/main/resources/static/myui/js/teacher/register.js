var register = {

    init : function () {
        $("#file_photo").on("change", function(){
            var formData = new FormData();
            var file = $('#file_photo')[0].files[0];
            formData.append("file", file);
            formData.append("token", $("#token").val());
            console.log(file);
            if('undefine' != typeof(file) && file != null && file != "") {
                $.ajax({
                    url: app.URL.getUploadPhotoUrl(),
                    type: "POST",
                    data: formData,
                    processData: false,
                    contentType: false,
                    success: function(response){
                        // 根据返回结果指定界面操作
                        if(response.status == 1) {
                            console.log(response.data);
                            $('#new_photo').attr('src', response.data['filePathPhoto']);
                            $('#token_photo').val(response.data['token_photo']);
                            $('#picture_tip_photo').html("<span style='color:blueviolet'>上传成功</span>");
                            console.log(response.data['token_photo']);
                        } else {
                            $('#picture_tip_photo').html("<span style='color:red'>上传失败</span>");
                            $('#new_photo').attr('src', '#');
                            $('#token_photo').val("");
                        }
                    },
                    error:function () {
                        alert("error");
                    }
                });
            }
        });

        $("#file_verifiedimg").on("change", function(){
            var formData = new FormData();
            var file = $('#file_verifiedimg')[0].files[0];
            formData.append("file", file);
            formData.append("token", $("#token").val());
            console.log(file);
            if('undefine' != typeof(file) && file != null && file != "") {
                $.ajax({
                    url: app.URL.getUploadVerifyUrl(),
                    type: "POST",
                    data: formData,
                    processData: false,
                    contentType: false,
                    success: function(response){
                        // 根据返回结果指定界面操作
                        if(response.status == 1) {
                            console.log(response.data['token']);
                            $('#new_verifiedimg').attr('src', response.data['filePathAuditImg']);
                            $('#token_verifiedimg').val(response.data['token_audit_img']);
                            $('#picture_tip_verifiedimg').html("<span style='color:blueviolet'>上传成功</span>");
                            console.log(response.data['token']);
                        } else {
                            $('#picture_tip_verifiedimg').html("<span style='color:red'>上传失败</span>");
                            $('#new_verifiedimg').attr('src', '#');
                            $('#token_verifiedimg').val("");
                        }
                    },
                    error:function () {
                        alert("error");
                    }
                });
            }
        });
    },

    registerTeacher : function () {
        //var student_id = $('#student_id').val();
        var realName = $('#sname').val();
        var address = $('#address').val();
        var city = $('#city').val();
        var diploma = $('#diploma').val();
        var comment = $('#comment').val();
        var age = $('#age').val();
        var sex = $('#sex').val();
        var cardId = $('#card_id').val()+"";
        var token_photo = $('#token_photo').val();
        var token_audit = $('#token_verifiedimg').val();
        console.log(cardId);
        //需要注册学生
        console.log("a");
        if(!realName || !address || !city || !comment || !diploma || !age || !sex || !token_photo || !token_audit ||!cardId) {
            alert("有未填写的数据");
            return false;
        }

        $.ajax(
            {
                url: app.URL.registerTeacher(),
                data: {
                    realName:realName,
                    address:address,
                    city:city,
                    diploma:diploma,
                    age:age,
                    sex:sex,
                    comment:comment,
                    cardId:cardId,
                    token_photo:token_photo,
                    token_audit:token_audit
                },
                type:"post",
                success:function (data) {
                    var status = data.status;
                    console.log(status);
                    if(status == 1) {
                        alert("上传审核信息成功");
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