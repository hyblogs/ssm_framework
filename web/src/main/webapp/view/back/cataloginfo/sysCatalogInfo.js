/** 页面初始化加载 */
avalon.ready(function(){
    //初始化列表数据
    vm.findSysCatalogInfo();
})
//初始化layer分页插件
var laypage = layui.laypage;

/**
 * Avalon展示菜单信息列表
 */
var vm = avalon.define({
    $id: "sysCatalogInfo",
    sysCatalogInfoList: [],
    sysCatalogInfoCurrentPage: 0,
    sysCatalogInfoPageSize: 10,
    sysCatalogInfoTotal: 0,
    sysCatalogInfoTotalPage: 0,
    sysCatalogInfoSearchParams: {
        currentPage: 1,
        pageSize: PAGESIZE,
        catalogName: '',
        catalogType: '',
        catalogState: ''
    },
    addSysCatalogInfo: function (el) {
        //清空弹窗内容
        vmEdit.clearEditLayer();
        //区别新增或修改
        vmEdit.addOrEdit = 1;
        //弹窗编辑菜单信息
        layer.open({
            type: 1,
            title: ['编辑菜单信息', 'font-size:16px;'],
            area: ['90%', '90%'],
            content: $('#editSysCatalogInfo'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function(){
                //右上角关闭回调--隐藏弹框
                $('#editSysCatalogInfo').hide();
            },
            end: function () {
                //右上角关闭回调--隐藏弹框
                $('#editSysCatalogInfo').hide();
            }
        });
    },
    findSysCatalogInfo: function () {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //初始化页号
        vm.sysCatalogInfoSearchParams.currentPage = 1;
        $.getJSON("/sysCatalogInfo/v1/getSysCatalogInfoByPage",vm.sysCatalogInfoSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysCatalogInfoList.removeAll();
                    vm.sysCatalogInfoTotalPage = 0;
                    vm.sysCatalogInfoCurrentPage = 1;
                    vm.sysCatalogInfoTotal = 0;
                } else {
                    vm.sysCatalogInfoList.removeAll();
                    vm.sysCatalogInfoList.pushArray(data.responseObj.list);
                    vm.sysCatalogInfoTotalPage = data.responseObj.pages;
                    vm.sysCatalogInfoCurrentPage = data.responseObj.pageNum;
                    vm.sysCatalogInfoTotal = data.responseObj.total;
                }
                //分页
                laypage.render({
                    elem: 'sysCatalogInfoPage',
                    count: vm.sysCatalogInfoTotal, //数据总数，从服务端得到
                    limit: vm.sysCatalogInfoSearchParams.pageSize,//每页数据量
                    theme: '#03b6fd',
                    jump: function(obj, first) {
                        //首次不执行
                        if(!first){
                            vm.getSysCatalogInfoByPage(obj.curr);
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
    getSysCatalogInfoByPage: function(page) {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //设置页号
        vm.sysCatalogInfoSearchParams.currentPage = page;
        $.getJSON("/sysCatalogInfo/v1/getSysCatalogInfoByPage",vm.sysCatalogInfoSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysCatalogInfoList.removeAll();
                    vm.sysCatalogInfoTotalPage = 0;
                    vm.sysCatalogInfoCurrentPage = 1;
                    vm.sysCatalogInfoTotal = 0;
                } else {
                    vm.sysCatalogInfoList.removeAll();
                    vm.sysCatalogInfoList.pushArray(data.responseObj.list);
                    vm.sysCatalogInfoTotalPage = data.responseObj.pages;
                    vm.sysCatalogInfoCurrentPage = data.responseObj.pageNum;
                    vm.sysCatalogInfoTotal = data.responseObj.total;
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
    delSysCatalogInfoById: function (sysCatalogInfoId) {
        if (isEmpty(sysCatalogInfoId)) {
            layer.alert('获取要删除的数据失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
        } else {
            //询问是否确定删除菜单信息
            layer.confirm('您确定要删除该菜单信息吗？', {
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
                    url: "/sysCatalogInfo/v1/delSysCatalogInfo",
                    data: {_method:"DELETE", sysCatalogInfoId: sysCatalogInfoId},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        if (data.responseCode == 200) {
                            layer.alert('删除菜单信息成功!', {
                                icon: 6,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                            //刷新菜单信息列表
                            vm.findSysCatalogInfo();
                        } else {
                            layer.alert('删除菜单信息失败，请稍后重试!', {
                                icon: 5,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                        }
                    },
                    error: function () {
                        layer.close(index_0);
                        layer.alert('删除菜单信息失败，请稍后重试!', {
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
    editSysCatalogInfoById: function (sysCatalogInfoId) {
        if (isEmpty(sysCatalogInfoId)) {
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
                url: "/sysCatalogInfo/v1/getSysCatalogInfoList",
                data: {id: sysCatalogInfoId},
                traditional: true,
                datatype: "json",
                success: function (data) {
                    layer.close(index);
                    //是否获取数据失败
                    var faild = true;
                    if (data.responseCode == 200) {
                        if (!isEmpty(data.responseObj)) {
                            //清空编辑框中的菜单信息
                            vmEdit.clearEditLayer();
                            //获取数据成功
                            faild = false;
                            var sysCatalogInfo = data.responseObj[0];
                            //删除多余的属性
                            delete sysCatalogInfo.createTime;
                            delete sysCatalogInfo.updateTime;
                            //区别新增或者修改
                            vmEdit.addOrEdit = 0;
                            //给弹窗赋值
                            vmEdit.sysCatalogInfo = sysCatalogInfo;
                            //弹窗编辑菜单信息
                            layer.open({
                                type: 1,
                                title: ['编辑菜单信息', 'font-size:16px;'],
                                area: ['90%', '90%'],
                                content: $('#editSysCatalogInfo'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                                cancel: function(){
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysCatalogInfo').hide();
                                },
                                end: function () {
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysCatalogInfo').hide();
                                }
                            });
                        }
                    }
                    //获取数据失败
                    if (faild) {
                        layer.alert('获取菜单信息失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                    }
                },
                error: function () {
                    layer.close(index);
                    layer.alert('获取菜单信息失败，请稍后重试!', {
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
            //询问是否确定修改菜单状态
            layer.confirm('您确定要修改该菜单状态为[' +newStateStr+ ']吗？', {
                btn: ['确定','取消'], //按钮
                icon: 3,
                title:'温馨提示'
            }, function(index){
                layer.close(index);
                //layer加载层-设定最长等待5秒
                var index_0 = layer.load(1, {time: 5*1000});
                //提交地址
                var url = "/sysCatalogInfo/v1/editSysCatalogInfo";
                //异步提交数据
                $.ajax({
                    type: "post",
                    url: url,
                    data: {id: id, catalogState: newState},
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
                            //刷新菜单信息列表
                            vm.findSysCatalogInfo();
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
 * Avalon编辑菜单信息
 */
var vmEdit = avalon.define({
    $id: "editSysCatalogInfo",
    addOrEdit: 1,//1-add;0-edit
    sysCatalogInfo: {
        id: 0,
        catalogName: '',
        catalogCode: '',
        catalogState: '',
        catalogIcon: '',
        catalogUrl: '',
        catalogColor: '',
        catalogSort: 0,
        catalogType: '',
        remark: ''
    },
    clearEditLayer: function () {
        this.sysCatalogInfo.id = null;
        this.sysCatalogInfo.catalogName = '';
        this.sysCatalogInfo.catalogCode = '';
        this.sysCatalogInfo.catalogState = '';
        this.sysCatalogInfo.catalogIcon = '';
        this.sysCatalogInfo.catalogUrl = '';
        this.sysCatalogInfo.catalogColor = '';
        this.sysCatalogInfo.catalogSort = 0;
        this.sysCatalogInfo.catalogType = '';
        this.sysCatalogInfo.remark = '';
    },
    subSysCatalogInfo: function (el) {
        if (isEmpty(this.sysCatalogInfo.catalogName) || isEmpty(this.sysCatalogInfo.catalogType)) {
            layer.alert('请填写完整的菜单信息!', {
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
            url = "/sysCatalogInfo/v1/saveSysCatalogInfo";
        } else {
            url = "/sysCatalogInfo/v1/editSysCatalogInfo";
        }
        //异步提交数据
        $.ajax({
            type: "post",
            url: url,
            data: this.sysCatalogInfo,
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
                    vm.findSysCatalogInfo();
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
})

