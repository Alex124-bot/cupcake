<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Bestil cupcakes
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h2>Hej, ${sessionScope.email} </h2>
        <h4>Bestil cupcakes her</h4>
        <form class="mt-4" method="post" action="${pageContext.request.contextPath}/fc/customerpage">
            <label for="topping">Toppings</label>
            <select name="topping" id="topping">
                <c:forEach var="topping" items="${applicationScope.toppingList}">
                    <option value="${topping.getId()}">${topping.getName()}</option>
                </c:forEach>
            </select>

            <label for="bottom">Bottoms</label>
            <select name="bottom" id="bottom">
                <c:forEach var="bottom" items="${applicationScope.bottomList}">
                    <option value="${bottom.getId()}">${bottom.getName()}</option>
                </c:forEach>
            </select>

            <label for="amount">amount</label>
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
            <button type="submit" class="btn btn-success">submit</button>
        </form>


        <table class="table">
            <thead>
            <tr>
                <th scope="col">Top</th>
                <th scope="col">Bund</th>
                <th scope="col">Antal</th>
                <th scope="col">Pris</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="basketItem" items="${sessionScope.basket}">
                <tr>
                    <td scope="row">${applicationScope.toppingList.get(basketItem.getToppingId()-1).getName()}</td>
                    <td>${applicationScope.bottomList.get(basketItem.getBottomId()-1).getName()}</td>
                    <td>${basketItem.getAmount()}</td>
                    <td>${applicationScope.toppingList.get(basketItem.getToppingId()-1).getPrice()
                            + applicationScope.bottomList.get(basketItem.getBottomId()-1).getPrice()
                            * basketItem.getAmount()},- kr.</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:body>

</t:genericpage>