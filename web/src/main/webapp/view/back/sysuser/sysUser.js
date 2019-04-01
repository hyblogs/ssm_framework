/** 页面初始化加载 */
avalon.ready(function(){
    //初始化列表数据
    vm.findSysUser();
    //初始化系统角色列表
    vmEdit.getSysRole();
})
//初始化layer分页插件
var laypage = layui.laypage;

/**
 * Avalon展示用户信息列表
 */
var vm = avalon.define({
    $id: "sysUser",
    sysUserList: [],
    sysUserCurrentPage: 0,
    sysUserPageSize: 10,
    sysUserTotal: 0,
    sysUserTotalPage: 0,
    sysRoleList: [],
    sysUserSearchParams: {
        currentPage: 1,
        pageSize: PAGESIZE,
        sysUserName: '',
        sysUserNick: '',
        mobile: '',
        email: '',
        auditState: '',
        isLogin: '',
        state: '',
        roleId: '',
        isOpenLoginCheck: ''
    },
    addSysUser: function (el) {
        //清空弹窗内容
        vmEdit.clearEditLayer();
        //加载系统角色信息
        vmEdit.getSysRole();
        //区别新增或修改
        vmEdit.addOrEdit = 1;
        //弹窗编辑用户信息
        layer.open({
            type: 1,
            title: ['编辑用户信息', 'font-size:16px;'],
            area: ['90%', '90%'],
            content: $('#editSysUser'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function(){
                //右上角关闭回调--隐藏弹框
                $('#editSysUser').hide();
            },
            end: function () {
                //右上角关闭回调--隐藏弹框
                $('#editSysUser').hide();
            }
        });
    },
    findSysUser: function () {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //初始化页号
        vm.sysUserSearchParams.currentPage = 1;
        $.getJSON("/sysUser/v1/getSysUserByPage",vm.sysUserSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysUserList.removeAll();
                    vm.sysUserTotalPage = 0;
                    vm.sysUserCurrentPage = 1;
                    vm.sysUserTotal = 0;
                } else {
                    vm.sysUserList.removeAll();
                    vm.sysUserList.pushArray(data.responseObj.list);
                    vm.sysUserTotalPage = data.responseObj.pages;
                    vm.sysUserCurrentPage = data.responseObj.pageNum;
                    vm.sysUserTotal = data.responseObj.total;
                }
                //分页
                laypage.render({
                    elem: 'sysUserPage',
                    count: vm.sysUserTotal, //数据总数，从服务端得到
                    limit: vm.sysUserSearchParams.pageSize,//每页数据量
                    theme: '#03b6fd',
                    jump: function(obj, first) {
                        //首次不执行
                        if(!first){
                            vm.getSysUserByPage(obj.curr);
                        }
                    }
                });
            } else {
                layer.alert('获取数据失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title:'温馨提示'
                })
            }
        })
    },
    getSysUserByPage: function(page) {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //设置页号
        vm.sysUserSearchParams.currentPage = page;
        $.getJSON("/sysUser/v1/getSysUserByPage",vm.sysUserSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysUserList.removeAll();
                    vm.sysUserTotalPage = 0;
                    vm.sysUserCurrentPage = 1;
                    vm.sysUserTotal = 0;
                } else {
                    vm.sysUserList.removeAll();
                    vm.sysUserList.pushArray(data.responseObj.list);
                    vm.sysUserTotalPage = data.responseObj.pages;
                    vm.sysUserCurrentPage = data.responseObj.pageNum;
                    vm.sysUserTotal = data.responseObj.total;
                }
            } else {
                layer.alert('获取数据失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title:'温馨提示'
                })
            }
        })
    },
    delSysUserById: function (sysUserId) {
        if (isEmpty(sysUserId)) {
            layer.alert('获取要删除的数据失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
        } else {
            //询问是否确定删除用户信息
            layer.confirm('您确定要删除该用户信息吗？', {
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
                    url: "/sysUser/v1/delSysUser",
                    data: {sysUserId: sysUserId},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        if (data.responseCode == 200) {
                            layer.alert('删除用户信息成功!', {
                                icon: 6,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                            //刷新用户信息列表
                            vm.findSysUser();
                        } else {
                            layer.alert('删除用户信息失败，请稍后重试!', {
                                icon: 5,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                        }
                    },
                    error: function () {
                        layer.close(index_0);
                        layer.alert('删除用户信息失败，请稍后重试!', {
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
    editSysUserById: function (sysUserId) {
        if (isEmpty(sysUserId)) {
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
                url: "/sysUser/v1/getSysUserList",
                data: {id: sysUserId},
                traditional: true,
                datatype: "json",
                success: function (data) {
                    layer.close(index);
                    //是否获取数据失败
                    var faild = true;
                    if (data.responseCode == 200) {
                        if (!isEmpty(data.responseObj)) {
                            //清空编辑框中的用户信息
                            vmEdit.clearEditLayer();
                            //弹窗编辑用户信息
                            layer.open({
                                type: 1,
                                title: ['编辑用户信息', 'font-size:16px;'],
                                area: ['90%', '90%'],
                                content: $('#editSysUser'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                                cancel: function(){
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysUser').hide();
                                },
                                end: function () {
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysUser').hide();
                                }
                            });
                            //加载系统角色信息
                            vmEdit.getSysRole();
                            //获取数据成功
                            faild = false;
                            setTimeout(vm.showEditSysUser(data.responseObj[0]),500);
                        }
                    }
                    //获取数据失败
                    if (faild) {
                        layer.alert('获取用户信息失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                    }
                },
                error: function () {
                    layer.close(index);
                    layer.alert('获取用户信息失败，请稍后重试!', {
                        icon: 5,
                        skin: 'layer-ext-moon',
                        title:'温馨提示'
                    })
                }
            })
        }
    },
    showEditSysUser: function(sysUser) {
        //删除多余的属性
        delete sysUser.createTime;
        delete sysUser.updateTime;
        delete sysUser.password;
        delete sysUser.salt;
        delete sysUser.auditTime;
        delete sysUser.isLogin;
        //区别新增或者修改
        vmEdit.addOrEdit = 0;
        //给弹窗赋值
        vmEdit.sysUser = sysUser;
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
            //询问是否确定修改用户状态
            layer.confirm('您确定要修改该用户状态为' +newStateStr+ '吗？', {
                btn: ['确定','取消'], //按钮
                icon: 3,
                title:'温馨提示'
            }, function(index){
                layer.close(index);
                //layer加载层-设定最长等待5秒
                var index_0 = layer.load(1, {time: 5*1000});
                //提交地址
                var url = "/sysUser/v1/editSysUser";
                //异步提交数据
                $.ajax({
                    type: "post",
                    url: url,
                    data: {id: id, state: newState},
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
                            //刷新用户信息列表
                            vm.findSysUser();
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
 * Avalon编辑用户信息
 */
var vmEdit = avalon.define({
    $id: "editSysUser",
    addOrEdit: 1,//1-add;0-edit
    sysRoleList: [],
    sysUser: {
        id: 0,
        sysUserName: '',
        sysUserNick: '',
        password: '',
        mobile: '',
        email: '',
        sex: -1,
        age: 18,
        idNumber: '',
        auditState: -1,
        isOpenLoginCheck: 0,
        state: 0,
        roleId: '',
        remark: ''
    },
    clearEditLayer: function () {
        this.sysUser.id = null;
        this.sysUser.sysUserName = '';
        this.sysUser.sysUserNick = '';
        this.sysUser.password = '';
        this.sysUser.mobile = '';
        this.sysUser.email = '';
        this.sysUser.sex = 1;
        this.sysUser.age = 18;
        this.sysUser.idNumber = '';
        this.sysUser.auditState = 0;
        this.sysUser.isOpenLoginCheck = 0;
        this.sysUser.state = 0;
        this.sysUser.roleId = '';
        this.sysUser.remark = '';
    },
    subSysUser: function (el) {
        if (isEmpty(this.sysUser.sysUserName) || isEmpty(this.sysUser.mobile)) {
            layer.alert('请填写完整的用户信息!', {
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
            url = "/sysUser/v1/saveSysUser";
        } else {
            url = "/sysUser/v1/editSysUser";
        }
        //异步提交数据
        $.ajax({
            type: "post",
            url: url,
            data: this.sysUser,
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
                    vm.findSysUser();
                } else {
                    layer.alert('提交失败，请稍后重试!', {
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
    },
    getSysRole: function () {
        $.getJSON("/sysRole/v1/getSysRoleList",{},function(data){
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vmEdit.sysRoleList.removeAll();
                    vm.sysRoleList.removeAll();
                } else {
                    vmEdit.sysRoleList.removeAll();
                    vmEdit.sysRoleList.pushArray(data.responseObj);
                    vm.sysRoleList.removeAll();
                    vm.sysRoleList.pushArray(data.responseObj);
                }
            } else {
                layer.alert('获取系统角色信息失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title:'温馨提示'
                })
            }
        })
    }
})

