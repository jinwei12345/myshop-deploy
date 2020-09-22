<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html>
<head>
    <%--    <link rel="shortcut icon" href="#" />--%>
    <title>我的商城 |内容管理 </title>
    <jsp:include page="../includes/header.jsp"/>
        <link href="https://cdn.bootcss.com/jquery-treetable/3.2.0/css/jquery.treetable.min.css" rel="stylesheet">
        <link href="https://cdn.bootcss.com/jquery-treetable/3.2.0/css/jquery.treetable.theme.default.css" rel="stylesheet">
</head>
<body class="hold-transition skin-blue sidebar-mini" >
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                内容管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" :"danger" } alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">分类列表</h3>
                            <div class="row" style=" margin-top: 20px;margin-left: 0px;">
                                <a href="/content/category/form" type="button" class="btn btn-sm  btn-default"><i class="fa fa-plus"> </i> 新增</a>&nbsp;&nbsp;
<%--                                <button type="button" class="btn btn-sm  btn-default" ><i class="fa fa-trash-o"> </i> 删除</button>&nbsp;&nbsp;--%>
                                <a href="#" type="button" class="btn btn-sm  btn-default"onclick="alert('功能尚未完成，敬请期待！')"><i class="fa fa-download"> </i> 导入</a>&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-sm  btn-default"><i class="fa fa-upload"> </i> 导出</a>&nbsp;&nbsp;

                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive ">
                            <table id="treeTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>名称</th>
                                    <th>排序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="tb_contentCategories" items="${tbContentCategories}">
                                    <tr data-tt-id="${tb_contentCategories.id}" data-tt-parent-id="${tb_contentCategories.partId.id}">
                                        <td>${tb_contentCategories.id}</td>
                                        <td >${tb_contentCategories.name}</td>
                                        <td>${tb_contentCategories.sortOrder}</td>
                                        <td>
                                            <a href="/content/category/form?id=${tb_contentCategories.id}" type="button" class="btn btn-sm  btn-primary"><i class="fa fa-edit"> </i> 编辑</a>&nbsp;&nbsp;&nbsp;
                                            <button type="button" class="btn btn-sm  btn-danger" onclick="App.deleteSingle('/content/category/delete','${tb_contentCategories.id}','警告：该删除操作会将包括选中类目在内的全部子类目及属于类目的内容一并删除，请谨慎操作！您还确定继续吗？')" ><i class="fa fa-trash-o" > </i> 删除</button>&nbsp;&nbsp;&nbsp;
                                            <a href="/content/category/form?partId.id=${tb_contentCategories.id}&partId.name=${tb_contentCategories.name}" type="button" class="btn btn-sm  btn-default"> <i class="fa fa-plus"> </i> 增加下级菜单</a>&nbsp;&nbsp;&nbsp;
                                        </td>
                                    </tr>

                                </c:forEach>

                                </tbody>

                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    </section>
</div>
<jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>
<script src="https://cdn.bootcss.com/jquery-treetable/3.2.0/jquery.treetable.min.js"></script>
<!-- 自定义模态框-->
<sys:modal/>
<script>
        $("#treeTable").treetable({
            expandable : true ,
            column:1,


        
    });
</script>


</body>

</html>