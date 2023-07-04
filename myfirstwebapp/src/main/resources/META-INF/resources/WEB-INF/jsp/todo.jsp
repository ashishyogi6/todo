    <%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1 class="mb-4">Enter Todo Details</h1>
            <form:form method="post" modelAttribute="todo">
                <fieldset class="mb-3 form-control">
                    <form:label path="description">Description</form:label>
                    <div class="container">
                        <form:input path="description" type="text" required="required"></form:input>
                        <form:errors path="description" cssClass="text-danger"></form:errors>
                    </div>
                </fieldset>
                <fieldset class="mb-3 form-control">
                    <form:label path="targetDate">Target Date</form:label>
                        <div class="container">
                            <form:input path="targetDate" type="text" required="required"></form:input>
                            <form:errors path="targetDate" cssClass="text-danger"></form:errors>
                        </div>
                </fieldset>

                <fieldset class="mb-3 form-control" style="position:relative">
                    <form:label path="remainingTime">Time </form:label>
                        <div class="container">
                                <form:input path="remainingTime" type="text" required="required"></form:input>
                                <form:errors path="remainingTime" cssClass="text-danger"></form:errors>
                        </div>
                </fieldset>

                <form:input type="hidden" path="id"></form:input>
                <form:input type="hidden" path="done"></form:input>
                <input type="submit" class="btn btn-success"/>

            </form:form>
        </div>

    <%@ include file="common/footer.jspf"%>
        <script >
            $('#targetDate').datepicker({
                format: 'yyyy-mm-dd',
                startDate:'0d'
            });
        </script>

        <script>
            $('#remainingTime').datetimepicker({
                format: 'hh:mm:ss a'
            });
        </script>