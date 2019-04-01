/** 页面初始化加载 */
avalon.ready(function(){
    //初始化列表数据
    vm.findSysAppInfo();
})
//初始化layer分页插件
var laypage = layui.laypage;

/**
 * Avalon展示系统信息列表
 */
var vm = avalon.define({
    $id: "sysAppInfo",
    sysAppInfoList: [],
    sysAppInfoCurrentPage: 0,
    sysAppInfoPageSize: 10,
    sysAppInfoTotal: 0,
    sysAppInfoTotalPage: 0,
    sysAppInfoSearchParams: {
        currentPage: 1,
        pageSize: PAGESIZE,
        sysName: '',
        sysNameShort: '',
        state: ''
    },
    addSysAppInfo: function (el) {
        //清空弹窗内容
        vmEdit.clearEditLayer();
        //区别新增或修改
        vmEdit.addOrEdit = 1;
        //弹窗编辑系统信息
        layer.open({
            type: 1,
            title: ['编辑系统信息', 'font-size:16px;'],
            area: ['90%', '90%'],
            content: $('#editSysAppInfo'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function(){
                //右上角关闭回调--隐藏弹框
                $('#editSysAppInfo').hide();
            },
            end: function () {
                //右上角关闭回调--隐藏弹框
                $('#editSysAppInfo').hide();
            }
        });
    },
    findSysAppInfo: function () {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //初始化页号
        vm.sysAppInfoSearchParams.currentPage = 1;
        $.getJSON("/sysAppInfo/v1/getSysAppInfoByPage",vm.sysAppInfoSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysAppInfoList.removeAll();
                    vm.sysAppInfoTotalPage = 0;
                    vm.sysAppInfoCurrentPage = 1;
                    vm.sysAppInfoTotal = 0;
                } else {
                    vm.sysAppInfoList.removeAll();
                    vm.sysAppInfoList.pushArray(data.responseObj.list);
                    vm.sysAppInfoTotalPage = data.responseObj.pages;
                    vm.sysAppInfoCurrentPage = data.responseObj.pageNum;
                    vm.sysAppInfoTotal = data.responseObj.total;
                }
                //分页
                laypage.render({
                    elem: 'sysAppInfoPage',
                    count: vm.sysAppInfoTotal, //数据总数，从服务端得到
                    limit: vm.sysAppInfoSearchParams.pageSize,//每页数据量
                    theme: '#03b6fd',
                    jump: function(obj, first) {
                        //首次不执行
                        if(!first){
                            vm.getSysAppInfoByPage(obj.curr);
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
    getSysAppInfoByPage: function(page) {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //设置页号
        vm.sysAppInfoSearchParams.currentPage = page;
        $.getJSON("/sysAppInfo/v1/getSysAppInfoByPage",vm.sysAppInfoSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysAppInfoList.removeAll();
                    vm.sysAppInfoTotalPage = 0;
                    vm.sysAppInfoCurrentPage = 1;
                    vm.sysAppInfoTotal = 0;
                } else {
                    vm.sysAppInfoList.removeAll();
                    vm.sysAppInfoList.pushArray(data.responseObj.list);
                    vm.sysAppInfoTotalPage = data.responseObj.pages;
                    vm.sysAppInfoCurrentPage = data.responseObj.pageNum;
                    vm.sysAppInfoTotal = data.responseObj.total;
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
    delSysAppInfoById: function (sysAppInfoId) {
        if (isEmpty(sysAppInfoId)) {
            layer.alert('获取要删除的数据失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
        } else {
            //询问是否确定删除系统信息
            layer.confirm('您确定要删除该系统信息吗？', {
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
                    url: "/sysAppInfo/v1/delSysAppInfo",
                    data: {sysAppInfoId: sysAppInfoId},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        layer.alert('删除系统信息成功!', {
                            icon: 6,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                        //刷新系统信息列表
                        vm.findSysAppInfo();
                    },
                    error: function () {
                        layer.close(index_0);
                        layer.alert('删除系统信息失败，请稍后重试!', {
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
    editSysAppInfoById: function (sysAppInfoId) {
        if (isEmpty(sysAppInfoId)) {
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
                url: "/sysAppInfo/v1/getSysAppInfoList",
                data: {id: sysAppInfoId},
                traditional: true,
                datatype: "json",
                success: function (data) {
                    layer.close(index);
                    //是否获取数据失败
                    var faild = true;
                    if (data.responseCode == 200) {
                        if (!isEmpty(data.responseObj)) {
                            //清空编辑框中的系统信息
                            vmEdit.clearEditLayer();
                            //获取数据成功
                            faild = false;
                            var sysAppInfo = data.responseObj[0];
                            //删除多余的属性
                            delete sysAppInfo.createTime;
                            delete sysAppInfo.updateTime;
                            //区别新增或者修改
                            vmEdit.addOrEdit = 0;
                            //给弹窗赋值
                            vmEdit.sysAppInfo = sysAppInfo;
                            //弹窗编辑系统信息
                            layer.open({
                                type: 1,
                                title: ['编辑系统信息', 'font-size:16px;'],
                                area: ['90%', '90%'],
                                content: $('#editSysAppInfo'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                                cancel: function(){
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysAppInfo').hide();
                                },
                                end: function () {
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysAppInfo').hide();
                                }
                            });
                        }
                    }
                    //获取数据失败
                    if (faild) {
                        layer.alert('获取系统信息失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                    }
                },
                error: function () {
                    layer.close(index);
                    layer.alert('获取系统信息失败，请稍后重试!', {
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
            //询问是否确定修改系统状态
            layer.confirm('您确定要修改该系统状态为' +newStateStr+ '吗？', {
                btn: ['确定','取消'], //按钮
                icon: 3,
                title:'温馨提示'
            }, function(index){
                layer.close(index);
                //layer加载层-设定最长等待5秒
                var index_0 = layer.load(1, {time: 5*1000});
                //提交地址
                var url = "/sysAppInfo/v1/editSysAppInfo";
                //异步提交数据
                $.ajax({
                    type: "post",
                    url: url,
                    data: {id: id, state: newState},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        //关闭弹窗
                        layer.closeAll();
                        layer.alert('提交成功!', {
                            icon: 6,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                        //刷新系统信息列表
                        vm.findSysAppInfo();
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
 * Avalon编辑系统信息
 */
var vmEdit = avalon.define({
    $id: "editSysAppInfo",
    addOrEdit: 1,//1-add;0-edit
    sysRoleList: [],
    sysAppInfo: {
        id: 0,
        sysName: '',
        sysNameShort: '',
        sysCode: '',
        sysLogo: '',
        sysRecords: '',
        sysBackUrl: '',
        sysSiteUrl: '',
        state: 0,
        sysDesc: ''
    },
    clearEditLayer: function () {
        this.sysAppInfo.id = null;
        this.sysAppInfo.sysName = '';
        this.sysAppInfo.sysNameShort = '';
        this.sysAppInfo.sysCode = '';
        this.sysAppInfo.sysLogo = '';
        this.sysAppInfo.sysRecords = '';
        this.sysAppInfo.sysBackUrl = '';
        this.sysAppInfo.sysSiteUrl = '';
        this.sysAppInfo.state = 0;
        this.sysAppInfo.sysDesc = '';
    },
    subSysAppInfo: function (el) {
        if (isEmpty(this.sysAppInfo.sysName)) {
            layer.alert('请填写完整的系统信息!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
            return false;
        }
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //提交地址
        var url = "";
        //判断是新增还是修改
        if (this.addOrEdit == 1) {
            url = "/sysAppInfo/v1/saveSysAppInfo";
        } else {
            url = "/sysAppInfo/v1/editSysAppInfo";
        }
        //异步提交数据
        $.ajax({
            type: "post",
            url: url,
            data: this.sysAppInfo,
            traditional: true,
            datatype: "json",
            success: function (data) {
                layer.close(index);
                //关闭弹窗
                layer.closeAll();
                layer.alert('提交成功!', {
                    icon: 6,
                    skin: 'layer-ext-moon',
                    title:'温馨提示'
                })
                //刷新栏目信息列表
                vm.findSysAppInfo();
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
})

