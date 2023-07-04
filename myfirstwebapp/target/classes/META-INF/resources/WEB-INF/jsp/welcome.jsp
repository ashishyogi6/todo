<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1 class="h1">Welcome ${name}</h1>
            <div class="container">
                <a class="type-name-link btn btn-success" href="todos">Manage</a> your todos
            </div>
        </div>
<%@ include file="common/footer.jspf"%>