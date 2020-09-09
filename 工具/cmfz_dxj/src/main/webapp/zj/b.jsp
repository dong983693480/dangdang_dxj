
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />



<script>

    $('#table2').jqGrid({
        url:'${path}/album/queryAlbumAll',
        datatype:'json',
        //引入bootstrap的UI样式
        styleUI:'Bootstrap',
        colNames:['ID','标题','评分','简介','播音','封面','作者','集数','发布日期'],
        cellEdit:false,
        editurl:"${path}/album/edit",
        colModel:[
            {name:'id'},
            {name:'title',editable:true},
            {name:'score',editable:true},
            {name:'content',editable:true},
            {name:'broadcast',editable:true},
            {
                name: 'coverImg',
                editable: true,
                edittype: 'file',
                editoptions:{enctype:"multipart/form-data"},
                //渲染静态数据
                // editoptions:{value:"1:研发部;2:教学部"},
                // 加载远程数据渲染下拉列表,要求响应的是一段html元素内容
                <%--editoptions: {dataUrl: '${pageContext.request.contextPath}/dept/queryAllDept'},--%>
                formatter: function (value, options, row) {
                    /**
                                   * value : 在远程匹配到的数据
                                   * options: 当前单元格操作属性对象
                     4.带分页功能的数据表格
                                   * row : 当前行的数据对象
                                   */
                    //console.log(value, options, row);
                    //函数的返回值会显示在当前单元格
                    return "<image style='width: 140px;height:100px' src=${path}/upload/album/"+value+"></image>";
                }
            },
            {name:'author',editable:true},
            {name:'count',editable:true},
            {
                name:'pubDate',
                formatter:'date',
                formatoptions:{newformat:'Y-m-d'}
            }
        ],

        pager:'#pagex2',
        rowList:[3,5,10,20,30],
        rowNum:3,// 指定默认每页展示的条数，值必须来自rowList中的一个
        height:330,
        width:500,
        viewrecords:true,// 是否显示总记录条数
        autowidth:true,
        multiselect:true,// 在表格第一列前面，加入复选框
        page:1,//指定初始化页码
        subGrid : true, //开启二级表格
        caption : "专辑详细信息", //二级表格表头

        subGridRowExpanded : function(subgrid_id, id) {  //1. 子表格的id   2

            var subgrid_table_id = subgrid_id + "_t";  //子表格的table id

            var pager_id = "p_" + subgrid_table_id;    //子表格的page id


            $("#" + subgrid_id).html(
                "<table id='" + subgrid_table_id+"' class='scroll'></table>" +
                "<div id='" + pager_id + "' class='scroll'></div>");

            $("#" + subgrid_table_id).jqGrid(
                {
                    url: "${path}/chapter/queryChapterAll?albumId=" + id,
                    datatype: "json",
                    editurl:'${path}/chapter/edit?albumId=' + id,//修改操作
                    colNames: ['ID', '名称', '章节大小','时长','创建日期','音频','操作'],
                    colModel: [
                        {name: "id", index: "num", width: 60},
                        {name: "title", index: "item", width: 50,editable:true},
                        {name: "size", index: "qty", width: 30, align: "right"},
                        {name: "duration", index: "qty", width: 30, align: "right"},
                        {name: "uploadTime", index: "qty", width: 30, align: "right"},

                        {name: "src", index: "qty",edittype: 'file', width:150,editable:true,align: "right",formatter:function (value,option,rows) {
                                return "<audio controls loop>\n" +
                                    "  <source src=\"${path}/upload/chapter/"+value+"\" type=\"audio/mpeg\">\n" +
                                    "</audio>";
                            }},
                        {name : "x1",width:100,
                            formatter:function(cellvalue, options, rowObject){
                                return "<a href='' ><span class='glyphicon glyphicon-download' /></a>&nbsp;&emsp;&emsp;" +
                                    "<a href='' ><span class='glyphicon glyphicon-play-circle' /></a>";
                            }
                        },


                    ],
                    rowNum: 3,
                    rowList:[3,5,10,20,30],
                    viewrecords:true,// 是否显示总记录条数
                    pager: pager_id,
                    height: '200px',
                    styleUI:'Bootstrap',
                    autowidth:true,
                    multiselect:true// 在表格第一列前面，加入复选框

                }).jqGrid('navGrid',
                "#" + pager_id, {
                    add : true,edit : true,del : true,edittext:"修改",addtext: "添加",deltext:"删除"}
                ,{
                    //修改后
                    closeAfterEdit:true,
                    afterSubmit:function (response) {
                        $.ajaxFileUpload( {
                            url : "${path}/chapter/upload1",//用于文件上传的服务器端请求地址
                            fileElementId : 'src',    //文件上传空间的id属性  <input type="file" id="file" name="file" />
                            // dataType : 'json',       //返回值类型 一般设置为json
                            //type:'POST',
                            success : function() {
                                $("#" + subgrid_table_id).trigger("reloadGrid");
                            }
                        });
                        return "true";
                    }
                },{
                    //添加后
                    closeAfterAdd:true,
                    afterSubmit:function (response) {
                        var id = response.responseJSON.data;
                        $.ajaxFileUpload( {
                            url : "${path}/chapter/1",//用于文件上传的服务器端请求地址
                            fileElementId : 'src',    //文件上传空间的id属性  <input type="file" id="file" name="file" />
                            // dataType : 'json',       //返回值类型 一般设置为json
                            type:'POST',
                            data:{id:id},
                            success : function() {
                                $("#" + subgrid_table_id).trigger("reloadGrid");
                            }
                        });
                        return "true";
                    }
                },{
                    //删除后
                });
        }
    }).navGrid('#pagex2',{add : true,edit : true,del : true,edittext:"修改",addtext: "添加",deltext:"删除"}
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
            //控制删除操作
        })
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