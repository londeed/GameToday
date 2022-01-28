<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="AdminPage"/>
        <jsp:param name="style" value="bootstrap"/>
        <jsp:param name="script" value=""/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">
<br>
<form action="${pageContext.request.contextPath}/admin/login" method="post" onsubmit="event.preventDefault(); validateForm(this)">
    <fieldset>
        <h2>Login Admin</h2>
        <span>Email</span>
        <label for="email">
            <input type="email" name="email" id="email" placeholder="Email">
        </label>
        <span>Password</span>
        <label for="password">
            <input type="password" name="password" id="password" placeholder="Password">
        </label>
        <button class="premi" type="submit">Accedi</button>
    </fieldset>
</form>
</body>
</html>

