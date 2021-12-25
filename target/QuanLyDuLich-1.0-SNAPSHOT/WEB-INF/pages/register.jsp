<%-- 
    Document   : register
    Created on : Dec 25, 2021, 12:00:46 PM
    Author     : QUOC ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">Đăng Ký Người Dùng</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action" />

<form:form method="post" 
           enctype="multipart/form-data"
           action="${action}" 
           modelAttribute="nhanvien">
    <div class="form-group">
        <label>Họ Nhân Viên</label>
        <form:input path="ho" class="form-control"  />
    </div>
    <div class="form-group">
        <label>Tên Nhân Viên</label>
        <form:input path="ten" class="form-control" />
    </div>
    <div class="form-group">
        <label>Email</label>
        <form:input path="email" class="form-control" />
    </div>
    <div class="form-group">
        <label>Tài Khoản Đăng Nhập</label>
        <form:input path="taikhoan" class="form-control" />
    </div>
    <div class="form-group">
        <label>Mật Khẩu</label>
        <form:password path="matkhau" class="form-control" />
    </div>
    
     <div class="form-group">
                <label>Confirm Password</label>
                <form:password path="confirmPassword" class="form-control" />
                
                 </div>
                
     <div class="form-group">
                <label>Avata</label>
                <form:input type="file" path="file" class="form-control" />
                
                 </div>

    <input type="submit" value="Đăng ký" class="btn btn-danger" />
</form:form>
<br><br>
