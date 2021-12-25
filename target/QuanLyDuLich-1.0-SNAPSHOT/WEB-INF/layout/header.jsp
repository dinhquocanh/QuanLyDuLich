<%-- 
    Document   : header
    Created on : Dec 19, 2021, 12:09:22 PM
    Author     : QUOC ANH
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">My Web</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
      </li>
      
      <c:forEach items="${loaihinhdulich}" var="c">
          <li class="nav-item">
              
              <c:url value="/" var="action">
                  <c:param name="loaihinhdulichid" value ="${c.id}" />
              </c:url>
        <a class="nav-link" href="${action}">${c.tenloaihinh}</a>
      </li>
          
      </c:forEach>
      
       <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/dulich"/>">Quản trị sản phẩm</a>
      </li>
      
      
      <li class="nav-item">                                                                                                         
  <a class="nav-link text-danger" href="<c:url value="/cart" />">
              Giỏ Hàng<span class="badge badge-info cartCounter">${cartStats.totalQuantity}</span>
          </a>     
      
      </li>
      
      <c:if test="${pageContext.request.userPrincipal.name == null}">
       <li class="nav-item">                                                                                                         
  <a class="nav-link text-success" href="<c:url value="/login" />">
             Đăng nhập
          </a>  
             
           </li>     
             
                 <li class="nav-item">
              <a class="nav-link text-success" href="<c:url value="/register" />">
                  Đăng ký
              </a>
            </li>
      </c:if>
            
            <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item">
              <a class="nav-link text-success" href="<c:url value="/" />">
                  <c:if test="${currentUser != null && currentUser.anhdaidien != null}">
                      <img src="${currentUser.anhdaidien}" class="rounded-circle" width="30" alt="${currentUser.taikhoan}" />
                  </c:if>
                  
                  Welcome ${pageContext.request.userPrincipal.name}!
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-success" href="<c:url value="/logout" />">
                  Đăng xuất
              </a>
            </li>
        </c:if>
        
   
       
      
      
      

      
    </ul>
  </div>
   <c:url value="/" var="action" />
    <form class="form-inline" action="${action}">
    <input class="form-control mr-sm-2" type="text" name="kw" placeholder="Nhập từ khóa...">
    <button class="btn btn-success" type="submit">Tìm kiếm</button>
  </form>
 
</nav>
