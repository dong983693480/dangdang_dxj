<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<script>
    $(function(){
        $("#table4").jqGrid({
            url:"${path}/guru/queryGuruAll",
            editurl:"${path}/guru/edit",
            datatype:"json",   //t必须要小写
            rowNum:"2",
            rowList:[2,10,15,20,50],
            pager:"#pagex4",
            viewrecords : true,   //是否展示总条数
            styleUI:"Bootstrap",
            height:"auto",
            autowidth :true,
            colNames:['id','名字','头像','账号','密码','状态','注册时间'],
            colModel:[
                {name:'id',index:'id',width:55},
                {name:'name',index:'id',width:55},
                {name:'picImg',index:'invdate',editable:true,width:90,align:"center",edittype:"file",
                    formatter:function(cellvalue,options,rowObject){
                        return "<img src='${path}/upload/"+cellvalue+"' style='width:200px;height:80px'/>"
                    }

                },
                {name:'username',editable:true,index:'name asc,invdate',width:100},
                {name:'password',index:'note',width:150,sortable : false},
                {name:'salt',index:'amount',width:90,align:"right center",
                    formatter:function(cellvalue,options,rowObject){
                        if(cellvalue==1){
                            return "<button class='btn btn-success' onclick='fuu(\""+rowObject.id+"\",\""+cellvalue+"\")'>不展示</button>";
                        }else{
                            return "<button class='btn btn-danger' onclick='fuu(\""+rowObject.id+"\",\""+cellvalue+"\")'>展示</button>";
                        }
                    }

                },

                {name:'regTime',index:'note',width:150,sortable : false,
                    formatter:'date',
                    formatoptions:{newformat:'Y-m-d'}},
            ],
        });
        //增删改查操作
        $("#table1").jqGrid('navGrid', '#pagex1', {edit : false,add : false,del : false,edittext:"修改",addtext: "添加",deltext:"删除"},

        );
    });
        function fuu(id,salt) {
            if(salt=="0"){
                $.ajax({
                    url:"${path}/guru/edit",
                    type: "post",
                    datatype:"json",
                    data: {"id":id,"salt":"1"},
                    success:function() {
                        $("#table4").trigger("reloadGrid");
                    }
                })
            }else{
                $.ajax({
                    url:"${path}/guru/edit",
                    type: "post",
                    datatype:"json",
                    data: {"id":id,"salt":"0"},
                    success:function() {
                        $("#table4").trigger("reloadGrid");
                    }
                })
            }


    }
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
    <table id="table4"></table>
    <%--分页工具栏--%>
    <div id="pagex4"></div>

</div>
