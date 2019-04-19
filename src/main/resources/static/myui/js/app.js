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
            return app.data.contextPath+"/communication/findunread"
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
                    $("message_count").val(data);
                    $("message_count").show();
                } else {
                    $("message_count").val("");
                    $("message_count").hide();
                }
            }
        },"json")
    },



}