/** 页面初始化加载 */
avalon.ready(function () {
    //初始化列表数据
    vm.findSysResource();
    //初始化搜索条件父级栏目下拉列表
    vm.getParentResourceList();
});
//初始化layer分页插件
var laypage = layui.laypage;

/**
 * Avalon展示栏目信息列表
 */
var vm = avalon.define({
    $id: "sysResource",
    sysResourceList: [],
    sysResourceCurrentPage: 0,
    sysResourcePageSize: 10,
    sysResourceTotal: 0,
    sysResourceTotalPage: 0,
    parentResourceList: [],
    sysResourceSearchParams: {
        currentPage: 1,
        pageSize: PAGESIZE,
        resourceName: '',
        resourceStatus: '',
        parentId: ''
    },
    getParentResourceList: function () {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5 * 1000});
        $.getJSON("../../../ssm_framework/back/sysResource/getSysResourceList", {type: 2}, function (data) {
            //关闭layer加载层
            layer.close(index);
            if (data.retCode === 200) {
                vm.parentResourceList.removeAll();
                if (data.retObj != null) {
                    vm.parentResourceList.pushArray(data.retObj);
                }
            } else {
                layer.alert('获取父级栏目信息失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title: '温馨提示'
                })
            }
        })
    },
    addSysResource: function (el) {
        //清空弹窗内容
        vmEdit.clearEditLayer();
        //加载父级栏目下拉列表内容
        vmEdit.getParentResourceList(2);
        //区别新增或修改
        vmEdit.addOrEdit = 1;
        //弹窗编辑栏目信息
        layer.open({
            type: 1,
            title: ['编辑栏目信息', 'font-size:16px;'],
            area: ['90%', '90%'],
            content: $('#editSysResource'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function () {
                //右上角关闭回调--隐藏弹框
                $('#editSysResource').hide();
            },
            end: function () {
                //右上角关闭回调--隐藏弹框
                $('#editSysResource').hide();
            }
        });
    },
    findSysResource: function () {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5 * 1000});
        //初始化页号
        vm.sysResourceSearchParams.currentPage = 1;
        $.getJSON("../../../ssm_framework/back/sysResource/getSysResourceByPage", vm.sysResourceSearchParams, function (data) {
            layer.close(index);
            if (data.retCode === 200) {
                if (isEmpty(data.retObj)) {
                    vm.sysResourceList.removeAll();
                    vm.sysResourceTotalPage = 0;
                    vm.sysResourceCurrentPage = 1;
                    vm.sysResourceTotal = 0;
                } else {
                    vm.sysResourceList.removeAll();
                    vm.sysResourceList.pushArray(data.retObj.list);
                    vm.sysResourceTotalPage = data.retObj.pages;
                    vm.sysResourceCurrentPage = data.retObj.pageNum;
                    vm.sysResourceTotal = data.retObj.total;
                }
                //分页
                laypage.render({
                    elem: 'sysResourcePage',
                    count: vm.sysResourceTotal, //数据总数，从服务端得到
                    limit: vm.sysResourceSearchParams.pageSize,//每页数据量
                    theme: '#03b6fd',
                    jump: function (obj, first) {
                        //首次不执行
                        if (!first) {
                            vm.getResourceByPage(obj.curr);
                        }
                    }
                });
            } else {
                layer.alert('提交失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title: '温馨提示'
                })
            }
        })
    },
    getResourceByPage: function (page) {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5 * 1000});
        //设置页号
        vm.sysResourceSearchParams.currentPage = page;
        $.getJSON("../../../ssm_framework/back/sysResource/getSysResourceByPage", vm.sysResourceSearchParams, function (data) {
            layer.close(index);
            if (data.retCode === 200) {
                if (isEmpty(data.retObj)) {
                    vm.sysResourceList.removeAll();
                    vm.sysResourceTotalPage = 0;
                    vm.sysResourceCurrentPage = 1;
                    vm.sysResourceTotal = 0;
                } else {
                    vm.sysResourceList.removeAll();
                    vm.sysResourceList.pushArray(data.retObj.list);
                    vm.sysResourceTotalPage = data.retObj.pages;
                    vm.sysResourceCurrentPage = data.retObj.pageNum;
                    vm.sysResourceTotal = data.retObj.total;
                }
            } else {
                layer.alert('提交失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title: '温馨提示'
                })
            }
        })
    },
    delSysResourceById: function (sysResourceId) {
        if (isEmpty(sysResourceId)) {
            layer.alert('获取要删除的数据失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title: '温馨提示'
            })
        } else {
            //询问是否确定删除栏目信息
            layer.confirm('您确定要删除该栏目信息吗？', {
                btn: ['确定', '取消'], //按钮
                icon: 3,
                title: '温馨提示'
            }, function (index) {
                layer.close(index);
                //layer加载层-设定最长等待5秒
                var index_0 = layer.load(1, {time: 5 * 1000});
                //发送异步请求
                $.ajax({
                    type: "post",
                    url: "../../../ssm_framework/back/sysResource/delSysResource",
                    data: {sysResourceId: sysResourceId},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        layer.alert('删除栏目信息成功!', {
                            icon: 6,
                            skin: 'layer-ext-moon',
                            title: '温馨提示'
                        });
                        //刷新栏目信息列表
                        vm.findSysResource();
                    },
                    error: function () {
                        layer.close(index_0);
                        layer.alert('删除栏目信息失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title: '温馨提示'
                        })
                    }
                })
            }, function (index) {
                layer.close(index);
            });
        }
    },
    editSysResourceById: function (sysResourceId) {
        if (isEmpty(sysResourceId)) {
            layer.alert('获取要修改的数据失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title: '温馨提示'
            })
        } else {
            //layer加载层-设定最长等待5秒
            var index = layer.load(1, {time: 5 * 1000});
            $.ajax({
                type: "get",
                url: "../../../ssm_framework/back/sysResource/getSysResourceList",
                data: {id: sysResourceId},
                traditional: true,
                datatype: "json",
                success: function (data) {
                    layer.close(index);
                    //是否获取数据失败
                    var faild = true;
                    if (data.retCode === 200) {
                        if (!isEmpty(data.retObj)) {
                            //清空数据
                            vmEdit.clearEditLayer();
                            //获取数据成功
                            faild = false;
                            var sysResource = data.retObj[0];
                            //删除多余的属性
                            delete sysResource.createTime;
                            delete sysResource.updateTime;
                            //区别新增或者修改
                            vmEdit.addOrEdit = 0;
                            //给父级栏目下拉框赋值
                            var type = 1;
                            if (!isNaN(sysResource.parentId)) {
                                type = sysResource.parentId === 0 ? 1 : 2;
                            }
                            //加载父级栏目
                            vmEdit.getParentResourceList(type);
                            //给弹窗赋值
                            vmEdit.sysResource = sysResource;
                            //弹窗编辑栏目信息
                            layer.open({
                                type: 1,
                                title: ['编辑栏目信息', 'font-size:16px;'],
                                area: ['90%', '90%'],
                                content: $('#editSysResource'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                                cancel: function () {
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysResource').hide();
                                },
                                end: function () {
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysResource').hide();
                                }
                            });
                        }
                    }
                    //获取数据失败
                    if (faild) {
                        layer.alert('获取栏目信息失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title: '温馨提示'
                        })
                    }
                },
                error: function () {
                    layer.close(index);
                    layer.alert('获取栏目信息失败，请稍后重试!', {
                        icon: 5,
                        skin: 'layer-ext-moon',
                        title: '温馨提示'
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
                title: '温馨提示'
            })
        } else {
            //新状态
            var newState = '';
            var newStateStr = '';
            if (state === 0) {
                newState = 1;
                newStateStr = '显示';
            } else if (state === 1) {
                newState = 0;
                newStateStr = '隐藏';
            }
            //询问是否确定修改栏目状态
            layer.confirm('您确定要修改该栏目状态为' + newStateStr + '吗？', {
                btn: ['确定', '取消'], //按钮
                icon: 3,
                title: '温馨提示'
            }, function (index) {
                layer.close(index);
                //layer加载层-设定最长等待5秒
                var index_0 = layer.load(1, {time: 5 * 1000});
                //提交地址
                var url = "../../../ssm_framework/back/sysResource/editSysResource";
                //异步提交数据
                $.ajax({
                    type: "post",
                    url: url,
                    data: {id: id, resourceStatus: newState},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        //关闭弹窗
                        layer.closeAll();
                        layer.alert('提交成功!', {
                            icon: 6,
                            skin: 'layer-ext-moon',
                            title: '温馨提示'
                        });
                        //刷新栏目信息列表
                        vm.findSysResource();
                        //刷新整个页面
                        parent.location.reload()
                    },
                    error: function () {
                        layer.close(index_0);
                        layer.alert('提交失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title: '温馨提示'
                        })
                    }
                })
            }, function (index) {
                layer.close(index);
            });
        }
    }
});

/**
 * Avalon编辑栏目信息
 */
var vmEdit = avalon.define({
    $id: "editSysResource",
    parentResourceList: [],
    addOrEdit: 1,//1-add;0-edit
    sysResource: {
        id: 0,
        resourceName: '',
        columnCode: '',
        resourceSort: 0,
        resourceIcon: '',
        resourceStatus: -1,
        parentId: 0,
        resourceUrl: '',
        resourceDesc: ''
    },
    clearEditLayer: function () {
        this.sysResource.id = null;
        this.sysResource.resourceName = '';
        this.sysResource.columnCode = '';
        this.sysResource.resourceSort = 0;
        this.sysResource.resourceIcon = '';
        this.sysResource.resourceStatus = 0;
        this.sysResource.parentId = 0;
        this.sysResource.resourceUrl = '';
        this.sysResource.resourceDesc = '';
    },
    subSysResource: function (el) {
        if (isEmpty(this.sysResource.resourceName) || isEmpty(this.sysResource.columnCode) ||
            isEmpty(this.sysResource.resourceIcon) || isEmpty(this.sysResource.resourceUrl)) {
            layer.alert('请填写完整的栏目信息!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title: '温馨提示'
            });
            return false;
        }
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5 * 1000});
        //提交地址
        var url = "";
        //判断是新增还是修改
        if (this.addOrEdit === 1) {
            url = "../../../ssm_framework/back/sysResource/saveSysResource";
        } else {
            url = "../../../ssm_framework/back/sysResource/editSysResource";
        }
        //异步提交数据
        $.ajax({
            type: "post",
            url: url,
            data: this.sysResource,
            traditional: true,
            datatype: "json",
            success: function (data) {
                layer.close(index);
                //关闭弹窗
                layer.closeAll();
                layer.alert('提交成功!', {
                    icon: 6,
                    skin: 'layer-ext-moon',
                    title: '温馨提示'
                });
                //刷新栏目信息列表
                vm.findSysResource();
            },
            error: function () {
                layer.close(index);
                layer.alert('提交失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title: '温馨提示'
                })
            }
        })
    },
    showPintuerIcons: function (el) {
        //弹窗显示系统图标信息
        layer.open({
            type: 1,
            title: ['可选系统图标', 'font-size:16px;'],
            area: ['90%', '90%'],
            content: $('#pintuer-icons'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function () {
                //右上角关闭回调--隐藏弹框部分的内容
                $('#pintuer-icons').hide();
            },
            end: function () {
                //右上角关闭回调--隐藏弹框部分的内容
                $('#pintuer-icons').hide();
            }
        });
    },
    getParentResourceList: function (type) {//查询类型：1-查询一级栏目的父级栏目；2-查询二级栏目的父级栏目
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5 * 1000});
        $.getJSON("../../../ssm_framework/back/sysResource/getSysResourceList", {type: type}, function (data) {
            //关闭layer加载层
            layer.close(index);
            if (data.retCode === 200) {
                vmEdit.parentResourceList.removeAll();
                if (data.retObj != null) {
                    vmEdit.parentResourceList.pushArray(data.retObj);
                }
            } else {
                layer.alert('获取父级栏目信息失败，请稍后重试!', {
                    icon: 5,
                    skin: 'layer-ext-moon',
                    title: '温馨提示'
                })
            }
        })
    }
});

/**
 * Avalon控制系统图标
 */
var vmIcons = avalon.define({
    $id: "pintuerIcons",
    getIconInfo: function (el) {
        //获取选中的系统图标
        var icon = el.target.className;
        if (isEmpty(icon)) {
            layer.alert('选择系统图标失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title: '温馨提示'
            })
        } else {
            //关闭当前弹窗
            layer.close(layer.index);
            //获取选中图标信息并赋值到编辑框
            vmEdit.sysResource.resourceIcon = icon;
        }
    }
});

