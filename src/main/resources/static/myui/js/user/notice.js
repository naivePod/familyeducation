var notice = {
    init : function () {
        $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
            // 获取已激活的标签页的名称
            var activeTab = $(e.target).text().trim();
            // 获取前一个激活的标签页的名称
            if(activeTab == "未读消息") {

                $.getJSON(app.URL.getUnreadMessagesUrl(), function (result, status) {
                    var v = new Vue({
                        el: '#unread',
                        data: {
                            messages: result['data']
                        }
                    })
                    console.log(result['data'].createTime);
                });
            } else if(activeTab == "已读消息"){
                $.getJSON(app.URL.getAllMessagesUrl(), function (result, status) {
                    var v = new Vue({
                        el: '#read',
                        data: {
                            messages: result['data']
                        }
                    })
                });
            }
        });
        $.getJSON(app.URL.getUnreadMessagesUrl(), function (result, status) {
            console.log(result);
            var v = new Vue({
                el: '#unread',
                data: {
                    messages: result['data']
                }
            })
            console.log(result['data'].createTime);
        });

    }
}