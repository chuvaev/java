<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Редактирование продукта" />
</jsp:include>
<h1>Редактирование продукта</h1>
<form action="product-save" method="post">
    <table class="table table-bordered">
        <tr>
            <td>
                <label for="productid">ID</label>
                <input type="text" readonly="readonly" name="id" id="productid" value="${product.id}">
            </td>
            <td>
                <label for="name">Название</label>
                <input type="text" name="name" id="name" value="${product.name}">
            </td>
            <td>
                <label for="description">Описание</label>
                <input type="text" name="description" id="description" value="${product.description}">
            </td>
            <td>
                <label for="price">Цена</label>
                <input type="text" name="price" id="price" value="${product.price}">
            </td>
        </tr>
    </table>
    <input type="submit" value="Сохранить">
</form>