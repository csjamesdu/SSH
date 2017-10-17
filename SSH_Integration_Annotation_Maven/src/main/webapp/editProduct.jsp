<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="s" uri="/struts-tags" %>


<%@page isELIgnored="false"%>


<div style="margin:0px auto; width:500px">


<form action="updateProduct" method="post">

name: <input name="product.name" value="${product.name}"> <br>
price: <input name="product.price" value="${product.price }"><br>
<input name="product.id" type="hidden" value="${product.id}"> 
<button type="submit">提交</button>

</form>
</div>