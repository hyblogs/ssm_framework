// zTree 对象
var zTreeObj;
// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
var setting = {
    async: {
        enable: true,//采用异步加载
        url : "/sysColumn/v1/getSysColumnsTree",
        dataType : "json",
        dataFilter: filter  //异步返回后经过Filter
    },
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            isParent: "isParent",
            rootPId:0
        },
        key : {
            title : "text", //鼠标悬停显示的信息
            name : "text" //网页上显示出节点的名称
        },
    },
    view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: false,
        expandSpeed:"fast"
    },
    check:{
        enable: true
    },
    callback: {
        onClick:zTreeOnCheck,   //节点被点击时调用的方法
        onAsyncSuccess: zTreeOnAsyncSuccess //异步加载完成调用
    }
};
/* 获取返回的数据，进行预操作，treeId是treeDemo,异步加载完之后走这个方法，responseData为后台返回数据  */
function filter(treeId, parentNode, responseData) {
    if (!responseData){
        return null;
    }
    return responseData;
}

//异步加载完成时运行，此方法将所有的节点打开
function zTreeOnAsyncSuccess(event, treeId, msg) {
    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    treeObj.expandAll(true);
}

//复选框选中事件，选中的项动态加载到文本框中
function zTreeOnCheck(){
    var zTree = $.fn.zTree.getZTreeObj("treeDemo");
    var nodes = zTree.getCheckedNodes(true);

    var columnIds = "";
    $(nodes).each(function(index, obj) {
        columnIds += obj.id + ",";
    });
    alert(columnIds);
}


//初始化layer分页插件
var laypage = layui.laypage;
/** 页面初始化加载 */
avalon.ready(function(){
    //初始化列表数据
    vm.findSysRole();

    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, null);
})

/**
 * Avalon展示角色信息列表
 */
var vm = avalon.define({
    $id: "sysRole",
    sysRoleList: [],
    sysRoleCurrentPage: 0,
    sysRolePageSize: 10,
    sysRoleTotal: 0,
    sysRoleTotalPage: 0,
    sysRoleSearchParams: {
        currentPage: 1,
        pageSize: PAGESIZE,
        roleName: '',
        roleState: ''
    },
    addSysRole: function (el) {
        //清空弹窗内容
        vmEdit.clearEditLayer();
        //区别新增或修改
        vmEdit.addOrEdit = 1;
        //弹窗编辑角色信息
        layer.open({
            type: 1,
            title: ['编辑角色信息', 'font-size:16px;'],
            area: ['90%', '90%'],
            content: $('#editSysRole'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function(){
                //右上角关闭回调--隐藏弹框
                $('#editSysRole').hide();
            },
            end: function () {
                //右上角关闭回调--隐藏弹框
                $('#editSysRole').hide();
            }
        });
    },
    findSysRole: function () {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //初始化页号
        vm.sysRoleSearchParams.currentPage = 1;
        $.getJSON("/sysRole/v1/getSysRoleByPage",vm.sysRoleSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysRoleList.removeAll();
                    vm.sysRoleTotalPage = 0;
                    vm.sysRoleCurrentPage = 1;
                } else {
                    vm.sysRoleList.removeAll();
                    vm.sysRoleList.pushArray(data.responseObj.list);
                    vm.sysRoleTotalPage = data.responseObj.pages;
                    vm.sysRoleCurrentPage = data.responseObj.pageNum;
                    vm.sysRoleTotal = data.responseObj.total;
                }
                //分页
                laypage.render({
                    elem: 'sysRolePage',
                    count: vm.sysRoleTotal, //数据总数，从服务端得到
                    limit: vm.sysRoleSearchParams.pageSize,//每页数据量
                    theme: '#03b6fd',
                    jump: function(obj, first) {
                        //obj包含了当前分页的所有参数，比如：
                        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                        console.log(obj.limit); //得到每页显示的条数

                        //首次不执行
                        if(!first){
                            //do something
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
    delSysRoleById: function (sysRoleId) {
        if (isEmpty(sysRoleId)) {
            layer.alert('获取要删除的数据失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
        } else {
            //询问是否确定删除角色信息
            layer.confirm('您确定要删除该角色信息吗？', {
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
                    url: "/sysRole/v1/delSysRole",
                    data: {sysRoleId: sysRoleId},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        layer.alert('删除角色信息成功!', {
                            icon: 6,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                        //刷新角色信息列表
                        vm.findSysRole();
                    },
                    error: function () {
                        layer.close(index_0);
                        layer.alert('删除角色信息失败，请稍后重试!', {
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
    editSysRoleById: function (sysRoleId) {
        if (isEmpty(sysRoleId)) {
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
                url: "/sysRole/v1/getSysRoleList",
                data: {id: sysRoleId},
                traditional: true,
                datatype: "json",
                success: function (data) {
                    layer.close(index);
                    //是否获取数据失败
                    var faild = true;
                    if (data.responseCode == 200) {
                        if (!isEmpty(data.responseObj)) {
                            //获取数据成功
                            faild = false;
                            var sysRole = data.responseObj[0];
                            vmEdit.clearEditLayer();
                            //删除多余的属性
                            delete sysRole.createTime;
                            delete sysRole.updateTime;
                            //区别新增或者修改
                            vmEdit.addOrEdit = 0;
                            //给弹窗赋值
                            vmEdit.sysRole = sysRole;
                            //弹窗编辑角色信息
                            layer.open({
                                type: 1,
                                title: ['编辑角色信息', 'font-size:16px;'],
                                area: ['90%', '90%'],
                                content: $('#editSysRole'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                                cancel: function(){
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysRole').hide();
                                },
                                end: function () {
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysRole').hide();
                                }
                            });
                        }
                    }
                    //获取数据失败
                    if (faild) {
                        layer.alert('获取角色信息失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                    }
                },
                error: function () {
                    layer.close(index);
                    layer.alert('获取角色信息失败，请稍后重试!', {
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
            //询问是否确定修改角色状态
            layer.confirm('您确定要修改该角色状态为' +newStateStr+ '吗？', {
                btn: ['确定','取消'], //按钮
                icon: 3,
                title:'温馨提示'
            }, function(index){
                layer.close(index);
                //layer加载层-设定最长等待5秒
                var index_0 = layer.load(1, {time: 5*1000});
                //提交地址
                var url = "/sysRole/v1/editSysRole";
                //异步提交数据
                $.ajax({
                    type: "post",
                    url: url,
                    data: {id: id, roleState: newState},
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
                        //刷新角色信息列表
                        vm.findSysRole();
                        //刷新整个页面
                        parent.location.reload()
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
    },
    editSysRoleColumnById: function (roleId) {
        //暂存角色Id
        vmRoleColumn.subParams.sysRoleId = roleId;
        //取消所有选中的节点
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        treeObj.checkAllNodes(false);
        vmRoleColumn.subParams.selectedColumn.removeAll();
        //获取对应角色已经拥有的栏目信息
        vm.getHadColumnByUid(roleId);
        //弹窗编辑角色信息
        layer.open({
            type: 1,
            title: ['编辑角色菜单', 'font-size:16px;'],
            area: ['300px', 'auto'],
            content: $('#editSysRoleColumn'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function(){
                //右上角关闭回调--隐藏弹框
                $('#editSysRoleColumn').hide();
            },
            end: function () {
                //右上角关闭回调--隐藏弹框
                $('#editSysRoleColumn').hide();
            }
        });
    },
    getHadColumnByUid: function(roleId) {
        //layer加载层-设定最长等待5秒
        var index_0 = layer.load(1, {time: 5*1000});
        //异步提交数据
        $.ajax({
            type: "get",
            url: '/sysColumnRole/v1/getSysColumnRoleByRoleId',
            traditional: true,
            data: {roleId:roleId},
            datatype: "json",
            success: function (data) {
                layer.close(index_0);
                if (data.responseCode == 200) {
                    if (!isEmpty(data.responseObj)) {
                        //ZTree对象
                        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                        for (var i = 0; i < data.responseObj.length; i++) {
                            var node = treeObj.getNodeByParam("id", data.responseObj[i].sysColumnId);
                            if(node != null) {
                                treeObj.checkNode(node, true)
                            }
                        }
                    }
                }
            },
            error: function () {
                layer.close(index_0);
                layer.alert('获取失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title:'温馨提示'
                })
            }
        })
    }
})


/**
 * Avalon编辑角色信息
 */
var vmEdit = avalon.define({
    $id: "editSysRole",
    addOrEdit: 1,//1-add;0-edit
    sysRole: {
        id: 0,
        roleName: '',
        roleDesc: '',
        roleState: 0,
        remark: ''
    },
    clearEditLayer: function () {
        this.sysRole.id = null;
        this.sysRole.roleName = '';
        this.sysRole.roleDesc = '';
        this.sysRole.roleState = 0;
        this.sysRole.remark = '';
    },
    subSysRole: function (el) {
        if (isEmpty(this.sysRole.roleName)) {
            layer.alert('请填写完整的角色信息!', {
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
            url = "/sysRole/v1/saveSysRole";
        } else {
            url = "/sysRole/v1/editSysRole";
        }
        //异步提交数据
        $.ajax({
            type: "post",
            url: url,
            data: this.sysRole,
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
                vm.findSysRole();
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

/**
 * Avalon编辑系统角色菜单分配信息
 * @type {Promise<boolean> | void | IDBRequest}
 */
var vmRoleColumn = avalon.define({
    $id: "editSysRoleColumn",
    subParams: {
        sysRoleId: '',
        selectedColumn: []
    },
    subSysRoleColumn: function (el) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = zTree.getCheckedNodes(true);
        //获取选中的节点信息
        $(nodes).each(function(index, obj) {
            vmRoleColumn.subParams.selectedColumn.push(obj.id);
        });
        if (vmRoleColumn.subParams.selectedColumn.length <= 0) {
            layer.alert('您还未选中任何栏目节点，请选择栏目节点后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
            return;
        }
        if (isEmpty(vmRoleColumn.subParams.sysRoleId)) {
            layer.alert('数据异常，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
        } else {
            //layer加载层-设定最长等待5秒
            var index = layer.load(1, {time: 5*1000});
            var url = '/sysColumnRole/v1/setRoleColumn';
            //异步提交数据
            $.ajax({
                type: "post",
                url: url,
                data: vmRoleColumn.subParams,
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
    },
    closeSysRoleColumn: function () {
        layer.closeAll();
    }
})

