<%-- 
    Document   : cart
    Created on : Dec 20, 2021, 2:48:25 PM
    Author     : QUOC ANH
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-infox"> GIỎ HÀNG</h1>

<c:if test="${cart == null}">
    <div class="alert alert-danger">
        Khong co san pham nao trong gio!!!
    </div>
</c:if>


<c:if test="${cart != null}">
<table class="table">
    <tr>
        <th>Mã Tour</th>
        <th>Tên Tour</th>
        <th>Đơn Giá</th>
        <th>Số người</th>
        <th></th>
    </tr>
    <c:forEach items="${cart.values()}" var="c">
    <tr>
        <td>${c.id}</td>
        <td>${c.name}</td>
        <td>${c.price}</td>
        <td>
            <div class="form-group">
                <input type="number" 
                       onblur="updateCart(${c.id}, this)"
                       value="${c.quantity}" 
                       class="form-control" />
            </div>
        </td>
        <td>
            <input type="button" 
                   onclick="deleteCart(${c.id})"
                   value="Xoa" 
                   class="btn btn-danger" />
        </td>
    </tr>
    </c:forEach>
</table>

<div class="alert alert-info">
    <h5>Tổng số <span class="cartCounter">${cartStats.totalQuantity} thành viên</span></h5>
    <h5>Tổng tiền: <span id="amountId">${cartStats.totalAmount}</span> VNĐ</h5>
</div>
<input type="button" value="Thanh toán" class="btn btn-info" />
<br><br>
</c:if>