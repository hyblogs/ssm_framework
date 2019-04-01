/** 页面初始化加载 */
avalon.ready(function(){
    //初始化列表数据
    vm.findSysNotice();
})
//初始化layer分页插件
var laypage = layui.laypage;

/**
 * Avalon展示公告信息列表
 */
var vm = avalon.define({
    $id: "sysNotice",
    sysNoticeList: [],
    sysNoticeCurrentPage: 0,
    sysNoticePageSize: 10,
    sysNoticeTotal: 0,
    sysNoticeTotalPage: 0,
    sysNoticeSearchParams: {
        currentPage: 1,
        pageSize: PAGESIZE,
        noticeTitle: '',
        noticeContent: '',
        noticeState: ''
    },
    addSysNotice: function (el) {
        //清空弹窗内容
        vmEdit.clearEditLayer();
        //区别新增或修改
        vmEdit.addOrEdit = 1;
        //弹窗编辑公告信息
        layer.open({
            type: 1,
            title: ['编辑公告信息', 'font-size:16px;'],
            area: ['90%', '90%'],
            content: $('#editSysNotice'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function(){
                //右上角关闭回调--隐藏弹框
                $('#editSysNotice').hide();
            },
            end: function () {
                //右上角关闭回调--隐藏弹框
                $('#editSysNotice').hide();
            }
        });
    },
    findSysNotice: function () {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //初始化页号
        vm.sysNoticeSearchParams.currentPage = 1;
        $.getJSON("/sysNotice/v1/getSysNoticeByPage",vm.sysNoticeSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysNoticeList.removeAll();
                    vm.sysNoticeTotalPage = 0;
                    vm.sysNoticeCurrentPage = 1;
                    vm.sysNoticeTotal = 0;
                } else {
                    vm.sysNoticeList.removeAll();
                    vm.sysNoticeList.pushArray(data.responseObj.list);
                    vm.sysNoticeTotalPage = data.responseObj.pages;
                    vm.sysNoticeCurrentPage = data.responseObj.pageNum;
                    vm.sysNoticeTotal = data.responseObj.total;
                }
                //分页
                laypage.render({
                    elem: 'sysNoticePage',
                    count: vm.sysNoticeTotal, //数据总数，从服务端得到
                    limit: vm.sysNoticeSearchParams.pageSize,//每页数据量
                    theme: '#03b6fd',
                    jump: function(obj, first) {
                        //首次不执行
                        if(!first){
                            vm.getSysNoticeByPage(obj.curr);
                        }
                    }
                });
            } else {
                layer.alert('提交失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title:'温馨提示'
                })
            }
        })
    },
    getSysNoticeByPage: function(page) {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //设置页号
        vm.sysNoticeSearchParams.currentPage = page;
        $.getJSON("/sysNotice/v1/getSysNoticeByPage",vm.sysNoticeSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysNoticeList.removeAll();
                    vm.sysNoticeTotalPage = 0;
                    vm.sysNoticeCurrentPage = 1;
                    vm.sysNoticeTotal = 0;
                } else {
                    vm.sysNoticeList.removeAll();
                    vm.sysNoticeList.pushArray(data.responseObj.list);
                    vm.sysNoticeTotalPage = data.responseObj.pages;
                    vm.sysNoticeCurrentPage = data.responseObj.pageNum;
                    vm.sysNoticeTotal = data.responseObj.total;
                }
            } else {
                layer.alert('提交失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title:'温馨提示'
                })
            }
        })
    },
    delSysNoticeById: function (sysNoticeId) {
        if (isEmpty(sysNoticeId)) {
            layer.alert('获取要删除的数据失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
        } else {
            //询问是否确定删除公告信息
            layer.confirm('您确定要删除该公告信息吗？', {
                btn: ['确定','取消'], //按钮
                icon: 3,
                title:'温馨提示'
            }, function(index){
                layer.close(index);
                //layer加载层-设定最长等待5秒
                var index_0 = layer.load(1, {time: 5*1000});
                //发送异步请求
                $.ajax({
                    type: "post",
                    url: "/sysNotice/v1/delSysNotice",
                    data: {_method:"DELETE", sysNoticeId: sysNoticeId},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        if (data.responseCode == 200) {
                            layer.alert('删除公告信息成功!', {
                                icon: 6,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                            //刷新公告信息列表
                            vm.findSysNotice();
                        } else {
                            layer.alert('删除公告信息失败，请稍后重试!', {
                                icon: 5,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                        }
                    },
                    error: function () {
                        layer.close(index_0);
                        layer.alert('删除公告信息失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                    }
                })
            }, function(index){
                layer.close(index);
            });
        }
    },
    editSysNoticeById: function (sysNoticeId) {
        if (isEmpty(sysNoticeId)) {
            layer.alert('获取要修改的数据失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
        } else {
            //layer加载层-设定最长等待5秒
            var index = layer.load(1, {time: 5*1000});
            $.ajax({
                type: "get",
                url: "/sysNotice/v1/getSysNoticeList",
                data: {id: sysNoticeId},
                traditional: true,
                datatype: "json",
                success: function (data) {
                    layer.close(index);
                    //是否获取数据失败
                    var faild = true;
                    if (data.responseCode == 200) {
                        if (!isEmpty(data.responseObj)) {
                            //清空编辑框中的公告信息
                            vmEdit.clearEditLayer();
                            //获取数据成功
                            faild = false;
                            var sysNotice = data.responseObj[0];
                            //删除多余的属性
                            delete sysNotice.createTime;
                            delete sysNotice.updateTime;
                            //区别新增或者修改
                            vmEdit.addOrEdit = 0;
                            //给弹窗赋值
                            vmEdit.sysNotice = sysNotice;
                            //弹窗编辑公告信息
                            layer.open({
                                type: 1,
                                title: ['编辑公告信息', 'font-size:16px;'],
                                area: ['90%', '90%'],
                                content: $('#editSysNotice'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                                cancel: function(){
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysNotice').hide();
                                },
                                end: function () {
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysNotice').hide();
                                }
                            });
                        }
                    }
                    //获取数据失败
                    if (faild) {
                        layer.alert('获取公告信息失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                    }
                },
                error: function () {
                    layer.close(index);
                    layer.alert('获取公告信息失败，请稍后重试!', {
                        icon: 5,
                        skin: 'layer-ext-moon',
                        title:'温馨提示'
                    })
                }
            })
        }
    },
    changeState: function (id, state) {
        if (isEmpty(id) || isNaN(state)) {
            layer.alert('数据异常，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
        } else {
            //新状态
            var newState = '';
            var newStateStr = '';
            if (state == 0) {
                newState = 1;
                newStateStr = '有效';
            } else if (state == 1) {
                newState = 0;
                newStateStr = '无效';
            }
            //询问是否确定修改公告状态
            layer.confirm('您确定要修改该公告状态为[' +newStateStr+ ']吗？', {
                btn: ['确定','取消'], //按钮
                icon: 3,
                title:'温馨提示'
            }, function(index){
                layer.close(index);
                //layer加载层-设定最长等待5秒
                var index_0 = layer.load(1, {time: 5*1000});
                //提交地址
                var url = "/sysNotice/v1/editSysNotice";
                //异步提交数据
                $.ajax({
                    type: "post",
                    url: url,
                    data: {id: id, noticeState: newState},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        if (data.responseCode == 200) {
                            //关闭弹窗
                            layer.closeAll();
                            layer.alert('提交成功!', {
                                icon: 6,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                            //刷新公告信息列表
                            vm.findSysNotice();
                        } else {
                            layer.alert('提交失败，请稍后重试!', {
                                icon: 5,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                        }
                    },
                    error: function () {
                        layer.close(index_0);
                        layer.alert('提交失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                    }
                })
            }, function(index){
                layer.close(index);
            });
        }
    }
})


/**
 * Avalon编辑公告信息
 */
var vmEdit = avalon.define({
    $id: "editSysNotice",
    addOrEdit: 1,//1-add;0-edit
    sysNotice: {
        id: 0,
        noticeTitle: '',
        noticeContent: '',
        noticeState: -1,
        remark: ''
    },
    clearEditLayer: function () {
        this.sysNotice.id = null;
        this.sysNotice.noticeTitle = '';
        this.sysNotice.noticeContent = '';
        this.sysNotice.noticeState = -1;
        this.sysNotice.remark = '';
    },
    subSysNotice: function (el) {
        if (isEmpty(this.sysNotice.noticeTitle) || isEmpty(this.sysNotice.noticeContent)) {
            layer.alert('请填写完整的公告信息!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            });
            return false;
        }
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //提交地址
        var url = "";
        //判断是新增还是修改
        if (this.addOrEdit == 1) {
            url = "/sysNotice/v1/saveSysNotice";
        } else {
            url = "/sysNotice/v1/editSysNotice";
        }
        //异步提交数据
        $.ajax({
            type: "post",
            url: url,
            data: this.sysNotice,
            traditional: true,
            datatype: "json",
            success: function (data) {
                layer.close(index);
                if (data.responseCode == 200) {
                    //关闭弹窗
                    layer.closeAll();
                    layer.alert('提交成功!', {
                        icon: 6,
                        skin: 'layer-ext-moon',
                        title:'温馨提示'
                    })
                    //刷新栏目信息列表
                    vm.findSysNotice();
                } else {
                    layer.alert(data.responseText, {
                        icon: 5,
                        skin: 'layer-ext-moon',
                        title:'温馨提示'
                    })
                }
            },
            error: function () {
                layer.close(index);
                layer.alert('提交失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title:'温馨提示'
                })
            }
        })
    }
});

