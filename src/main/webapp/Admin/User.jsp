<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Assignment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

</head>

<body class="">
	<main class="container mt-10">
		<nav class="navbar navbar-light bg-light fixed-bot">
            <div class="container-fluid">
                <a class="navbar-brand" href="/finaldam/Homeadmin?index=${idadmin}">Noob Food</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="offcanvas offcanvas-end bg-light" tabindex="-1" id="offcanvasNavbar"
                    aria-labelledby="offcanvasNavbarLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title " id="offcanvasNavbarLabel">Menu</h5>
                        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                            aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="/finaldam/Homeadmin?index=${idadmin}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                                        class="bi bi-house-fill" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd"
                                            d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z" />
                                        <path fill-rule="evenodd"
                                            d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z" />
                                    </svg> Home
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="/finaldam/Notify?index=${idadmin}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                                        class="bi bi-chat-right-dots-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h9.586a1 1 0 0 1 .707.293l2.853 2.853a.5.5 0 0 0 .854-.353V2zM5 6a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
                                    </svg> Thông báo
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/finaldam/Manageuser?index=${idadmin}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                                        class="bi bi-people-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                                        <path fill-rule="evenodd"
                                            d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z" />
                                        <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z" />
                                    </svg> Users
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link active" href="/finaldam/Managefood?index=${idadmin}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                                        class="bi bi-cup-straw" viewBox="0 0 16 16">
                                        <path
                                            d="M13.902.334a.5.5 0 0 1-.28.65l-2.254.902-.4 1.927c.376.095.715.215.972.367.228.135.56.396.56.82 0 .046-.004.09-.011.132l-.962 9.068a1.28 1.28 0 0 1-.524.93c-.488.34-1.494.87-3.01.87-1.516 0-2.522-.53-3.01-.87a1.28 1.28 0 0 1-.524-.93L3.51 5.132A.78.78 0 0 1 3.5 5c0-.424.332-.685.56-.82.262-.154.607-.276.99-.372C5.824 3.614 6.867 3.5 8 3.5c.712 0 1.389.045 1.985.127l.464-2.215a.5.5 0 0 1 .303-.356l2.5-1a.5.5 0 0 1 .65.278zM9.768 4.607A13.991 13.991 0 0 0 8 4.5c-1.076 0-2.033.11-2.707.278A3.284 3.284 0 0 0 4.645 5c.146.073.362.15.648.222C5.967 5.39 6.924 5.5 8 5.5c.571 0 1.109-.03 1.588-.085l.18-.808zm.292 1.756C9.445 6.45 8.742 6.5 8 6.5c-1.133 0-2.176-.114-2.95-.308a5.514 5.514 0 0 1-.435-.127l.838 8.03c.013.121.06.186.102.215.357.249 1.168.69 2.438.69 1.27 0 2.081-.441 2.438-.69.042-.029.09-.094.102-.215l.852-8.03a5.517 5.517 0 0 1-.435.127 8.88 8.88 0 0 1-.89.17zM4.467 4.884s.003.002.005.006l-.005-.006zm7.066 0-.005.006c.002-.004.005-.006.005-.006zM11.354 5a3.174 3.174 0 0 0-.604-.21l-.099.445.055-.013c.286-.072.502-.149.648-.222z" />
                                    </svg> Food
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/finaldam/statistical?index=${idadmin}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                                        class="bi bi-file-earmark-bar-graph-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M9.293 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.707A1 1 0 0 0 13.707 4L10 .293A1 1 0 0 0 9.293 0zM9.5 3.5v-2l3 3h-2a1 1 0 0 1-1-1zm.5 10v-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm-2.5.5a.5.5 0 0 1-.5-.5v-4a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-.5.5h-1zm-3 0a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-1z" />
                                    </svg> Thống kê
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
		<div class="row mt-10 ">
			<div class="offset-2 col-8 ">
				<ul class="nav nav-pills mb-3 " id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="UserEditon-tab"
							data-bs-toggle="pill" data-bs-target="#UserEditon" type="button"
							role="tab" aria-controls="UserEditon" aria-selected="true">User
							Editon</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="UserList-tab" data-bs-toggle="tab"
							data-bs-target="#UserList" type="button" role="tab"
							aria-controls="UserList" aria-selected="false">User List</button>
					</li>
				</ul>
				<div class="tab-content " id="myTabContent">
					<div class="tab-pane fade show active " id="UserEditon"
						role="tabpanel" aria-labelledby="UserEditon-tab">
						<form class="row g-3 needs-validation" novalidate
							action="/Manageruser" method="POST">
							<div class="form-groub col-md-4">
								<label for="username" class="bg-light">fullname</label> <input
									type="text" class="form-control border-warning" name="fullname"
									id="fullname" aria-describedby="fullnamehid"
									value="${users.fullname }" required>
							</div>
							<div class="form-groub col-md-4">
								<label for="username" class="bg-light">Username</label> <input
									type="text" class="form-control border-warning" name="username"
									id="username" aria-describedby="usernamehid"
									value="${users.username.trim() }" required>
							</div>
							<div class="form-groub col-md-4">
								<label for="pass" class="bg-light">Password</label> <input
									type="password" class="form-control border-warning" name="pass"
									id="pass" aria-describedby="passhidid"
									value="${users.pass.trim() }" required>
							</div>
							<div class="form-groub col-md-6">
								<label for="email" class="form-label">Email</label> <input
									type="email" class="form-control" name="email"
									placeholder="nguyenvana@gmail.com"
									value="${users.email.trim() }" required>
							</div>
							<div class="form-groub col-md-4">
								<label for="phone" class="bg-light">Number Phone</label> <input
									type="text" class="form-control border-warning" name="sdt"
									id="sdt" value="${users.sdt.trim()}"
									aria-describedby="phonehid" required>
							</div>
							<div class="form-groub col-md-12">
								<label for="address" class="form-label">Nơi nhận hàng</label> <input
									type="text" class="form-control border-warning" name="diachi"
									placeholder="Hữu Bằng, Quốc Oai, Hà Nội, Việt Nam"
									aria-describedby="addresshid" value="${users.diachi.trim() }"
									required>
							</div>
							<div class="col-md-7">
								<div class="offset-10 col-4">
									<button type="submit" formaction="/finaldam/Manageuser/insert"
										class="btn btn-success rounded-pill">Create</button>
									<button type="submit"
										formaction="/finaldam/Manageuser/update?id=${users.userid}"
										class="btn btn-warning rounded-pill">Update</button>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane fade" id="UserList" role="tabpanel"
						aria-labelledby="UserList-tab">
						<table class="table table-dark table-sm " border="1">
							<thead>
								<tr>
									<th class="col-2">Username</th>
									<th class="col-2">Password</th>
									<th class="col-3">Fullname</th>
									<th class="col-3">Email</th>
									<th class="col-3">Phone</th>
									<th class="col-3">address</th>
									<th colspan="2" class="col-2 text-center">function</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${lstuser}" var="u">
									<tr>
										<th class="col-2">"${u.username }"</th>
										<th class="col-2">"${u.pass}"</th>
										<th class="col-3">${u.fullname}</th>
										<th class="col-3">${u.email}</th>
										<th class="col-3">${u.sdt}</th>
										<th class="col-3">${u.diachi}</th>
										<th class="col-1"><a
											href="/finaldam/Manageuser/edit?index=${idadmin }&&id=${u.userid}"
											class="btn btn-warning text-center rounded-pill">update</a></th>
										<th class="col-1"><a
											onclick="confirmdelete(${idadmin},${u.userid })"
											class="btn btn-danger text-center rounded-pill">delete </a></th>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
		<script type="text/javascript">
		function confirmdelete(index,id) {
			var ques=confirm('do want to delete???');
			if(ques){
				alert('delete succsessfull');
				window.location.href='/finaldam/Deletenotify/user?index='+index+'&&id='+id;
			}
		}
		</script>
</body>

</html>