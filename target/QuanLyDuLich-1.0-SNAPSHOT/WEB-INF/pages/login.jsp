<%-- 
    Document   : login
    Created on : Dec 25, 2021, 11:38:04 AM
    Author     : QUOC ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-danger"> ĐĂNG NHẬP NGƯỜI DÙNG </h1>


<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Tên đăng nhập hoặc mật khẩu không chính xác !!!!!
    </div>
</c:if>

<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <div class="form-group">
        <label>Tên Đăng nhập</label>
        <input type="text" name="username" class="form-control" />
    </div>
    
    <div class="form-group">
        <label>Mật khẩu</label>
        <input type="password" name="password" class="form-control" />
    </div>
    
    <input type="submit" value="Đăng nhập" class="btn btn-danger" />
    
</form>

<br><br>