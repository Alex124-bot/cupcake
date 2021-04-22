<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
        Cupcakes
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <h2 class="display-1">Velkommen om bord</h2>
            <h4 class="h-25 mb-4">Øens bedste cupcakes.</h4>
            <c:if test="${sessionScope.user == null }">
                <div class="alert alert-info">
                    <strong><a class="alert-link" href="fc/loginpage">Log ind</a></strong> for at starte din bestilling,
                    eller <a class="alert-link" href="fc/registerpage">opret ny bruger</a>.
                </div>
            </c:if>

        </div>
        <div class="row container-fluid">
            <div class="span4"><img class="img-polaroid img-fluid" src="<c:url value='/images/cc_kids.jpg'/>" alt="kids"/> </div>
            <div class="span8"><p>hey</p></div>
        </div>
        <c:if test="${sessionScope.role == 'employee' }">
        </c:if>
        <c:if test="${sessionScope.role == 'customer'}">
        </c:if>

    </jsp:body>
</t:genericpage>