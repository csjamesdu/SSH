<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%>

<div style="margin:10px auto; width:500px">
<table>
	<tr>
		<td>ID</td>
		<td>NAME</td>
		<td>PRICE</td>
		<td>EDIT</td>
		<td>DELETE</td>
	</tr>
	
	<s:iterator value="products" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td>${p.price}</td>
			<td><a href="editProduct?product.id=${p.id}">edit</a></td>
			<td><a href="deleteProduct?product.id=${p.id}">delete</a></td>
		</tr>
	</s:iterator>
</table>
<br>
<br>

<form action="addProduct" method="post">
	name:<input name="product.name"><br>
	price:<input name="product.price"><br>
	<button type="submit">add</button>
</form>
<br>
<br>

<a href="insertProduct">Auto Insert 5 Products</a> <br> Automatically insert 5 products in a batch<br><br>
<a href="insertrollbackProduct">Auto Insert 5 Products with Rolling Back</a><br> Generate RuntimeException in the middle of batch insert

</div>	