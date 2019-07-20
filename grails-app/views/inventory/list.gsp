<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2019-07-17
  Time: 07:51
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>List Products</title>
</head>

<body>

<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>SKU</td>
    </tr>
    <g:each in="${allProducts}" var="thisProduct">
        <tr>
            <td>${thisProduct.name}</td>
            <td>${thisProduct.price}</td>
            <td>${thisProduct.sku}</td>
        </tr>
    </g:each>
</table>

</body>
</html>