<%-- 
    Document   : dulich
    Created on : Dec 19, 2021, 12:14:06 PM
    Author     : QUOC ANH
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">QUẢN LÝ CHUYẾN DU LỊCH</h1>
 
<c:if test="${errMsg !=null} ">
    
    <div class="alert alert-danger">
    ${errMsg}
</div>
</c:if>

<form:form method="post" action="" modelAttribute="dulich" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    
    <div class="form-group">
        <label>Tên chuyến du lịch </label>
        <form:input path="tendulich" class="form-control" id="tendulich" />
        <form:errors path="tendulich" element="div" cssClass="text-danger" />
        
    </div>    
        
    <div class="form-group">
        <label>Đơn giá</label>
        <form:input path="gia" class="form-control" id="gia" />
        <form:errors path="gia" element="div" cssClass="text-danger" />
    </div>    
        
    <div class="form-group">
        <label>Mô tả chuyến đi</label>
        <form:textarea path="mota" class="form-control" id="mota" />
        
    </div>   
        
         <div class="form-group">
        <label for="anhdulich">Ảnh chuyến du lịch</label>
        <form:input type="file" path="anhdulich" id="anhdulich" class="form-control" />
        
    </div>    
        
    <div class="form-group">
        <label>Loại hình du lịch</label>
        <form:select path="loaihinhdulichId" class="form-control">
            <c:forEach items="${loaihinhdulich}" var="c">
                <form:option value="${c.id}">${c.tenloaihinh}</form:option>
            </c:forEach>
            
        </form:select>
        
    </div>   
        
     <input type="submit" value="Thêm chuyến" class="btn btn-danger">
    
</form:form>