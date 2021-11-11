<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Assignment</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous"
>

</head>
<body class="bg-dark">
	<main class="container">
		<div class="row">
			<div class="offset-4 col-4 bg-light mt-3">
				<form action="/finaldam/Login" method="POST">
					<div class="card-header">
						<b>Login</b>
					</div>
					<div class="card-body">
							<%
								String err = request.getParameter("error");
								if ("1".equals(err)) {
									out.print("<h5 style=\"color: red;\">tài khoản hoặc mật khẩu không chính xác</h5>");
								}
							%>
						<div class="form-group">
							<label>User Name</label> 
							<input type="text" class="form-control" name="username" id="username" aria-description="helpid" required>
							<small id="usernamehid" class="form-text text-muted">Username is Required</small>
						</div>
						<div class="form-group">
							<label>Password</label> 
							<input type="password" class="form-control" name="password" id="password" aria-description="passwordhelpid" required> 
							<small id="passwordhid" class="form-text text-muted" >password is Required</small>
						</div>
						<div class="form-group mt-3">
							<div class="form-check form-check-inline">
								<label><input class="form-check-input" type="checkbox" name="remember" id="remember">Remember me!!!</label>
							</div>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn btn-success rounded-pill border-danger" onclick="GFG_Fun()">Login</button> 
						<a href="/finaldam/Home" class="btn btn-primary rounded-pill border-danger">exit</a></br>
                        <a href="/finaldam/Registration">Do not have an account?</a>
                        <a href="/finaldam/Forgotpassword">Forgot password?</a>
					</div>
				</form>
			</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous">
		var file = ${error};
		function GFG_Fun() {
			alert('tài khoản hoặc mật khẩu không chính xác');
		if (file.length ==0) {
			alert('tài khoản hoặc mật khẩu không chính xác');
		} else {
		}
	}
	</script>
</body>
</html>