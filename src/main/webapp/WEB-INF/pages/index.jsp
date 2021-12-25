<%-- 
    Document   : index
    Created on : Dec 16, 2021, 2:21:30 PM
    Author     : QUOC ANH
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <h1 class="text-center text-danger" >GIỚI THIỆU TOUR DU LỊCH</h1>
        
            
        
        <h1 class="text-center" text-danger">ĐẶT TOUR DU LỊCH TRỰC TUYẾN</h1>
   
            <c:if test="${dulich.size()==0}">
                <div class="alert alert-danger">
                    Không có chuyến du lịch nào phù hợp.
                </div> 
            </c:if>
            <div class="row">
                 <c:forEach items="${dulich}" var ="p">
                     <div class="col-md-3 col-xs-12" style="padding: 10px;">
                            <div class="card" >
                                 <c:if test="${p.image !=null && p.image.startsWith('https') }">
                                     <img class="card-img-top" src="${p.image}" alt="${p.tendulich}"> 
                                </c:if> 
                                   
                                    <c:if test="${p.image ==null || !p.image.startsWith('https') }">
                                     <img class="card-img-top" src="<c:url value="/images/nha ban.jpg" />" alt="${p.tendulich}"> 
                                </c:if> 
                                    <div class="card-body">
                                      <h4 class="card-title">${p.tendulich}</h4>
                                      <p class="card-text">${p.gia} VNĐ</p>
                                      <a href="#" class="btn btn-primary" onclick="addToCart(${p.id}, '${p.tendulich}', ${p.gia})">Đặt tour</a>
                                      <a href="#" class="btn btn-danger">Xem chi tiết</a>
                                    </div>
                            </div>
                </div>
                     </c:forEach>
            </div>

