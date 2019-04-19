function getMessageCount() {
    $.ajax({
        type:"get",
        url:"/user/communication/findunread",
        type:"json",
        success:function(res){
            var data = res.data;
            console.log(data);
            if(data > 0) {
                $("message_count").html(data);
                $("message_count").show();
            } else {
                $("message_count").html("");
                $("message_count").hide();
            }
        }

    });

}
$(function(){

    var interval = setInterval( getMessageCount(),3000); //每个五秒调用一次函数

})

