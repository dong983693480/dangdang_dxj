

<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<script>
    $("#table2").jqGrid({

            url :"${path}/album/queryAlbumAll",
            editurl:"${path}/album/edit",
            datatype : "json",
            height : 300,
            rowNum : 2,
            rowList : [2, 8, 10, 20, 30 ],
            pager : '#pagex2',
            sortname : 'id',
            viewrecords : true,
            subGrid : true,
            colNames : [ 'id','标题名', '封面图片', '评分','作者','播音员','集数','内容','发布日期' ],
            colModel : [
                {name : 'id',index : 'id',  width : 55},
                {name : 'title',editable:true,index : 'name',  width : 60},
                {name : 'coverImg',editable:true,index : 'invdate',width : 170,height:100,edittype:"file",
                    formatter:function(cellvalue,options,rowObject){
                        return "<img src='${path}/upload/album/"+cellvalue+"' style='width:200px;height:80px'/>"
                    }
                },
                {name : 'score',editable:true,index : 'name',width : 50,align : "center"},
                {name : 'author',editable:true,index : 'amount',width : 50,align : "center"},
                {name : 'broadcast',editable:true,index : 'tax',width : 80,align : "center"},
                {name : 'count',editable:true,index : 'total',width : 80,align : "left"},
                {name : 'content',editable:true,index : 'note',width : 400 ,height:100},
                {name : 'pubDate',index : 'note',width : 150,align : "left"}
            ],

            subGridRowExpanded : function(subgrid_id, row_id) {
                var subgrid_table_id, pager_id;
                subgrid_table_id = subgrid_id + "_t";
                pager_id = "p_" + subgrid_table_id;
                alert(pager_id);
                alert(subgrid_table_id);
                $("#" + subgrid_id).html(
                    "<table id='" + subgrid_table_id
                    + "' class='scroll'></table><div id='"
                    + pager_id + "' class='scroll'></div>");
                $("#" + subgrid_table_id).jqGrid(
                    {
                        url : "${path}/chapter/queryChapterAll?albumId="+row_id,
                        datatype : "json",
                        colNames : [ 'id', '标题', '路径', '时长','大小','上传时间','操作' ],
                        colModel : [
                            {name : "id",  index : "num",width : 80,key : true},
                            {name : "title",  index : "num",width : 150,key : true},
                            {name : "src",index : "item",  width : 150,
                                formatter:function(cellvalue,options,rowObject){
                                    return "<audio controls loop>\n" +
                                        "  <source src=\"/src/"+value+"\" type=\"audio/mpeg\">\n" +
                                        "</audio>";
                                }},
                            {name : "duration",index : "qty",width : 150,align : "right"},
                            {name : "size",index : "unit",width : 150,align : "right"},
                            {name : "uploadTime",index : "total",width : 150,align : "right",sortable : false},
                            {name : "x1",align:"center",
                                formatter:function(cellvalue, options, rowObject){
                                    return "<a href='' ><span class='glyphicon glyphicon-download' /></a>&nbsp;&emsp;&emsp;" +
                                        "<a href='' ><span class='glyphicon glyphicon-play-circle' /></a>";
                                }
                            }
                        ],
                    });
                jQuery("#" + subgrid_table_id).jqGrid('navGrid',"#" + pager_id, {edit : true,add : true,del : true,edittext:"修改",addtext: "添加",deltext:"删除"
                    });
            },
            subGridRowColapsed : function(subgrid_id, row_id) {
                // this function is called before removing the data
                //var subgrid_table_id;
                //subgrid_table_id = subgrid_id+"_t";
                //jQuery("#"+subgrid_table_id).remove();
            }
        });
    $("#table2").jqGrid('navGrid', '#pagex2', { add : true,edit : true,del : true,edittext:"修改",addtext: "添加",deltext:"删除"}

    ,{
        closeAfterEdit:true,
            beforeShowForm:function(obg) {
        obg.find("#src").attr("disabled", true);
    }
    },
    {
        closeAfterAdd:true,
            afterSubmit:function(data){
        $.ajaxFileUpload({
            url:"${path}/album/upload1",
            type:"post",
            datatype:"json",
            data:{id:data.responseText},  //获取id
            fileElementId:"coverImg",  //需要上传的文件域的ID，即<input type="file">的ID
            success:function(){
                //刷新表单
                $("#table2").trigger("reloadGrid");
            }
        });
        return "xxxx";  //必须要有返回值  返回值随便写

    }
    });

</script>

<div>
    <%--面板--%>
    <div class="panel panel-success">
        <div class="panel-heading panel-success">
            <h1>专辑信息</h1>
        </div>
    </div>
    <!-- 标签页-->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">专辑信息</a></li>
    </ul>
    <%--初始化表格--%>
    <table id="table2"></table>
    <%--分页工具栏--%>
    <div id="pagex2"></div>

</div>
