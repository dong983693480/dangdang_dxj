<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<script>
    $(function(){
        $("#table1").jqGrid({
            url:"${path}/carousel/queryAll",
            editurl:"${path}/carousel/edit",
            datatype:"json",   //t必须要小写
            rowNum:"2",
            rowList:[2,10,15,20,50],
            pager:"#pagex1",
            viewrecords : true,   //是否展示总条数
            styleUI:"Bootstrap",
            height:"auto",
            autowidth :true,
            colNames:['id','图片','描述','状态','上传时间'],
            colModel:[
                {name:'id',index:'id',width:55},
                {name:'src',index:'invdate',editable:true,width:90,align:"center",edittype:"file",
                    formatter:function(cellvalue,options,rowObject){
                        return "<img src='${path}/upload/"+cellvalue+"' style='width:200px;height:80px'/>"
                    }

                },
                {name:'description',editable:true,index:'name asc,invdate',width:100},
                {name:'struts',index:'amount',width:90,align:"right center",
                    formatter:function(cellvalue,options,rowObject){
                        if(cellvalue==1){
                            return "<button class='btn btn-success' onclick='fuu(\""+rowObject.id+"\",\""+cellvalue+"\")'>不展示</button>";
                        }else{
                            return "<button class='btn btn-danger' onclick='fuu(\""+rowObject.id+"\",\""+cellvalue+"\")'>展示</button>";
                        }
                    }

                },
                {name:'createdate',index:'note',width:150,sortable : false},
            ],
        });
        //增删改查操作
        $("#table1").jqGrid('navGrid', '#pagex1', {edit : true,add : true,del : true,edittext:"修改",addtext: "添加",deltext:"删除"},
            {
                closeAfterEdit:true,
                beforeShowForm:function(obg) {
                    obg.find("#src").attr("disabled", true);
                }
            },
            {
                closeAfterAdd:true,
                afterSubmit:function(data){
                    $.ajaxFileUpload({
                        url:"${path}/carousel/upload1",
                        type:"post",
                        datatype:"json",
                        data:{id:data.responseText},  //获取id
                        fileElementId:"src",  //需要上传的文件域的ID，即<input type="file">的ID
                        success:function(){
                            //刷新表单
                            $("#table1").trigger("reloadGrid");
                        }
                    });
                    return "xxxx";  //必须要有返回值  返回值随便写

                }
            }
        );
    });
        function fuu(id,struts) {
            if(struts=="0"){
                $.ajax({
                    url:"${path}/carousel/edit",
                    type: "post",
                    datatype:"json",
                    data: {"id":id,"struts":"1","oper":"edit"},
                    success:function() {
                        $("#table1").trigger("reloadGrid");
                    }
                })
            }else{
                $.ajax({
                    url:"${path}/carousel/edit",
                    type: "post",
                    datatype:"json",
                    data: {"id":id,"struts":"0","oper":"edit"},
                    success:function() {
                        $("#table1").trigger("reloadGrid");
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
    <table id="table1"></table>
    <%--分页工具栏--%>
    <div id="pagex1"></div>

</div>
