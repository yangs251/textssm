<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaobai
  Date: 2020/7/23
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"  language="java" %>
<html>
<head>
    <title>所有员工</title>
</head>
<script type="text/javascript" src="../jquery-3.3.1.js"></script>
<script type="text/javascript">
    function add() {
      location.href=("/add.jsp");
    }
    $(function () {
       $("#delete").click(function () {
           var checkID=[];
           $("input[name='checkbox']:checked").each(function(i){
               checkID[i] = $(this).val();
           });
           alert(checkID);
           location.href=("${pageContext.request.contextPath}/employee/empdelete.do?checkId="+checkID);
       })
    })
</script>
<body>
<input type="button" onclick="add()" value="添加">
<input type="button" id="delete" value="删除">
<table border="2">
    <tr>
        <td>名字</td>
        <td>性别</td>
        <td>年龄</td>
        <td>身份证正面</td>
        <td>身份证反面</td>
        <td>职位</td>
        <td>部门</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="emp">
    <tr>
        <td>${emp.ename}</td>
        <td>${emp.esex}</td>
        <td>${emp.eage}</td>
        <td><img src="${emp.eidentity}" style="width: 80px;height: 100px"></td>
        <td><img src="${emp.eidentityy}" style="width: 80px;height: 100px"></td>
        <td>${emp.did}</td>
        <td>${emp.sid}</td>
        <td><input type="button" value="修改"> <input type="checkbox" value="${emp.eid}" name="checkbox"></td>

    </tr>
    </c:forEach>
</table>

</body>
</html>
