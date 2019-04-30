var app = {
    data: {
        nowTime: null,
        contextPath: null,
    },
    URL: {
        checkLoginUrl: function () {
            return app.data.contextPath+"/account/login";
        },
        logoutUrl: function () {
            return app.data.contextPath+"/account/logout";
        },
        getMessageCountUrl: function () {
            return app.data.contextPath+"/user/manage/findunread"
        },
        getUnreadMessagesUrl: function () {
            return app.data.contextPath+"/user/manage/unreadmessages"
        },
        getAllMessagesUrl: function () {
            return app.data.contextPath+"/user/manage/allmessages"
        },
        updateStudentUrl : function () {
            return app.data.contextPath+"/student/update";
        },
        createStudentUrl : function () {
            return app.data.contextPath+"/student/register";
        },
        getStudentUrl : function () {
            return app.data.contextPath + "/student/detail";
        },
        getPersonUrl : function() {
            return app.data.contextPath + "/user/detail";
        },
        getUploadPhotoUrl : function () {
            return app.data.contextPath + "/user/audit/upload_photo";
        },
        getUploadVerifyUrl : function () {
            return app.data.contextPath + "/user/audit/upload_audit_img";
        },
        registerTeacher : function () {
            return app.data.contextPath + "/user/audit/register";
        },
        publishEducationInformationUrl : function () {
            return app.data.contextPath + "/teacher/publish";
        },
        getOrderListUrl : function () {
            return app.data.contextPath + "/order/list";
        }
    },
    init: function (contextPath) {
        app.data.contextPath = contextPath;
    },

    getMessageCount: function () {
        $.get(app.URL.getMessageCountUrl(),function(res){
            if(res && res['status'] == 1) {

                var data = res['data'];
                console.log(data);
                if(data > 0) {
                    $("#message_count").val(data);
                    $("#message_count").show();
                } else {
                    $("#message_count").val("");
                    $("#message_count").hide();
                }
            }
        },"json")
    },



}