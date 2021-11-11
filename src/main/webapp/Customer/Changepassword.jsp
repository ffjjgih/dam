<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
	crossorigin="anonymous">
</head>

<body>
	<main class="container ">
		<nav class="row">
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<div class="container-fluid">
					<c:choose>
						<c:when test="${idcustomer!=null}">
							<a class="navbar-brand"
								href="/finaldam/Home?index=${idcustomer }">Noob Food</a>
							<button class="navbar-toggler" type="button"
								data-bs-toggle="collapse"
								data-bs-target="#navbarSupportedContent"
								aria-controls="navbarSupportedContent" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarSupportedContent">
								<ul class="navbar-nav me-auto mb-2 mb-lg-0">
									<li class="nav-item"><a class="nav-link"
										href="/finaldam/Appointment?index=${idcustomer }"> <svg
												xmlns="http://www.w3.org/2000/svg" width="30" height="30"
												fill="currentColor" class="bi bi-calendar-event"
												viewBox="0 0 16 16">
                                        		<path
													d="M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z" />
                                        		<path
													d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
                                    		</svg> đặt bàn
									</a></li>
									<li class="nav-item dropdown">
									<li class="nav-item"><a class="nav-link"
										href="/finaldam/Food?index=${idcustomer }"> <svg
												xmlns="http://www.w3.org/2000/svg" width="30" height="30"
												fill="currentColor" class="bi bi-egg-fried"
												viewBox="0 0 16 16">
                                        		<path
													d="M8 11a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                                        		<path
													d="M13.997 5.17a5 5 0 0 0-8.101-4.09A5 5 0 0 0 1.28 9.342a5 5 0 0 0 8.336 5.109 3.5 3.5 0 0 0 5.201-4.065 3.001 3.001 0 0 0-.822-5.216zm-1-.034a1 1 0 0 0 .668.977 2.001 2.001 0 0 1 .547 3.478 1 1 0 0 0-.341 1.113 2.5 2.5 0 0 1-3.715 2.905 1 1 0 0 0-1.262.152 4 4 0 0 1-6.67-4.087 1 1 0 0 0-.2-1 4 4 0 0 1 3.693-6.61 1 1 0 0 0 .8-.2 4 4 0 0 1 6.48 3.273z" />
                                    		</svg> đồ ăn
									</a></li>
									<li class="nav-item dropdown">
									<li class="nav-item"><a class="nav-link"
										href="/finaldam/Cart?index=${idcustomer }"> <svg
												xmlns="http://www.w3.org/2000/svg" width="30" height="30"
												fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
                                        		<path
													d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z" />
                                    		</svg> giỏ hàng
									</a></li>
									<li class="nav-item dropdown"><a
										class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
										role="button" data-bs-toggle="dropdown" aria-expanded="false">
											<svg xmlns="http://www.w3.org/2000/svg" width="24"
												height="24" fill="currentColor" class="bi bi-person-fill"
												viewBox="0 0 16 16">
  												<path
													d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
											</svg> Account
									</a>
										<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
											<li><a class="dropdown-item"
												href="/finaldam/Changepassword?index=${idcustomer }">change password</a></li>
											<li>
												<hr class="dropdown-divider">
											</li>
											<li><a class="dropdown-item" href="/finaldam/Profile?index=${idcustomer }"> <svg
														xmlns="http://www.w3.org/2000/svg" width="24" height="24"
														fill="currentColor" class="bi bi-file-earmark-person-fill"
														viewBox="0 0 16 16">
                                        				<path d="M9.293 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.707A1 1 0 0 0 13.707 4L10 .293A1 1 0 0 0 9.293 0zM9.5 3.5v-2l3 3h-2a1 1 0 0 1-1-1zM11 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0zm2 5.755V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1v-.245S4 12 8 12s5 1.755 5 1.755z" />
                                      				</svg> Edit profile
											</a></li>
											<li><a class="dropdown-item" href="/finaldam/History?index=${idcustomer }"> <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-clock-history" viewBox="0 0 16 16">
  													<path d="M8.515 1.019A7 7 0 0 0 8 1V0a8 8 0 0 1 .589.022l-.074.997zm2.004.45a7.003 7.003 0 0 0-.985-.299l.219-.976c.383.086.76.2 1.126.342l-.36.933zm1.37.71a7.01 7.01 0 0 0-.439-.27l.493-.87a8.025 8.025 0 0 1 .979.654l-.615.789a6.996 6.996 0 0 0-.418-.302zm1.834 1.79a6.99 6.99 0 0 0-.653-.796l.724-.69c.27.285.52.59.747.91l-.818.576zm.744 1.352a7.08 7.08 0 0 0-.214-.468l.893-.45a7.976 7.976 0 0 1 .45 1.088l-.95.313a7.023 7.023 0 0 0-.179-.483zm.53 2.507a6.991 6.991 0 0 0-.1-1.025l.985-.17c.067.386.106.778.116 1.17l-1 .025zm-.131 1.538c.033-.17.06-.339.081-.51l.993.123a7.957 7.957 0 0 1-.23 1.155l-.964-.267c.046-.165.086-.332.12-.501zm-.952 2.379c.184-.29.346-.594.486-.908l.914.405c-.16.36-.345.706-.555 1.038l-.845-.535zm-.964 1.205c.122-.122.239-.248.35-.378l.758.653a8.073 8.073 0 0 1-.401.432l-.707-.707z"/>
  													<path d="M8 1a7 7 0 1 0 4.95 11.95l.707.707A8.001 8.001 0 1 1 8 0v1z"/>
  													<path d="M7.5 3a.5.5 0 0 1 .5.5v5.21l3.248 1.856a.5.5 0 0 1-.496.868l-3.5-2A.5.5 0 0 1 7 9V3.5a.5.5 0 0 1 .5-.5z"/>
													</svg> History	
											</a></li>
											<li><a class="dropdown-item" href="#"> <svg
														xmlns="http://www.w3.org/2000/svg" width="24" height="24"
														fill="currentColor" class="bi bi-box-arrow-left"
														viewBox="0 0 16 16">
                                        				<path fill-rule="evenodd"
															d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z" />
                                        				<path fill-rule="evenodd"
															d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z" />
                                      				</svg>logout
											</a></li>
										</ul></li>
								</ul>
							</div>
						</c:when>
						<c:otherwise>
							<a class="navbar-brand" href="/finaldam/Home">Noob Food</a>
							<button class="navbar-toggler" type="button"
								data-bs-toggle="collapse"
								data-bs-target="#navbarSupportedContent"
								aria-controls="navbarSupportedContent" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarSupportedContent">
								<ul class="navbar-nav me-auto mb-2 mb-lg-0">
									<li class="nav-item"><a class="nav-link"
										href="/finaldam/Appointment"> <svg
												xmlns="http://www.w3.org/2000/svg" width="30" height="30"
												fill="currentColor" class="bi bi-calendar-event"
												viewBox="0 0 16 16">\
                                        		<path d="M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z" />
                                        		<path
													d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
                                    		</svg> đặt bàn
									</a></li>
									<li class="nav-item dropdown">
									<li class="nav-item"><a class="nav-link"
										href="/finaldam/Food"> <svg
												xmlns="http://www.w3.org/2000/svg" width="30" height="30"
												fill="currentColor" class="bi bi-egg-fried"
												viewBox="0 0 16 16">
                                        		<path
													d="M8 11a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                                          		<path
													d="M13.997 5.17a5 5 0 0 0-8.101-4.09A5 5 0 0 0 1.28 9.342a5 5 0 0 0 8.336 5.109 3.5 3.5 0 0 0 5.201-4.065 3.001 3.001 0 0 0-.822-5.216zm-1-.034a1 1 0 0 0 .668.977 2.001 2.001 0 0 1 .547 3.478 1 1 0 0 0-.341 1.113 2.5 2.5 0 0 1-3.715 2.905 1 1 0 0 0-1.262.152 4 4 0 0 1-6.67-4.087 1 1 0 0 0-.2-1 4 4 0 0 1 3.693-6.61 1 1 0 0 0 .8-.2 4 4 0 0 1 6.48 3.273z" />
                                    		</svg> đồ ăn
									</a></li>
									<li class="nav-item dropdown">
									<li class="nav-item"><a class="nav-link"
										href="/finaldam/Cart"> <svg
												xmlns="http://www.w3.org/2000/svg" width="30" height="30"
												fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
                                        		<path
													d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z" />
                                    		</svg> giỏ hàng
									</a></li>
									<li class="nav-item dropdown"><a
										class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
										role="button" data-bs-toggle="dropdown" aria-expanded="false">
											<svg xmlns="http://www.w3.org/2000/svg" width="24"
												height="24" fill="currentColor" class="bi bi-person-fill"
												viewBox="0 0 16 16">
  												<path
													d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
											</svg> Account
									</a>
										<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
											<li><a class="dropdown-item" href="/finaldam/Login"> <svg
														xmlns="http://www.w3.org/2000/svg" width="24" height="24"
														fill="currentColor" class="bi bi-box-arrow-in-right"
														viewBox="0 0 16 16">
                                        				<path fill-rule="evenodd"
															d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z" />
                                        				<path fill-rule="evenodd"
															d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
                                      				</svg> Login
											</a></li>
										</ul></li>
								</ul>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</nav>
		</nav>
		<div class="row mt-8 offset-2 col-8 bg-light mt-8" style="margin-top: 10px;">
			<form class="row g-3" action="/Registration" method="POST">
				<div class="form-groub col-md-4">
                     <label for="username" class="bg-light">old password</label>
					 <input type="password" class="form-control border-warning" name="oldpw" id="oldpw" aria-describedby="fullnamehid">
					 <%
								String err = request.getParameter("error");
								if ("2".equals(err)) {
									out.print("<small id='emailhid' style='color: red;' class='form-text text-muted' >enter wrong password</small>");
								}
					 %>
                </div>
				<div class="form-groub col-md-4">
                     <label for="username" class="bg-light">new password</label>
					 <input type="password" class="form-control border-warning" name="newpw" id="newpw" aria-describedby="usernamehid">
                </div>
				<div class="form-groub col-md-4">
                                    <label for="pass" class="bg-light">confirm password</label>
                                    <input type="password" class="form-control border-warning" name="confirmpw" id="confirmpw" aria-describedby="youtubehidid"  required>
                                    <%
								if ("1".equals(err)) {
									out.print("<small id='emailhid' style='color: red;' class='form-text text-muted' >incorrect password</small>");
								}
					 %>
                                  </div>
				<div class="col-12 offset-6">
					<button class="btn btn-success rounded-pill border-danger"
						formaction="/finaldam/Changepassword/Change?index=${idcustomer}">Change</button>
					<button type="reset"
						class="btn btn-primary rounded-pill border-danger">clear</button>
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