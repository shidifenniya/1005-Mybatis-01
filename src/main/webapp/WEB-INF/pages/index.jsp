<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>起始页</title>
    <link href="../../css/demo.css" rel="stylesheet" type="text/css">
    <script src="../../scripts/boot.js" type="text/javascript"></script>
</head>

<body>
<h2>欢迎页</h2>


<div style="width:60%;">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                    <a class="mini-button" iconCls="icon-add" onclick="edit()">编辑</a>
                    <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>
                </td>
                <td style="white-space:nowrap;">
                    <input id="key" class="mini-textbox" emptyText="请输入姓名" style="width:150px;" onenter="onKeyEnter"/>
                    <a class="mini-button" onclick="search()">查询</a>
                </td>
            </tr>
        </table>
    </div>
</div>

<div id="datagrid1"
     class="mini-datagrid"
     style="width: 60%;height: 60%"
     sizeList="[2,5,10]"
     pageSize="5"
     url="/limitStudent">

    <%-- 配置表格中的列 --%>
    <div property="columns">

        <div field="id"
             width="120"
             headerAlign="center"
             allowSort="true">学生编号</div>

        <div field="studentName"
             width="120"
             headerAlign="center"
             allowSort="true">学生姓名</div>

        <div field="password"
             width="120"
             headerAlign="center"
             allowSort="true">学生密码</div>


    </div>

</div>

</body>

<script>

    mini.parse();

    var datagrid = mini.get("datagrid1");

    datagrid.load();

    /* 查询 */
    function search() {
        var key = mini.get("key").getValue();
        datagrid.load({studentName: key});
    }

    function onKeyEnter(e) {
        search();
    }

</script>
</html>
