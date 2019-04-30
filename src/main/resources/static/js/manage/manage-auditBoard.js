/**
 * 模块化JavaScript
 **/
var manageAuditBoardPage = {
    data:{
        pageNum: 0,
        pageSize: 0,
        totalPageNum: 0,
        totalPageSize: 0,
        subjects: [],
    },
    init: function (pageNum, pageSize, totalPageNum, totalPageSize, audits) {
        manageAuditBoardPage.data.pageNum = pageNum;
        manageAuditBoardPage.data.pageSize = pageSize;
        manageAuditBoardPage.data.totalPageNum = totalPageNum;
        manageAuditBoardPage.data.totalPageSize = totalPageSize;
        manageAuditBoardPage.data.audits = audits;
        //分页初始化
        manageAuditBoardPage.subPageMenuInit();


        //查看审核信息，取消
        $('#cancelUpdateAuditBtn').click(function(){
            $("#updateAuditModal").modal('hide');
        });

        //更新审核状态，通过
        $('#confirmUpdateAuditBtn').click(function(){
            var index = $('#updateAuditIndex');
            manageAuditBoardPage.updateAuditAction(index, 1);
        });
        //更新审核状态，未通过
        $('#failAuditBtn').click(function(){
            var index = $('#updateAuditIndex');
            manageAuditBoardPage.updateAuditAction(index, 2);
        });
    },
    firstPage: function () {
        window.location.href = app.URL.manageAuditListUrl() + '?page=1';
    },
    prevPage: function () {
        window.location.href = app.URL.manageAuditListUrl() + '?page=' + (pageNum-1);
    },
    targetPage: function (page) {
        window.location.href = app.URL.manageAuditListUrl() + '?page=' + page;
    },
    nextPage: function () {
        window.location.href = app.URL.manageAuditListUrl() + '?page=' + (pageNum+1);
    },
    lastPage: function () {
        window.location.href = app.URL.manageAuditListUrl() + '?page=' + manageAuditBoardPage.data.totalPageNum;
    },
    subPageMenuInit: function(){
        var subPageStr = '<ul class="pagination">';
        if (manageAuditBoardPage.data.pageNum == 1) {
            subPageStr += '<li class="disabled"><a><span>首页</span></a></li>';
            subPageStr += '<li class="disabled"><a><span>上一页</span></a></li>';
        } else {
            subPageStr += '<li><a onclick="manageAuditBoardPage.firstPage()"><span>首页</span></a></li>';
            subPageStr += '<li><a onclick="manageAuditBoardPage.prevPage()"><span>上一页</span></a></li>';
        }
        var startPage = (manageAuditBoardPage.data.pageNum-4 > 0 ? manageAuditBoardPage.data.pageNum-4 : 1);
        var endPage = (startPage+7 > manageAuditBoardPage.data.totalPageNum ? manageAuditBoardPage.data.totalPageNum : startPage+7);
        console.log('startPage = ' + startPage);
        console.log('endPage = ' + endPage);
        console.log('pageNum = ' + manageAuditBoardPage.data.pageNum);
        console.log('totalPageNum = ' + manageAuditBoardPage.data.totalPageNum);
        for (var i = startPage; i <= endPage; i++) {
            if (i == manageAuditBoardPage.data.pageNum) {
                subPageStr += '<li class="active"><a onclick="manageAuditBoardPage.targetPage('+i+')">'+i+'</a></li>';
            } else {
                subPageStr += '<li><a onclick="manageAuditBoardPage.targetPage('+i+')">'+i+'</a></li>';
            }
        }
        if (manageAuditBoardPage.data.pageNum == manageAuditBoardPage.data.totalPageNum) {
            subPageStr += '<li class="disabled"><a><span>下一页</span></a></li>';
            subPageStr += '<li class="disabled"><a><span>末页</span></a></li>';
        } else {
            subPageStr += '<li><a onclick="manageAuditBoardPage.nextPage()"><span>下一页</span></a></li>';
            subPageStr += '<li><a onclick="manageAuditBoardPage.lastPage()"><span>末页</span></a></li>';
        }
        $('#subPageHead').html(subPageStr);
    },
    initAddSubjectData: function () {
        //初始化数据
        $('#subjectName').text("");
    },

    //查看详细审核信息
    updateAuditModalAction: function (index) {
        //编辑考试，弹出编辑窗口
        //console.log(index);
        //输入框初始化数据
        manageAuditBoardPage.initUpdateAuditData(index);
        $("#updateAuditModal").modal({
            keyboard : false,
            show : true,
            backdrop : "static"
        });
    },
    initUpdateAuditData: function (index) {
        //初始化数据
        var audits = manageAuditBoardPage.data.audits;
        console.log(audits);
        $("#showPhoto").attr ("src", app.URL.getImgPrex()+audits[index].photo);
        $("#showVerifiedImg").attr ("src", app.URL.getImgPrex()+audits[index].auditImage);
        $('#updateAuditIndex').text(index);
        $('#showUsername').text(audits[index].username);
        console.log(audits[index].username);
        $('#showAge').text(audits[index].age);
        $('#showSex').text(audits[index].sex);
        $('#showRealName').text(audits[index].realName);
        $('#showDiploma').text(audits[index].diploma);
        $('#showCity').text(audits[index].city);
        $('#showStatus').text(app.formatAuditStatus(audits[index].status));
    },
    checkUpdateSubjectData: function (subjectName) {
        return true;
    },
    updateAuditAction: function (index,status) {
        var audits = manageAuditBoardPage.data.audits;

        if (!index) {
            console.log(audits[index].id);
            $.ajax({
                url : app.URL.updateAuditUrl(),
                type : "post",
                dataType: "json",
                contentType : "application/json;charset=UTF-8",
                <!-- 向后端传输的数据 -->
                data: {
                    id:audits[index].id,
                    status:status
                },
                success:function(result) {
                    if (result && result['status']) {
                        // 验证通过 刷新页面
                        window.location.reload();
                    } else {
                        console.log(result.message);
                    }
                },
                error:function(result){
                    console.log(result.message);
                }
            });
        }
    },
    deleteSubjectAction: function (index) {
        $.ajax({
            url : app.URL.deleteSubjectUrl()+index,
            type : "DELETE",
            dataType: "json",
            contentType : "application/json;charset=UTF-8",
            success:function(result) {
                if (result && result['success']) {
                    // 验证通过 刷新页面
                    window.location.reload();
                } else {
                    console.log(result.message);
                }
            },
            error:function(result){
                console.log(result.message);
            }
        });
    }


};