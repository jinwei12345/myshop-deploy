var App =function () {
    //inCheck
    var _masterCheckbox;
    var _checkbox;

    //数组用于存放id
    var _idArray;

    //默认的Dropzone参数
    var _defaultDropZoneOpts ={
        url: "", //文件提交地址
        paramName: "dropFile", // 传到后台的参数名称
        method: "post",  // 也可用put
        maxFiles: 1,// 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1,// 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传"+this.maxFiles+" 个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg。",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持.",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消"

    };
    /**
     * 私有方法，初始化icheck
     */
    var handlerInitCheckBox=function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });
        //获取顶部checkbox
        _masterCheckbox=$('input[type="checkbox"].minimal.icheck_master');
        //获取全部checkbox
         _checkbox=$('input[type="checkbox"].minimal');


    };
    /**
     * checkbox全选功能
     */
    var handlerCheckBoxAll=function () {
        _masterCheckbox.on("ifClicked",function (e) {
            //返回true表示未选中
            if(e.target.checked){
                _checkbox.iCheck("uncheck");



            }
            //选中状态
            else{
                _checkbox.iCheck("check");

            }

        })


    };
    /**
     * 删除单笔记录
     * @param url 删除链接
     * @param id 需要删除数据的 ID
     */
    var handlerDeleteSingle = function (url, id, msg) {
        // 可选参数
        if (!msg) msg = null;

        // 将 ID 放入数组中，以便和批量删除通用
        _idArray = new Array();
        _idArray.push(id);

        $("#modal-message").html(msg == null ? "您确定删除数据项吗？" : msg);
        $("#modal-default").modal("show");
        // 绑定删除事件
        $("#btnModalOk").bind("click", function () {
            handlerDeleteData(url);
        });
    };
    /**
     * 批量删除
     */
    var handlerDeleteMulti=function (url) {
        _idArray = [];
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id !== "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);


            }
        });
        //判断用户是否选择了数据项
        if (_idArray.length === 0) {

            $("#modal-message").html("您没有选择任何数据，请勾选至少一项数据");

        } else {

            $("#modal-message").html("确定删除这" + _idArray.length + "项数据吗？");


        }
        //点击删除按钮时弹出模态框
        $("#modal-default").modal("show");
        //如果用户选择了数据项则调用删除方法
        $("#btnModalOk").bind("click", function () {
            handlerDeleteData(url);

        });
    };

        /**
         * ajax异步删除
         */
        var handlerDeleteData = function (url){
            $("#modal-default").modal("hide");

            if(_idArray.length===0){

            }
            /**
             * 删除操作
             */
            else {
                setTimeout(function () {
                    $.ajax({
                        "url": url,
                        "type": "POST",
                        "data": {"ids": _idArray.toString()},
                        "dataType": "JSON",
                        "success": function (data) {
                            // 请求成功后，无论是成功或是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件
                            $("#btnModalOk").unbind("click");
                            //请求成功
                            if (data.status === 200) {
                                //刷新页面
                                $("#btnModalOk").bind("click", function () {
                                    window.location.reload();
                                });

                            }
                            //请求失败
                            else {
                                $("#btnModalOk").bind("click", function () {
                                    //确定按钮事件改为隐藏模态框
                                    $("#modal-default").modal("hide");
                                });

                            }
                            //无论如何都要提示信息，模态框必须调用
                            $("#modal-message ").html(data.message);
                            $("#modal-default").modal("show");
                        }
                    });
                    },500);

            }


    };
    /**
     * 初始化dataTables
     */
    var handlerInitDataTables=function (url ,columns) {
        //返回一个datatable对象
        return $("#datatable").DataTable({
            "paging": true,
            "info": true,
            "lengthChange": false,
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "ajax": {
                "url": url
            },
            "columns": columns,
            "drawCallback": function (settings) {
                handlerInitCheckBox();
                handlerCheckBoxAll();
            }

        });
    };
    /**
     * 初始化树形菜单ZTree
     */
    var handlerInitZTree =function (url,autoParam,callback) {
        var setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url:url,
                autoParam:autoParam
            }
        };

        $.fn.zTree.init($("#myTree"), setting);

        $("#btnModalOk").bind("click",function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            var nodes = zTree.getSelectedNodes();
            //未选择
            if (nodes.length === 0) {
                alert("请先选择一个父节点");
            }
            //已选择
            else {
                callback(nodes);
            }


        })



    };
    /**
     * 初始化DropZone
     * @param opts
     */
    var handlerInitDropZone =function (opts) {
      Dropzone.autoDiscover = false;
      //继承
      $.extend(_defaultDropZoneOpts,opts);
       new Dropzone(_defaultDropZoneOpts.id,_defaultDropZoneOpts);

    };
    /**
     * 查看信息
     * @param url
     */
    var  handlerShowDetail=function (url) {
        //这里是通过ajax的方式将请求的数据以html的方式，将jsp装载进模态框传回来
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success :function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");


            }
        });

    };

    return{
        /**
         * 初始化datatables
         */
        init:function(){
            handlerInitCheckBox();
            handlerCheckBoxAll();

        },

        /**
         * 删除单笔数据
         * @param url
         */
        deleteSingle: function(url, id, msg) {
            handlerDeleteSingle(url, id, msg);
        },

        deleteMulti: function (url) {
            handlerDeleteMulti(url);


        },
        initDataTables:function (url,columns) {
            return  handlerInitDataTables(url,columns);

        },
        showDetail:function (url) {
            handlerShowDetail(url);

        },
        initZTree: function (url,autoParam,callback) {
            handlerInitZTree(url,autoParam,callback);

        },
        initDropZone:function (opts) {
            handlerInitDropZone(opts);

        }

    }
}();
$(document).ready(function () {
    App.init();

});