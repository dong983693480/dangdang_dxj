<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>持明法州后台管理系统</title>
    <link rel="icon" href="${path}/bootstrap/img/arrow-up.png" type="image/x-icon">
    <link rel="stylesheet" href="${path}/bootstrap/css/bootstrap.css">

    <%--引入jqgrid中主题css--%>
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/css/css/hot-sneaks/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/boot/css/trirand/ui.jqgrid-bootstrap.css">
    <%--引入js文件--%>
    <script src="${path}/bootstrap/js/jquery.min.js"></script>
    <script src="${path}/bootstrap/js/bootstrap.js"></script>
    <script src="${path}/bootstrap/jqgrid/js/i18n/grid.locale-cn.js"></script>
    <script src="${path}/bootstrap/jqgrid/boot/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="${path}/bootstrap/js/ajaxfileupload.js"></script>

</head>
<body>

    <%--<h1 align="center">什么都没有了,全靠你们造啦O(∩_∩)O哈哈~</h1>--%>
    <!--顶部导航-->
    <div>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">持明法州管理系统</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">

                        </li>
                    </ul>
                    <form class="navbar-form navbar-left">
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">欢迎:<span style="color: #2aabd2">${admin.username}</span> </a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">退出登录<i class="glyphicon glyphicon-log-out"></i></a>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>

    <!--栅格系统-->
    <div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <div class="panel panel-success" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading "  role="tab" id="headingOne">
                        <h4 class="panel-title"  >
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                用户管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse " role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <center>
                                <button class="btn btn-warning"><li role="presentation " class="active"> <a href="javascript:$('#xx1').load('${path}/user/user.jsp')">用户信息</a></li></button><br/><br/>
                                <button class="btn btn-warning"><li role="presentation"><a href="#">用户统计</a></li></button><br/><br/>
                                <button class="btn btn-warning"><li role="presentation"><a href="#">用户分布</a></li></button>
                                </center>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="panel panel-warning">
                    <div class="panel-heading"  role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                轮播图管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <center>
                                    <button class="btn btn-warning"><li role="presentation " class="active">
                                        <a href="javascript:$('#xx1').load('${path}/banana/banana.jsp')">轮播图信息</a>
                                    </li></button><br/><br/>
                                </center>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-success">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                专辑管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <center>
                                    <button class="btn btn-warning"><li role="presentation " class="active">
                                        <a href="javascript:$('#xx1').load('${path}/zj/a.jsp')">专辑信息</a>
                                    </li></button><br/><br/>
                                </center>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-info">
                    <div class="panel-heading" role="tab" id="headingThree1">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree1" aria-expanded="false" aria-controls="collapseThree1">
                                文章管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree1">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <center>
                                    <button class="btn btn-warning"><li role="presentation " class="active"><a href="javascript:$('#xx1').load('${path}/user/article.jsp')">文章信息</a></li></button><br/><br/>
                                </center>
                            </ul>
                        </div>
                    </div>
                    <br/>
                <div class="panel panel-danger">
                    <div class="panel-heading" role="tab" id="headingThree11">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree11" aria-expanded="false" aria-controls="collapseThree11">
                                上师管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree11" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree11">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <center>
                                    <button class="btn btn-warning"><li role="presentation " class="active"><a href="javascript:$('#xx1').load('${path}/user/guru.jsp')">上师信息</a></li></button><br/><br/>
                                    <button class="btn btn-warning"><li role="presentation"><a href="#">用户统计</a></li></button><br/><br/>
                                    <button class="btn btn-warning"><li role="presentation"><a href="#">用户分布</a></li></button>
                                </center>
                            </ul>
                        </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
        <!--左边手风琴部分-->
        <!--巨幕开始-->
        <!--右边轮播图部分-->
        <!--页脚-->
        <div class="col-md-10" id="xx1">
            <div class="jumbotron">
                <h3>欢迎来到持明法州管理系统</h3>
            </div>

            <%--轮播图--%>
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox" >
                    <div  class="item active">
                        <img style="width: 100% ;height: 500px"   src="${path}/bootstrap/img/shouye.jpg" alt="...">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div  class="item">
                        <img style="width: 100% ;height: 500px"  src="${path}/bootstrap/img/2.png" alt="...">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div  class="item">
                        <img style="width: 100% ;height: 500px"  src="${path}/bootstrap/img/1.png" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div  class="item">
                        <img style="width: 100% ;height: 500px"  src="${path}/bootstrap/img/3.png" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div  class="item">
                        <img style="width: 100% ;height: 500px"  src="${path}/bootstrap/img/4.png" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>

                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <div class="panel panel-footer" align="center">
                    @百知xxxxxxxxx
                </div>
        </div>
    </div>
    </div>
    <!--栅格系统-->

</body>
</html>
