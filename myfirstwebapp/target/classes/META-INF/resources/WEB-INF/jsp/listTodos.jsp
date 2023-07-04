    <%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf" %>
    <div class="container">
            <h1 class="h1 mt-2">Your Todos</h1>
            <hr>
            <table class="table">
                <thead>
                    <tr>
                        <th>description</th>
                        <th>targetDate</th>
                        <th>Done?</th>
                        <th>Remaining Time</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todos">
                        <tr>
                            <td>${todos.description}</td>
                            <td>${todos.targetDate}</td>
                            <td>${todos.done}</td>
                            <td>${todos.remainingTime}</td>
                            <td><a class="btn btn-warning" href="update-todo?id=${todos.id}">Update</a> </td>
                            <td><a class="btn btn-danger" href="delete-todo?id=${todos.id}">Delete</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todos" class="btn btn-success">Add Todo</a>
        </div>
    </div>
    <%@ include file="common/footer.jspf"%>