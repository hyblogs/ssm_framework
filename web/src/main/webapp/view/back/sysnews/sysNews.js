/** 页面初始化加载 */
avalon.ready(function(){
    //初始化列表数据
    vm.findSysNews();
})
//初始化layer分页插件
var laypage = layui.laypage;

/**
 * Avalon展示资讯信息列表
 */
var vm = avalon.define({
    $id: "sysNews",
    sysNewsList: [],
    sysNewsCurrentPage: 0,
    sysNewsPageSize: 10,
    sysNewsTotal: 0,
    sysNewsTotalPage: 0,
    sysNewsSearchParams: {
        currentPage: 1,
        pageSize: PAGESIZE,
        newsTitle: '',
        newsContent: '',
        newsState: ''
    },
    addSysNews: function (el) {
        //清空弹窗内容
        vmEdit.clearEditLayer();
        //区别新增或修改
        vmEdit.addOrEdit = 1;
        //弹窗编辑资讯信息
        layer.open({
            type: 1,
            title: ['编辑资讯信息', 'font-size:16px;'],
            area: ['90%', '90%'],
            content: $('#editSysNews'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function(){
                //右上角关闭回调--隐藏弹框
                $('#editSysNews').hide();
            },
            end: function () {
                //右上角关闭回调--隐藏弹框
                $('#editSysNews').hide();
            }
        });
    },
    findSysNews: function () {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //初始化页号
        vm.sysNewsSearchParams.currentPage = 1;
        $.getJSON("/sysNews/v1/getSysNewsByPage",vm.sysNewsSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysNewsList.removeAll();
                    vm.sysNewsTotalPage = 0;
                    vm.sysNewsCurrentPage = 1;
                    vm.sysNewsTotal = 0;
                } else {
                    vm.sysNewsList.removeAll();
                    vm.sysNewsList.pushArray(data.responseObj.list);
                    vm.sysNewsTotalPage = data.responseObj.pages;
                    vm.sysNewsCurrentPage = data.responseObj.pageNum;
                    vm.sysNewsTotal = data.responseObj.total;
                }
                //分页
                laypage.render({
                    elem: 'sysNewsPage',
                    count: vm.sysNewsTotal, //数据总数，从服务端得到
                    limit: vm.sysNewsSearchParams.pageSize,//每页数据量
                    theme: '#03b6fd',
                    jump: function(obj, first) {
                        //首次不执行
                        if(!first){
                            vm.getSysNewsByPage(obj.curr);
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
    getSysNewsByPage: function(page) {
        //layer加载层-设定最长等待5秒
        var index = layer.load(1, {time: 5*1000});
        //设置页号
        vm.sysNewsSearchParams.currentPage = page;
        $.getJSON("/sysNews/v1/getSysNewsByPage",vm.sysNewsSearchParams,function(data){
            layer.close(index);
            if (data.responseCode == 200) {
                if (isEmpty(data.responseObj)) {
                    vm.sysNewsList.removeAll();
                    vm.sysNewsTotalPage = 0;
                    vm.sysNewsCurrentPage = 1;
                    vm.sysNewsTotal = 0;
                } else {
                    vm.sysNewsList.removeAll();
                    vm.sysNewsList.pushArray(data.responseObj.list);
                    vm.sysNewsTotalPage = data.responseObj.pages;
                    vm.sysNewsCurrentPage = data.responseObj.pageNum;
                    vm.sysNewsTotal = data.responseObj.total;
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
    delSysNewsById: function (sysNewsId) {
        if (isEmpty(sysNewsId)) {
            layer.alert('获取要删除的数据失败，请稍后重试!', {
                icon: 5,
                skin: 'layer-ext-moon',
                title:'温馨提示'
            })
        } else {
            //询问是否确定删除资讯信息
            layer.confirm('您确定要删除该资讯信息吗？', {
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
                    url: "/sysNews/v1/delSysNews",
                    data: {_method:"DELETE", sysNewsId: sysNewsId},
                    traditional: true,
                    datatype: "json",
                    success: function (data) {
                        layer.close(index_0);
                        if (data.responseCode == 200) {
                            layer.alert('删除资讯信息成功!', {
                                icon: 6,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                            //刷新资讯信息列表
                            vm.findSysNews();
                        } else {
                            layer.alert('删除资讯信息失败，请稍后重试!', {
                                icon: 5,
                                skin: 'layer-ext-moon',
                                title:'温馨提示'
                            })
                        }
                    },
                    error: function () {
                        layer.close(index_0);
                        layer.alert('删除资讯信息失败，请稍后重试!', {
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
    editSysNewsById: function (sysNewsId) {
        if (isEmpty(sysNewsId)) {
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
                url: "/sysNews/v1/getSysNewsList",
                data: {id: sysNewsId},
                traditional: true,
                datatype: "json",
                success: function (data) {
                    layer.close(index);
                    //是否获取数据失败
                    var faild = true;
                    if (data.responseCode == 200) {
                        if (!isEmpty(data.responseObj)) {
                            //清空编辑框中的资讯信息
                            vmEdit.clearEditLayer();
                            //获取数据成功
                            faild = false;
                            var sysNews = data.responseObj[0];
                            //删除多余的属性
                            delete sysNews.createTime;
                            delete sysNews.updateTime;
                            //区别新增或者修改
                            vmEdit.addOrEdit = 0;
                            //给弹窗赋值
                            vmEdit.sysNews = sysNews;
                            //弹窗编辑资讯信息
                            layer.open({
                                type: 1,
                                title: ['编辑资讯信息', 'font-size:16px;'],
                                area: ['90%', '90%'],
                                content: $('#editSysNews'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                                cancel: function(){
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysNews').hide();
                                },
                                end: function () {
                                    //右上角关闭回调--隐藏弹框
                                    $('#editSysNews').hide();
                                }
                            });
                        }
                    }
                    //获取数据失败
                    if (faild) {
                        layer.alert('获取资讯信息失败，请稍后重试!', {
                            icon: 5,
                            skin: 'layer-ext-moon',
                            title:'温馨提示'
                        })
                    }
                },
                error: function () {
                    layer.close(index);
                    layer.alert('获取资讯信息失败，请稍后重试!', {
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
            //询问是否确定修改资讯状态
            layer.confirm('您确定要修改该资讯状态为[' +newStateStr+ ']吗？', {
                btn: ['确定','取消'], //按钮
                icon: 3,
                title:'温馨提示'
            }, function(index){
                layer.close(index);
                //layer加载层-设定最长等待5秒
                var index_0 = layer.load(1, {time: 5*1000});
                //提交地址
                var url = "/sysNews/v1/editSysNews";
                //异步提交数据
                $.ajax({
                    type: "post",
                    url: url,
                    data: {id: id, newsState: newState},
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
                            //刷新资讯信息列表
                            vm.findSysNews();
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
 * Avalon编辑资讯信息
 */
var vmEdit = avalon.define({
    $id: "editSysNews",
    addOrEdit: 1,//1-add;0-edit
    sysNews: {
        id: 0,
        newsTitle: '',
        subTitle: '',
        newsContent: '',
        newsOutline: '',
        newsType: '',
        newsState: null,
        newsAuthor: '',
        newsFrom: '',
        newsFromUrl: '',
        linkUrl: '',
        isOuter: null,
        newsImgs: '',
        remark: ''
    },
    clearEditLayer: function () {
        this.sysNews.id = null;
        this.sysNews.newsTitle = '';
        this.sysNews.subTitle = '';
        this.sysNews.newsContent = '';
        this.sysNews.newsOutline = '';
        this.sysNews.newsType = '';
        this.sysNews.newsState = null;
        this.sysNews.newsAuthor = '';
        this.sysNews.newsFrom = '';
        this.sysNews.newsFromUrl = '';
        this.sysNews.linkUrl = '';
        this.sysNews.isOuter = null;
        this.sysNews.newsImgs = '';
        this.sysNews.remark = '';
    },
    subSysNews: function (el) {
        if (isEmpty(this.sysNews.newsTitle) || isEmpty(this.sysNews.newsContent)) {
            layer.alert('请填写完整的资讯信息!', {
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
            url = "/sysNews/v1/saveSysNews";
        } else {
            url = "/sysNews/v1/editSysNews";
        }
        //异步提交数据
        $.ajax({
            type: "post",
            url: url,
            data: this.sysNews,
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
                    vm.findSysNews();
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

