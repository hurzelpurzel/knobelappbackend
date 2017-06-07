<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <base href="/knobelapp/">
        <title>Fehler</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    </head>
    <body>
        <div class="alert alert-danger">
            <strong>Leider trat ein Fehler auf</strong>
            <div>
                <c:if test="${not empty errMsg}">
                    <h2>${errMsg}</h2>
                </c:if>
            </div>
        </div>

    </body>

</html>

