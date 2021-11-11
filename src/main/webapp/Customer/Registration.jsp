<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">

<head>
<title>Assignment</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

</head>
<body class="bg-dark">
	<main class="container mt-8">
		<div class="row mt-8 offset-2 col-8 bg-light mt-8">
							<%
								String err = request.getParameter("error");
								if ("1".equals(err)) {
									out.print("<h5 style=\"color: red;\">tài khoản đã tồn tại</h5>");
								}
							%>
			<form class="row g-3" action="/Registration" method="POST">
				<div class="form-groub col-md-4">
                     <label for="username" class="bg-light">fullname</label>
					 <input type="text" class="form-control border-warning" name="fullname" id="fullname" required aria-describedby="fullnamehid">
                </div>
				<div class="form-groub col-md-4">
                     <label for="username" class="bg-light">Username</label>
					 <input type="text" class="form-control border-warning" name="username" id="username" required aria-describedby="usernamehid">
                </div>
				<div class="form-groub col-md-4">
                                    <label for="pass" class="bg-light">Password</label>
                                    <input type="password" class="form-control border-warning" name="pass" id="pass" aria-describedby="youtubehidid"  required>
                                  </div>
				<div class="form-groub col-md-6">
					<label for="email" class="form-label">Email</label> <input
						type="email" class="form-control" name="email"
						placeholder="nguyenvana@gmail.com" required>
				</div>
				<div class="form-groub col-md-4">
                     <label for="phone" class="bg-light">Number Phone</label>
					 <input type="number" class="form-control border-warning" name="sdt" id="sdt" aria-describedby="phonehid">
                </div>
				<div class="form-groub col-md-12">
					<label for="address" class="form-label">Nơi nhận hàng</label> 
					<input type="text" class="form-control border-warning"  name="diachi" placeholder="Hữu Bằng, Quốc Oai, Hà Nội, Việt Nam" aria-describedby="addresshid" required>
				</div>
				<div class="col-12 offset-6">
					<button class="btn btn-success rounded-pill border-danger"
						formaction="/finaldam/Registration/login">Sign in</button>
					<a href="/finaldam/Login"
						class="btn btn-primary rounded-pill border-danger">exit</a>
				</div>
			</form>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>

</body>

</html>