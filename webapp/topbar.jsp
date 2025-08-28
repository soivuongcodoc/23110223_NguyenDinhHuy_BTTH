<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topbar</title>
<!-- Thêm Bootstrap / FontAwesome nếu cần -->
<link rel="stylesheet" 
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" 
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>

<!-- Topbar -->
<div class="container-fluid bg-light p-2">
    <div class="row">
        <c:choose>
            <!-- Nếu chưa đăng nhập -->
            <c:when test="${sessionScope.account == null}">
                <div class="col-sm-6 text-end">
                    <ul class="list-inline mb-0">
                        <li class="list-inline-item">
                            <a href="${pageContext.request.contextPath }/login">Đăng nhập</a>
                            |<a href="${pageContext.request.contextPath }/register">Đăng ký</a>
                        </li>
                        <li class="list-inline-item">
                            <i class="fa fa-search"></i>
                        </li>
                    </ul>
                </div>
            </c:when>

            <!-- Nếu đã đăng nhập -->
            <c:otherwise>
                <div class="col-sm-6 text-end">
                    <ul class="list-inline mb-0">
                        <li class="list-inline-item">
                            <a href="${pageContext.request.contextPath }/member/myaccount">
                                ${sessionScope.account.fullName}
                            </a>
                            |
                            <a href="${pageContext.request.contextPath }/logout">Đăng Xuất</a>
                        </li>
                        <li class="list-inline-item">
                            <i class="fa fa-search"></i>
                        </li>
                    </ul>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</body>
</html>
