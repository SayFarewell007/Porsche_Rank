<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- ${user.name }
${user.passWord }
   --%>
 <table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.name}</td>
            <td>${c.passWord}</td>
               
        </tr>
    </c:forEach>
</table> 
<h1>�û�������������󣬵�¼ʧ�ܣ��볢������ע�ᣡ</h1>