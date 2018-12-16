<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
<jsp:param name="title" value="Каталог" />
</jsp:include>

<table class="table table-bordered table-hover">
    <thead style="text-align: center" class="thead-cart">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Название</th>
        <th scope="col">Цена</th>
        <th scope="col">Действие</th>
    </tr>
    </thead>
    <c:forEach var="product" items="${products}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td style="text-align: center" width="20%">
                <a class="btn btn-danger" href="product_delete?id=${product.id}">Удалить</a>
                <a class="btn btn-danger" href="edit_product?id=${product.id}">Изменить</a>
                <a class="btn btn-danger" href="add_to_cart?id=${product.id}">В корзину</a>
            </td>
        </tr>
    </c:forEach>
</table>
