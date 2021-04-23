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
            <h2 class="display-4 mb-4">Velkommen om bord
                <c:if test="${sessionScope.user != null }">, ${sessionScope.email}</c:if></h2>

            <c:if test="${sessionScope.user == null }">
                <div class="alert alert-success">
                    <strong><a class="alert-link" href="fc/loginpage">Log ind</a></strong>
                    for at starte din bestilling, eller
                    <a class="alert-link" href="fc/registerpage">opret ny bruger</a>.
                </div>
            </c:if>

            <div class="row">

                <div class="w-25 pl-4 rounded-1"><img class="img-circle border-white img-fluid" src="<c:url value='/images/cc_kids.jpg'/>"alt="kids"/></div>
                <div class="w-75"><h4>Øens bedste cupcakes</h4>
                    <p>Quisque porttitor nisi eu dolor porta, at ultrices orci sollicitudin. In blandit posuere ipsum, eu tempor sem ornare a. Phasellus at libero aliquam, ullamcorper leo convallis, auctor erat. Aenean mollis facilisis molestie. Maecenas venenatis dapibus sodales. Proin porta auctor diam, et vehicula nibh pharetra sed. Morbi ornare nisl et bibendum condimentum. Maecenas in ligula posuere arcu fringilla eleifend commodo non metus. Duis ultrices convallis dui, luctus maximus erat condimentum sit amet. Donec a est velit. Cras congue enim vel nibh molestie, in aliquam dui aliquet.
                </p>
                    <h4>Mums Mums Mums!</h4>
                <p>Morbi nisl augue, aliquet nec porttitor et, pulvinar non nibh. Ut dapibus imperdiet ipsum non commodo. In commodo auctor leo sed sagittis. Vestibulum sit amet pretium enim, sed maximus tortor. Vestibulum non eros ultrices, tristique ipsum vel, aliquam justo. Aliquam erat volutpat. Donec nec consectetur ipsum. Phasellus non ultricies enim, vitae pharetra nisl. Curabitur in purus tortor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In a tellus a sapien condimentum elementum quis efficitur dui. Donec nec rutrum massa.
                </p></div>
            </div>
    </jsp:body>
</t:genericpage>