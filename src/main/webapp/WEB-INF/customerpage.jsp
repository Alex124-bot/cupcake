<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of our wonderful site.
        </br>
        <form method="post" action="${pageContext.request.contextPath}/fc/bmiresult">
        <table>
        <tr>
            <th>Bottoms</th>
            <th>Toppings</th>
            <th>amount</th>
        </tr>
        <tr>
        <td>
            <select name="bottom" id="bottom">
                <c:forEach var="bottom" items="${applicationScope.bottomList}">
                    <option value="${bottom.id}">${bottom.name}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <select name="topping" id="topping">
                <c:forEach var="topping" items="${applicationScope.toppingList}">
                    <option value="${topping.id}">${topping.name}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <select name="amount" id="amount">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
    </select>
    </td>
    </tr>
    </table>
            <button type="submit" class="btn btn-primary">submit</button>
    </form>
</jsp:body>

</t:genericpage>

