<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
        Bestil
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2 class="display-1">Velkommen om bord</h2>
            <h4 class="h-25 mb-4">Øens bedste cupcakes. Vælg og bestil her:</h4>
            <c:if test="${sessionScope.user == null }">
                <div class="alert alert-info">
                    <strong><a class="alert-link" href="fc/loginpage">Log ind</a></strong> for at starte din bestilling,
                    eller <a class="alert-link" href="fc/registerpage">opret ny bruger</a>.
                </div>
            </c:if>
        </div>

        <c:if test="${sessionScope.role == 'employee' }">
            <p style="font-size: larger">This is what you can do,
                since your are logged in as an employee</p>
            <p><a href="fc/employeepage">Employee Page</a>
        </c:if>

        <c:if test="${sessionScope.role == 'customer' }">
            <form method="post" action="${pageContext.request.contextPath}/fc/bmiresult"> <!-- replace bmiresult -->
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
                        </td>
                    </tr>
                </table>
                <button type="submit" class="btn btn-primary">submit</button>
            </form>
        </c:if>

        </div>

    </jsp:body>
</t:genericpage>