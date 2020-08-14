<%--
  Created by IntelliJ IDEA.
  User: Xiaobai
  Date: 2020/7/22
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<script type="text/javascript">
$(function () {
    $.ajax({
        url:"/superior/listsuperior.do",
        type:'post',
        success:function (data) {
         var list=JSON.parse(data);
         var str="职位:";
         for (var i=0;i<list.length;i++){
          str+=list[i].sname+"<input type='checkbox' value='"+list[i].sid+"' name='sid' >"
         }
         $("#sup").html(str);
        }
    })
})
</script>
<body>
<form method="post" action="/employee/addemp.do" enctype="multipart/form-data">
    姓名:<input type="text" name="ename"><br/>
    性别:男<input type="radio" name="esex" value="男">
        女<input type="radio" name="esex" value="女"><br/>
    年龄:<input type="text" name="eage"><br/>
    身份证正面:<input type="file" name="eidt"><br/>
    身份证反面:<input type="file" name="edity"><br/>
    部门:<select name="did">
             <option value="4">营销部</option>
             <option value="2">测试部</option>
             <option value="1">开发部</option>
             <option value="3">管理部</option>
        </select>
    <div id="sup">
    </div>
    <input type="submit" value="提交">

</form>
</body>
</html>
