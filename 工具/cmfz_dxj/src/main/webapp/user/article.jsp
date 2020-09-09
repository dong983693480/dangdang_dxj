<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<script>
    $(function(){
        $("#table5").jqGrid({
            url:"${path}/article/queryArticleAll",
            editurl:"${path}/article/edit",
            datatype:"json",   //t必须要小写
            rowNum:"2",
            rowList:[2,10,15,20,50],
            pager:"#pagex5",
            viewrecords : true,   //是否展示总条数
            styleUI:"Bootstrap",
            height:"auto",
            autowidth :true,
            colNames:['id','标题','头像','上师姓名','内容','上师id','注册时间'],
            colModel:[
                {name:'id',index:'id',width:55},
                {name:'title',index:'id',width:55},
                {name:'img',index:'invdate',editable:true,width:90,align:"center",edittype:"file",
                    formatter:function(cellvalue,options,rowObject){
                        return "<img src='${path}/upload/user/"+cellvalue+"' style='width:200px;height:80px'/>"
                    }

                },
                {name:'guruName',editable:true,index:'name asc,invdate',width:100},
                {name:'content',index:'note',width:150,sortable : false},
                {name:'guruId',index:'note',width:150,sortable : false},
                {name:'uploadTime',index:'note',width:150,sortable : false,
                    formatter:'date',
                    formatoptions:{newformat:'Y-m-d'}},
            ],
        });
        //增删改查操作
        $("#table5").jqGrid('navGrid', '#pagex5', {edit : false,add : false,del : true,edittext:"修改",addtext: "添加",deltext:"删除"}

        );
    });
</script>


<div>
    <%--面板--%>
    <div class="panel panel-warning">
        <div class="panel-heading panel-success">
            <h1>轮播图信息</h1>
        </div>
    </div>
    <!-- 标签页-->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">轮播图信息</a></li>
    </ul>
    <%--初始化表格--%>
    <table id="table5"></table>
    <%--分页工具栏--%>
    <div id="pagex5"></div>

</div>
