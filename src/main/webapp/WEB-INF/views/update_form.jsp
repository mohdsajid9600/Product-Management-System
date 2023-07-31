<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../css_files/All_css_files.jsp"%>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
			<h1 class="text-center py-3 mb-5">Update the product details</h1>
				<form action="${pageContext.request.contextPath }/handleform" method="post">
				<input type="hidden" name="id" value="${Product.id }">
					<div class="form-group">
						<label for="name">Product Name</label> <input
							type="text" name="productName" class="form-control"
							id="name"
							value="${Product.productName }"
							placeholder="Enter the product name here">
					</div>

					<div class="form-group">
						<label for="description">Product
							Description</label>
						<textarea class="form-control" id="description"
							name="productDescription" rows="5" placeholder="Enter the product description here">${Product.productDescription }</textarea>
					</div>
					<div class="form-group">
						<label for="price">Product Price</label> <input
							type="text" id="price" class="form-control" value="${Product.productPrice }" name="productPrice"
							placeholder="Enter product price here">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger" role="button">Back</a>
						<button class="btn btn-outline-success" type="submit">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>