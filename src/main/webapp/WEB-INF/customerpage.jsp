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
        <h2>Hej<c:if test="${sessionScope.user != null }">, ${sessionScope.email}</c:if></h2>
        <form class="mt-4" method="post" action="${pageContext.request.contextPath}/fc/customerpage">
            <fieldset>
                <legend>Byg din cupcake kurv her..</legend>
                <label class="p-2" for="topping"><Strong>Topping:</Strong></label>
                <select class="p-1" name="topping" id="topping">
                    <c:forEach var="topping" items="${applicationScope.toppingList}">
                        <option value="${topping.id}" selected="${requestScope.get(topping.name)}">${topping.name}</option>
                    </c:forEach>
                </select>

                <label class="p-2" for="bottom"><strong>Bund:</strong></label>
                <select class="p-1" name="bottom" id="bottom">
                    <c:forEach var="bottom" items="${applicationScope.bottomList}">
                        <option value="${bottom.id}" selected="${requestScope.get(bottom.name)}">${bottom.name}</option>
                    </c:forEach>
                </select>

                <label class="p-2" for="amount">Antal:</label>
                <select class="p-1" name="amount" id="amount">
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
                <button type="submit" class="btn btn-outline-success mx-2">Tilføj til kurv</button>
            </fieldset>
        </form>
        <hr>
        <table class="table table-bordered table-striped table-hover">
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
                    <td scope="row"><b>${applicationScope.toppingList.get(basketItem.toppingId-1).name}</b></td>
                    <td><strong>${applicationScope.bottomList.get(basketItem.bottomId-1).name}</strong></td>
                    <td><strong>${basketItem.amount}</strong></td>
                    <td><strong>${applicationScope.toppingList.get(basketItem.toppingId-1).price
                            + applicationScope.bottomList.get(basketItem.bottomId-1).price
                            * basketItem.amount},- kr.</strong></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button class="btn float-left btn-lg btn-success" type="submit">Bestil til afhentning</button>
        <button class="btn float-right mx-2 btn-lg btn-outline-dark" type="submit">Ryd kurv</button>
    </jsp:body>

</t:genericpage>