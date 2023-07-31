<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../css_files/All_css_files.jsp"%>
</head>
<body>
<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">PID</th>
							<th scope="col">Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products }" var="p">
							<tr>
								<th scope="row">TECHONLY${p.id }</th>
								<td>${p.productName }</td>
								<td>${p.productDescription }</td>
								<td class="font-weight-bold">&#x20B9; ${p.productPrice }</td>
								<td>
								<a href="delete/${p.id }"><i class="fa-solid fa-trash-can text-danger"></i> </a>
								<a href="getProduct/${p.id}"> <i class="fa-solid fa-pen-nib text-success"></i></a>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="container text-center mt-3">
					<a href="addproduct" role="button" class="btn btn-outline-success">Add
						Product</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>